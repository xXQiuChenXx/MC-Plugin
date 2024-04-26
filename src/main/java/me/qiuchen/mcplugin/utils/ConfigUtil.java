package me.qiuchen.mcplugin.utils;

import me.qiuchen.mcplugin.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ConfigUtil {
    private final Main pluginInstance;
    public static YamlConfiguration config;

    public ConfigUtil(Main pluginInstance) {
        this.pluginInstance = pluginInstance;
    }

    public void loadConfiguration() {
        String PATH = "config.yml";

        Main instance = this.pluginInstance;

        String test = instance.getConfig().getCurrentPath();
        System.out.println(test);

        File configFile = new File(instance.getDataFolder(), PATH);

        if (!configFile.exists()) {
            instance.saveResource(PATH, false);
        }

        config = YamlConfiguration.loadConfiguration(configFile);

        InputStream inputStream = instance.getResource(PATH);
        if(inputStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            config.addDefaults(defaultConfig);
        }

    }

    public static YamlConfiguration getConfig() {
        return config;
    }
}
