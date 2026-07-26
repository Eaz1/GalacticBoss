package me.eaz.galacticbosses.util;

import org.bukkit.Bukkit;

public final class VersionUtil {

    private VersionUtil() {
    }

    public static String getVersion() {
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    }

    public static boolean is1_12() {
        return getVersion().startsWith("v1_12");
    }

    public static boolean isCompatible() {
        return is1_12();
    }

    public static void checkVersion() {

        if (!isCompatible()) {
            Bukkit.getLogger().warning("--------------------------------");
            Bukkit.getLogger().warning("GalacticBosses");
            Bukkit.getLogger().warning("This plugin is designed for Spigot 1.12.x");
            Bukkit.getLogger().warning("Detected: " + getVersion());
            Bukkit.getLogger().warning("--------------------------------");
        }

    }

}
