package me.qiuchen.mcplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MainCommandTabComplete implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(commandSender instanceof Player player)) {
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 1) {
            if (player.hasPermission("mcp.reload")) {
                list.add("reload");
            }
            if (player.hasPermission("mcp.fly")) {
                list.add("fly");
            }
            if (player.hasPermission("mcp.heal")) {
                list.add("heal");
            }
            list.add("gui");

            return list;
        }

        return list;
    }
}
