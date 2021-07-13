package me.hitthetarget56.playereventmanager;

import me.hitthetarget56.playereventmanager.commands.admin.SetLogMessage;
import me.hitthetarget56.playereventmanager.config.LogMessageManager;
import me.hitthetarget56.playereventmanager.listener.JoinEvent;
import me.hitthetarget56.playereventmanager.listener.LeaveEvent;

import org.bukkit.configuration.file.FileConfiguration;

import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerEventManager extends JavaPlugin {
    private static PlayerEventManager instance;


    public static PlayerEventManager getInstance() {
        return instance;
    }

    public FileConfiguration getLogMessages() {
        return LogMessageManager.get();
    }

    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getCommand("setlogmessage").setExecutor(new SetLogMessage());

        LogMessageManager.setup();
        LogMessageManager.get().addDefault("default-join","%player% has joined!");
        LogMessageManager.get().addDefault("default-leave","%player% has left.");
        LogMessageManager.get().options().copyDefaults(true);
        LogMessageManager.save();

        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
    }


}
