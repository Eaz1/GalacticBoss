package me.eaz.galacticbosses.tasks;

import me.eaz.galacticbosses.GalacticBosses;
import me.eaz.galacticbosses.rewards.RewardManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class RewardTask {

    private final GalacticBosses plugin;
    private final RewardManager rewardManager;

    public RewardTask(GalacticBosses plugin, RewardManager rewardManager) {
        this.plugin = plugin;
        this.rewardManager = rewardManager;
    }

    public void rewardBossFight() {

        // Everyone who participated gets $5,000
        for (Map.Entry<UUID, Double> entry : rewardManager.getDamageMap().entrySet()) {

            Player player = Bukkit.getPlayer(entry.getKey());

            if (player == null) {
                continue;
            }

            giveMoney(player, 5000);

            player.sendMessage(ChatColor.GREEN +
                    "You received $5,000 for participating in the boss fight!");
        }

        // Top damage player
        UUID topUUID = rewardManager.getTopDamager();

        if (topUUID != null) {

            Player winner = Bukkit.getPlayer(topUUID);

            if (winner != null) {

                giveMoney(winner, 10000);

                giveGalacticKey(winner);

                Bukkit.broadcastMessage(
                        ChatColor.DARK_PURPLE +
                        "" + ChatColor.BOLD +
                        winner.getName() +
                        ChatColor.LIGHT_PURPLE +
                        " dealt the most damage to the Galactic Wither!"
                );
            }
        }

        rewardManager.clear();
    }

    private void giveMoney(Player player, double amount) {

        // TODO
        // Connect to your custom economy.
    }

    private void giveGalacticKey(Player player) {

        // TODO
        // Give the player a Galactic Key item.
    }
}
