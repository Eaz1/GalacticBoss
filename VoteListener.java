package me.eaz.galacticvotes.listeners;

import me.eaz.galacticbosses.events.GalacticVotePartyEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import com.vexsoftware.votifier.model.VotifierEvent;

public class VoteListener implements Listener {

    @EventHandler
    public void onVote(VotifierEvent event) {

        String player = event.getVote().getUsername();

        // Your existing vote rewards/code stays here.



        // Notify GalacticBosses that a vote was received.
        Bukkit.getPluginManager().callEvent(
                new GalacticVotePartyEvent(player)
        );
    }
            }
