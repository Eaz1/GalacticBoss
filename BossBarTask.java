package me.eaz.galacticbosses.tasks;

import me.eaz.galacticbosses.GalacticBosses;
import me.eaz.galacticbosses.bosses.BossBarManager;
import org.bukkit.entity.Wither;
import org.bukkit.scheduler.BukkitRunnable;

public class BossBarTask extends BukkitRunnable {

    private final GalacticBosses plugin;
    private final BossBarManager bossBarManager;

    public BossBarTask(GalacticBosses plugin, BossBarManager bossBarManager) {
        this.plugin = plugin;
        this.bossBarManager = bossBarManager;
    }

    @Override
    public void run() {

        if (!plugin.getBossManager().hasBoss()) {
            bossBarManager.removeAll();
            cancel();
            return;
        }

        Wither boss = plugin.getBossManager().getBoss();

        if (boss == null || boss.isDead()) {
            bossBarManager.removeAll();
            cancel();
            return;
        }

        bossBarManager.update(boss);
    }
}
