package me.maoswords.cmd.give;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ThunderSwordGive {
    public void giveThunderSword(Player player) {
        ItemStack thunderSword = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta thunderSwordMeta = thunderSword.getItemMeta();
        thunderSwordMeta.setDisplayName("§3Thunder Sword");
        thunderSword.setItemMeta(thunderSwordMeta);
        player.getInventory().addItem(thunderSword);
        player.sendMessage(ChatColor.GOLD + "You have been given a " + ChatColor.DARK_AQUA + "Thunder Sword!");
    }
}
