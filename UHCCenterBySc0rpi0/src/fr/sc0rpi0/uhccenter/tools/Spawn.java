package fr.sc0rpi0.uhccenter.tools;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class Spawn {
	private final static Location spawn = new Location(Bukkit.getServer().getWorld("world"), 0, 122, 0);;
	private final static int size = 10;
	
	public static void generateSpawn() {
		for (int i = -size; i <= size; i++) {
			for (int j = -size; j <= size; j++) {
				if (i == -size || j == -size || i == size || j == size) {
					Bukkit.getWorld("world").getBlockAt(new Location(Bukkit.getWorld("world"), spawn.getX() + i, spawn.getY() + 2, spawn.getZ() + j)).setType(Material.STAINED_GLASS);
					Bukkit.getWorld("world").getBlockAt(new Location(Bukkit.getWorld("world"), spawn.getX() + i, spawn.getY() + 1, spawn.getZ() + j)).setType(Material.STAINED_GLASS);
					Bukkit.getWorld("world").getBlockAt(new Location(Bukkit.getWorld("world"), spawn.getX() + i, spawn.getY(), spawn.getZ() + j)).setType(Material.STAINED_GLASS);
					Bukkit.getWorld("world").getBlockAt(new Location(Bukkit.getWorld("world"), spawn.getX() + i, spawn.getY() - 1, spawn.getZ() + j)).setType(Material.STAINED_GLASS);
				}
				Bukkit.getWorld("world").getBlockAt(new Location(Bukkit.getWorld("world"), spawn.getX() + i, spawn.getY() - 2, spawn.getZ() + j)).setType(Material.STAINED_GLASS);
			}
		}
	}

	public static Location getSpawn() {
		return spawn;
	}
}
