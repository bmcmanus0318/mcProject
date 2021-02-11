package me.Ben.mcProject;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.Recipe;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;



import me.Ben.mcProject.commands.command;

public class Main extends JavaPlugin
{
    public void onEnable() {
    	
    	PluginManager pm = getServer().getPluginManager();
    	pm.registerEvents(, this);
    	
    	
    	
    	
        Bukkit.addRecipe((Recipe)this.getGodAppleRecipe());
        Bukkit.addRecipe((Recipe)this.getNameTagRecipe());
        Bukkit.addRecipe((Recipe)this.getSaddleRecipe());
        Bukkit.addRecipe((Recipe)this.getTotemRecipe());
        
        
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
}



 

