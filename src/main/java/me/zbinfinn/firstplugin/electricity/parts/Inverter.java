package me.zbinfinn.firstplugin.electricity.parts;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

public class Inverter extends ElectricityPart {
    public Inverter(Location loc) {
        super(loc);
    }

    @Override
    public void rightClicked() {

    }

    @Override
    public void tickON() {
        Block block = location.getBlock();
        BlockData data = block.getBlockData();
        location.getBlock().setType(Material.STICKY_PISTON);
        location.getBlock().setBlockData(data);
    }

    @Override
    public void tickOFF() {
        Block block = location.getBlock();
        BlockData data = block.getBlockData();
        location.getBlock().setType(Material.PISTON);
        location.getBlock().setBlockData(data);

    }
}
