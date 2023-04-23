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
		worldBorder.setSize(worldBorder.getSize() + value);
	}
	
	public static int getSpeed() {
		return speed;
	}
	
	public static void addSpeed(int value) {
		speed += value;
	}
	
	public static int getMinSize() {
		return minSize;
	}
	
	public static void addMinSize(int value) {
		minSize += value;
	}

	public static WorldBorder getWorldBorder() {
		return worldBorder;
	}
}
