package me.eaz.galacticbosses.util;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public final class SchedulerUtil {

    private SchedulerUtil() {
    }

    public static BukkitTask runSyncRepeating(JavaPlugin plugin,
                                              BukkitRunnable runnable,
                                              long delay,
                                              long period) {

        return runnable.runTaskTimer(plugin, delay, period);
    }

    public static BukkitTask runSyncLater(JavaPlugin plugin,
                                          BukkitRunnable runnable,
                                          long delay) {

        return runnable.runTaskLater(plugin, delay);
    }

    public static BukkitTask runAsyncRepeating(JavaPlugin plugin,
                                               BukkitRunnable runnable,
                                               long delay,
                                               long period) {

        return runnable.runTaskTimerAsynchronously(plugin, delay, period);
    }

    public static BukkitTask runAsyncLater(JavaPlugin plugin,
                                           BukkitRunnable runnable,
                                           long delay) {

        return runnable.runTaskLaterAsynchronously(plugin, delay);
    }

    public static void cancel(BukkitTask task) {

        if (task != null && !task.isCancelled()) {
            task.cancel();
        }
    }
}
