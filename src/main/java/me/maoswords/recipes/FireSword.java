package me.maoswords.recipes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class FireSword {

    private final JavaPlugin plugin;

    public FireSword(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerRecipes() {
        ItemStack fireSword = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta fireSwordMeta = fireSword.getItemMeta();
        fireSwordMeta.setDisplayName("§cFire Sword");
        fireSword.setItemMeta(fireSwordMeta);
        ShapedRecipe fireSwordRecipe = new ShapedRecipe(fireSword);
        fireSwordRecipe.shape(" F ", " F ", " S ");
        fireSwordRecipe.setIngredient('F', Material.FLINT_AND_STEEL);
        fireSwordRecipe.setIngredient('S', Material.BLAZE_ROD);
        plugin.getServer().addRecipe(fireSwordRecipe);
    }
}
