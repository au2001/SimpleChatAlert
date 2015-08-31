package me.boomboompowermc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.boomboompowermc.SCAalert;

public class SCAalert implements CommandExecutor {
	
	 public boolean onCommand(CommandSender sender, Command commmnd, String cmd, String[] args) {
	    	if (cmd.equalsIgnoreCase("simplechatalert:alert")) {
	    		if (!(sender instanceof Player)) {
	   				sender.sendMessage(ChatColor.DARK_RED + "This is for players only!");
	   				
	   			} else {
	   				Player p = (Player) sender;    				
	   				if (!p.hasPermission("sca.alert")) {
	   					sender.sendMessage(ChatColor.DARK_RED + "You do not have access to this command!");
	    					
	    			} else if (args.length == 0) {
	    				sender.sendMessage(ChatColor.RED + "Add a message! Example: " + ChatColor.ITALIC + "/alert Welcome to the server!");
	    			} else {
	    				Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ALERT: " + ChatColor.RED + ChatColor.BOLD + message(args));
	    				p.setPlayerListName(ChatColor.RED + "" + ChatColor.BOLD + "ALERT " + ChatColor.RESET + p.getName());    				
	    				p.setPlayerListName(ChatColor.RESET + p.getName());
	    			}
	    		}
	    	}
	    	return true;
	    }
	    public String message(String[] args) {
	    	StringBuilder builder = new StringBuilder();
	    	for (int i = 0; i < args.length; i++) {
	    	builder.append(args[i]);
	    	builder.append(" ");
	    	}
	    	return builder.toString().trim();
	    } 
}
