package me.qiuchen.mcplugin.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import me.qiuchen.mcplugin.Main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;


public class MyEvents implements Listener {
    private final Main plugin;

    public MyEvents(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSheerEntity(PlayerShearEntityEvent event) {
        Entity entity = event.getEntity();
        Player player = event.getPlayer();

        if(entity.getType() == EntityType.SHEEP) {
            player.sendMessage("This is a sheep, you cannot do that here!");
            event.setCancelled(true);
        } else {
            player.sendMessage("This is not a sheep.");
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String configMessage = this.plugin.getConfig().getString("join-message");

        if(configMessage != null) {
            String joinText = PlaceholderAPI.setPlaceholders(event.getPlayer(), configMessage);
            TextComponent component = Component.text(joinText);
            event.joinMessage(component);
        }

        if(player.getName().equalsIgnoreCase("YuanXeow")) {
            System.out.println("Test PASS");
            player.setGameMode(GameMode.CREATIVE);
        }
    }
    @EventHandler
    public void onBedLeave(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("You just leaved the bed... Boom!!!");
        player.setHealth(0);
    }
}
