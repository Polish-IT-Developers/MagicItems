package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    Main plugin;

    public PlayerMoveListener(Main m) {
        plugin = m;
    }

    @EventHandler
    public void ruch(PlayerMoveEvent e) {
        if(!plugin.getConfig().getBoolean("start")) {
            if(!e.getPlayer().hasPermission("items.startedycji")) {
                e.setCancelled(true);
            }
        }
    }
}
