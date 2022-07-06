package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class KnockShieldListener implements Listener {

    HashMap<Player, Long> cooldown = new HashMap<Player, Long>();
    int cooldown_time = 6;

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Player player = event.getPlayer();

        if(item != null) {
            if(event.getItem().getType() == Material.SHIELD) {
                if(event.getItem().getItemMeta().hasLore() && event.getItem().getItemMeta().getLore().equals(SpecialItemManager.knockShield.getItemMeta().getLore())) {
                    if(cooldown.containsKey(player)) {
                        if(cooldown.get(player) > System.currentTimeMillis()) {
                            event.setCancelled(true);
                        } else {
                            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                                int points = 50;
                                double radius = 3.0d;
                                Location origin = player.getEyeLocation().subtract(0, 0.5, 0);

                                for (int i = 0; i < points; i++) {
                                    double angle = 2 * Math.PI * i / points;
                                    Location point = origin.clone().add(radius * Math.sin(angle), 0.0d, radius * Math.cos(angle));
                                    origin.getWorld().spawnParticle(Particle.REDSTONE, point.getX(), point.getY(), point.getZ(), 1, new Particle.DustOptions(Color.LIME, 1));

                                    for (Entity entity : origin.getWorld().getEntities()) {
                                        if (entity instanceof LivingEntity) {
                                            Location entityLocation = entity.getLocation();
                                            double distance = entityLocation.distance(point);
                                            if (distance <= 1.5) {
                                                entity.setVelocity(entityLocation.getDirection().multiply(-2));
                                            }
                                        }
                                    }
                                }

                                BossBar bossBar = Bukkit.createBossBar("§8» §2Moc odpychająca tarczy §7(§f" + cooldown_time + " §7sek) §8«", BarColor.GREEN, BarStyle.SOLID);
                                bossBar.setVisible(true);
                                bossBar.addPlayer(player);

                                Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), new Runnable() {
                                    int time = 6;
                                    @Override
                                    public void run() {
                                        if(time == 0) {
                                            bossBar.removeAll();
                                            bossBar.setVisible(false);
                                            return;
                                        }

                                        bossBar.setProgress(time / 6D);
                                        bossBar.setTitle("§8» §2Moc odpychająca tarczy §7(§f" + time + " §7sek) §8«");

                                        time--;
                                    }
                                }, 0L, 20L);

                                cooldown.put(player, System.currentTimeMillis() + 6000);
                            }
                        }
                    } else {
                        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                            int points = 50;
                            double radius = 3.0d;
                            Location origin = player.getEyeLocation().subtract(0, 0.5, 0);

                            for (int i = 0; i < points; i++) {
                                double angle = 2 * Math.PI * i / points;
                                Location point = origin.clone().add(radius * Math.sin(angle), 0.0d, radius * Math.cos(angle));
                                origin.getWorld().spawnParticle(Particle.REDSTONE, point.getX(), point.getY(), point.getZ(), 1, new Particle.DustOptions(Color.LIME, 1));

                                for(Entity entity : origin.getWorld().getEntities()) {
                                    if(entity instanceof LivingEntity) {
                                        Location entityLocation = entity.getLocation();
                                        double distance = entityLocation.distance(point);
                                        if(distance <= 1.5) {
                                            entity.setVelocity(entityLocation.getDirection().multiply(-2));
                                        }
                                    }
                                }
                            }

                            BossBar bossBar = Bukkit.createBossBar("§8» §2Moc odpychająca tarczy §7(§f" + cooldown_time + " §7sek) §8«", BarColor.GREEN, BarStyle.SOLID);
                            bossBar.setVisible(true);
                            bossBar.addPlayer(player);

                            Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), new Runnable() {
                                int time = 6;
                                @Override
                                public void run() {
                                    if(time == 0) {
                                        bossBar.removeAll();
                                        bossBar.setVisible(false);
                                        return;
                                    }

                                    bossBar.setProgress(time / 6D);
                                    bossBar.setTitle("§8» §2Moc odpychająca tarczy §7(§f" + time + " §7sek) §8«");

                                    time--;
                                }
                            }, 0L, 20L);

                            cooldown.put(player, System.currentTimeMillis() + 6000);
                        }
                    }
                }
            }
        }
    }

    public static Location getFixedLocation(final Location location, final double far, final double high,
                                            final double offset) {

        final Location loc = location.clone();

        loc.setYaw((float) (loc.getYaw() + (offset * 5)));

        final Location fixed = loc.add(loc.getDirection().normalize().multiply(far));
        fixed.add(0, high, 0);

        return fixed;

    }

    public static Location getFixedLocation(final Location location, final double far, final double high) {
        return getFixedLocation(location, far, high, 0);
    }

}
