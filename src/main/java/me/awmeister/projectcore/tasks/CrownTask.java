package me.awmeister.projectcore.tasks;

import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class CrownTask {

    static Main plugin;

    public CrownTask(Main m) {
        plugin = m;
    }

    public static void startTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player ps : Bukkit.getOnlinePlayers()) {
                    if(ps.getInventory().getHelmet() != null && ps.getInventory().getHelmet().equals(SpecialItemManager.crown)) {
                        ps.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
                    }
                }
            }
        }.runTaskTimer(plugin, 2 * 20L, 2 * 20L);
    }

}
