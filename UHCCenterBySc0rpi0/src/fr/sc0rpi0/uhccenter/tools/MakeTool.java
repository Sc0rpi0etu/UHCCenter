package fr.sc0rpi0.uhccenter.tools;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MakeTool {
	@SuppressWarnings("deprecation")
	public static ItemStack makeItem(Material material, String name, Integer amount, int data) {
		ItemStack it = new ItemStack(material, amount, (short) 0, (byte) data);
		ItemMeta im = it.getItemMeta();
		
		im.setDisplayName(name);
		it.setItemMeta(im);
		
		return it;
	}
}
