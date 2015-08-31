package me.boomboompowermc.SimpleChatAlert;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AlertCommand implements CommandExecutor {

	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args.length > 0) {
			String message = ChatColor.translateAlternateColorCodes('&', "&4&lALERT: &c&l" + StringUtils.join(args, " "));
			for (Player player : Bukkit.getOnlinePlayers())
				player.sendMessage(message.replace("{PLAYER}", player.getName()));
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "Add a message! Example: " + ChatColor.ITALIC + "/alert Welcome to the server, {PLAYER}!");
		}
		return true;
	}
}
