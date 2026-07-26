package me.eaz.galacticbosses.util;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;

public final class EntityUtil {

    private EntityUtil() {
    }

    public static void setMaxHealth(LivingEntity entity, double health) {

        entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
        entity.setHealth(health);
    }

    public static void makePersistent(LivingEntity entity) {
        entity.setRemoveWhenFarAway(false);
    }

    public static void setCustomName(LivingEntity entity, String name) {
        entity.setCustomName(MessageUtil.color(name));
        entity.setCustomNameVisible(true);
    }

    public static void freeze(Monster monster) {

        monster.setAI(false);

        if (monster.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
            monster.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.0D);
        }
    }

    public static void unfreeze(Monster monster) {

        monster.setAI(true);

        if (monster.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
            monster.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.23D);
        }
    }

  }
