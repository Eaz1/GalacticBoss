package me.eaz.galacticbosses.rewards;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RewardManager {

    private final HashMap<UUID, Double> damageMap = new HashMap<>();

    public void addDamage(Player player, double damage) {
        damageMap.put(
                player.getUniqueId(),
                damageMap.getOrDefault(player.getUniqueId(), 0.0) + damage
        );
    }

    public Map<UUID, Double> getDamageMap() {
        return damageMap;
    }

    public UUID getTopDamager() {

        UUID top = null;
        double highest = 0;

        for (Map.Entry<UUID, Double> entry : damageMap.entrySet()) {

            if (entry.getValue() > highest) {
                highest = entry.getValue();
                top = entry.getKey();
            }

        }

        return top;
    }

    public void clear() {
        damageMap.clear();
    }

    public void rewardPlayers() {

        // Everyone gets $5,000
        for (UUID uuid : damageMap.keySet()) {

            Player player = Bukkit.getPlayer(uuid);

            if (player == null) {
                continue;
            }

            // TODO
            // Give player $5,000
        }

        // Top damage player
        UUID top = getTopDamager();

        if (top != null) {

            Player winner = Bukkit.getPlayer(top);

            if (winner != null) {

                // TODO
                // Give winner $10,000
                // Give 1 Galactic Key
                // Broadcast winner

            }
        }

        clear();
    }
  }
