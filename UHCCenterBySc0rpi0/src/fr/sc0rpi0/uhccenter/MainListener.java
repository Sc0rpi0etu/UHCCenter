package fr.sc0rpi0.uhccenter;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.sc0rpi0.uhccenter.tools.HostTool;
import fr.sc0rpi0.uhccenter.tools.MainScoreboard;
import fr.sc0rpi0.uhccenter.tools.PlayerInGame;
import fr.sc0rpi0.uhccenter.tools.Spawn;
import fr.sc0rpi0.uhccenter.tools.Timer;

public class MainListener implements Listener {
	public MainListener() {
		Spawn.generateSpawn();
	}

	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.setScoreboard(MainScoreboard.getScoreboard());
		
		if (!PlayerInGame.contains(player)) {
			player.setGameMode(GameMode.ADVENTURE);
			player.teleport(Spawn.getSpawn());
			PlayerInGame.add(player);
		}
		
		// if host
		if (PlayerInGame.isHost(player)) {
			// if host doesn't have hostcompass
			ItemStack hostCompass = HostTool.getHostCompass();
			if (!player.getInventory().contains(hostCompass)) {
				player.getInventory().addItem(HostTool.getHostCompass());
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemStack it = event.getItem();
		Action action = event.getAction();
		
		if (it == null) return;
		
		// if host and interact with hostCompass
		if (PlayerInGame.isHost(player) && (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) && it.equals(HostTool.getHostCompass())) {
			player.openInventory(HostTool.getMainInventory());
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		
		if (inv.getName().equals(HostTool.getBorderFenceName()) || inv.getName().equals(HostTool.getHostCompassName()) || inv.getName().equals(HostTool.getPluginArmorStandName()) || inv.getName().equals(HostTool.getTimerClockName())) {
			HostTool.onInventoryAction(event);
		}
	}
	
	@EventHandler
	public void onPlayerDamagePlayer(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
			if (!Timer.isPVP()) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			if (Timer.isNoDamage()) {
				event.setCancelled(true);
			}
		}
	}
}
