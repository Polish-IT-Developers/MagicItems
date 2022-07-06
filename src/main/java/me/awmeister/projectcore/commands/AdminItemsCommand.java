package me.awmeister.projectcore.commands;

import me.awmeister.projectcore.gui.*;
import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminItemsCommand implements CommandExecutor {

    Main plugin;

    public AdminItemsCommand(Main m) {
        plugin = m;
        m.getCommand("items").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        Player p = (Player) sender;

        if(p.hasPermission("items.admin")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("boss")) {
                    BossGUI.OpenBossGUI(p);
                } else if(args[0].equalsIgnoreCase("bows")) {
                    BowsGUI.OpenBowsGUI(p);
                } else if(args[0].equalsIgnoreCase("models")) {
                    ModelsGUI.OpenModelsGUI(p);
                } else if(args[0].equalsIgnoreCase("move")) {
                    MoveGUI.OpenMoveGUI(p);
                } else if(args[0].equalsIgnoreCase("other")) {
                    OthersGUI.OpenOtherGUI(p);
                } else if(args[0].equalsIgnoreCase("wands")) {
                    WandsGUI.OpenWandsGUI(p);
                } else if(args[0].equalsIgnoreCase("defense")) {
                    DefenseGUI.OpenDefendGUI(p);
                } else if(args[0].equalsIgnoreCase("debug")) {
                    p.getInventory().addItem(SpecialItemManager.debug);
                    p.sendMessage("§8» §aPomyślnie nadano przedmiot testowy!");
                } else {
                    p.sendMessage("§8» §cPodana kategoria nie została znaleziona!");
                }
            } else {
                p.sendMessage("§8» §7Poprawne użycie: §f/items [kategoria]");
            }
        } else {
            p.sendMessage("§8» §cNie posiadasz uprawnień do tej komendy!");
        }

        return false;
    }

}
