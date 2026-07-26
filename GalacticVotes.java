package me.eaz.galacticvotes;

import me.eaz.galacticvotes.listeners.VoteListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class GalacticVotes extends JavaPlugin {

    private static GalacticVotes instance;

    @Override
    public void onEnable() {

        instance = this;

        getServer().getPluginManager().registerEvents(new VoteListener(), this);

        getLogger().info("GalacticVotes enabled.");
    }

    @Override
    public void onDisable() {

        getLogger().info("GalacticVotes disabled.");
    }

    public static GalacticVotes getInstance() {
        return instance;
    }
}
