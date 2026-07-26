package me.eaz.galacticbosses.util;

import org.bukkit.ChatColor;

public final class MessageUtil {

    private MessageUtil() {
    }

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String prefix() {
        return color("&8[&5&lGalacticBosses&8] &r");
    }

    public static String bossSpawn() {
        return prefix() + color("&5&lThe Galactic Wither has appeared!");
    }

    public static String bossDeath() {
        return prefix() + color("&dThe Galactic Wither has been defeated!");
    }

    public static String winner(String player) {
        return prefix() + color("&d" + player + " dealt the most damage and earned the Galactic Key!");
    }

    public static String participationReward() {
        return prefix() + color("&aYou received $5,000 for participating!");
    }

    public static String topReward() {
        return prefix() + color("&6You received an extra $10,000 and a Galactic Key!");
    }

          }
