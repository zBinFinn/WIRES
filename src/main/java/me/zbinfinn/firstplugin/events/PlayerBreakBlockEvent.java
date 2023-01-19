package me.zbinfinn.firstplugin.events;

import me.zbinfinn.firstplugin.electricity.handlers.WiresHandler;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakBlockEvent implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        Location location = event.getBlock().getLocation();

        WiresHandler.remove(location);



    }

}
