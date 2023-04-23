package fr.sc0rpi0.uhccenter.tools;

import org.bukkit.Bukkit;
import org.bukkit.WorldBorder;

public class Border {
	private static int speed = 5;
	private static int minSize = 50;
	private static WorldBorder worldBorder = Bukkit.getWorld("world").getWorldBorder();
	
	public static int getSize() {
		return (int) worldBorder.getSize();
	}
	
	public static void addSize(int value) {
		double size = worldBorder.getSize() + value;
		if (size >= Border.getMinSize() && size <= 10000) {
			worldBorder.setSize(size);
			MainScoreboard.getScoreboard().getTeam("BorderSize").setSuffix((int)(size) + " x " + (int)(size));
		}
	}
	
	public static int getSpeed() {
		return speed;
	}
	
	public static void addSpeed(int value) {
		if (speed + value >= 1 && speed + value <= 10) {
			speed += value;
			MainScoreboard.getScoreboard().getTeam("BorderSpeed").setSuffix(speed + " blocks/min");
		}
	}
	
	public static int getMinSize() {
		return minSize;
	}
	
	public static void addMinSize(int value) {
		if (minSize + value >= 50 && minSize + value <= Border.getSize() && minSize + value <= 250) {
			minSize += value;
			MainScoreboard.getScoreboard().getTeam("BorderMinSize").setSuffix(minSize + " x " + minSize);
		}
	}

	public static WorldBorder getWorldBorder() {
		return worldBorder;
	}
}
