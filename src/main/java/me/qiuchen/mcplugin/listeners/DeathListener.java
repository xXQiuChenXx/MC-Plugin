package me.qiuchen.mcplugin.listeners;

import me.qiuchen.mcplugin.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Main plugin = Main.getPlugin();
        String pathName = plugin.getDataFolder().getPath();

        Player player = event.getPlayer();
        player.sendMessage("Path Location: " + pathName);

        System.out.println(pathName);
    }
}
