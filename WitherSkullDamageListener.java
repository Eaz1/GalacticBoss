package me.eaz.galacticbosses.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.WitherSkull;

public class WitherSkullDamageListener implements Listener {

    @EventHandler
    public void onSkullDamage(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof WitherSkull)) {
            return;
        }

        // Force every wither skull to deal exactly 25 damage
        event.setDamage(25.0);
    }
}
