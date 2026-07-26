package me.eaz.galacticbosses.listeners;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Map;
import java.util.UUID;

public class BossDeathListener implements Listener {

    private final GalacticBosses plugin;

    public BossDeathListener(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBossDeath(EntityDeathEvent event) {

        if (!(event.getEntity() instanceof Wither)) {
            return;
        }

        if (!plugin.getBossManager().hasBoss()) {
            return;
        }

        Wither boss = plugin.getBossManager().getBoss();

        if (!event.getEntity().getUniqueId().equals(boss.getUniqueId())) {
            return;
        }

        event.getDrops().clear();
        event.setDroppedExp(0);

        UUID winner = plugin.getDamageTracker().getTopDamager();

        for (Map.Entry<UUID, Double> entry : plugin.getDamageTracker().getDamageMap().entrySet()) {

            Player player = Bukkit.getPlayer(entry.getKey());

            if (player == null) {
                continue;
            }

            plugin.getVaultEconomy().deposit(player, 5000);

            player.sendMessage(ChatColor.GREEN + "You received $5,000 for participating!");
        }

        if (winner != null) {

            Player player = Bukkit.getPlayer(winner);

            if (player != null) {

                plugin.getVaultEconomy().deposit(player, 10000);

                plugin.getCrazyCratesHook().giveGalacticKey(player);

                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD +
                        player.getName() +
                        ChatColor.LIGHT_PURPLE +
                        " dealt the most damage and received a Galactic Key + $10,000!");
            }
        }

        plugin.getDamageTracker().clear();
        plugin.getBossManager().removeBoss();

        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE +
                "The Galactic Wither has been defeated!");
    }
}
