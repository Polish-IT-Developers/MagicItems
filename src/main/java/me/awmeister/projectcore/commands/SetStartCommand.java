package me.awmeister.projectcore.commands;

import me.awmeister.projectcore.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class SetStartCommand implements CommandExecutor {

    Main plugin;

    public SetStartCommand(Main m) {
        plugin = m;
        m.getCommand("start-edycji").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        Player p = (Player) sender;

        if(p.hasPermission("items.startedycji")) {
            if(!plugin.getConfig().getBoolean("start")) {
                plugin.getConfig().set("start", true);
                plugin.saveConfig();
                plugin.reloadConfig();
                p.sendMessage("§8» §aEdycja została rozpoczęta!");

                for(Player ps : Bukkit.getOnlinePlayers()) {
                    if(!p.isOp()) {
                        ps.removePotionEffect(PotionEffectType.BLINDNESS);
                        ps.sendTitle("§a§lEdycja rozpoczęta!", "§fMożesz zacząć swoją przygodę!", 3, 40, 3);
                    }
                }
            } else {
                p.sendMessage("§8» §cEdycja już się rozpoczęła!");
            }
        } else {
            p.sendMessage("§8» §cNie posiadasz uprawnień do tej komendy!");
        }

        return false;
    }

}
