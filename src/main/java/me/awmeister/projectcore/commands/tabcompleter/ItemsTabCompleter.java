package me.awmeister.projectcore.commands.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemsTabCompleter implements TabCompleter {

    private static final List<String> COMMANDS = Arrays.asList("boss", "bows", "defense", "models", "move", "other", "wands", "debug");

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        final List<String> completions = new ArrayList<>();
        StringUtil.copyPartialMatches(args[0], COMMANDS, completions);
        Collections.sort(completions);
        return completions;
    }

}
