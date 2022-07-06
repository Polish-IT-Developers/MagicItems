package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SmokeBowListener implements Listener {
    Main plugin;

    public SmokeBowListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent event) {
        if(event.getBow() != null) {
            if(event.getBow().getItemMeta().hasLore() && event.getBow().getItemMeta().getLore().equals(SpecialItemManager.flashbow.getItemMeta().getLore())) {
                if(event.getEntity() instanceof Player) {
                    event.getProjectile().setCustomName("Smoke Bow");

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if(!event.getProjectile().isDead() && !event.getProjectile().isOnGround()) {
                                event.getProjectile().getWorld().spawnParticle(Particle.SMOKE_NORMAL, event.getProjectile().getLocation(), 25);
                            } else {
                                cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0L, 2L);
                }
            } else if(event.getBow().getItemMeta().hasLore() && event.getBow().getItemMeta().getLore().equals(SpecialItemManager.teleportbow.getItemMeta().getLore())) {
                if(event.getEntity() instanceof Player) {
                    Player p = (Player) event.getEntity();

                    p.launchProjectile(EnderPearl.class).setVelocity(event.getProjectile().getVelocity().multiply(1.1));
                    p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                }
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event) {
        if(event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("Smoke Bow")) {
            event.getEntity().getWorld().spawnParticle(Particle.SMOKE_LARGE, event.getEntity().getLocation(), 1000);

            for(Entity entity : event.getEntity().getNearbyEntities(4, 4, 4)) {
                if(entity instanceof LivingEntity) {
                    LivingEntity livingentity = (LivingEntity) entity;

                    if(livingentity != event.getEntity().getShooter()) {
                        livingentity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 0));
                        livingentity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
                    }
                }
            }
        }
    }

}
