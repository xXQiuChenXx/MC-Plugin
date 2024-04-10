package me.qiuchen.mcplugin.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand {
    private static final ArrayList<Player> flying_players = new ArrayList<>();

    public static boolean onFlyCommand(Player sender, String[] args) {

        Player target = args[0].isEmpty() ? sender : Bukkit.getServer().getPlayer(args[0]);

        if(args[0] != null && !sender.hasPermission("mcp.fly.other")) {
            sender.sendMessage("You dont have the permission to use this command.");
            return false;
        } else if(args[0] != null && args[0].isEmpty() && !sender.hasPermission("mcp.fly")) {
            sender.sendMessage("You dont have the permission to use this command.");
            return false;
        }

        if(target != null & sender != null) {
            if (flying_players.contains(target)) {
                target.setAllowFlight(false);
                flying_players.remove(target);
                sender.sendMessage("Player " + target.getName() + " is no longer flying!");
            } else {
                target.setAllowFlight(true);
                flying_players.add(target);
                sender.sendMessage("Player " + target.getName() + " is now flying!");
            }

            return true;
        }
        return true;
    }
}
