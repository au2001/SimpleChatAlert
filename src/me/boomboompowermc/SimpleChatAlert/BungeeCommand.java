package me.boomboompowermc.SimpleChatAlert;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import org.apache.commons.lang.StringUtils;

public class BungeeCommand extends Command {

	public BungeeCommand(String label) {
		super(label);
	}

	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("sca.alert")) {
			if (args.length > 0) {
				String message = ChatColor.RED + "" + ChatColor.BOLD + StringUtils.join(args, " ");
				BungeeAlert.instance.getProxy().broadcast(new TextComponent(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ALERT: " + message));
			} else {
				sender.sendMessage(new TextComponent(ChatColor.DARK_RED + "Add a message! Example: " + ChatColor.ITALIC + "/alert Welcome to the server!"));
			}
		} else {
			sender.sendMessage(new TextComponent(ChatColor.DARK_RED + "You do not have access to this command!"));
		}
	}

}
