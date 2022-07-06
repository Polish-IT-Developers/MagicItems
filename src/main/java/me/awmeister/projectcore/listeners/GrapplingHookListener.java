package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class GrapplingHookListener implements Listener {

    HashMap<Player, Long> cooldown = new HashMap<Player, Long>();

    @EventHandler
    public void onFish(PlayerFishEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getItemInHand();
        ItemMeta meta = item.getItemMeta();

        if(!meta.getLore().isEmpty() && meta.getLore().equals(SpecialItemManager.grapplinghook.getItemMeta().getLore())) {
            if(e.getState().equals(PlayerFishEvent.State.REEL_IN)) {
                if(cooldown.containsKey(p)) {
                    if(cooldown.get(p) > System.currentTimeMillis()) {
                        e.setCancelled(true);
                    } else {
                        Location playerloc = p.getLocation();
                        Location hookloc = e.getHook().getLocation();
                        Location change = hookloc.subtract(playerloc);

                        p.setVelocity(change.toVector().multiply(0.3));
                        cooldown.put(p, System.currentTimeMillis() + 500);
                    }
                } else {
                    Location playerloc = p.getLocation();
                    Location hookloc = e.getHook().getLocation();
                    Location change = hookloc.subtract(playerloc);

                    p.setVelocity(change.toVector().multiply(0.3));

                    cooldown.put(p, System.currentTimeMillis() + 500);
                }

                Location playerloc = p.getLocation();
                Location hookloc = e.getHook().getLocation();
                Location change = hookloc.subtract(playerloc);

                p.setVelocity(change.toVector().multiply(0.3));

                cooldown.put(p, System.currentTimeMillis() + 500);
            } else if(e.getState().equals(PlayerFishEvent.State.IN_GROUND)) {
                Location playerloc = p.getLocation();
                Location hookloc = e.getHook().getLocation();
                Location change = hookloc.subtract(playerloc);

                p.setVelocity(change.toVector().multiply(0.3));

                cooldown.put(p, System.currentTimeMillis() + 500);
            }
        }
    }

}
