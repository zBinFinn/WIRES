package me.zbinfinn.firstplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class KillAllEntitiesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player player = (Player) sender;
        int counter = 0;

        for (Entity entity : player.getWorld().getEntities()) {
            if (!(entity instanceof Player)) {
                entity.remove();
                counter ++;
            }
        }

        player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.RED + "KILL" + ChatColor.DARK_RED + "]" + ChatColor.WHITE + " Killed " + counter + " Entities.");

        return false;
    }
}
