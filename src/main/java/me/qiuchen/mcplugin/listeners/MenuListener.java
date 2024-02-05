package me.qiuchen.mcplugin.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        if(event.getView().getTitle().equalsIgnoreCase("Test")) {
            if(event.getCurrentItem() == null) return;

            if(event.getCurrentItem().getType() == Material.DIAMOND_AXE) {
                System.out.println("Test");
            }
        }

        event.setCancelled(true);
    }
}
