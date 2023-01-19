package me.zbinfinn.firstplugin.electricity.parts;

import org.bukkit.Location;

public abstract class PowerSource extends ElectricityPart{
    public PowerSource(Location loc) {
        super(loc);
    }

    public abstract boolean getPowerSourcePowered();
}
