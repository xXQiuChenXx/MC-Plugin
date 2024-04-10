package me.qiuchen.mcplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {
    private final ArrayList<Player> flying_players = new ArrayList<Player>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(sender instanceof Player)) return true;

        Player target = strings[0].isEmpty() ? (Player) sender : Bukkit.getServer().getPlayer(strings[0]);

        if(target == null) {
            sender.sendMessage("Player not found!");
            return true;
        }

        if(flying_players.contains(target)) {
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
}
