package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CraftItemListener implements Listener {

    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        Inventory inventory = event.getInventory();

        for (ItemStack item : inventory.getContents()) {
            if(item != null) {
                if(item.getType() == Material.BOW && item.hasItemMeta() && item.getItemMeta().hasLore()) {
                    if(item.getItemMeta().getLore().equals(SpecialItemManager.flashbow)) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    } else if(item.getItemMeta().getLore().equals(SpecialItemManager.xraybow)) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    } else if(item.getItemMeta().getLore().equals(SpecialItemManager.airstrikebow)) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    } else if(item.getItemMeta().getLore().equals(SpecialItemManager.teleportshard)) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    }
                } else if(item.getType() == Material.NETHER_STAR && item.hasItemMeta() && item.getItemMeta().hasLore()) {
                    if(item.getItemMeta().getLore().equals(SpecialItemManager.shuriken.getItemMeta().getLore())) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    }
                } else if(item.getType() == Material.SNOWBALL && item.hasItemMeta() && item.getItemMeta().hasLore()) {
                    if(item.getItemMeta().getLore().equals(SpecialItemManager.shockwaveSnowball.getItemMeta().getLore())) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    }
                } else if(item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta() && item.getItemMeta().hasLore()) {
                    if(item.getItemMeta().getLore().equals(SpecialItemManager.teleportshard.getItemMeta().getLore())) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    }
                } else if(item.getType() == Material.BLAZE_ROD && item.hasItemMeta() && item.getItemMeta().hasLore()) {
                    if(item.getItemMeta().getLore().equals(SpecialItemManager.laser.getItemMeta().getLore())) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    } else if(item.getItemMeta().getLore().equals(SpecialItemManager.freezer.getItemMeta().getLore())) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    }
                } else if(item.getType() == Material.SUGAR && item.hasItemMeta() && item.getItemMeta().hasLore()) {
                    if(item.getItemMeta().getLore().equals(SpecialItemManager.undead.getItemMeta().getLore())) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    }
                } else if(item.getType() == Material.GLOWSTONE_DUST && item.hasItemMeta() && item.getItemMeta().hasLore()) {
                    if(item.getItemMeta().getLore().equals(SpecialItemManager.crown)) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    } else if(item.getItemMeta().getLore().equals(SpecialItemManager.hat)) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    } else if(item.getItemMeta().getLore().equals(SpecialItemManager.christmashat)) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    } else if(item.getItemMeta().getLore().equals(SpecialItemManager.santaclaushat)) {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("§8» §cMagiczne przedmioty nie mogą być używane do craftowania!");
                    }
                }
            }
        }
    }

}
