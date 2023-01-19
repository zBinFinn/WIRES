package me.zbinfinn.firstplugin.runnables;

import me.zbinfinn.firstplugin.electricity.handlers.WiresHandler;
import org.bukkit.scheduler.BukkitRunnable;

public class TickLoopRunnable extends BukkitRunnable {
    @Override
    public void run(){
        WiresHandler.tick();
    }
}