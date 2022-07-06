package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Objects;
import java.util.Random;

public class AirStrikeBowListener implements Listener {

    @EventHandler
    public void onShoot(EntityShootBowEvent event) {
        if(event.getEntity() instanceof Player) {
            if(event.getBow() != null) {
                if(event.getBow().getItemMeta().hasLore() && event.getBow().getItemMeta().getLore().equals(SpecialItemManager.airstrikebow.getItemMeta().getLore())) {
                    if(event.getProjectile() instanceof Arrow) {
                        Arrow arrow = (Arrow) event.getProjectile();
                        arrow.setCustomName("Air Strike Bow");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event) {
        if(event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            if(arrow.getCustomName() != null && arrow.getCustomName().equals("Air Strike Bow")) {
                Location location = arrow.getLocation();
                Random random = new Random();
                for(Entity entity : arrow.getNearbyEntities(10, 10, 10)) {
                    if(entity instanceof Player) {
                        Player entity1 = (Player) entity;

                        BossBar bossBar = Bukkit.createBossBar("§8» §c§lNACHODZI NALOT! §8«", BarColor.RED, BarStyle.SOLID);
                        bossBar.setVisible(true);
                        bossBar.addPlayer(entity1);
                        bossBar.addFlag(BarFlag.DARKEN_SKY);

                        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), new Runnable() {
                            int time = 4;
                            @Override
                            public void run() {
                                if(time == 0) {
                                    bossBar.removeAll();
                                    bossBar.setVisible(false);
                                    return;
                                }

                                if(bossBar.getTitle().equals("§8» §c§lNACHODZI NALOT! §8«")) {
                                    bossBar.setTitle("§8» §4§lNACHODZI NALOT! §8«");
                                } else {
                                    bossBar.setTitle("§8» §c§lNACHODZI NALOT! §8«");
                                }

                                time--;
                            }
                        }, 0L, 20L);

                        entity1.playSound(entity1.getLocation(), Sound.ENTITY_TNT_PRIMED, 5,5);
                    }
                }

                for(int i = 0; i < 10; i++) {
                    Arrow airstrikearrow = arrow.getWorld().spawn(location.clone().add(random.nextInt(5 + 5) - 5, 100, random.nextInt(5 + 5) - 5), Arrow.class);
                    airstrikearrow.setCustomName("Air Strike Arrow");
                    airstrikearrow.setColor(Color.RED);
                    airstrikearrow.setShooter(arrow.getShooter());
                }
            } else if(arrow.getCustomName() != null && arrow.getCustomName().equals("Air Strike Arrow")) {
                arrow.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, arrow.getLocation(), 10);
                arrow.getWorld().playSound(arrow.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 5,5);
//                Random random = new Random();
//                arrow.getWorld().spawn(arrow.getLocation().clone().add(random.nextInt(5 + 5) - 5, arrow.getLocation().getY(), random.nextInt(5 + 5) - 5), TNTPrimed.class);
                for(Entity entity : arrow.getNearbyEntities(3, 3, 3)) {
                    if(entity instanceof LivingEntity) {
                        if(entity != arrow.getShooter()) {
                            LivingEntity livingEntity = (LivingEntity) entity;
                            livingEntity.damage(10, (Entity) arrow.getShooter());
                        }
                    }
                }
                arrow.remove();
            }
        }
    }

}
