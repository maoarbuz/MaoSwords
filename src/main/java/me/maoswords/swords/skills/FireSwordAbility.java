package me.maoswords.swords.skills;

import me.maoswords.utils.CooldownManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Fireball;

public class FireSwordAbility {

    private final CooldownManager cooldownManager = new CooldownManager(5000);

    public void useAbility(Player player) {
        if (cooldownManager.canUseAbility(player.getUniqueId())) {
            player.launchProjectile(Fireball.class);
            cooldownManager.setCooldown(player.getUniqueId());
        } else {
            long timeLeft = cooldownManager.getTimeLeft(player.getUniqueId());
            player.sendMessage(ChatColor.RED + "Ability will be available in " + timeLeft + " seconds.");
        }
    }

    public void useDamageEntity(Entity entity) {
        entity.setFireTicks(100);
    }
}
