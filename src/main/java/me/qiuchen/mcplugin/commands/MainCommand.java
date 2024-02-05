package me.qiuchen.mcplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import me.qiuchen.mcplugin.Main;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player player) {
            if (strings.length == 0) {
                player.sendMessage("Hello, Welcome to plugin dev!");
                return true;
            }

            if (strings[0].equals("reload")) {
                if (!sender.hasPermission("mc.reload")) {
                    player.sendMessage("You dont have the permission to use this command.");
                    return false;
                }
                Main instance = Main.getPlugin();
                instance.getConfigUtil().loadConfiguration();
                player.sendMessage("Reload Complete!");
            }

            if (strings[0].equals("heal")) {
                Player targetPlayer = strings.length == 1 ? player : Bukkit.getServer().getPlayerExact(strings[1]);
                if (targetPlayer != null) { // Bypass NullPointer
                    targetPlayer.setFoodLevel(20);
                    targetPlayer.setHealth(20);
                }
            }

            if(strings[0].equals("gui")) {
                Inventory inventory = Bukkit.createInventory(player, 27, "Test");
                ItemStack item = new ItemStack(Material.DIAMOND_AXE);
                ItemMeta itemMeta = item.getItemMeta();

                itemMeta.setDisplayName("Hello");
                item.setItemMeta(itemMeta);

                inventory.setItem(1, item);
                player.openInventory(inventory);
            }


        } else if (sender instanceof ConsoleCommandSender) {
            System.out.println("Hello Console!");

        } else if (sender instanceof BlockCommandSender) {
            System.out.println("The command was run by a command block.");
        }


        return true;
    }
}
