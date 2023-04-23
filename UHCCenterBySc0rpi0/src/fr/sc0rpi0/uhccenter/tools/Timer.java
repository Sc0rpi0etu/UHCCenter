package fr.sc0rpi0.uhccenter.tools;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.permissions.BroadcastPermissions;

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
		if (value + pvpTimer > 0 && value + pvpTimer < borderTimer) {
			pvpTimer += value;
			MainScoreboard.getScoreboard().getTeam("PVPTimer").setSuffix(pvpTimer + " min");
		}
	}
	
	public static void addBorderTimer(int value) {
		if (pvpTimer < borderTimer + value) {
			borderTimer += value;
			MainScoreboard.getScoreboard().getTeam("BorderTimer").setSuffix(borderTimer + " min");
		}
	}

	public static int getTimer() {
		return timer;
	}
	
	public static boolean isPVP() {
		return getTimer() >= getPvpTimer() * 60;
	}

	@Override
	public void run() {
		timer++;
		
		MainScoreboard.getScoreboard().getTeam("Timer").setSuffix((timer / 60) + " min " + (timer % 60) + " s");
		
		if (timer == getPvpTimer() * 60) {
			Bukkit.broadcastMessage(ColorTool.getMainColorAqua() + "PVP is on !");
		}
		
		if (timer == getBorderTimer() * 60) {
			Bukkit.broadcastMessage(ColorTool.getMainColorAqua() + "Border is on !");
		}
		
		if (timer > getBorderTimer() * 60 && Border.getSize() > Border.getMinSize()) {
			Border.getWorldBorder().setSize(Border.getWorldBorder().getSize() - (double) Border.getSpeed() / 60);
			if (Border.getSize() < Border.getMinSize()) {
				Border.getWorldBorder().setSize(Border.getMinSize());
			}
			MainScoreboard.getScoreboard().getTeam("BorderSizeGame").setSuffix((int) Border.getWorldBorder().getSize() + " x " + (int) Border.getWorldBorder().getSize());
		}
	}

	public static boolean isNoDamage() {
		return timer <= 20;
	}

}
