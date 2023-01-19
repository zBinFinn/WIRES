package me.zbinfinn.firstplugin.electricity.parts;

import org.bukkit.Location;
import org.bukkit.Material;

public class Lamp extends ElectricityPart {

    public Lamp(Location loc) {
        super(loc);
    }

    @Override
    public void rightClicked() {
        //no
    }

    @Override
    public void tickON() {
        location.getBlock().setType(Material.SHROOMLIGHT);
    }

    @Override
    public void tickOFF() {
        location.getBlock().setType(Material.BLACKSTONE);
    }
}
