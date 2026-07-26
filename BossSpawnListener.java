package me.eaz.galacticbosses.listeners;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.ChatColor;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class BossSpawnListener implements Listener {

    private final GalacticBosses plugin;

    public BossSpawnListener(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBossSpawn(CreatureSpawnEvent event) {

        if (!(event.getEntity() instanceof Wither)) {
            return;
        }

        if (!plugin.getBossManager().hasBoss()) {
            return;
        }

        Wither boss = (Wither) event.getEntity();

        if (!boss.getUniqueId().equals(plugin.getBossManager().getBoss().getUniqueId())) {
            return;
        }

        boss.setCustomName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Galactic Wither");
        boss.setCustomNameVisible(true);
        boss.setRemoveWhenFarAway(false);

        plugin.getLogger().info("Galactic Wither spawned successfully.");
    }
}
