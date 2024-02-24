package me.qiuchen.mcplugin;

import me.qiuchen.mcplugin.commands.DBCommand;
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Main extends JavaPlugin implements Listener {
    private static Main plugin; // Get plugin instance
    private ConfigUtil configUtil;
    public Connection connection;

    @Override
    public void onEnable() {
        plugin = this;
        configUtil = new ConfigUtil(this);
        saveDefaultConfig();
        configUtil.loadConfiguration();
        registerEvents();
        registerCommands();
        DBConnection();
        System.out.println("The plugin has started!");
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll((Plugin) this);
        System.out.println(getConfig().getString("join-message"));
        try {
            connection.close();
        } catch (SQLException e) {
            getLogger().warning("Failed to disconnect to database: " + e.getMessage());
        }
        System.out.println("Mc plugin was stopped!");
    }

    private void registerEvents() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new MyEvents(), this);
        pluginManager.registerEvents(new DeathListener(), this);
    }

    @SuppressWarnings("")
    private void registerCommands() {
        PluginCommand command = getCommand("mc");
        if(command != null) command.setExecutor(new MainCommand()); // To Bypass NullPointer Warnings
        PluginCommand db_command = getCommand("database");
        if(command != null) command.setExecutor(new DBCommand());
    }

    public void DBConnection() {
        String host = ConfigUtil.getConfig().getString("database.host");
        int port = ConfigUtil.getConfig().getInt("database.port");
        String username = ConfigUtil.getConfig().getString("database.username");
        String password = ConfigUtil.getConfig().getString("database.password");
        String database = ConfigUtil.getConfig().getString("database.database");

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
            getLogger().info("Connected to database!");
        } catch (SQLException e) {
            getLogger().warning("Failed to connect to database: " + e.getMessage());
        }
    }

    public static Main getPlugin() {
        return plugin;
    }

    public ConfigUtil getConfigUtil() {
        return this.configUtil;
    }

}
