package me.boomboompowermc.SimpleChatAlert;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AlertCommand implements CommandExecutor {

	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args.length > 0) {
			String message = ChatColor.RED + "" + ChatColor.BOLD + StringUtils.join(args, " ");
			Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ALERT: " + message);
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "Add a message! Example: " + ChatColor.ITALIC + "/alert Welcome to the server!");
		}
		return true;
	}
}
