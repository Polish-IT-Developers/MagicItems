package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import javax.xml.validation.Validator;
import java.util.HashMap;

public class FreezerListener implements Listener {

    static Main plugin;

    public FreezerListener(Main m) {
        plugin = m;
    }

    public static HashMap<Player, Player> frozen = new HashMap<Player, Player>();
    HashMap<Player, Long> cooldown = new HashMap<Player, Long>();

    int cooldown_time = 10;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if(item != null) {
            if(event.getItem().getType() == Material.BLAZE_ROD) {
                if(event.getItem().getItemMeta().hasLore() && event.getItem().getItemMeta().getLore().equals(SpecialItemManager.freezer.getItemMeta().getLore())) {
                    player.getInventory().getItemInOffHand();
                    if(!player.getInventory().getItemInOffHand().equals(SpecialItemManager.freezer)) {
                        if(cooldown.containsKey(player)) {
                            if(cooldown.get(player) > System.currentTimeMillis()) {
                                event.setCancelled(true);
                            } else {
                                if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                                    Location lineStart = player.getEyeLocation();
                                    Location lineEnd = getFixedLocation(player, 10, 0);
                                    drawLineWithFreeze(lineStart, lineEnd, 0.5, player);
                                }

                                BossBar bossBar = Bukkit.createBossBar("§8» §fZamrażacz §7(§f" + cooldown_time + " §7sek) §8«", BarColor.YELLOW, BarStyle.SOLID);
                                bossBar.setVisible(true);
                                bossBar.addPlayer(player);

                                Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), new Runnable() {
                                    int time = 10;
                                    @Override
                                    public void run() {
                                        if(time == 0) {
                                            bossBar.removeAll();
                                            bossBar.setVisible(false);
                                            return;
                                        }

                                        bossBar.setProgress(time / 10D);
                                        bossBar.setTitle("§8» §fZamrażacz §7(§f" + time + " §7sek) §8«");

                                        time--;
                                    }
                                }, 0L, 20L);

                                cooldown.put(player, System.currentTimeMillis() + 10000);
                            }
                        } else {
                            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                                Location lineStart = player.getEyeLocation();
                                Location lineEnd = getFixedLocation(player, 10, 0);
                                drawLineWithFreeze(lineStart, lineEnd, 0.5, player);
                            }

                            BossBar bossBar = Bukkit.createBossBar("§8» §fZamrażacz §7(§f" + cooldown_time + " §7sek) §8«", BarColor.YELLOW, BarStyle.SOLID);
                            bossBar.setVisible(true);
                            bossBar.addPlayer(player);

                            Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), new Runnable() {
                                int time = 10;
                                @Override
                                public void run() {
                                    if(time == 0) {
                                        bossBar.removeAll();
                                        bossBar.setVisible(false);
                                        return;
                                    }

                                    bossBar.setProgress(time / 10D);
                                    bossBar.setTitle("§8» §fZamrażacz §7(§f" + time + " §7sek) §8«");

                                    time--;
                                }
                            }, 0L, 20L);

                            cooldown.put(player, System.currentTimeMillis() + 10000);
                        }
                    }
                }
            }
        }
    }

    public void drawLineWithFreeze(
            /* Would be your orange wool */Location point1,
            /* Your white wool */ Location point2,
            /*Space between each particle*/double space,
                                           Player shooter
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
            world.spawnParticle(Particle.REDSTONE, p1.getX(), p1.getY(), p1.getZ(), 1, new Particle.DustOptions(Color.AQUA, 1));

            for(Player player : Bukkit.getOnlinePlayers()) {
                Location pLocation = player.getLocation();
                Location particleLocation = new Location(point1.getWorld(), p1.getX(), p1.getY(), p1.getZ());
                double distanceToParticle = pLocation.distance(particleLocation);
                if(distanceToParticle <= 2) {
                    if(player != shooter) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 3));
                        player.setFreezeTicks(Integer.MAX_VALUE);
                        if(!frozen.containsKey(player)) {
                            frozen.put(player, shooter);
                            player.sendMessage("§8» §bGracz " + shooter.getName() + " zamroził Cię przy użyciu Zamrażacza!");
                        }
                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            @Override
                            public void run() {
                                player.setFreezeTicks(0);
                                frozen.remove(player);
                            }
                        }, 100);
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

}
