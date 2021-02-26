package me.Ben.mcProject;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;


import me.Ben.mcProject.commands.command;
import me.Ben.mcProject.listiners.blockBreak;
import me.Ben.mcProject.listiners.dragonSpawn;
import net.md_5.bungee.api.ChatColor;


public class Main extends JavaPlugin implements Listener
{
	private final blockBreak blockListener = new blockBreak();
	
	
	public static Map<String, ItemStack[]> menus = new HashMap<String, ItemStack[]>();
	
	
	
    public void onEnable() {
    	this.saveDefaultConfig();
    	
    	if (this.getConfig().contains("data"))
    	{
    		this.loadInvs();;
    	}
    	
    	PluginManager pm = getServer().getPluginManager();
    	//pm.registerEvents(stickListener, this);
    	pm.registerEvents(blockListener, this);
    	
    	pm.registerEvents(this, this);
    	
    	
    	
    	
    	Bukkit.addRecipe((Recipe)this.getVaultBlock());
    	Bukkit.addRecipe((Recipe)this.getDragonSpawn());
        Bukkit.addRecipe((Recipe)this.getGodAppleRecipe());
        Bukkit.addRecipe((Recipe)this.getNameTagRecipe());
        Bukkit.addRecipe((Recipe)this.getSaddleRecipe());
        Bukkit.addRecipe((Recipe)this.getTotemRecipe());
        Bukkit.addRecipe((Recipe) this.getUselessFeather());
        Bukkit.addRecipe((Recipe) this.getUselessStick());
        
        
        getCommand("hello").setExecutor(new command());
        
    }
    
    public ShapedRecipe getGodAppleRecipe() {
        final ItemStack item = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        final NamespacedKey key = new NamespacedKey((Plugin)this, "enchanted_golden_apple");
        final ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(new String[] { "GGG", "GAG", "GGG" });
        recipe.setIngredient('G', Material.GOLD_BLOCK);
        recipe.setIngredient('A', Material.APPLE);
        return recipe;
    }
    
    public ShapedRecipe getNameTagRecipe() {
        final ItemStack item = new ItemStack(Material.NAME_TAG);
        final NamespacedKey key = new NamespacedKey((Plugin)this, "name_tag");
        final ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(new String[] { "***", "LPL", "*S*" });
        recipe.setIngredient('P', Material.PAPER);
        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('S', Material.STRING);
        recipe.setIngredient('*', Material.AIR);
        return recipe;
    }
    
    public ShapedRecipe getSaddleRecipe() {
        final ItemStack item = new ItemStack(Material.SADDLE);
        final NamespacedKey key = new NamespacedKey((Plugin)this, "saddle");
        final ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(new String[] { "***", "LLL", "***" });
        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('*', Material.AIR);
        return recipe;
    }
    
