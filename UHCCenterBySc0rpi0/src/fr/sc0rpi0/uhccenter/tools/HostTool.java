package fr.sc0rpi0.uhccenter.tools;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HostTool {
	
	private final static String hostCompassName = "§3§lHost Manager";
	private final static String timerClockName = "§3§lTimer Manager";
	private final static String borderFenceName = "§3§lBorder Manager";
	private final static String pluginArmorStandName = "§3§lPlugin Manager";

	public static String getHostCompassName() {
		return hostCompassName;
	}
	
	public static String getHostcompassname() {
		return hostCompassName;
	}

	public static String getTimerClockName() {
		return timerClockName;
	}

	public static String getBorderFenceName() {
		return borderFenceName;
	}

	public static String getPluginArmorStandName() {
		return pluginArmorStandName;
	}

	// compass
	public static ItemStack getHostCompass() {
		ItemStack it = new ItemStack(Material.COMPASS);
		ItemMeta im = it.getItemMeta();
		List<String> loreList = new ArrayList<String>();
		loreList.add(ColorTool.getMainColorGray() + "This tool will help you to make your own game.");
		
		im.setDisplayName(getHostCompassName());
		im.setLore(loreList);
		
		it.setItemMeta(im);
		
		return it;
	}
	
	// main inventory
	public static Inventory getMainInventory() {
		Inventory inv = Bukkit.createInventory(null, 9*5, hostCompassName);
		
		inv.setItem(9*2+1, MakeTool.makeItem(Material.WATCH, timerClockName, 1, 0));
		
		inv.setItem(9*2+4, MakeTool.makeItem(Material.FENCE, borderFenceName, 1, 0));
		
		inv.setItem(9*2+7, MakeTool.makeItem(Material.ARMOR_STAND, pluginArmorStandName, 1, 0));
		
		return inv;
	}
	
	// timer inventory
	@SuppressWarnings("deprecation")
	public static Inventory getTimerInventory() {
		Inventory inv = Bukkit.createInventory(null, 9*6, timerClockName);
		
		inv.setItem(9+2, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getDoubleNegativeColor() + "-10", 1, DyeColor.RED.getData()));
		inv.setItem(9+3, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getSimpleNegativeColor() + "-1", 1, DyeColor.MAGENTA.getData()));
		inv.setItem(9+4, MakeTool.makeItem(Material.SKULL_ITEM, ColorTool.getMainColorAqua() + "PVP : " + Timer.getPvpTimer() + " min", 1, 0));
		inv.setItem(9+5, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getSimplePositiveColor() + "+1", 1, DyeColor.LIME.getData()));
		inv.setItem(9+6, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getDoublePositiveColor() + "+10", 1, DyeColor.GREEN.getData()));
		
		inv.setItem(9*2+2, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getDoubleNegativeColor() + "-10", 1, DyeColor.RED.getData()));
		inv.setItem(9*2+3, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getSimpleNegativeColor() + "-1", 1, DyeColor.MAGENTA.getData()));
		inv.setItem(9*2+4, MakeTool.makeItem(Material.FENCE, ColorTool.getMainColorAqua() + "Border : " + Timer.getBorderTimer() + " min", 1, 0));
		inv.setItem(9*2+5, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getSimplePositiveColor() + "+1", 1, DyeColor.LIME.getData()));
		inv.setItem(9*2+6, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getDoublePositiveColor() + "+10", 1, DyeColor.GREEN.getData()));
		
		inv.setItem(9*4+4, MakeTool.makeItem(Material.BARRIER, ColorTool.getMainColorAqua() + "Get back", 1, 0));
		
		return inv;
	}
	
	// barrier inventory
	@SuppressWarnings("deprecation")
	public static Inventory getBarrierInventory() {
		Inventory inv = Bukkit.createInventory(null, 9*6, borderFenceName);
		
		inv.setItem(9+2, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getDoubleNegativeColor() + "-100", 1, DyeColor.RED.getData()));
		inv.setItem(9+3, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getSimpleNegativeColor() + "-10", 1, DyeColor.MAGENTA.getData()));
		inv.setItem(9+4, MakeTool.makeItem(Material.FENCE, ColorTool.getMainColorAqua() + "Size : " + Border.getSize() + " x " + Border.getSize(), 1, 0));
		inv.setItem(9+5, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getSimplePositiveColor() + "+10", 1, DyeColor.LIME.getData()));
		inv.setItem(9+6, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getDoublePositiveColor() + "+100", 1, DyeColor.GREEN.getData()));
		
		inv.setItem(9*2+2, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getDoubleNegativeColor() + "-10", 1, DyeColor.RED.getData()));
		inv.setItem(9*2+3, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getSimpleNegativeColor() + "-1", 1, DyeColor.MAGENTA.getData()));
		inv.setItem(9*2+4, MakeTool.makeItem(Material.FEATHER, ColorTool.getMainColorAqua() + "Speed : " + Border.getSpeed() + " block/min", 1, 0));
		inv.setItem(9*2+5, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getSimplePositiveColor() + "+1", 1, DyeColor.LIME.getData()));
		inv.setItem(9*2+6, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getDoublePositiveColor() + "+10", 1, DyeColor.GREEN.getData()));
		
		inv.setItem(9*3+2, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getDoubleNegativeColor() + "-10", 1, DyeColor.RED.getData()));
		inv.setItem(9*3+3, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getSimpleNegativeColor() + "-1", 1, DyeColor.MAGENTA.getData()));
		inv.setItem(9*3+4, MakeTool.makeItem(Material.FENCE, ColorTool.getMainColorAqua() + "Min Size : " + Border.getMinSize() + " x " + Border.getMinSize(), 1, 0));
		inv.setItem(9*3+5, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getSimplePositiveColor() + "+1", 1, DyeColor.LIME.getData()));
		inv.setItem(9*3+6, MakeTool.makeItem(Material.STAINED_CLAY, ColorTool.getDoublePositiveColor() + "+10", 1, DyeColor.GREEN.getData()));
		
		inv.setItem(9*5+4, MakeTool.makeItem(Material.BARRIER, ColorTool.getMainColorAqua() + "Get back", 1, 0));
		
		return inv;
	}
	
	// plugin inventory
	public static Inventory getPluginInventory() {
		Inventory inv = Bukkit.createInventory(null, 9*6, pluginArmorStandName);
		
		inv.setItem(9*4+4, MakeTool.makeItem(Material.BARRIER, ColorTool.getMainColorAqua() + "Get back", 1, 0));
		
		return inv;
	}

	public static void onInventoryAction(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		ItemStack it = event.getCurrentItem();
		Player player = (Player) event.getWhoClicked();
		int slot = event.getSlot();
		
		event.setCancelled(true);
		
		switch (inv.getName()) {
			case hostCompassName:
				switch (it.getItemMeta().getDisplayName()) {
					case timerClockName:
						player.openInventory(getTimerInventory());
						break;
						
					case borderFenceName:
						player.openInventory(getBarrierInventory());
						break;
						
					case pluginArmorStandName:
						player.openInventory(getPluginInventory());
						break;
				}
				break;
				
			case timerClockName:
				switch (it.getItemMeta().getDisplayName()) {
					case "§bGet back":
						player.openInventory(getMainInventory());
						break;
					
					case "§4-10":
						System.out.println(Timer.getPvpTimer() + " " + Timer.getBorderTimer());
						if ((int)(slot / 9) == 1) {
							System.out.println(Timer.getPvpTimer());
							Timer.addPvpTimer(-10);
							System.out.println(Timer.getPvpTimer());
						} else {
							Timer.addBorderTimer(-10);
						}
						break;
						
					case "§c-1":
						if ((int)(slot / 9) == 1) {
							Timer.addPvpTimer(-1);
						} else {
							Timer.addBorderTimer(-1);
						}
						break;
						
					case "§a+1":
						if ((int)(slot / 9) == 1) {
							Timer.addPvpTimer(1);
						} else {
							Timer.addBorderTimer(1);
						}
						break;
						
					case "§2+10":
						if ((int)(slot / 9) == 1) {
							Timer.addPvpTimer(10);
						} else {
							Timer.addBorderTimer(10);
						}
						break;
						
					default:
						break;
				}
				inv.setItem(9+4, MakeTool.makeItem(Material.SKULL_ITEM, ColorTool.getMainColorAqua() + "PVP : " + Timer.getPvpTimer() + " min", 1, 0));
				inv.setItem(9*2+4, MakeTool.makeItem(Material.FENCE, ColorTool.getMainColorAqua() + "Border : " + Timer.getBorderTimer() + " min", 1, 0));
				break;
				
			case borderFenceName:
				switch (it.getItemMeta().getDisplayName()) {
					case "§bGet back":
						player.openInventory(getMainInventory());
						break;
					
					case "§4-10":
					case "§4-100":
						switch (slot / 9) {
							case 1:
								Border.addSize(-100);
								if (Border.getSize() < Border.getMinSize()) {
									Border.addSize(100);
								}
								break;
							case 2:
								Border.addSpeed(-10);
								break;
							case 3:
								Border.addMinSize(-100);
								if (Border.getSize() < Border.getMinSize()) {
									Border.addMinSize(100);
								}
								break;
						}
						break;
						
					case "§c-1":
					case "§c-10":
						switch (slot / 9) {
							case 1:
								Border.addSize(-10);
								if (Border.getSize() < Border.getMinSize()) {
									Border.addSize(10);
								}
								break;
							case 2:
								Border.addSpeed(-1);
								break;
							case 3:
								Border.addMinSize(-10);
								if (Border.getSize() < Border.getMinSize()) {
									Border.addMinSize(10);
								}
								break;
						}
						break;
						
					case "§a+1":
					case "§a+10":
						switch (slot / 9) {
							case 1:
								Border.addSize(10);
								if (Border.getSize() < Border.getMinSize()) {
									Border.addSize(-10);
								}
								break;
							case 2:
								Border.addSpeed(1);
								break;
							case 3:
								Border.addMinSize(10);
								if (Border.getSize() < Border.getMinSize()) {
									Border.addMinSize(-10);
								}
								break;
						}
						break;
						
					case "§2+10":
					case "§2+100":
						switch (slot / 9) {
							case 1:
								Border.addSize(100);
								if (Border.getSize() < Border.getMinSize()) {
									Border.addSize(-100);
								}
								break;
							case 2:
								Border.addSpeed(10);
								break;
							case 3:
								Border.addMinSize(100);
								if (Border.getSize() < Border.getMinSize()) {
									Border.addMinSize(-100);
								}
								break;
						}
						break;
						
					default:
						break;
				}
				inv.setItem(9+4, MakeTool.makeItem(Material.FENCE, ColorTool.getMainColorAqua() + "Size : " + Border.getSize() + " x " + Border.getSize(), 1, 0));
				inv.setItem(9*2+4, MakeTool.makeItem(Material.FEATHER, ColorTool.getMainColorAqua() + "Speed : " + Border.getSpeed() + " block/min", 1, 0));
				inv.setItem(9*3+4, MakeTool.makeItem(Material.FENCE, ColorTool.getMainColorAqua() + "Min Size : " + Border.getMinSize() + " x " + Border.getMinSize(), 1, 0));
				break;
				
			case pluginArmorStandName:
				if (it.getItemMeta().getDisplayName().equals("§bGet back")) {
					player.openInventory(getMainInventory());
				}
				break;
		}
		
	}
}
