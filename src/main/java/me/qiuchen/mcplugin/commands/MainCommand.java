package me.qiuchen.mcplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import me.qiuchen.mcplugin.Main;

import java.util.Objects;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player player) {
            player.sendMessage("Hello, Welcome to plugin dev!");

            if (strings.length == 0) return true;

            if (strings[0].equals(("reload")) && sender.hasPermission("mc.reload")) {
                Main.reload();
            } else {
                player.sendMessage("You dont have the permission to use this command.");
            }

            if (strings[0].equals("heal")) {
                Player targetPlayer = Bukkit.getServer().getPlayerExact(strings[1]);

                Objects.requireNonNullElse(targetPlayer, player).setHealth(10);
                Objects.requireNonNullElse(targetPlayer, player).setFoodLevel(10);
            }


        } else if (sender instanceof ConsoleCommandSender) {
            System.out.println("Hello Console!");

        } else if (sender instanceof BlockCommandSender) {
            System.out.println("The command was run by a command block.");
        }


        return true;
    }
}
