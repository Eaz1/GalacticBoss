package me.eaz.galacticbosses.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Skeleton;

public class MinionDeathListener implements Listener {

    @EventHandler
    public void onMinionDeath(EntityDeathEvent event) {

        if (event.getEntity() instanceof Zombie) {

            Zombie zombie = (Zombie) event.getEntity();

            if (zombie.getCustomName() != null &&
                    zombie.getCustomName().contains("Galactic")) {

                event.getDrops().clear();
                event.setDroppedExp(0);
            }
        }

        if (event.getEntity() instanceof Skeleton) {

            Skeleton skeleton = (Skeleton) event.getEntity();

            if (skeleton.getCustomName() != null &&
                    skeleton.getCustomName().contains("Galactic")) {

                event.getDrops().clear();
                event.setDroppedExp(0);
            }
        }
    }
        }
