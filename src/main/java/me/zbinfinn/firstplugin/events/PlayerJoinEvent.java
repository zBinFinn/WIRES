package me.zbinfinn.firstplugin.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        e.setJoinMessage("");
        Bukkit.broadcastMessage(ChatColor.GREEN + "+ " + e.getPlayer().getName());

    }
}
