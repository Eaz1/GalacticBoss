package me.eaz.galacticbosses.managers;

import me.eaz.galacticbosses.GalacticBosses;
import me.eaz.galacticbosses.bosses.BossBarManager;
import me.eaz.galacticbosses.bosses.BossManager;
import me.eaz.galacticbosses.bosses.DamageTracker;
import me.eaz.galacticbosses.crates.CrazyCratesHook;
import me.eaz.galacticbosses.economy.VaultEconomy;
import me.eaz.galacticbosses.events.VoteBossManager;
import me.eaz.galacticbosses.rewards.RewardManager;

public class ManagerRegistry {

    private final GalacticBosses plugin;

    private BossManager bossManager;
    private BossBarManager bossBarManager;
    private DamageTracker damageTracker;
    private RewardManager rewardManager;
    private VaultEconomy vaultEconomy;
    private CrazyCratesHook crazyCratesHook;
    private VoteBossManager voteBossManager;

    public ManagerRegistry(GalacticBosses plugin) {
        this.plugin = plugin;
    }

    public void load() {

        vaultEconomy = new VaultEconomy();
        vaultEconomy.setup();

        crazyCratesHook = new CrazyCratesHook();

        bossManager = new BossManager(plugin);
        bossBarManager = new BossBarManager();

        damageTracker = new DamageTracker();
        rewardManager = new RewardManager();

        voteBossManager = new VoteBossManager(plugin);
    }

    public BossManager getBossManager() {
        return bossManager;
    }

    public BossBarManager getBossBarManager() {
        return bossBarManager;
    }

    public DamageTracker getDamageTracker() {
        return damageTracker;
    }

    public RewardManager getRewardManager() {
        return rewardManager;
    }

    public VaultEconomy getVaultEconomy() {
        return vaultEconomy;
    }

    public CrazyCratesHook getCrazyCratesHook() {
        return crazyCratesHook;
    }

    public VoteBossManager getVoteBossManager() {
        return voteBossManager;
    }
          }
