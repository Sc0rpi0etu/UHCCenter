package fr.sc0rpi0.uhccenter.tools;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import fr.sc0rpi0.uhccenter.Main;

public class GameControl {
	public final static int maxPlayers = 20;
	
	public static void teleport(Main main) {
		double x = Bukkit.getWorld("world").getWorldBorder().getSize() * 2 / 3;
		double angle = PlayerInGame.getPlayerList().size() / 360;
		double currentAngle = 0;
		Location start = new Location(Bukkit.getWorld("world"), 0, 0, x);
		
		for (Player p : PlayerInGame.getPlayerList()) {
			Location loc = new Location(Bukkit.getWorld("world"), start.getX() * Math.cos(currentAngle), 0, start.getY() * Math.sin(currentAngle));
			
			generateWaitingSpawn(loc, Material.GLASS);
			p.teleport(loc);
			
			currentAngle += angle;
		}
		
		Timer timer = new Timer();
		timer.runTaskTimer(main, 0, 20);
	}
	
	public static void generateWaitingSpawn(Location loc, Material material) {
		loc = new Location(Bukkit.getWorld("world"), loc.getX() - 2, loc.getY() - 2, loc.getZ() - 2);
		
		for (int x = 0; x < 5; x++) {
			for (int z = 0; z < 5; z++) {
				for (int y = 0; y < 5; y++) {
					if (y == 0 || z == 0 || z == 4 || x == 0 || x == 4)
						loc.add(x, y, z).getBlock().setType(material);
					
				}
			}
		}
	}
	
	public static void initScoreboard() {
		ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
		Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
		
		Objective sideObjective = scoreboard.registerNewObjective("title", "dummy");
		
		sideObjective.setDisplayName(ColorTool.getMainColorAqua() + "UHC Center");
		sideObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score playerInGameScore = sideObjective.getScore(ColorTool.getMainColorAqua() + "Player : " + ColorTool.getMainColorGray() + PlayerInGame.getPlayerList().size() + " / " + GameControl.maxPlayers);
		
		for (Player player : PlayerInGame.getPlayerList()) {
			
		}
	}
}
