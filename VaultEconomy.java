package me.eaz.galacticbosses.economy;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultEconomy {

    private Economy economy;

    public boolean setup() {

        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider<Economy> rsp =
                Bukkit.getServicesManager().getRegistration(Economy.class);

        if (rsp == null) {
            return false;
        }

        economy = rsp.getProvider();
        return economy != null;
    }

    public boolean isHooked() {
        return economy != null;
    }

    public void deposit(OfflinePlayer player, double amount) {

        if (!isHooked() || player == null) {
            return;
        }

        economy.depositPlayer(player, amount);
    }

    public void withdraw(OfflinePlayer player, double amount) {

        if (!isHooked() || player == null) {
            return;
        }

        economy.withdrawPlayer(player, amount);
    }

    public double getBalance(OfflinePlayer player) {

        if (!isHooked() || player == null) {
            return 0.0;
        }

        return economy.getBalance(player);
    }

    public Economy getEconomy() {
        return economy;
    }
    }
