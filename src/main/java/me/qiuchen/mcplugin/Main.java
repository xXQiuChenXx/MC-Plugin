package me.qiuchen.mcplugin;

import me.qiuchen.mcplugin.commands.MainCommand;
import me.qiuchen.mcplugin.listeners.DeathListener;
import me.qiuchen.mcplugin.listeners.MyEvents;
import me.qiuchen.mcplugin.utils.ConfigUtil;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
    private static Main plugin; // Get plugin instance
    private ConfigUtil configUtil;

    @Override
    public void onEnable() {
        plugin = this;
        configUtil = new ConfigUtil(this);
        saveDefaultConfig();
        registerEvents();
        registerCommands();
        System.out.println("The plugin has started!");
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll((Plugin) this);
        System.out.println("Mc plugin was stopped!");
    }

    private void registerEvents() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new MyEvents(this), this);
        pluginManager.registerEvents(new DeathListener(), this);
    }

    @SuppressWarnings("")
    private void registerCommands() {
        PluginCommand command = getCommand("mc");
        if(command != null) command.setExecutor(new MainCommand()); // To Bypass NullPointer Warnings
    }

    public static Main getPlugin() {
        return plugin;
    }

    public ConfigUtil getConfigUtil() {
        return this.configUtil;
    }

}
