package me.eaz.galacticbosses.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.OfflinePlayer;

public class GalacticBossesExpansion extends PlaceholderExpansion {

    private final GalacticBosses plugin;

    public GalacticBossesExpansion(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "galacticbosses";
    }

    @Override
    public String getAuthor() {
        return "Eaz";
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String identifier) {

        if (identifier.equalsIgnoreCase("votes")) {
            return String.valueOf(plugin.getVoteBossManager().getCurrentVotes());
        }

        if (identifier.equalsIgnoreCase("votes_required")) {
            return String.valueOf(plugin.getConfig().getInt("boss.votes-required"));
        }

        if (identifier.equalsIgnoreCase("votes_left")) {
            int required = plugin.getConfig().getInt("boss.votes-required");
            return String.valueOf(Math.max(0, required - plugin.getVoteBossManager().getCurrentVotes()));
        }

        if (identifier.equalsIgnoreCase("vote_progress")) {
            int required = plugin.getConfig().getInt("boss.votes-required");
            return plugin.getVoteBossManager().getCurrentVotes() + "/" + required;
        }

        if (identifier.equalsIgnoreCase("boss_alive")) {
            return plugin.getBossManager().hasBoss() ? "Yes" : "No";
        }

        if (plugin.getBossManager().hasBoss()) {

            if (identifier.equalsIgnoreCase("boss_health")) {
                return String.valueOf((int) plugin.getBossManager().getBoss().getHealth());
            }

            if (identifier.equalsIgnoreCase("boss_health_percent")) {
                double hp = plugin.getBossManager().getBoss().getHealth();
                double max = plugin.getBossManager().getBoss().getMaxHealth();
                return String.valueOf((int) ((hp / max) * 100));
            }
        }

        return null;
    }
    }
