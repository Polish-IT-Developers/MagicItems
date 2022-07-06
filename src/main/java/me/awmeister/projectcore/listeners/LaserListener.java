package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class LaserListener implements Listener {

    static Main plugin;

    public LaserListener(Main m) {
        plugin = m;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Player player = event.getPlayer();

        if(item != null) {
            if(event.getItem().getType() == Material.BLAZE_ROD) {
                if(event.getItem().getItemMeta().hasLore() && event.getItem().getItemMeta().getLore().equals(SpecialItemManager.laser.getItemMeta().getLore())) {
                    player.getInventory().getItemInOffHand();
                    if(!player.getInventory().getItemInOffHand().equals(SpecialItemManager.laser)) {
                        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                            Location lineStart = player.getEyeLocation();
                            Location lineEnd = getFixedLocation(player, 10, 0);
                            drawLineWithDamage(lineStart, lineEnd, 0.5, 1, (LivingEntity) player);
                        }
                    }
                }
            }
        }
    }



    public void drawLineWithDamage(
            /* Would be your orange wool */Location point1,
            /* Your white wool */ Location point2,
            /*Space between each particle*/double space,
                                           double damage,
                                           LivingEntity shooter
    ) {

        World world = point1.getWorld();

        /*Distance between the two particles*/
        double distance = point1.distance(point2);

        /* The points as vectors */
        Vector p1 = point1.toVector();
        Vector p2 = point2.toVector();

        /* Subtract gives you a vector between the points, we multiply by the space*/
        Vector vector = p2.clone().subtract(p1).normalize().multiply(space);

        /*The distance covered*/
        double covered = 0;

        /* We run this code while we haven't covered the distance, we increase the point by the space every time*/
        for (; covered < distance; p1.add(vector)) {
            /*Spawn the particle at the point*/
            world.spawnParticle(Particle.REDSTONE, p1.getX(), p1.getY(), p1.getZ(), 1, new Particle.DustOptions(Color.RED, 1));

            for(Entity entity : world.getEntities()) {
                if(entity instanceof LivingEntity) {
                    LivingEntity livingEntity = (LivingEntity) entity;
                    Location entityLocation = livingEntity.getEyeLocation();
                    Location particleLocation = new Location(point1.getWorld(), p1.getX(), p1.getY(), p1.getZ());
                    double distanceToParticle = entityLocation.distance(particleLocation);
                    if(distanceToParticle <= 2) {
                        if(livingEntity != shooter) {
                            livingEntity.damage(damage, shooter);
                        }
                    }
                }

            }

            /* We add the space covered */
            covered += space;
        }
    }

    public static Location getFixedLocation(final Player player, final double far, final double high,
                                            final double offset) {

        final Location loc = player.getLocation().clone();

        loc.setYaw((float) (loc.getYaw() + (offset * 5)));

        final Location fixed = loc.add(loc.getDirection().normalize().multiply(far));
        fixed.add(0, high, 0);

        return fixed;

    }

    public static Location getFixedLocation(final Player player, final double far, final double high) {
        return getFixedLocation(player, far, high, 0);
    }

//    public  Vector getDirectionBetweenLocations(Location Start, Location End) {
//        Vector from = Start.toVector();
//        Vector to = End.toVector();
//        return to.subtract(from);
//    }

}
