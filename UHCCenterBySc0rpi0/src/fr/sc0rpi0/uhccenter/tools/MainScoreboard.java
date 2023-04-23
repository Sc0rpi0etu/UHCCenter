package fr.sc0rpi0.uhccenter.tools;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class MainScoreboard {
	private static ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
	private static Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

	public static Scoreboard getScoreboard() {
		return scoreboard;
	}

	public static void createScoreboardLobby() {
		Objective obj = MainScoreboard.scoreboard.registerNewObjective("UHC Center", "dummy");
		obj.setDisplayName(ColorTool.getInventoryColor() + "UHC Center");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		obj.getScore(ColorTool.getMainColorGray() + "============ Timer ===========").setScore(7);
		
		Team PVPtimer = MainScoreboard.scoreboard.registerNewTeam("PVPTimer");
		PVPtimer.addEntry(ColorTool.getMainColorAqua() + "PVP : ");
		PVPtimer.setSuffix(Timer.getPvpTimer() + " min");
		obj.getScore(ColorTool.getMainColorAqua() + "PVP : ").setScore(6);
		
		Team Bordertimer = MainScoreboard.scoreboard.registerNewTeam("BorderTimer");
		Bordertimer.addEntry(ColorTool.getMainColorAqua() + "Border : ");
		Bordertimer.setSuffix(Timer.getBorderTimer() + " min");
		obj.getScore(ColorTool.getMainColorAqua() + "Border : ").setScore(5);
		
		obj.getScore(ColorTool.getMainColorGray() + "=========== Border ==========").setScore(4);
		
		Team BorderSize = MainScoreboard.scoreboard.registerNewTeam("BorderSize");
		BorderSize.addEntry(ColorTool.getMainColorAqua() + "Border Size : ");
		BorderSize.setSuffix(Border.getSize() + " x " + Border.getSize());
		obj.getScore(ColorTool.getMainColorAqua() + "Border Size : ").setScore(3);
		
		Team BorderSpeed = MainScoreboard.scoreboard.registerNewTeam("BorderSpeed");
		BorderSpeed.addEntry(ColorTool.getMainColorAqua() + "Border Speed : ");
		BorderSpeed.setSuffix(Border.getSpeed() + " blocks/min");
		obj.getScore(ColorTool.getMainColorAqua() + "Border Speed : ").setScore(2);
		
		Team BorderMinSize = MainScoreboard.scoreboard.registerNewTeam("BorderMinSize");
		BorderMinSize.addEntry(ColorTool.getMainColorAqua() + "Border Min Size : ");
		BorderMinSize.setSuffix(Border.getMinSize() + " x " + Border.getMinSize());
		obj.getScore(ColorTool.getMainColorAqua() + "Border Min Size : ").setScore(1);
		
		obj.getScore(ColorTool.getMainColorGray() + "============================").setScore(0);
	}
	
	public static void createScoreboardGame() {
		Objective obj = MainScoreboard.scoreboard.registerNewObjective("UHC Center Game", "dummy");
		obj.setDisplayName(ColorTool.getInventoryColor() + "UHC Center");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		obj.getScore(ColorTool.getMainColorGray() + "============ Timer ===========").setScore(6);
		
		Team timer = MainScoreboard.scoreboard.registerNewTeam("Timer");
		timer.addEntry(ColorTool.getMainColorAqua() + "Timer : ");
		timer.setSuffix((Timer.getTimer() / 60) + " min " + (Timer.getTimer() % 60) + " s");
		obj.getScore(ColorTool.getMainColorAqua() + "Timer : ").setScore(5);
		
		Team PVPtimer = MainScoreboard.scoreboard.registerNewTeam("PVPTimerGame");
		PVPtimer.addEntry(ColorTool.getMainColorAqua() + "PVP : ");
		PVPtimer.setSuffix(Timer.getPvpTimer() + " min");
		obj.getScore(ColorTool.getMainColorAqua() + "PVP : ").setScore(4);
		
		Team Bordertimer = MainScoreboard.scoreboard.registerNewTeam("BorderTimerGame");
		Bordertimer.addEntry(ColorTool.getMainColorAqua() + "Border : ");
		Bordertimer.setSuffix(Timer.getBorderTimer() + " min");
		obj.getScore(ColorTool.getMainColorAqua() + "Border : ").setScore(3);
		
		obj.getScore(ColorTool.getMainColorGray() + "=========== Border ==========").setScore(2);
		
		Team BorderSize = MainScoreboard.scoreboard.registerNewTeam("BorderSizeGame");
		BorderSize.addEntry(ColorTool.getMainColorAqua() + "Border Size : ");
		BorderSize.setSuffix(Bukkit.getWorld("world").getWorldBorder().getSize() + " x " + Bukkit.getWorld("world").getWorldBorder().getSize());
		obj.getScore(ColorTool.getMainColorAqua() + "Border Size : ").setScore(1);
		
		obj.getScore(ColorTool.getMainColorGray() + "============================").setScore(0);
	}
}
