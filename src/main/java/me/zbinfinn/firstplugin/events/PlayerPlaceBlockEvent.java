package me.zbinfinn.firstplugin.events;

import me.zbinfinn.firstplugin.electricity.handlers.WiresHandler;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceBlockEvent implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Location location = event.getBlockPlaced().getLocation();
        Material blockType = event.getBlockPlaced().getType();

        WiresHandler.addBlockType(blockType, location);

    }

}
