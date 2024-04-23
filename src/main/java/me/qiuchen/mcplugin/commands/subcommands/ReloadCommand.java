package me.qiuchen.mcplugin.commands.subcommands;

import me.qiuchen.mcplugin.Main;
import org.bukkit.entity.Player;

public class ReloadCommand {
    public static boolean onReloadCommand(Player sender) {
        if (!sender.hasPermission("mcp.reload")) {
            sender.sendMessage("You dont have the permission to use this command.");
            return false;
        }
        Main instance = Main.getPlugin();
        instance.getConfigUtil().loadConfiguration();
        sender.sendMessage("Reload Complete!");
        return true;
    }
}
