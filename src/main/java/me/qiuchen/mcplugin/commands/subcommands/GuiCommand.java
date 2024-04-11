package me.qiuchen.mcplugin.commands.subcommands;

import me.qiuchen.mcplugin.utils.Constants;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiCommand {
    public static boolean onGuiCommand(Player player) {
        Component component = Constants.GUITitle;
        Inventory inventory = Bukkit.createInventory(player, 27, component);
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.displayName(component);
        item.setItemMeta(itemMeta);

        inventory.setItem(1, item);
        player.openInventory(inventory);
        return true;
    }
}
