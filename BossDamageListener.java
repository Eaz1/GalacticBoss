package me.eaz.galacticbosses.rewards;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.Map;
import java.util.UUID;

public class RewardManager {

    private final GalacticBosses plugin;

    public RewardManager(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    public void giveRewards() {

        Map<UUID, Double> damage = plugin.getDamageTracker().getDamageMap();

        if (damage.isEmpty()) {
            return;
        }

        double participationReward = plugin.getConfig().getDouble("boss.participant-reward", 5000);
        double topReward = plugin.getConfig().getDouble("boss.top-damage-reward", 10000);
        String crate = plugin.getConfig().getString("boss.crate-name", "Galactic");

        UUID winner = plugin.getDamageTracker().getTopDamager();

        for (UUID uuid : damage.keySet()) {

            OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);

            plugin.getVaultEconomy().deposit(player, participationReward);

            if (uuid.equals(winner)) {

                plugin.getVaultEconomy().deposit(player, topReward);

                plugin.getCrazyCratesHook().giveGalacticKey(player);

                Bukkit.dispatchCommand(
                        Bukkit.getConsoleSender(),
                        "cc give physical " + player.getName() + " " + crate + " 1"
                );
            }
        }

        plugin.getDamageTracker().clear();
    }
             }
