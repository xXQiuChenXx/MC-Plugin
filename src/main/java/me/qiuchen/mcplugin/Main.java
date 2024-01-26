package me.qiuchen.mcplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Starting My First Plugin");

    }

    @Override
    public void onDisable() {
        System.out.println("Stopping My Plugin");
    }
}
