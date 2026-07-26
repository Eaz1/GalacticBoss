package me.eaz.galacticbosses.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GalacticVotePartyEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final String playerName;

    public GalacticVotePartyEvent(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