    public ShapedRecipe getTotemRecipe() {
        final ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING);
        final NamespacedKey key = new NamespacedKey((Plugin)this, "totem_of_undying");
        final ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(new String[] { "EGE", "GGG", "GAG" });
        recipe.setIngredient('G', Material.GOLD_BLOCK);
        recipe.setIngredient('E', Material.EMERALD);
        recipe.setIngredient('A', Material.ENCHANTED_GOLDEN_APPLE);
        return recipe;
    }
    
    public ShapedRecipe getDragonSpawn() {
        final ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Dragon Spawn");
        List<String> lore = new ArrayList <String>();
        lore.add(" ");
        lore.add(ChatColor.GOLD + "Summmons the Ender Dragon in any dimension");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        final NamespacedKey key = new NamespacedKey((Plugin)this,"dragon_spawn");
        final ShapedRecipe recipe = new ShapedRecipe(key, item);
        
        recipe.shape(new String[] { "***", "NSH", "***" });
        recipe.setIngredient('H', Material.DRAGON_HEAD);
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('N', Material.NETHER_STAR);
       
        recipe.setIngredient('*', Material.AIR);
        return recipe;
    }
    
    public ShapedRecipe getVaultBlock() {
        final ItemStack item = new ItemStack(Material.CHEST);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Vault");
        List<String> lore = new ArrayList <String>();
        lore.add(" ");
        lore.add(ChatColor.GOLD + "Stores your extra items");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        
        final NamespacedKey key = new NamespacedKey((Plugin)this,"vault");
        final ShapedRecipe recipe = new ShapedRecipe(key, item);
        
        recipe.shape(new String[] { "III", "ICI", "III" });
        recipe.setIngredient('C', Material.CHEST);
        recipe.setIngredient('I', Material.IRON_BLOCK);
        
        return recipe;
    }
    
    
    public ShapedRecipe getUselessFeather() {
        final ItemStack item = new ItemStack(Material.FEATHER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Normal Feather");
        List<String> lore = new ArrayList <String>();
        lore.add(" ");
        lore.add(ChatColor.GOLD + "Just a normal feather");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1000, true);
        meta.addEnchant(Enchantment.KNOCKBACK, 1000, true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        
        final NamespacedKey key = new NamespacedKey((Plugin)this,"normal_feather");
        final ShapedRecipe recipe = new ShapedRecipe(key, item);
        
        recipe.shape(new String[] { "III", "ICI", "III" });
        recipe.setIngredient('C', Material.FEATHER);
        recipe.setIngredient('I', Material.AIR);
        
        return recipe;
    }
    
    public ShapedRecipe getUselessStick() {
        final ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Normal Stick");
        List<String> lore = new ArrayList <String>();
        lore.add(" ");
        lore.add(ChatColor.GOLD + "Just a normal Stick");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addEnchant(Enchantment.KNOCKBACK, 1000, true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        
        final NamespacedKey key = new NamespacedKey((Plugin)this,"normal_stick");
        final ShapedRecipe recipe = new ShapedRecipe(key, item);
        
        recipe.shape(new String[] { "III", "ICI", "III" });
        recipe.setIngredient('C', Material.STICK);
        recipe.setIngredient('I', Material.AIR);
        
        return recipe;
    }
    
    
    @Override 
    public void onDisable()
    {
    	if(!menus.isEmpty())
    	{
    		this.saveInvs();
    	}
    }
    
    public void saveInvs()
    {
    	for (Map.Entry<String, ItemStack[]> entry : menus.entrySet()) {
    		this.getConfig().set("data." + entry.getKey(), entry.getValue());
    	}
    	this.saveConfig();
    }
    
    public void loadInvs()
    {
    	this.getConfig().getConfigurationSection("data").getKeys(false).forEach(key ->{
    		@SuppressWarnings("unchecked")
			ItemStack[] content = ((List<ItemStack>) this.getConfig().get("data." + key)).toArray(new ItemStack[0]);
    		menus.put(key, content);
    	});
    }
    
    @EventHandler
	public void onDragonClick(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		
		
		if (player.getInventory().getItemInMainHand() == null)
		{
			return;
		}
		if(!(player.getInventory().getItemInMainHand().hasItemMeta()))
		{
			
			return;
		}
		if(!(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Dragon Spawn")))
		{
			
			return;
		}
		
		event.getAction();
		if(event.getAction().equals(org.bukkit.event.block.Action.LEFT_CLICK_AIR) || event.getAction().equals(org.bukkit.event.block.Action.LEFT_CLICK_BLOCK))
		{
			
			return;
		}
		
		
		Location loc = player.getLocation();
		World world = player.getWorld();
		ItemStack item = player.getInventory().getItemInMainHand();
		player.getInventory().remove(item);
		
		world.spawnEntity(loc, EntityType.ENDER_DRAGON);
		
		
		
		
	}
    @EventHandler
    public void onVaultOpen(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		
		
		if (player.getInventory().getItemInMainHand() == null)
		{
			return;
		}
		if(!(player.getInventory().getItemInMainHand().hasItemMeta()))
		{
			
			return;
		}
		if(!(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Vault")))
		{
			
			return;
		}
		
		event.getAction();
		if(event.getAction().equals(org.bukkit.event.block.Action.LEFT_CLICK_AIR) || event.getAction().equals(org.bukkit.event.block.Action.LEFT_CLICK_BLOCK))
		{
			
			return;
		}
		
		
		Inventory inv = Bukkit.createInventory(player, 54, player.getName() + "'s Private Vault");
		
		if (Main.menus.containsKey(player.getUniqueId().toString()))
		{
			inv.setContents(Main.menus.get(player.getUniqueId().toString()));
		}
		
		player.openInventory(inv);
		
		
		
		
	}
    @EventHandler
    public void onVaultPlace(BlockPlaceEvent event)
	{
Player player = event.getPlayer();
		
		
		if (player.getInventory().getItemInMainHand() == null)
		{
			return;
		}
		if(!(player.getInventory().getItemInMainHand().hasItemMeta()))
		{
			
			return;
		}
		if(!(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Vault")))
		{
			
			return;
		}
		
		
		event.setCancelled(true);
	}
    
    @EventHandler
    public void onBedrockPlace(BlockPlaceEvent event)
	{
Player player = event.getPlayer();

ItemStack item = new ItemStack(Material.BEDROCK);
		
		
		if (player.getInventory().getItemInMainHand() == null)
		{
			return;
		}
		if(!(player.getInventory().getItemInMainHand().equals(item)))
		{
			
			return;
		}
		if(!(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Vault")))
		{
			
			return;
		}
		
		
		event.setCancelled(true);
	}
    @EventHandler
	public void onGuiClose(InventoryCloseEvent event)
	{
		if(event.getView().getTitle().contains(event.getPlayer().getName() + "'s Private Vault"))
		{
			Main.menus.put(event.getPlayer().getUniqueId().toString(), event.getInventory().getContents());
		}
	}
}



 

