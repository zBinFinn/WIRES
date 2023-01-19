package me.zbinfinn.firstplugin.constants;

import me.zbinfinn.firstplugin.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemConstants {
    public static ItemStack AREA_SELECTION_TOOL;
    public static ItemStack POWER_STICK;

    public static void initializeConstants() {
        //Area Selection Tool
        AREA_SELECTION_TOOL = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = AREA_SELECTION_TOOL.getItemMeta();
        meta.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Selection Tool");
        meta.setLore(List.of(
                ChatColor.GREEN + "Left Click a block to set it as the Corner 1",
                ChatColor.GREEN + "Right Click a block to set it as the Corner 2",
                "",
                "" + ChatColor.GRAY + ChatColor.ITALIC + "Press Swap Hands to update the selected area"
        ));
        ItemUtil.hideAllFlags(meta);
        AREA_SELECTION_TOOL.setItemMeta(meta);

        //Power Stick
        POWER_STICK = new ItemStack(Material.STICK);
        meta = POWER_STICK.getItemMeta();
        meta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "Power Stick");
        meta.setLore(List.of(
                ChatColor.RED + "Click a block to toggle its powered state"
        ));
        ItemUtil.hideAllFlags(meta);
        POWER_STICK.setItemMeta(meta);

    }





}
