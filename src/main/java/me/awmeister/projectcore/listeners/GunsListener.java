package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public class GunsListener implements Listener {

    HashMap<Player, Long> fireball = new HashMap<Player, Long>();
    HashMap<Player, Long> wither = new HashMap<Player, Long>();
    HashMap<Player, Long> dragon = new HashMap<Player, Long>();

    Main plugin;

    public GunsListener(Main m) {
        plugin = m;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();

        if(event.getMaterial() == Material.FIRE_CHARGE) {
            if(p.getInventory().getItemInMainHand().getItemMeta().hasLore() && p.getItemInHand().getItemMeta().getLore().equals(SpecialItemManager.fireballgun.getItemMeta().getLore())) {
                if(fireball.containsKey(p)) {
                    if(fireball.get(p) > System.currentTimeMillis()) {
                        p.sendMessage("§8» §cMiędzy użyciami tego przedmiotu za pomocą LPM musisz odczekać 0,5 sekundy a PPM 1,25 sekundy!");
                        event.setCancelled(true);
                    } else {
                        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                            event.setCancelled(true);
                            p.launchProjectile(Fireball.class).getVelocity().multiply(3);
                            fireball.put(p, System.currentTimeMillis() + 1250);
                        } else if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                            event.setCancelled(true);
                            p.launchProjectile(SmallFireball.class).getVelocity().multiply(3);
                            fireball.put(p, System.currentTimeMillis() + 500);
                        } else {
                            event.setCancelled(true);
                        }
                    }
                } else {
                    if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                        event.setCancelled(true);
                        p.launchProjectile(Fireball.class).getVelocity().multiply(3);
                        fireball.put(p, System.currentTimeMillis() + 1250);
                    } else if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                        event.setCancelled(true);
                        p.launchProjectile(SmallFireball.class).getVelocity().multiply(3);
                        fireball.put(p, System.currentTimeMillis() + 500);
                    } else {
                        event.setCancelled(true);
                    }
                }
            }
        } else if(event.getMaterial() == Material.WITHER_SKELETON_SKULL) {
            if(p.getInventory().getItemInMainHand().getItemMeta().hasLore() && p.getItemInHand().getItemMeta().getLore().equals(SpecialItemManager.withergun.getItemMeta().getLore())) {
                if(wither.containsKey(p)) {
                    if(wither.get(p) > System.currentTimeMillis()) {
                        p.sendMessage("§8» §cOdczekaj 0,5 sekundy między użyciami tego przedmiotu!");
                        event.setCancelled(true);
                    } else {
                        if(event.getAction() == Action.RIGHT_CLICK_AIR) {
                            p.launchProjectile(WitherSkull.class).getVelocity().multiply(2);
                            wither.put(p, System.currentTimeMillis() + 500);
                        } else {
                            event.setCancelled(true);
                        }
                    }
                } else {
                    if(event.getAction() == Action.RIGHT_CLICK_AIR) {
                        p.launchProjectile(WitherSkull.class).getVelocity().multiply(2);
                        wither.put(p, System.currentTimeMillis() + 500);
                    } else {
                        event.setCancelled(true);
                    }
                }
            }
        } else if(event.getMaterial() == Material.DRAGON_HEAD) {
            if(p.getInventory().getItemInMainHand().getItemMeta().hasLore() && p.getItemInHand().getItemMeta().getLore().equals(SpecialItemManager.dragongun.getItemMeta().getLore())) {
                if (dragon.containsKey(p)) {
                    if (dragon.get(p) > System.currentTimeMillis()) {
                        p.sendMessage("§8» §cOdczekaj 10 sekund pomiędzy użyciami tego przedmiotu!");
                        event.setCancelled(true);
                    } else {
                        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
                            p.launchProjectile(DragonFireball.class).getVelocity().multiply(2);
                            dragon.put(p, System.currentTimeMillis() + 10000);
                        } else {
                            event.setCancelled(true);
                        }
                    }
                } else {
                    if (event.getAction() == Action.RIGHT_CLICK_AIR) {
                        p.launchProjectile(DragonFireball.class).getVelocity().multiply(2);
                        dragon.put(p, System.currentTimeMillis() + 10000);
                    } else {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

}
