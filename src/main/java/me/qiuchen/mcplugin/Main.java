package me.qiuchen.mcplugin;

import me.qiuchen.mcplugin.commands.MainCommand;
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
        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll((Plugin) this);
        System.out.println("Mc plugin was stopped!");
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new MyEvents(), this);
    }

    private void registerCommands() {
        MainCommand command = new MainCommand();
        getCommand("hi").setExecutor(command);
    }


    public static void reload() {
        System.out.println("Reload Done!");
    }
}
