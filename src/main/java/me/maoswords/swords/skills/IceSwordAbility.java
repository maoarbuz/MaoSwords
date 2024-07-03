package me.maoswords.swords.skills;

import me.maoswords.utils.CooldownManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.plugin.java.JavaPlugin;

public class IceSwordAbility {

    private final CooldownManager cooldownManager = new CooldownManager(5000);
    private final JavaPlugin plugin;

    public IceSwordAbility(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void useAbility(Player player) {
        if (cooldownManager.canUseAbility(player.getUniqueId())) {
            player.launchProjectile(Snowball.class);
        } else {
            long timeLeft = cooldownManager.getTimeLeft(player.getUniqueId());
            player.sendMessage(ChatColor.RED + "Способность будет доступна через " + timeLeft + " секунд.");
        }
    }

    public void useDamageEntity(Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
        }
    }
}
