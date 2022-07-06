package me.awmeister.projectcore.gui;

import me.awmeister.projectcore.items.SpecialItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BowsGUI {

    public static void OpenBowsGUI(Player p) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&8Łuki..."));

        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(" ");
        glass.setItemMeta(glassMeta);

        for (int i = 0; i <= 26; ++i) {
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23 || i == 24 || i == 25 || i == 26) {
                inv.setItem(i, glass);
            }
        }

//        inv.setItem(11, SpecialItemManager.teleportbow);
        inv.setItem(12, SpecialItemManager.airstrikebow);
        inv.setItem(13, SpecialItemManager.xraybow);
        inv.setItem(14, SpecialItemManager.flashbow);

        p.openInventory(inv);
    }

}
