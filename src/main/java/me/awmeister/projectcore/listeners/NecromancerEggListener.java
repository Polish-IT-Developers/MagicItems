package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class NecromancerEggListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getHand() != null && event.getHand().equals(EquipmentSlot.HAND)) {
                if(event.getItem() != null && event.getItem().equals(SpecialItemManager.necromanceregg)) {
                    Location spawnlocation;
                    if(event.getClickedBlock().isPassable()) {
                        spawnlocation = event.getClickedBlock().getLocation().add(0.5, 0, 0.5);
                    } else {
                        spawnlocation = event.getClickedBlock().getRelative(event.getBlockFace()).getLocation().add(0.5, 0, 0.5);
                    }
                    NecromancerListener.spawnNecromancer(spawnlocation);
                    if(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
                        event.getItem().setAmount(event.getItem().getAmount() - 1);
                    }
                    event.setCancelled(true);
                }
            }
        }
    }

}
