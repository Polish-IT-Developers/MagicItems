package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
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

import java.awt.*;

public class XrayBowListener implements Listener {

    Main plugin;

    public XrayBowListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent event) {
        if(event.getBow() != null) {
            if(event.getBow().getItemMeta().hasLore() && event.getBow().getItemMeta().getLore().equals(SpecialItemManager.xraybow.getItemMeta().getLore())) {
                if(event.getEntity() instanceof Player) {
                    event.getProjectile().setCustomName("XRAY Bow");

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if(!event.getProjectile().isDead() && !event.getProjectile().isOnGround()) {
                                event.getProjectile().getWorld().spawnParticle(Particle.GLOW_SQUID_INK, event.getProjectile().getLocation(), 25);
                            } else {
                                cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0L, 2L);
                }
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event) {
        if(event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("XRAY Bow")) {
            event.getEntity().getWorld().spawnParticle(Particle.GLOW_SQUID_INK, event.getEntity().getLocation(), 1000);

            for(Entity entity : event.getEntity().getNearbyEntities(12, 12, 12)) {
                if(entity instanceof LivingEntity) {
                    LivingEntity livingentity = (LivingEntity) entity;

                    if(livingentity != event.getEntity().getShooter()) {
                        livingentity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 200, 0));
                    }
                }
            }
        }
    }

}
