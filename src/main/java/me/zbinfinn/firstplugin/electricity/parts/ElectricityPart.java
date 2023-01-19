package me.zbinfinn.firstplugin.electricity.parts;

import org.bukkit.Location;

public abstract class ElectricityPart {
    protected boolean conducting = false;
    protected boolean isPowered = false;
    protected Location location;
    protected boolean isPowerSource;

    public ElectricityPart(Location loc) {
        location = loc;
    }

    public abstract void rightClicked();
    public abstract void tickON();
    public abstract void tickOFF();

    public void setPowered(boolean powered) {
        isPowered = powered;
    }

    public Location getLocation() {
        return location;
    }
    public boolean isConducting() {return conducting;}
    public boolean isPowered() {return isPowered;}
}
