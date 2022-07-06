package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SnowballListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if(item != null) {
            if(event.getItem().getType() == Material.SNOWBALL) {
                if(event.getItem().getItemMeta().hasLore() && event.getItem().getItemMeta().getLore().equals(SpecialItemManager.shockwaveSnowball.getItemMeta().getLore())) {
                    if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                        event.setCancelled(true);
                        player.launchProjectile(Snowball.class).setCustomName("Śnieżka odrzutu");
                        if(player.getGameMode() != GameMode.CREATIVE) {
                            if (item.getAmount() == 1) {
                                player.getInventory().remove(item);
                            } else {
                                item.setAmount(item.getAmount() - 1);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if(event.getEntity().getCustomName() != null) {
            if(event.getEntity().getCustomName().equalsIgnoreCase("Śnieżka odrzutu")) {
                event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, event.getEntity().getLocation(), 200);

                for(Entity entity : event.getEntity().getWorld().getEntities()) {
                    if(entity instanceof LivingEntity) {
                        LivingEntity livingEntity = (LivingEntity) entity;
                        Location entityLocation = livingEntity.getLocation();
                        double distanceToParticle = entityLocation.distance(event.getEntity().getLocation());
                        if(distanceToParticle <= 5) {
                            livingEntity.setVelocity(entity.getLocation().getDirection().multiply(-3));
                        }
                    }

                }
            }
        }
    }

}
