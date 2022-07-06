package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class TeleportBowListener implements Listener {

    @EventHandler
    public void onBowShoot(EntityShootBowEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            ItemStack bow = e.getBow();

            if(e.getBow() != null) {
                if(e.getBow().getItemMeta().hasLore() && e.getBow().getItemMeta().getLore().equals(SpecialItemManager.teleportbow.getItemMeta().getLore())) {
                    e.setCancelled(true);
                    p.launchProjectile(EnderPearl.class).setVelocity(e.getProjectile().getVelocity().multiply(1.1));
                    p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                }
            }
        }
    }

}
