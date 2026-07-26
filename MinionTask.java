package me.eaz.galacticbosses.tasks;

import me.eaz.galacticbosses.GalacticBosses;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class MinionTask extends BukkitRunnable {

    private final GalacticBosses plugin;
    private final Wither boss;

    public MinionTask(GalacticBosses plugin, Wither boss) {
        this.plugin = plugin;
        this.boss = boss;
    }

    @Override
    public void run() {

        if (boss == null || boss.isDead()) {
            cancel();
            return;
        }

        int zombies = plugin.getConfig().getInt("boss.zombies-per-wave", 4);
        int skeletons = plugin.getConfig().getInt("boss.skeletons-per-wave", 4);
        double health = plugin.getConfig().getDouble("boss.minion-health", 100.0);

        spawnZombies(zombies, health);
        spawnSkeletons(skeletons, health);
    }

    private void spawnZombies(int amount, double health) {

        for (int i = 0; i < amount; i++) {

            Location loc = randomLocation();

            Zombie zombie = (Zombie) boss.getWorld().spawnEntity(loc, EntityType.ZOMBIE);

            zombie.setCustomName("§2Galactic Zombie");
            zombie.setCustomNameVisible(true);

            zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
            zombie.setHealth(health);

            zombie.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
            zombie.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            zombie.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            zombie.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));

            zombie.setRemoveWhenFarAway(false);
        }
    }

    private void spawnSkeletons(int amount, double health) {

        for (int i = 0; i < amount; i++) {

            Location loc = randomLocation();

            Skeleton skeleton = (Skeleton) boss.getWorld().spawnEntity(loc, EntityType.SKELETON);

            skeleton.setCustomName("§7Galactic Skeleton");
            skeleton.setCustomNameVisible(true);

            skeleton.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
            skeleton.setHealth(health);

            skeleton.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
            skeleton.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            skeleton.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            skeleton.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
            skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.BOW));

            skeleton.setRemoveWhenFarAway(false);
        }
    }

    private Location randomLocation() {

        double x = boss.getLocation().getX() + (Math.random() * 8) - 4;
        double z = boss.getLocation().getZ() + (Math.random() * 8) - 4;
        double y = boss.getWorld().getHighestBlockYAt((int) x, (int) z) + 1;

        return new Location(boss.getWorld(), x, y, z);
    }
                }
