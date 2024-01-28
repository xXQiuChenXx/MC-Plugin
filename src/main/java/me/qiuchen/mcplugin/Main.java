package me.qiuchen.mcplugin;

import me.qiuchen.mcplugin.listeners.MyEvents;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("The plugin has started!");

        getServer().getPluginManager().registerEvents(new MyEvents(), this);

    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll((Plugin) this);
        System.out.println("Mc plugin was stopped!");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!command.getName().equalsIgnoreCase("hi")) return false;

        if(sender instanceof Player player) {
            player.sendMessage("Hello, Welcome to plugin dev!");

        } else if(sender instanceof ConsoleCommandSender) {
            System.out.println("Hello Console!");

        } else if(sender instanceof BlockCommandSender) {
            System.out.println("The command was run by the Console.");
        }

        return true;
    }
}
