package me.maoswords.swords.skills;

import me.maoswords.utils.CooldownManager;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ThunderSwordAbility {

    private final CooldownManager cooldownManager = new CooldownManager(5000);

    public void useAbility(Player player) {
        if (cooldownManager.canUseAbility(player.getUniqueId())) {
            Block targetBlock = player.getTargetBlock(null, 50);
            if (targetBlock != null) {
                player.getWorld().strikeLightning(targetBlock.getLocation());
                cooldownManager.setCooldown(player.getUniqueId());
            } else {
                player.sendMessage(ChatColor.RED + "No target within reach.");
            }
        } else {
            long timeLeft = cooldownManager.getTimeLeft(player.getUniqueId());
            player.sendMessage(ChatColor.RED + "Ability will be available in " + timeLeft + " seconds.");
        }
    }

    public void useDamageEntity(Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1));
        }
    }
}
