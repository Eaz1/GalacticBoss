package me.eaz.galacticbosses.bosses;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wither;

public class BossManager {
    private final GalacticBosses plugin;
    private Wither boss;
    public BossManager(GalacticBosses plugin){this.plugin=plugin;}
    public void spawnBoss(Location location){
        if(hasBoss()) return;
        boss=(Wither)location.getWorld().spawnEntity(location,EntityType.WITHER);
        boss.setCustomName(plugin.getConfig().getString("boss.name","§5§lGalactic Wither"));
        boss.setCustomNameVisible(true);
        boss.setRemoveWhenFarAway(false);
        double health=plugin.getConfig().getDouble("boss.health",5000.0);
        boss.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
        boss.setHealth(health);
        boss.setAI(false);
    }
    public boolean hasBoss(){return boss!=null && !boss.isDead();}
    public Wither getBoss(){return boss;}
}
