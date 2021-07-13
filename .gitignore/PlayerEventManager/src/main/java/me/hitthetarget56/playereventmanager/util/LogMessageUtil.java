package me.hitthetarget56.playereventmanager.util;

import me.hitthetarget56.playereventmanager.PlayerEventManager;
import me.hitthetarget56.playereventmanager.config.LogMessageManager;
import org.bukkit.entity.Player;


public class LogMessageUtil {

    public static String getJoinMessage(Player player){
        return PlayerEventManager.getInstance().getLogMessages().getString(player.getUniqueId()+".join");
    }
    public static String getLeaveMessage(Player player){
        return PlayerEventManager.getInstance().getLogMessages().getString(player.getUniqueId()+".leave");
    }

    public static void setJoinMessage(Player player, String message){
        PlayerEventManager.getInstance().getLogMessages().set(player.getUniqueId()+".join", message);
        LogMessageManager.save();
    }
    public static void setLeaveMessage(Player player, String message){
        PlayerEventManager.getInstance().getLogMessages().set(player.getUniqueId()+".leave", message);
        LogMessageManager.save();
    }

    public static String getDefaultJoin(){
        return PlayerEventManager.getInstance().getLogMessages().getString("default-join");
    }
    public static String getDefaultLeave(){
        return PlayerEventManager.getInstance().getLogMessages().getString("default-leave");
    }





}
