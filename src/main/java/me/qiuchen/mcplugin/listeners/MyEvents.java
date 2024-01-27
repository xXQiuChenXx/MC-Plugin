package me.qiuchen.mcplugin.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
}
