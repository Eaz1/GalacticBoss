package me.eaz.galacticbosses.bosses;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;

public class BossBarManager {

    private final BossBar bossBar;

    public BossBarManager() {
        bossBar = Bukkit.createBossBar(
                "§5§lGalactic Wither",
                BarColor.PURPLE,
                BarStyle.SEGMENTED_10
        );
    }

    public void update(Wither wither) {

        if (wither == null || wither.isDead()) {
            removeAll();
            return;
        }

        double maxHealth = wither.getMaxHealth();
        double health = wither.getHealth();

        bossBar.setProgress(Math.max(0.0, Math.min(1.0, health / maxHealth)));

        for (Player player : Bukkit.getOnlinePlayers()) {

            if (player.getWorld().equals(wither.getWorld())
                    && player.getLocation().distance(wither.getLocation()) <= 80) {

                if (!bossBar.getPlayers().contains(player)) {
                    bossBar.addPlayer(player);
                }

            } else {
                bossBar.removePlayer(player);
            }
        }
    }

    public void removeAll() {
        bossBar.removeAll();
    }

    public BossBar getBossBar() {
        return bossBar;
    }
}
