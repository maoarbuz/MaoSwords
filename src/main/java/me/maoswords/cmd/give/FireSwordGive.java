package me.maoswords.cmd.give;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FireSwordGive {
    public void giveFireSword(Player player) {
        ItemStack fireSword = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta fireSwordMeta = fireSword.getItemMeta();
        fireSwordMeta.setDisplayName("§cFire Sword");
        fireSword.setItemMeta(fireSwordMeta);
        player.getInventory().addItem(fireSword);
        player.sendMessage(ChatColor.GOLD + "You have been given a " + ChatColor.RED + "Fire Sword!");
    }
}
