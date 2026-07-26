package me.eaz.galacticbosses.listeners;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class BossProjectileListener implements Listener {

    private final GalacticBosses plugin;

    public BossProjectileListener(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {

        if (!(event.getEntity() instanceof WitherSkull)) {
            return;
        }

        Entity shooter = (Entity) ((WitherSkull) event.getEntity()).getShooter();

        if (!(shooter instanceof Wither)) {
            return;
        }

        if (!plugin.getBossManager().hasBoss()) {
            return;
        }

        Wither boss = plugin.getBossManager().getBoss();

        if (!shooter.getUniqueId().equals(boss.getUniqueId())) {
            return;
        }

        // Prevent charged (blue) skulls
        ((WitherSkull) event.getEntity()).setCharged(false);
    }
          }
