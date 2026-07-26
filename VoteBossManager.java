package me.eaz.galacticbosses.events;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class VoteBossManager {

    private final GalacticBosses plugin;

    private int currentVotes;

    public VoteBossManager(GalacticBosses plugin) {
        this.plugin = plugin;
        this.currentVotes = 0;
    }

    /**
     * Called whenever a player votes.
     */
    public void addVote() {

        currentVotes++;

        int votesRequired = plugin.getConfig().getInt("boss.votes-required", 99);

        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE +
                "Vote Party Progress: " +
                ChatColor.GREEN +
                currentVotes + "/" + votesRequired);

        if (currentVotes >= votesRequired) {
            startBossEvent();
            currentVotes = 0;
        }
    }

    private void startBossEvent() {

        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "GALACTIC BOSS EVENT");
        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "The Galactic Wither has spawned!");
        Bukkit.broadcastMessage("");

        String worldName = plugin.getConfig().getString("boss.spawn.world", "world");
        double x = plugin.getConfig().getDouble("boss.spawn.x", 0);
        double y = plugin.getConfig().getDouble("boss.spawn.y", 100);
        double z = plugin.getConfig().getDouble("boss.spawn.z", 0);

        Location spawn = new Location(
                Bukkit.getWorld(worldName),
                x,
                y,
                z
        );

        plugin.getBossManager().spawnBoss(spawn);
    }

    public int getCurrentVotes() {
        return currentVotes;
    }

    public void resetVotes() {
        currentVotes = 0;
    }
            }
