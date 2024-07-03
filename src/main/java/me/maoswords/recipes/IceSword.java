package me.maoswords.recipes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class IceSword {

    private final JavaPlugin plugin;

    public IceSword(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerRecipes() {
        ItemStack fireSword = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta fireSwordMeta = fireSword.getItemMeta();
        fireSwordMeta.setDisplayName("§bIce Sword");
        fireSword.setItemMeta(fireSwordMeta);
        ShapedRecipe fireSwordRecipe = new ShapedRecipe(fireSword);
        fireSwordRecipe.shape(" F ", " F ", " S ");
        fireSwordRecipe.setIngredient('F', Material.SNOWBALL);
        fireSwordRecipe.setIngredient('S', Material.BLAZE_ROD);
        plugin.getServer().addRecipe(fireSwordRecipe);
    }
}
