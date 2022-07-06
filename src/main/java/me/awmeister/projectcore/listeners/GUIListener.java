package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Bossy...")) {
            Player p = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE || !e.getCurrentItem().hasItemMeta()) {
                e.setCancelled(true);
                return;
            }

            switch (e.getCurrentItem().getType()) {
                case SKELETON_SPAWN_EGG -> {
                    p.getInventory().addItem(SpecialItemManager.necromanceregg);
                    p.closeInventory();
                }
                case PAPER -> e.setCancelled(true);
            }
        } else if (ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Łuki...")) {
            Player p = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE || !e.getCurrentItem().hasItemMeta()) {
                e.setCancelled(true);
                return;
            }

            switch (e.getCurrentItem().getType()) {
                case BOW:
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eŁuk teleportacji")) {
                        p.getInventory().addItem(SpecialItemManager.teleportbow);
                        p.closeInventory();
                        break;
                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eŁuk z nalotem")) {
                        p.getInventory().addItem(SpecialItemManager.airstrikebow);
                        p.closeInventory();;
                        break;
                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eŁuk z bombą dymną")) {
                        p.getInventory().addItem(SpecialItemManager.flashbow);
                        p.closeInventory();
                        break;
                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eŁuk ze strzałą zwiadowczą")) {
                        p.getInventory().addItem(SpecialItemManager.xraybow);
                        p.closeInventory();
                        break;
                    }
                case PAPER:
                    e.setCancelled(true);
                    break;
            }
        } else if (ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Poruszanie się...")) {
            Player p = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE || !e.getCurrentItem().hasItemMeta()) {
                e.setCancelled(true);
                return;
            }

            switch (e.getCurrentItem().getType()) {
                case BOW -> {
                    p.getInventory().addItem(SpecialItemManager.teleportbow);
                    p.closeInventory();
                }
                case AMETHYST_SHARD -> {
                    p.getInventory().addItem(SpecialItemManager.teleportshard);
                    p.closeInventory();
                }
                case FISHING_ROD -> {
                    p.getInventory().addItem(SpecialItemManager.grapplinghook);
                    p.closeInventory();
                }
                case PAPER -> e.setCancelled(true);
            }
        } else if (ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Inne...")) {
            Player p = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE || !e.getCurrentItem().hasItemMeta()) {
                e.setCancelled(true);
                return;
            }

            switch (e.getCurrentItem().getType()) {
                case IRON_AXE -> {
                    p.closeInventory();
                    p.getInventory().addItem(SpecialItemManager.thorhammer);
                }
                case NETHER_STAR -> {
                    p.closeInventory();
                    p.getInventory().addItem(SpecialItemManager.shuriken);
                }
                case NETHERITE_PICKAXE -> {
                    p.closeInventory();
                    p.getInventory().addItem(SpecialItemManager.superpickaxe);
                }
                case BLAZE_ROD -> {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bLaser")) {
                        p.getInventory().addItem(SpecialItemManager.laser);
                        p.closeInventory();
                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bZamrażacz")) {
                        p.getInventory().addItem(SpecialItemManager.freezer);
                        p.closeInventory();
                    }
                }
                case PAPER -> e.setCancelled(true);
            }
        } else if(ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Różdżki...")) {
            Player p = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE || !e.getCurrentItem().hasItemMeta()) {
                e.setCancelled(true);
                return;
            }

            switch (e.getCurrentItem().getType()) {
                case FIRE_CHARGE -> {
                    p.closeInventory();
                    p.getInventory().addItem(SpecialItemManager.fireballgun);
                }
                case WITHER_SKELETON_SKULL -> {
                    p.closeInventory();
                    p.getInventory().addItem(SpecialItemManager.withergun);
                }
                case DRAGON_HEAD -> {
                    p.closeInventory();
                    p.getInventory().addItem(SpecialItemManager.dragongun);
                }
                case SUGAR -> {
                    p.closeInventory();
                    p.getInventory().addItem(SpecialItemManager.undead);
                }
                case PAPER -> e.setCancelled(true);
            }
        } else if(ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Modele...")) {
            Player p = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE || !e.getCurrentItem().hasItemMeta()) {
                e.setCancelled(true);
                return;
            }

            switch (e.getCurrentItem().getType()) {
                case GLOWSTONE_DUST:
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("Korona")) {
                        p.closeInventory();
                        p.getInventory().addItem(SpecialItemManager.crown);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("Czapka z daszkiem")) {
                        p.closeInventory();
                        p.getInventory().addItem(SpecialItemManager.hat);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("Czapka Mikołaja")) {
                        p.closeInventory();
                        p.getInventory().addItem(SpecialItemManager.christmashat);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("Czapka Sierżanta Zimy")) {
                        p.closeInventory();
                        p.getInventory().addItem(SpecialItemManager.santaclaushat);
                    }
                    break;
                case PAPER:
                    e.setCancelled(true);
                    break;
            }
        } else if(ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Przedmioty obronne...")) {
            Player p = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE || !e.getCurrentItem().hasItemMeta()) {
                e.setCancelled(true);
                return;
            }

            switch (e.getCurrentItem().getType()) {
                case SHIELD:
                    p.closeInventory();
                    p.getInventory().addItem(SpecialItemManager.knockShield);
                    break;
                case SNOWBALL:
                    p.closeInventory();
                    p.getInventory().addItem(SpecialItemManager.shockwaveSnowball);
                    break;
                case PAPER:
                    e.setCancelled(true);
                    break;
            }
        }
    }
}
