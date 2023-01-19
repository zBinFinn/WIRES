package me.zbinfinn.firstplugin.commands;

import me.zbinfinn.firstplugin.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UwUifyChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Main.chatUwUified = !Main.chatUwUified;
        if (Main.chatUwUified)
            sender.sendMessage(ChatColor.of("#CC5577") + "Chat UwUified");
        else
            sender.sendMessage(ChatColor.of("#CC5577") + "Chat unUwUified :(");

        return false;
    }
}
