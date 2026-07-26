package me.eaz.galacticbosses.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class WitherBlockBreakListener implements Listener {

    @EventHandler
    public void onExplosionPrime(ExplosionPrimeEvent event) {

        if (event.getEntityType() != EntityType.WITHER) {
            return;
        }

        // Prevent block damage
        event.setRadius(0F);

        // Keep explosion effect
        event.setFire(false);
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {

        if (event.getEntityType() != EntityType.WITHER) {
            return;
        }

        // Prevent all block destruction
        event.blockList().clear();
    }
}
