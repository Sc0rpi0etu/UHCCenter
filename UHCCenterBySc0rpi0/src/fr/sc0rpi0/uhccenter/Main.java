package fr.sc0rpi0.uhccenter;

import org.bukkit.plugin.java.JavaPlugin;

import fr.sc0rpi0.uhccenter.commands.CommandController;
import fr.sc0rpi0.uhccenter.tools.Border;
import fr.sc0rpi0.uhccenter.tools.MainScoreboard;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.println("---------------------------------------------");
		System.out.println("Plugin UHCCenter is enabled");
		System.out.println("The author is Sc0rpi0");
		System.out.println("---------------------------------------------");
		
		// Configuration
		launchCommands();
		Border.getWorldBorder().setSize(200);
		MainScoreboard.createScoreboardLobby();
		
		// Listener
		getServer().getPluginManager().registerEvents(new MainListener(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("---------------------------------------------");
		System.out.println("Plugin UHCCenter is disabled");
		System.out.println("The author is Sc0rpi0");
		System.out.println("---------------------------------------------");
	}
	
	private void launchCommands() {
		getCommand("uhc").setExecutor(new CommandController(this));;
	}
}
