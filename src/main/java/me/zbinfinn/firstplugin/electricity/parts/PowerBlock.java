package me.zbinfinn.firstplugin.electricity.parts;

import org.bukkit.Location;

public class PowerBlock extends PowerSource {

    public PowerBlock(Location loc) {
        super(loc);
        isPowerSource = true;
    }

    @Override
    public boolean getPowerSourcePowered() {
        return true;
    }

    @Override
    public void rightClicked() {
        //nothing
    }

    @Override
    public void tickON() {

    }

    @Override
    public void tickOFF() {

    }

}
