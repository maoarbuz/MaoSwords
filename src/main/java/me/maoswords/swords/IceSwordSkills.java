package me.maoswords.swords;

import me.maoswords.swords.skills.IceSwordAbility;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class IceSwordSkills implements Listener {

    private final IceSwordAbility iceSwordAbility;
    private final JavaPlugin plugin;

    public IceSwordSkills(JavaPlugin plugin) {
        this.plugin = plugin;
        this.iceSwordAbility = new IceSwordAbility(plugin);
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item != null && item.getType() == Material.WOODEN_SWORD) {
            if (item.getItemMeta().getDisplayName().equals("§bIce Sword")) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    iceSwordAbility.useAbility(player);
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

                if (item.getItemMeta().getDisplayName().equals("§bIce Sword")) {
                    iceSwordAbility.useDamageEntity(entity);
                }
            }
        }
    }
}
