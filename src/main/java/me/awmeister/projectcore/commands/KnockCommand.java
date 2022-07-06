package me.awmeister.projectcore.commands;

import me.awmeister.projectcore.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KnockCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("items.knock")) {
                if(args.length == 2) {
                    Player target = Bukkit.getPlayer(args[0]);
                    int knockValue = Integer.parseInt(args[1]);

                    if(target != null) {
                        if(Main.getPlugin(Main.class).getConfig().getBoolean("higherKnockback") && knockValue > 50) {
                            target.setVelocity(target.getLocation().getDirection().multiply(-knockValue));

                            player.sendMessage("§8» §aGracz " + target.getName() + " został odrzucony z siłą " + knockValue + ".");
                        } else if(knockValue <= 50) {
                            target.setVelocity(target.getLocation().getDirection().multiply(-knockValue));

                            player.sendMessage("§8» §aGracz " + target.getName() + " został odrzucony z siłą " + knockValue + ".");
                        } else {
                            player.sendMessage("§8» §cPodana wartość jest za duża! Aby umożliwić używanie większych wartości włącz odpowiednią opcję w pliku config.yml.");
                        }
                    } else {
                        player.sendMessage("§8» §cTen gracz nie istnieje lub jest offline!");
                    }
                } else {
                    player.sendMessage("§8» §7Poprawne użycie: §f/knock [gracz] [wartość]");
                }
            } else {
                player.sendMessage("§8» §cNie posiadasz uprawnień do tej komendy!");
            }
        } else {
            if(args.length == 2) {
                Player target = Bukkit.getPlayer(args[0]);
                int knockValue = Integer.parseInt(args[1]);

                if(target != null) {
                    target.setVelocity(target.getLocation().getDirection().multiply(-knockValue));

                    sender.sendMessage("§8» §aGracz " + target.getName() + " został odrzucony z siłą " + knockValue + ".");
                } else {
                    sender.sendMessage("§8» §cTen gracz nie istnieje lub jest offline!");
                }
            } else {
                sender.sendMessage("§8» §7Poprawne użycie: §f/knock [gracz] [wartość]");
            }
        }
        return false;
    }

}
