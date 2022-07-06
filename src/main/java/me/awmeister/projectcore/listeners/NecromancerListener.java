package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import org.bukkit.*;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NecromancerListener implements Listener {

    static Main plugin;

    public NecromancerListener(Main m) {
        plugin = m;
    }
    private static final DecimalFormat df = new DecimalFormat("0");

    public static void spawnNecromancer(Location location) {
        Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
        skeleton.setCustomName("§c§lNecromancer");
        skeleton.setCustomNameVisible(true);
        Attributable skeletonAt = skeleton;
        AttributeInstance attributeHealth = skeletonAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attributeHealth.setBaseValue(100);
        skeleton.setHealth(100);
        AttributeInstance attributeSpeed = skeletonAt.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        attributeSpeed.setBaseValue(0.2);
        AttributeInstance attributeDamage = skeletonAt.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
        attributeDamage.setBaseValue(5);

        skeleton.setCanPickupItems(false);
        skeleton.setGlowing(true);

        skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SHOVEL));
        skeleton.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
        skeleton.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
        skeleton.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
        skeleton.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));

        BossBar bossBar = Bukkit.createBossBar("§8» §fNecromancer §7(§f " + df.format(skeleton.getHealth()) + " §c♥§7) §8«", BarColor.PURPLE, BarStyle.SOLID);

        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                if(!skeleton.isDead()) {
                    bossBar.setVisible(true);
                    bossBar.addFlag(BarFlag.PLAY_BOSS_MUSIC);
                    Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), new Runnable() {
                        @Override
                        public void run() {
                            List<Entity> entities = skeleton.getNearbyEntities(20, 20, 20);
                            for(Entity entity : entities) {
                                if(entity instanceof Player) {
                                    if(!bossBar.getPlayers().contains((Player) entity)) {
                                        bossBar.addPlayer((Player) entity);
                                    }
                                }
                            }

                            List<Player> players = bossBar.getPlayers();
                            for(Player player : players) {
                                if(!entities.contains(player)) {
                                    bossBar.removePlayer(player);
                                }
                            }
                        }
                    }, 0, 20L);

                    Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), new Runnable() {
                        @Override
                        public void run() {
                            if(skeleton.isDead()) {
                                bossBar.removeAll();
                                bossBar.setVisible(false);
                                return;
                            }

                            bossBar.setProgress(skeleton.getHealth() / skeleton.getMaxHealth());
                            bossBar.setTitle("§8» §fNecromancer §7(§f" + df.format(skeleton.getHealth()) + " §c❤§7) §8«");
                        }
                    }, 0L, 2L);

                    if(skeleton.getTarget() != null) {
                        if(i % 2 == 0) {
                            FallingBlock fallingBlock = skeleton.getWorld().spawnFallingBlock(skeleton.getLocation().add(0, 2, 0), Material.SNOW_BLOCK, (byte) 0);
                            fallingBlock.setCustomName("§bPocisk Necromancera");
                            fallingBlock.setDropItem(false);
                            fallingBlock.setVelocity(skeleton.getTarget().getLocation().add(0, 1, 0).subtract(fallingBlock.getLocation()).toVector().multiply(0.5));
                            fallingBlock.getWorld().playSound(fallingBlock.getLocation(), Sound.ENTITY_WITHER_SHOOT, 5, 5);
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if(!fallingBlock.isDead()) {
                                        fallingBlock.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, fallingBlock.getLocation(), 1);
                                        for(Entity entity : fallingBlock.getNearbyEntities(2, 2, 2)) {
                                            if(entity instanceof Player) {
                                                if(fallingBlock.getLocation().distanceSquared(entity.getLocation()) < 1) {
                                                    Player player = (Player) entity;
                                                    player.damage(6, skeleton);
                                                    fallingBlock.remove();
                                                    cancel();
                                                }
                                            }
                                        }
                                    } else {
                                        cancel();
                                    }
                                }
                            }.runTaskTimer(plugin, 0L, 2L);
                        }
                        if(i % 10 == 0) {
                            Random r = new Random();
                            skeleton.getWorld().playSound(skeleton.getLocation(), Sound.ENTITY_EVOKER_PREPARE_SUMMON, 5, 5);
                            for(int x = 0; x < 4; x++) {
                                Zombie zombie = skeleton.getWorld().spawn(skeleton.getLocation().add(r.nextInt(1 + 1) - 1, 0, r.nextInt(1 + 1) - 1), Zombie.class);
                                zombie.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
                                zombie.setAdult();
                                zombie.setHealth(5);
                                zombie.setTarget(skeleton.getTarget());
                                zombie.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, zombie.getLocation(), 1);
                            }
                        }
                        i++;
                    }
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 0L, 20L);
    }

    @EventHandler
    public void onChange(EntityChangeBlockEvent event) {
        if(event.getEntity() instanceof FallingBlock) {
            if(event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("§bPocisk Necromancera")) {
                event.setCancelled(true);
                event.getEntity().remove();
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if(event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("§c§lNecromancer")) {
            event.getDrops().clear();

            ArrayList<ItemStack> possibleDrops = new ArrayList<>();

            possibleDrops.add(SpecialItemManager.hat);
            possibleDrops.add(new ItemStack(Material.SKELETON_SKULL, 1));
            possibleDrops.add(SpecialItemManager.undead);

            int dropPosition = new Random().nextInt(possibleDrops.toArray().length);

            event.getEntity().getLocation().getWorld().dropItem(event.getEntity().getLocation(), possibleDrops.get(dropPosition));
        }
    }

//    public static BossBar bossBar = Bukkit.getServer().createBossBar("§cNecromancer", BarColor.RED, BarStyle.SOLID, BarFlag.PLAY_BOSS_MUSIC);
//
//    public static void runNecromancerBar(LivingEntity livingEntity) {
//        new BukkitRunnable() {
//            @Override
//            public void run() {
//                bossBar.setVisible(true);
//                if(!livingEntity.isDead()) {
//                    if(bossBar.getProgress() != livingEntity.getHealth() / livingEntity.getMaxHealth()) {
//                        bossBar.setProgress(livingEntity.getHealth() / livingEntity.getMaxHealth());
//                    }
//                } else {
//                    for(Player player : bossBar.getPlayers()) {
//                        bossBar.removePlayer(player);
//                    }
//                    bossBar.setVisible(false);
//                }
//
//                for(Player player : bossBar.getPlayers()) {
//                    if(!livingEntity.getNearbyEntities(16, 16, 16).equals(player)) {
//                        bossBar.removePlayer(player);
//                    }
//                }
//
//                for(Entity entity : livingEntity.getNearbyEntities(16, 16, 16)) {
//                    if(entity instanceof Player) {
//                        Player p = (Player) entity;
//                        if(!bossBar.getPlayers().equals(entity)) {
//                            bossBar.addPlayer(p);
//                        }
//                    }
//                }
//            }
//        }.runTaskTimer(plugin, 0, 1);
//    }

}
