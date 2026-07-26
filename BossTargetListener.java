package me.eaz.galacticbosses.listeners;

import me.eaz.galacticbosses.GalacticBosses;
import me.eaz.galacticbosses.util.BossUtils;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class BossTargetListener implements Listener {

    private final GalacticBosses plugin;

    public BossTargetListener(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTarget(EntityTargetEvent event) {

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

        Player target = BossUtils.getNearestPlayer(boss.getLocation());

        if (target != null) {
            boss.setTarget(target);
        }
    }
          }
