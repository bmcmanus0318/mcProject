package me.Ben.mcProject.listiners;

import java.awt.Color;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class blockBreak implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		Block block = event.getBlock();
		String p = event.getPlayer().getName();
		
		
		Bukkit.broadcastMessage(p + " MINED " + block.getType());
	}
	
	@EventHandler
	public void onDiamondBreak(BlockBreakEvent event)
	{
		Block block = event.getBlock();
		Player p = event.getPlayer();
		Inventory inv = p.getInventory();
		
		if (block.getType() == Material.DIAMOND_ORE)
		{
			final ItemStack item = new ItemStack(Material.STONE);
			event.setDropItems(false);
			inv.addItem(item);
			p.sendMessage(ChatColor.RED + "NO DIAMOND 4 U. HAHAHAHAH.");
		}
		
		
	}

}
