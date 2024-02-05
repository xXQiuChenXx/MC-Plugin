package me.qiuchen.mcplugin.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;

public class Constants {
    public static Component GUITitle = Component.text("You're a ").color(NamedTextColor.LIGHT_PURPLE)
            .append(Component.text().content("Bunny").color(NamedTextColor.LIGHT_PURPLE));
}
