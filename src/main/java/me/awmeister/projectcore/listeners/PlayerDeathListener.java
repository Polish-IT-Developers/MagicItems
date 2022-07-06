package me.awmeister.projectcore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();

        if(FreezerListener.frozen.containsKey(player)) {
            player.setFreezeTicks(0);
            FreezerListener.frozen.remove(player);
        }
    }

}
