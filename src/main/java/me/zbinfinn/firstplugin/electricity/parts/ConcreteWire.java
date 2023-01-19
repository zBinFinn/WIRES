package me.zbinfinn.firstplugin.electricity.parts;

import org.bukkit.Location;
import org.bukkit.Material;

public class ConcreteWire extends ElectricityPart{
    public ConcreteWire(Location loc) {
        super(loc);
        conducting = true;
    }

    @Override
    public void rightClicked() {

    }

    @Override
    public void tickON() {
        location.getBlock().setType(Material.YELLOW_CONCRETE);
    }

    @Override
    public void tickOFF() {
        location.getBlock().setType(Material.BLACK_CONCRETE);
    }


}
