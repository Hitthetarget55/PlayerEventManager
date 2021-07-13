package me.hitthetarget56.playereventmanager.listener;

import me.hitthetarget56.playereventmanager.util.LogMessageUtil;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(LogMessageUtil.getJoinMessage(event.getPlayer()) == null){
            event.setJoinMessage(LogMessageUtil.getDefaultJoin()
                .replace("%player%",event.getPlayer().getName())
            );
        }else{
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', LogMessageUtil.getJoinMessage(event.getPlayer()).replace("%player%",event.getPlayer().getName())));
        }
    }

}
