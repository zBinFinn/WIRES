package me.zbinfinn.firstplugin.util;

import me.zbinfinn.firstplugin.Main;
import me.zbinfinn.firstplugin.enums.RepeatAdjacentType;
import me.zbinfinn.firstplugin.runnables.RepeatAdjacentlyRunnable;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationUtil {

    public static void runAdjacently(Location location, RepeatAdjacentType type, RepeatAdjacentlyRunnable code) {
        ArrayList<Location> locations = new ArrayList<>();


        if (type != RepeatAdjacentType.DIAGONAL_EIGHT) {
            locations.addAll(getAdjacentLocations(location));
        }
        if (type != RepeatAdjacentType.ADJACENT_SIX) {
            locations.addAll(getDiagonalLocations(location));
        }

        for (Location loc : locations) {
            code.run(loc);
        }
    }

    public static ArrayList<Location> getLocationsOnGrid(Location cornerOne, Location cornerTwo) {
        ArrayList<Location> list = new ArrayList<>();

        int x1 = cornerOne.getBlockX();
        int y1 = cornerOne.getBlockY();
        int z1 = cornerOne.getBlockZ();

        int x2 = cornerTwo.getBlockX();
        int y2 = cornerTwo.getBlockY();
        int z2 = cornerTwo.getBlockZ();

        int lowestX = Math.min(x1, x2);
        int lowestY = Math.min(y1, y2);
        int lowestZ = Math.min(z1, z2);

        int highestX = Math.max(x1, x2);
        int highestY = Math.max(y1, y2);
        int highestZ = Math.max(z1, z2);

        for(int x = lowestX; x <= highestX; x++)
            for(int y = lowestY; y <= highestY; y++)
                for(int z = lowestZ; z <= highestZ; z++)
                    list.add(new Location(Main.WORLD, x, y, z));
        return list;
    }

    public static List<Location> getAdjacentLocations(Location location) {
        Location cloned = location.clone();
        return List.of(
                cloned.add(-1, 0, 0).clone(),
                cloned.add(2, 0, 0).clone(),
                cloned.add(-1, -1, 0).clone(),
                cloned.add(0, 2, 0).clone(),
                cloned.add(0, -1, -1).clone(),
                cloned.add(0, 0, 2).clone()
        );
    }

    private static List<Location> getDiagonalLocations (Location location) {
        Location cloned = location.clone();
        return List.of(
                cloned.add(1, 1, 1).clone(),
                cloned.add(-2, 0, 0).clone(),
                cloned.add(0, 0, -2).clone(),
                cloned.add(2, 0, 0).clone(),
                cloned.add(0, -2, 0).clone(),
                cloned.add(-2, 0, 0).clone(),
                cloned.add(0, 0, 2).clone(),
                cloned.add(2, 0, 0).clone()
        );

    }



}
