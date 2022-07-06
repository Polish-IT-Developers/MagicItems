package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class PlayerJoinListener implements Listener {

    Main plugin;

    public PlayerJoinListener(Main m) {
        plugin = m;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();

        new BukkitRunnable() {
            @Override
            public void run() {
                if(!plugin.getConfig().getBoolean("start")) {
                    if(!p.hasPermission("items.startedycji")) {
                        p.sendTitle("§b§lZAMROŻENIE", "§fPoczekaj na start edycji...", 3, 40, 3);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10000, 1));
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 40L);
    }

}
