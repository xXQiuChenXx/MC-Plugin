package me.qiuchen.mcplugin.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HealCommand {
    public static boolean onHealCommand(Player sender, String[] strings) {
        Player targetPlayer = strings[1].isEmpty() ? sender : Bukkit.getServer().getPlayerExact(strings[1]);
        if (targetPlayer != null) { // Bypass NullPointer
            targetPlayer.setFoodLevel(20);
            targetPlayer.setHealth(20);
            sender.sendMessage("Healed player " + targetPlayer.getName() + "!");
        } else if(sender != null ) {
            sender.sendMessage("Player not found!");
        }
        return true;
    }
}
