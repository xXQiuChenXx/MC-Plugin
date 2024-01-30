package me.qiuchen.mcplugin;

import me.qiuchen.mcplugin.commands.MainCommand;
import me.qiuchen.mcplugin.listeners.DeathListener;
import me.qiuchen.mcplugin.listeners.MyEvents;
import org.bukkit.Server;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
public final class Main extends JavaPlugin implements Listener {
    private static Main plugin; // Get plugin instance

    @Override
    public void onEnable() {
        plugin = this;
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
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new MyEvents(), this);
        pluginManager.registerEvents(new DeathListener(), this);
    }

    private void registerCommands() {
        MainCommand command = new MainCommand();
        getCommand("hi").setExecutor(command);
    }

    public static void reload() {
        System.out.println("Reload Done!");
    }

    public static Main getPlugin() {
        return plugin;
    }

}
