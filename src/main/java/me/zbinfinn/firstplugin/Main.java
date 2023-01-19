package me.zbinfinn.firstplugin;

import me.zbinfinn.firstplugin.commands.GetSelectionToolCommand;
import me.zbinfinn.firstplugin.commands.KillAllEntitiesCommand;
import me.zbinfinn.firstplugin.commands.TickCommand;
import me.zbinfinn.firstplugin.commands.UwUifyChatCommand;
import me.zbinfinn.firstplugin.constants.ItemConstants;
import me.zbinfinn.firstplugin.electricity.handlers.WiresHandler;
import me.zbinfinn.firstplugin.events.PlayerBreakBlockEvent;
import me.zbinfinn.firstplugin.events.PlayerJoinEvent;
import me.zbinfinn.firstplugin.events.PlayerLeaveEvent;
import me.zbinfinn.firstplugin.events.PlayerPlaceBlockEvent;
import me.zbinfinn.firstplugin.runnables.TickLoopRunnable;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static boolean chatUwUified = false;
    public static World WORLD;

    @Override
    public void onEnable() {
        ItemConstants.initializeConstants();
        WORLD = getServer().getWorld("world");

        //Init Commands
        getCommand("killall").setExecutor(new KillAllEntitiesCommand());
        getCommand("uwuify").setExecutor(new UwUifyChatCommand());
        getCommand("getstaff").setExecutor(new GetSelectionToolCommand());
        getCommand("tick").setExecutor(new TickCommand());

        //Init Events
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new PlayerJoinEvent(), this);
        pm.registerEvents(new PlayerLeaveEvent(), this);
        pm.registerEvents(new PlayerPlaceBlockEvent(), this);
        pm.registerEvents(new PlayerBreakBlockEvent(), this);

        TickLoopRunnable task = new TickLoopRunnable();
        task.runTaskTimer(this, 0, 1);

        Bukkit.broadcastMessage("On Enable");
    }

    @Override
    public void onDisable() {
        Bukkit.broadcastMessage("On Disable");
        WiresHandler poo = new WiresHandler();

    }
}
