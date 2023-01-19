package me.zbinfinn.firstplugin.electricity.handlers;

import me.zbinfinn.firstplugin.electricity.parts.*;
import me.zbinfinn.firstplugin.util.LocationUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Directional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WiresHandler{
    private static final HashMap<Location, ElectricityPart> partsHash = new HashMap<>();
    private static final List<PowerSource> powerSources = new ArrayList<>();
    private static transient final List<Location> alreadyVisitedLocations = new ArrayList<>();

    public static void add(ElectricityPart part) {
        if (!(partsHash.containsKey(part.getLocation()))) {
            partsHash.put(part.getLocation(), part);


            if (part instanceof PowerSource) {
                powerSources.add((PowerSource) part);
            }

        }
    }

    public static void tick() {
        resetAllPoweredStates();

        for (PowerSource ps : powerSources) {
            if (ps.getPowerSourcePowered()) {
                boolean currentElectricity = true;
                alreadyVisitedLocations.clear();
                alreadyVisitedLocations.add(ps.getLocation());

                for (Location loc : LocationUtil.getAdjacentLocations(ps.getLocation()))
                    powerLocation(loc, currentElectricity);
            }
        }

        for (ElectricityPart ep : partsHash.values()) {
            if (ep.isPowered())
                ep.tickON();
            else
                ep.tickOFF();
        }

    }

    private static void powerLocation(Location location, boolean currentElectricity) {
        if (!(alreadyVisitedLocations.contains(location))) {
            alreadyVisitedLocations.add(location);
            if (partsHash.containsKey(location)) {
                if (partsHash.get(location).isPowered())
                    return;
                if (partsHash.get(location) instanceof Inverter) {
                    currentElectricity = !currentElectricity;
                    powerLocation(calculateInverterLocation(location),currentElectricity);
                }
                partsHash.get(location).setPowered(currentElectricity);
                if (partsHash.get(location).isConducting())
                    for (Location locationToAdd : LocationUtil.getAdjacentLocations(location))
                        if (!(alreadyVisitedLocations.contains(locationToAdd)))
                            powerLocation(locationToAdd, currentElectricity);
            }
        }
    }

    private static Location calculateInverterLocation(Location location) {
        Location clone = location.clone();
        Directional data = (Directional) location.getBlock().getBlockData();
        return switch (data.getFacing()) {
            case UP -> clone.add(0, 1, 0);
            case DOWN -> clone.add(0, -1, 0);
            case NORTH -> clone.add(0, 0, -1);
            case SOUTH -> clone.add(0, 0, 1);
            case WEST -> clone.add(-1, 0, 0);
            case EAST -> clone.add(1, 0, 0);
            default -> null;
        };
    }

    private static void resetAllPoweredStates() {
        for (ElectricityPart part : partsHash.values()) {
            part.setPowered(false);
        }
    }

    public static void remove(Location location) {
        if (partsHash.containsKey(location)) {
            if (partsHash.get(location) instanceof PowerSource) {
                powerSources.remove(partsHash.get(location));
            }
            partsHash.remove(location);
        }


    }

    public static void addBlockType(Material blockType, Location location) {

        switch (blockType) {
            case GOLD_BLOCK -> WiresHandler.add(new PowerBlock(location));
            case BLACKSTONE -> WiresHandler.add(new Lamp(location));
            case BLACK_CONCRETE -> WiresHandler.add(new ConcreteWire(location));
            case PISTON -> WiresHandler.add(new Inverter(location));
        }

    }
}
