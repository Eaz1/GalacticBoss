package me.eaz.galacticbosses.crates;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class CrazyCratesHook {

    public void giveGalacticKey(OfflinePlayer player) {

        if (player == null || player.getName() == null) {
            return;
        }

        Bukkit.dispatchCommand(
                Bukkit.getConsoleSender(),
                "cc give physical " + player.getName() + " Galactic 1"
        );
    }

    public void giveKey(OfflinePlayer player, String crate, int amount) {

        if (player == null || player.getName() == null) {
            return;
        }

        Bukkit.dispatchCommand(
                Bukkit.getConsoleSender(),
                "cc give physical " + player.getName() + " " + crate + " " + amount
        );
    }

    public boolean isInstalled() {
        return Bukkit.getPluginManager().isPluginEnabled("CrazyCrates");
    }

}
