package me.qiuchen.mcplugin.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HealCommand {
    public static boolean onHealCommand(Player player, String[] strings) {
        Player targetPlayer = strings.length == 1 ? player : Bukkit.getServer().getPlayerExact(strings[1]);
        if (targetPlayer != null) { // Bypass NullPointer
            targetPlayer.setFoodLevel(20);
            targetPlayer.setHealth(20);
            player.sendMessage("Healed player " + targetPlayer.getName() + "!");
        } else {
            player.sendMessage("Player not found!");
        }
        return true;
    }
}
