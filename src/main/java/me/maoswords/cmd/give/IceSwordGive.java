package me.maoswords.cmd.give;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IceSwordGive {
    public void giveIceSword(Player player) {
        ItemStack iceSword = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta iceSwordMeta = iceSword.getItemMeta();
        iceSwordMeta.setDisplayName("§bIce Sword");
        iceSword.setItemMeta(iceSwordMeta);
        player.getInventory().addItem(iceSword);
        player.sendMessage(ChatColor.GOLD + "You have been given a " + ChatColor.AQUA + "Ice Sword!");
    }
}
