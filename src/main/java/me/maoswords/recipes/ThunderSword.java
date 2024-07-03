package me.maoswords.recipes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class ThunderSword {

    private final JavaPlugin plugin;

    public ThunderSword(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerRecipes() {
        ItemStack thunderSword = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta thunderSwordMeta = thunderSword.getItemMeta();
        thunderSwordMeta.setDisplayName("§3Thunder Sword");
        thunderSword.setItemMeta(thunderSwordMeta);
        ShapedRecipe thunderSwordRecipe = new ShapedRecipe(thunderSword);
        thunderSwordRecipe.shape(" I ", " I ", " S ");
        thunderSwordRecipe.setIngredient('I', Material.IRON_INGOT);
        thunderSwordRecipe.setIngredient('S', Material.BLAZE_ROD);
        plugin.getServer().addRecipe(thunderSwordRecipe);
    }
}
