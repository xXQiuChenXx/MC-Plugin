package me.qiuchen.mcplugin.listeners;

import me.qiuchen.mcplugin.utils.Constants;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        Component component = Constants.GUITitle;
        System.out.println(event.getView().title());
        if(event.getView().title().equals(component)) {
            if(event.getCurrentItem() == null) return;

            if(event.getCurrentItem().getType() == Material.DIAMOND_AXE) {
                System.out.println("Test");
            }
        }

        event.setCancelled(true);
    }
}
