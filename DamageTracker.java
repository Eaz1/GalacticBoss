package me.eaz.galacticbosses.bosses;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DamageTracker {

    private final HashMap<UUID, Double> damageMap = new HashMap<>();

    /**
     * Adds damage dealt by a player.
     */
    public void addDamage(Player player, double damage) {

        damageMap.put(
                player.getUniqueId(),
                damageMap.getOrDefault(player.getUniqueId(), 0.0) + damage
        );
    }

    /**
     * Returns all recorded damage.
     */
    public Map<UUID, Double> getDamageMap() {
        return damageMap;
    }

    /**
     * Returns true if the player participated.
     */
    public boolean participated(Player player) {
        return damageMap.containsKey(player.getUniqueId());
    }

    /**
     * Returns the amount of damage a player dealt.
     */
    public double getDamage(Player player) {
        return damageMap.getOrDefault(player.getUniqueId(), 0.0);
    }

    /**
     * Returns the UUID of the highest damage dealer.
     */
    public UUID getTopDamager() {

        UUID winner = null;
        double highest = 0;

        for (Map.Entry<UUID, Double> entry : damageMap.entrySet()) {

            if (entry.getValue() > highest) {
                highest = entry.getValue();
                winner = entry.getKey();
            }

        }

        return winner;
    }

    /**
     * Clears all boss fight damage.
     */
    public void clear() {
        damageMap.clear();
    }

}
