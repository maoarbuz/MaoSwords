package me.maoswords.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {

    private final Map<UUID, Long> cooldowns = new HashMap<>();
    private final long cooldownTime;

    public CooldownManager(long cooldownTime) {
        this.cooldownTime = cooldownTime;
    }

    public boolean canUseAbility(UUID playerUUID) {
        if (!cooldowns.containsKey(playerUUID)) {
            return true;
        }
        long lastUseTime = cooldowns.get(playerUUID);
        return System.currentTimeMillis() - lastUseTime >= cooldownTime;
    }

    public void setCooldown(UUID playerUUID) {
        cooldowns.put(playerUUID, System.currentTimeMillis());
    }

    public long getTimeLeft(UUID playerUUID) {
        if (!cooldowns.containsKey(playerUUID)) {
            return 0;
        }
        long lastUseTime = cooldowns.get(playerUUID);
        return (cooldownTime - (System.currentTimeMillis() - lastUseTime)) / 1000;
    }
}
