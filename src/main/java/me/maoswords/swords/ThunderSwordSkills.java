package me.maoswords.swords;

import me.maoswords.swords.skills.ThunderSwordAbility;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ThunderSwordSkills implements Listener {

    private final ThunderSwordAbility thunderSwordAbility = new ThunderSwordAbility();

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item != null && item.getType() == Material.WOODEN_SWORD) {
            if (item.getItemMeta().getDisplayName().equals("§3Thunder Sword")) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    thunderSwordAbility.useAbility(player);
                }
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack item = player.getInventory().getItemInMainHand();

            if (item != null && item.getType() == Material.WOODEN_SWORD) {
                Entity entity = event.getEntity();

                if (item.getItemMeta().getDisplayName().equals("§3Thunder Sword")) {
                    thunderSwordAbility.useDamageEntity(entity);
                }
            }
        }
    }
}
