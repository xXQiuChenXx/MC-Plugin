package me.qiuchen.mcplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import me.qiuchen.mcplugin.Main;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player player) {
            player.sendMessage("Hello, Welcome to plugin dev!");

            if (strings.length == 0) return true;

            if (strings[0].equals("reload")) {
                if (!sender.hasPermission("mc.reload")) {
                    player.sendMessage("You dont have the permission to use this command.");
                    return false;
                }
               Main instance = Main.getPlugin();
                instance.getConfigUtil().reload();
            }

            if (strings[0].equals("heal")) {
                Player targetPlayer = strings.length == 1 ? player : Bukkit.getServer().getPlayerExact(strings[1]);
                if (targetPlayer != null) { // Bypass NullPointer
                    targetPlayer.setFoodLevel(20);
                    targetPlayer.setHealth(20);
                }
            }


        } else if (sender instanceof ConsoleCommandSender) {
            System.out.println("Hello Console!");

        } else if (sender instanceof BlockCommandSender) {
            System.out.println("The command was run by a command block.");
        }


        return true;
    }
}
