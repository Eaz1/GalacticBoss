package me.eaz.galacticbosses;

import me.clip.placeholderapi.PlaceholderAPI;
import me.eaz.galacticbosses.bosses.BossManager;
import me.eaz.galacticbosses.bosses.DamageTracker;
import me.eaz.galacticbosses.commands.BossCommand;
import me.eaz.galacticbosses.commands.BossInfoCommand;
import me.eaz.galacticbosses.commands.BossTopCommand;
import me.eaz.galacticbosses.crates.CrazyCratesHook;
import me.eaz.galacticbosses.economy.VaultEconomy;
import me.eaz.galacticbosses.events.VoteBossManager;
import me.eaz.galacticbosses.listeners.*;
import me.eaz.galacticbosses.placeholders.GalacticBossesExpansion;
import me.eaz.galacticbosses.rewards.RewardManager;
import me.eaz.galacticbosses.util.Constants;
import me.eaz.galacticbosses.util.VersionUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class GalacticBosses extends JavaPlugin {

    private static GalacticBosses instance;

    private BossManager bossManager;
    private DamageTracker damageTracker;
    private RewardManager rewardManager;
    private VaultEconomy vaultEconomy;
    private CrazyCratesHook crazyCratesHook;
    private VoteBossManager voteBossManager;

    @Override
    public void onEnable() {

        instance = this;

        saveDefaultConfig();

        VersionUtil.checkVersion();

        bossManager = new BossManager(this);
        damageTracker = new DamageTracker();
        rewardManager = new RewardManager(this);
        vaultEconomy = new VaultEconomy();
        crazyCratesHook = new CrazyCratesHook();
        voteBossManager = new VoteBossManager(this);

        vaultEconomy.setup();

        if (getCommand("boss") != null) {
            getCommand("boss").setExecutor(new BossCommand(this));
        }

        if (getCommand("bossinfo") != null) {
            getCommand("bossinfo").setExecutor(new BossInfoCommand(this));
        }

        if (getCommand("bosstop") != null) {
            getCommand("bosstop").setExecutor(new BossTopCommand(this));
        }

        getServer().getPluginManager().registerEvents(new BossDamageListener(this), this);
        getServer().getPluginManager().registerEvents(new BossDeathListener(this), this);
        getServer().getPluginManager().registerEvents(new BossSpawnListener(this), this);
        getServer().getPluginManager().registerEvents(new BossTargetListener(this), this);
        getServer().getPluginManager().registerEvents(new BossProjectileListener(this), this);
        getServer().getPluginManager().registerEvents(new WitherBlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new WitherHealListener(this), this);

        getServer().getPluginManager().registerEvents(new MinionSpawnListener(), this);
        getServer().getPluginManager().registerEvents(new MinionDeathListener(), this);
        getServer().getPluginManager().registerEvents(new MinionTargetListener(), this);

        if (getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new GalacticBossesExpansion(this).register();
            getLogger().info("Hooked into PlaceholderAPI.");
        }

        getLogger().info("======================================");
        getLogger().info("GalacticBosses v" + getDescription().getVersion());
        getLogger().info("Boss: " + Constants.BOSS_NAME);
        getLogger().info("Health: " + Constants.BOSS_HEALTH);
        getLogger().info("Vote Goal: " + getConfig().getInt("boss.votes-required"));
        getLogger().info("Plugin enabled successfully!");
        getLogger().info("======================================");
    }

    @Override
    public void onDisable() {
        getLogger().info("GalacticBosses disabled.");
    }

    public static GalacticBosses getInstance() {
        return instance;
    }

    public BossManager getBossManager() {
        return bossManager;
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
