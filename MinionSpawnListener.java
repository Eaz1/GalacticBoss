package me.eaz.galacticbosses.listeners;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class MinionSpawnListener implements Listener {

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {

        if (event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.CUSTOM) {
            return;
        }

        if (event.getEntityType() == EntityType.ZOMBIE) {

            Zombie zombie = (Zombie) event.getEntity();

            zombie.setCustomName("§2Galactic Zombie");
            zombie.setCustomNameVisible(true);

            zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100.0);
            zombie.setHealth(100.0);

            zombie.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
            zombie.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            zombie.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            zombie.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
        }

        if (event.getEntityType() == EntityType.SKELETON) {

            Skeleton skeleton = (Skeleton) event.getEntity();

            skeleton.setCustomName("§7Galactic Skeleton");
            skeleton.setCustomNameVisible(true);

            skeleton.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100.0);
            skeleton.setHealth(100.0);

            skeleton.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
            skeleton.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            skeleton.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            skeleton.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
            skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.BOW));
        }
    }
    }
