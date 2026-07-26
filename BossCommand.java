package me.eaz.galacticbosses.commands;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BossCommand implements CommandExecutor {

    private final GalacticBosses plugin;

    public BossCommand(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("galacticbosses.admin")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission.");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.GOLD + "GalacticBosses Commands");
            sender.sendMessage(ChatColor.YELLOW + "/boss spawn");
            sender.sendMessage(ChatColor.YELLOW + "/boss remove");
            sender.sendMessage(ChatColor.YELLOW + "/boss votes");
            sender.sendMessage(ChatColor.YELLOW + "/boss reload");
            return true;
        }

        switch (args[0].toLowerCase()) {

            case "spawn":

                if (plugin.getBossManager().hasBoss()) {
                    sender.sendMessage(ChatColor.RED + "A boss is already active.");
                    return true;
                }

                World world = Bukkit.getWorld(
                        plugin.getConfig().getString("boss.spawn.world", "world")
                );

                if (world == null) {
                    sender.sendMessage(ChatColor.RED + "Configured world not found.");
                    return true;
                }

                Location location = new Location(
                        world,
                        plugin.getConfig().getDouble("boss.spawn.x"),
                        plugin.getConfig().getDouble("boss.spawn.y"),
                        plugin.getConfig().getDouble("boss.spawn.z")
                );

                plugin.getBossManager().spawnBoss(location);

                sender.sendMessage(ChatColor.GREEN + "Galactic Wither spawned.");
                break;

            case "remove":

                plugin.getBossManager().removeBoss();

                sender.sendMessage(ChatColor.GREEN + "Galactic Wither removed.");
                break;

            case "votes":

                sender.sendMessage(ChatColor.LIGHT_PURPLE +
                        "Current Votes: " +
                        plugin.getVoteBossManager().getCurrentVotes());

                break;

            case "reload":

                plugin.reloadConfig();

                sender.sendMessage(ChatColor.GREEN + "GalacticBosses configuration reloaded.");

                break;

            default:

                sender.sendMessage(ChatColor.RED + "Unknown subcommand.");
                break;
        }

        return true;
    }
                    }
