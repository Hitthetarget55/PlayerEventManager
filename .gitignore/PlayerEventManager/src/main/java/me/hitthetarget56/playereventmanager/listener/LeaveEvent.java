package me.hitthetarget56.playereventmanager.listener;

import me.hitthetarget56.playereventmanager.util.LogMessageUtil;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class LeaveEvent implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        if(LogMessageUtil.getLeaveMessage(event.getPlayer()) == null){
            event.setQuitMessage(LogMessageUtil.getDefaultLeave()
                    .replace("%player%",event.getPlayer().getName())
            );
        }else{
            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&',
                    LogMessageUtil.getLeaveMessage(event.getPlayer())
                            .replace("%player%",event.getPlayer().getName())));
        }
    }


}
