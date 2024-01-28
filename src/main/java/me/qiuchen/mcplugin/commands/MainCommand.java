package me.qiuchen.mcplugin.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(sender instanceof Player player) {
            player.sendMessage("Hello, Welcome to plugin dev!");

        } else if(sender instanceof ConsoleCommandSender) {
            System.out.println("Hello Console!");

        } else if(sender instanceof BlockCommandSender) {
            System.out.println("The command was run by a command block.");
        }


        return true;
    }
}
