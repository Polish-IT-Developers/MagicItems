package me.awmeister.projectcore.main;

import me.awmeister.projectcore.commands.*;
import me.awmeister.projectcore.commands.tabcompleter.ItemsTabCompleter;
import me.awmeister.projectcore.listeners.PlayerJoinListener;
import me.awmeister.projectcore.items.SpecialItemManager;
import me.awmeister.projectcore.listeners.*;
import me.awmeister.projectcore.recipes.RecipeManager;
import me.awmeister.projectcore.tasks.CrownTask;
import me.awmeister.projectcore.tasks.HatTask;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("[Items] Enabling...");
        Bukkit.getConsoleSender().sendMessage("[Items] INFO: This plugin supports MC 1.19!");
        SpecialItemManager.init();
        getCommand("items").setExecutor(new AdminItemsCommand(this));
        getCommand("items").setTabCompleter(new ItemsTabCompleter());
        getCommand("start-edycji").setExecutor(new SetStartCommand(this));
        getCommand("knock").setExecutor(new KnockCommand());

        getConfig().options().copyDefaults(true);
        saveConfig();

        new CrownTask(this);
        CrownTask.startTask();

        new HatTask(this);
        HatTask.startTask();

        RecipeManager.registerRecipes();

        Bukkit.getPluginManager().registerEvents(new SmokeBowListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new GunsListener(this), this);
        Bukkit.getPluginManager().registerEvents(new XrayBowListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ThorHammerListener(this), this);
        Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
        Bukkit.getPluginManager().registerEvents(new GrapplingHookListener(), this);
        Bukkit.getPluginManager().registerEvents(new TeleportBowListener(), this);
        Bukkit.getPluginManager().registerEvents(new TeleportShardListener(), this);
        Bukkit.getPluginManager().registerEvents(new BoomerangListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(this), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(this), this);
        Bukkit.getPluginManager().registerEvents(new NecromancerListener(this), this);
        Bukkit.getPluginManager().registerEvents(new NecromancerEggListener(), this);
        Bukkit.getPluginManager().registerEvents(new AirStrikeBowListener(), this);
        Bukkit.getPluginManager().registerEvents(new TestItemListener(this), this);
        Bukkit.getPluginManager().registerEvents(new LaserListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new FreezerListener(this), this);
        Bukkit.getPluginManager().registerEvents(new UndeadsWandListener(), this);
        Bukkit.getPluginManager().registerEvents(new KnockShieldListener(), this);
        Bukkit.getPluginManager().registerEvents(new SnowballListener(), this);
        Bukkit.getPluginManager().registerEvents(new CraftItemListener(), this);

        Bukkit.getConsoleSender().sendMessage("[Items] Plugin has been successfully enabled!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("[Items] Disabling...");

        Bukkit.getScheduler().cancelTasks(this);

        RecipeManager.unregisterRecipes();

        Bukkit.getConsoleSender().sendMessage("[Items] Plugin has been successfully disabled!");
    }
}
