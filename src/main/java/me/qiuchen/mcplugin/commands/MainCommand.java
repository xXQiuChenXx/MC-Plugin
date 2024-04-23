package me.qiuchen.mcplugin.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import me.qiuchen.mcplugin.Main;

import static me.qiuchen.mcplugin.commands.subcommands.FlyCommand.onFlyCommand;
import static me.qiuchen.mcplugin.commands.subcommands.GuiCommand.onGuiCommand;
import static me.qiuchen.mcplugin.commands.subcommands.HealCommand.onHealCommand;
import static me.qiuchen.mcplugin.commands.subcommands.ReloadCommand.onReloadCommand;

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
                onReloadCommand(player);
            }

            if (subcommand.equals("heal")) {
                onHealCommand(player, strings);
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
