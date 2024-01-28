package me.qiuchen.mcplugin.listeners;

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

        player.getDisplayName();

        TextComponent component = Component.text("Welcome to the server @" + player.getName());
        event.joinMessage(component);

        if(player.getName().equalsIgnoreCase("YuanXeow")) {
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
