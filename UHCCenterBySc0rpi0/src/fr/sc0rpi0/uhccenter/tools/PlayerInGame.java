package fr.sc0rpi0.uhccenter.tools;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class PlayerInGame {
	private static List<Player> playerlist = new ArrayList<Player>();
	
	public static boolean contains(Player p) {
		return playerlist.contains(p);
	}
	
	public static boolean add(Player p) {
		return playerlist.add(p);
	}
	
	public static boolean remove(Player p) {
		return playerlist.remove(p);
	}
	
	public static Player getHost() {
		return playerlist.get(0);
	}
	
	public static boolean isHost(Player p) {
		return p.equals(getHost());
	}
	
	public static List<Player> getPlayerList() {
		return playerlist;
	}
}
