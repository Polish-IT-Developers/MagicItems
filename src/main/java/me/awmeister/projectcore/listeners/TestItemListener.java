package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestItemListener implements Listener {

    static Main plugin;

    public TestItemListener(Main m) {
        plugin = m;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Player player = event.getPlayer();

        if(item != null) {
            if(event.getItem().getType() == Material.BARRIER) {
                if(event.getItem().getItemMeta().hasLore() && event.getItem().getItemMeta().getLore().equals(SpecialItemManager.debug.getItemMeta().getLore())) {
                    event.setCancelled(true);
                    player.sendMessage("§8» §c§lUWAGA: §cAktualnie nie ma żadnej funkcji w fazie BETA...");
                }
            }
        }
    }

    //                    event.setCancelled(true);
    //                    player.sendMessage("§8» §c§lUWAGA: §cAktualnie nie ma żadnej funkcji w fazie BETA...");

}
