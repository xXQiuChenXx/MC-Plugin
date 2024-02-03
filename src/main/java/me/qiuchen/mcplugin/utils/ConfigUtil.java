package me.qiuchen.mcplugin.utils;

import me.qiuchen.mcplugin.Main;

public class ConfigUtil {
    private final Main pluginInstance;
    public String JoinMessage;

    public ConfigUtil(Main pluginInstance) {
        this.pluginInstance = pluginInstance;
        init();
    }

    public void init() {
        JoinMessage = this.pluginInstance.getConfig().getString("join-message");
    }
    public void reload() {
        init();
    }
}
