package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class UndeadsWandListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Player player = event.getPlayer();

        if(item != null) {
            if(event.getItem().getType() == Material.SUGAR) {
                if(event.getItem().getItemMeta().hasLore() && event.getItem().getItemMeta().getLore().equals(SpecialItemManager.undead.getItemMeta().getLore())) {
                    if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                        int points = 10;
                        double radius = 3.0d;
                        Location origin = player.getLocation();

                        for (int i = 0; i < points; i++) {
                            double angle = 2 * Math.PI * i / points;
                            Location point = origin.clone().add(radius * Math.sin(angle), 0.0d, radius * Math.cos(angle));
                            origin.getWorld().spawnEntity(point, EntityType.EVOKER_FANGS);
                        }
                    } else if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                        Location lineStart = getFixedLocation(player, 3, 0);
                        Location lineEnd = getFixedLocation(player, 7, 0);
                        drawLineWithEntity(lineStart, lineEnd, 0.5);
                    }
                }
            }
        }
    }

    public void drawLineWithEntity(
            /* Would be your orange wool */Location point1,
            /* Your white wool */ Location point2,
            /*Space between each entity*/double space
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
            /*Spawn the entity at the point*/
            Location spawnLocation = new Location(world, p1.getX(), p1.getY(), p1.getZ());
            world.spawnEntity(spawnLocation, EntityType.EVOKER_FANGS);

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

}
