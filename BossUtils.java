package me.eaz.galacticbosses.util;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public final class BossUtils {

    private BossUtils() {
    }

    public static void setupBoss(Wither wither, double health, String name) {

        wither.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
        wither.setHealth(health);

        wither.setCustomName(ChatColor.translateAlternateColorCodes('&', name));
        wither.setCustomNameVisible(true);

        wither.setAI(false);
        wither.setRemoveWhenFarAway(false);
        wither.setPersistent(true);
    }

    public static Player getNearestPlayer(Location location) {

        Player nearest = null;
        double distance = Double.MAX_VALUE;

        for (Player player : location.getWorld().getPlayers()) {

            double d = player.getLocation().distanceSquared(location);

            if (d < distance) {
                distance = d;
                nearest = player;
            }
        }

        return nearest;
    }

    public static void equipIronArmor(EntityEquipment equipment) {

        equipment.setHelmet(new ItemStack(Material.IRON_HELMET));
        equipment.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        equipment.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        equipment.setBoots(new ItemStack(Material.IRON_BOOTS));
    }
}
