package fr.sc0rpi0.uhccenter.tools;

import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {
	private static int pvpTimer = 20;
	private static int borderTimer = 50;
	private static int timer = 0;
	
	
	public static int getPvpTimer() {
		return pvpTimer;
	}

	public static int getBorderTimer() {
		return borderTimer;
	}
	
	public static void addPvpTimer(int value) {
		pvpTimer += value;
	}
	
	public static void addBorderTimer(int value) {
		borderTimer += value;
	}

	public static int getTimer() {
		return timer;
	}
	
	public static boolean isPVP() {
		return getTimer() >= getPvpTimer();
	}

	@Override
	public void run() {
		timer++;
		
		if (timer < getBorderTimer() && Border.getSize() > Border.getMinSize()) {
			Border.getWorldBorder().setSize(Border.getWorldBorder().getSize() - Border.getSpeed() / 60);
			if (Border.getSize() < Border.getMinSize()) {
				Border.getWorldBorder().setSize(Border.getMinSize());
			}
		}
	}

	public static boolean isNoDamage() {
		return timer <= 20;
	}

}
