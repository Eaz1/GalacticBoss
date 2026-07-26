package me.eaz.galacticbosses.listeners;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BossJoinListener implements Listener {

    private final GalacticBosses plugin;

    public BossJoinListener(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        if (!plugin.getBossManager().hasBoss()) {
            return;
        }

        Player player = event.getPlayer();

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.sendMessage("");
            player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Galactic Boss");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "A Galactic Wither is currently alive!");
            player.sendMessage(ChatColor.GRAY + "Use /bossinfo to view information.");
            player.sendMessage("");
        }, 40L);
    }
}
