package me.qiuchen.mcplugin.commands;

import me.qiuchen.mcplugin.utils.Constants;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import me.qiuchen.mcplugin.Main;

import static me.qiuchen.mcplugin.commands.subcommands.FlyCommand.onFlyCommand;
import static me.qiuchen.mcplugin.commands.subcommands.GuiCommand.onGuiCommand;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player player) { // Player Commands
            if (strings.length == 0) {
                player.sendMessage("你好，這裏是MCP !!!");
                return true;
            }

            String subcommand = strings[0];

            if (subcommand.equals("reload")) {
                if (!sender.hasPermission("mcp.reload")) {
                    player.sendMessage("You dont have the permission to use this command.");
                    return false;
                }
                Main instance = Main.getPlugin();
                instance.getConfigUtil().loadConfiguration();
                player.sendMessage("Reload Complete!");
            }

            if (subcommand.equals("heal")) {
                Player targetPlayer = strings.length == 1 ? player : Bukkit.getServer().getPlayerExact(strings[1]);
                if (targetPlayer != null) { // Bypass NullPointer
                    targetPlayer.setFoodLevel(20);
                    targetPlayer.setHealth(20);
                }
            }

            if(subcommand.equals("gui")) {
                onGuiCommand(player);
            }

            if(subcommand.equals("fly")) {
               onFlyCommand(player, strings);
            }


        } else if (sender instanceof ConsoleCommandSender) {
            System.out.println("Hello Console!");

        } else if (sender instanceof BlockCommandSender) {
            System.out.println("The command was run by a command block.");
        }


        return true;
    }
}
