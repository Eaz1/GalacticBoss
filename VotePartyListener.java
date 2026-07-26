package me.eaz.galacticbosses.listeners;

import me.eaz.galacticbosses.GalacticBosses;
import me.eaz.galacticbosses.events.GalacticVotePartyEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class VotePartyListener implements Listener {

    private final GalacticBosses plugin;

    public VotePartyListener(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onVote(GalacticVotePartyEvent event) {

        plugin.getVoteBossManager().addVote();

    }
}
