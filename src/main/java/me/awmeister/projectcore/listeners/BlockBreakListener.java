package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    Main plugin;

    public BlockBreakListener(Main main) {
        plugin = main;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if(!plugin.getConfig().getBoolean("start")) {
            if(!p.isOp()) {
                e.setCancelled(true);
                p.sendMessage("§8» §cEdycja jeszcze się nie rozpoczęła...");
            }
        }
    }

}
