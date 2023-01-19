package me.zbinfinn.firstplugin.commands;

import me.zbinfinn.firstplugin.constants.ItemConstants;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetSelectionToolCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player player = (Player) sender;

        player.getInventory().addItem(ItemConstants.AREA_SELECTION_TOOL);
        player.getInventory().addItem(ItemConstants.POWER_STICK);
        player.sendMessage(ChatColor.GREEN + "Area Selection Tool given");
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 1);


        return false;
    }
}
