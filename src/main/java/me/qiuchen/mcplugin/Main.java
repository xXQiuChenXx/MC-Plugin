package me.qiuchen.mcplugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("The plugin has started!");

        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        System.out.println("Stopping My Plugin");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        try {
            String msg = event.joinMessage().toString();
            System.out.println(msg);
        } catch (NullPointerException error) {
            //
        }

        TextComponent component = Component.text("Welcome to the server @" + player.getName());
        event.joinMessage(component);
    }

    @EventHandler
    public void onBedLeave(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("You just leaved the bed... Boom!!!");
        player.setHealth(0);
    }
}
