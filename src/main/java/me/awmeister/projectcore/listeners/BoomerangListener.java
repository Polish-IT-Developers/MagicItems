package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class BoomerangListener implements Listener {

    Main plugin;

    public BoomerangListener(Main m) {
        plugin = m;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (p.getItemInHand().getType() != Material.AIR) {
            if (p.getInventory().getItemInHand().getItemMeta().equals(SpecialItemManager.shuriken.getItemMeta())) {
                ArmorStand as = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                Location destination = p.getLocation().add(p.getLocation().getDirection().multiply(10));

                as.setArms(true);
                as.setGravity(false);
                as.setVisible(false);
                as.setItemInHand(new ItemStack(Material.NETHER_STAR));
                as.setRightArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(120), Math.toRadians(0)));

                if (p.getItemInHand().getAmount() == 1) {
                    p.getInventory().remove(SpecialItemManager.shuriken);
                } else {
                    p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                }

                Vector vector = destination.subtract(p.getLocation()).toVector();

                new BukkitRunnable() {
                    int distance = 20;
                    int i = 0;

                    public void run() {
                        EulerAngle rot = as.getRightArmPose();
                        EulerAngle rotnew = rot.add(0, 20, 0);

                        as.setRightArmPose(rotnew);

                        if (i >= distance) {
                            as.teleport(as.getLocation().subtract(vector.normalize()));
                            if (i >= distance) {
                                as.remove();
                                p.getInventory().addItem(SpecialItemManager.shuriken);
                                cancel();
                            }
                        } else {
                            as.teleport(as.getLocation().add(vector.normalize()));
                        }

                        i++;

                        for (Entity entity : as.getLocation().getChunk().getEntities()) {
                            if (as.getLocation().distanceSquared(entity.getLocation()) < 1) {
                                if (entity != e.getPlayer()) {
                                    if (entity instanceof LivingEntity) {
                                        LivingEntity livingEntity = (LivingEntity) entity;
                                        livingEntity.damage(5, p);
                                    }
                                }
                            }
                        }
                    }
                }.runTaskTimer(plugin, 1L, 1L);

                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntity(PlayerInteractAtEntityEvent event) {
        if(event.getRightClicked() instanceof ArmorStand) {
            ArmorStand as = (ArmorStand) event.getRightClicked();

            if(as.getItemInHand().getType().equals(Material.NETHER_STAR)) {
                event.setCancelled(true);
            }
        }
    }

}
