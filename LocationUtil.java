package me.eaz.galacticbosses.util;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.Random;

public final class LocationUtil {

    private static final Random RANDOM = new Random();

    private LocationUtil() {
    }

    public static Location randomLocation(Location center, int radius) {

        double x = center.getX() + (RANDOM.nextDouble() * radius * 2) - radius;
        double z = center.getZ() + (RANDOM.nextDouble() * radius * 2) - radius;

        World world = center.getWorld();

        int y = world.getHighestBlockYAt((int) x, (int) z) + 1;

        return new Location(world, x, y, z);
    }

    public static boolean isWithinRadius(Location first, Location second, double radius) {

        if (!first.getWorld().equals(second.getWorld())) {
            return false;
        }

        return first.distanceSquared(second) <= radius * radius;
    }

    public static Location center(Location location) {

        return new Location(
                location.getWorld(),
                location.getBlockX() + 0.5,
                location.getY(),
                location.getBlockZ() + 0.5,
                location.getYaw(),
                location.getPitch()
        );
    }

                                         }
