package me.hitthetarget56.playereventmanager.commands.admin;

import me.hitthetarget56.playereventmanager.util.LogMessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SetLogMessage implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // TODO: adjust, make into a gui with optional nogui
        Player target = Bukkit.getPlayerExact(args[0]);
        StringBuilder b = new StringBuilder();
        for(int i = 1; i < args.length; i++)
            b.append(args[i] + " ");
        String message = ChatColor.translateAlternateColorCodes('&', b.toString());
        LogMessageUtil.setJoinMessage(target,message);
        sender.sendMessage("Success");

        return true;
    }
}
