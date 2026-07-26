package me.eaz.galacticbosses.bosses;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.Location;
import org.bukkit.entity.Wither;

public class BossManager {

    private final GalacticBosses plugin;
    private Wither activeBoss;

    public BossManager(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    public boolean hasBoss() {
        return activeBoss != null && !activeBoss.isDead();
    }

    public Wither getBoss() {
        return activeBoss;
    }

    public void setBoss(Wither wither) {
        this.activeBoss = wither;
    }

    public void clearBoss() {
        this.activeBoss = null;
    }

    public boolean spawnBoss(Location location) {

        if (hasBoss()) {
            return false;
        }

        GalacticWither boss = new GalacticWither(plugin);
        activeBoss = boss.spawn(location);

        return true;
    }

    public void removeBoss() {

        if (activeBoss != null && !activeBoss.isDead()) {
            activeBoss.remove();
        }

        activeBoss = null;
    }
}
