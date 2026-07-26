package me.eaz.galacticbosses.listeners;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class WitherHealListener implements Listener {

    private final GalacticBosses plugin;

    public WitherHealListener(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWitherHeal(EntityRegainHealthEvent event) {

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

        // Prevent natural regeneration
        event.setCancelled(true);
    }
                                                    }
