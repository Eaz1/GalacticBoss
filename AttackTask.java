package me.eaz.galacticbosses.tasks;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkull;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class AttackTask extends BukkitRunnable {

    private final GalacticBosses plugin;
    private final Wither boss;

    public AttackTask(GalacticBosses plugin, Wither boss) {
        this.plugin = plugin;
        this.boss = boss;
    }

    @Override
    public void run() {

        if (boss == null || boss.isDead()) {
            cancel();
            return;
        }

        Player target = null;
        double closest = Double.MAX_VALUE;

        for (Player player : boss.getWorld().getPlayers()) {

            if (!player.isOnline() || player.isDead()) {
                continue;
            }

            double distance = player.getLocation().distanceSquared(boss.getLocation());

            if (distance < closest) {
                closest = distance;
                target = player;
            }
        }

        if (target == null) {
            return;
        }

        Vector direction = target.getEyeLocation().toVector()
                .subtract(boss.getEyeLocation().toVector())
                .normalize();

        WitherSkull skull = boss.launchProjectile(WitherSkull.class);

        skull.setCharged(false);

        skull.setVelocity(direction.multiply(1.5));

        boss.setTarget(target);
    }
                                                  }
