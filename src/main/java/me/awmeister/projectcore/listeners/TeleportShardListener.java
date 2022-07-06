package me.awmeister.projectcore.listeners;

import me.awmeister.projectcore.items.SpecialItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class TeleportShardListener implements Listener {

    HashMap<Player, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        ItemStack item = player.getItemInHand();

        if(cooldown.containsKey(player)) {
            if(cooldown.get(player) > System.currentTimeMillis()) {
                player.sendMessage("§8» §cOdczekaj 0,4 sekundy między użyciami tego przedmiotu!");
                event.setCancelled(true);
            } else {
                if(event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                    if(item.hasItemMeta()) {
                        ItemMeta meta = item.getItemMeta();

                        if(Objects.equals(Objects.requireNonNull(meta).getLore(), Objects.requireNonNull(SpecialItemManager.teleportshard.getItemMeta()).getLore())) {
                            try {
                                Block block = player.getTargetBlock((Set<Material>) null, 8);
                                Location loc = block.getLocation();
                                float pitch = player.getEyeLocation().getPitch();
                                float yaw = player.getEyeLocation().getYaw();
                                loc.add(0,1,0);
                                loc.setYaw(yaw);
                                loc.setPitch(pitch);
                                player.teleport(loc);
                                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 5, 5);
                                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 20, 4));

                                cooldown.put(player, System.currentTimeMillis() + 400);
                            } catch (IllegalStateException exception) {
                                Bukkit.getLogger().warning("[Items] [WARN] Caught IllegalStateException in TeleportShardListener.java");
                            }
                        }
                    }
                }
            }
        } else {
            if(event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                if(item.hasItemMeta()) {
                    ItemMeta meta = item.getItemMeta();

                    if(Objects.equals(Objects.requireNonNull(meta).getLore(), Objects.requireNonNull(SpecialItemManager.teleportshard.getItemMeta()).getLore())) {
                        try {
                            Block block = player.getTargetBlock((Set<Material>) null, 8);
                            Location loc = block.getLocation();
                            float pitch = player.getEyeLocation().getPitch();
                            float yaw = player.getEyeLocation().getYaw();
                            loc.add(0,1,0);
                            loc.setYaw(yaw);
                            loc.setPitch(pitch);
                            player.teleport(loc);
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 5, 5);
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 20, 4));

                            cooldown.put(player, System.currentTimeMillis() + 400);
                        } catch (IllegalStateException exception) {
                            Bukkit.getLogger().warning("[Items] [WARN] Caught IllegalStateException in TeleportShardListener.java");
                        }
                    }
                }
            }
        }
    }

}
