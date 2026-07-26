package me.eaz.galacticbosses.listeners;

import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class MinionTargetListener implements Listener {

    @EventHandler
    public void onTarget(EntityTargetLivingEntityEvent event) {

        if (!(event.getEntity() instanceof Monster)) {
            return;
        }

        if (!(event.getTarget() instanceof Player)) {
            return;
        }

        Monster monster = (Monster) event.getEntity();

        if (monster.getCustomName() == null) {
            return;
        }

        if (!monster.getCustomName().contains("Galactic")) {
            return;
        }

        // Keep targeting players only.
        monster.setTarget((Player) event.getTarget());
    }
}
