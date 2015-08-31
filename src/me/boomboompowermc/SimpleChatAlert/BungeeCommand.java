package me.boomboompowermc.SimpleChatAlert;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import org.apache.commons.lang.StringUtils;

public class BungeeCommand extends Command {

	public BungeeCommand(String label) {
		super(label);
	}

	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("sca.alert")) {
			if (args.length > 0) {
				String message = ChatColor.translateAlternateColorCodes('&', "&4&lALERT: &c&l" + StringUtils.join(args, " "));
				for (ProxiedPlayer player : BungeeAlert.instance.getProxy().getPlayers())
					player.sendMessage(new TextComponent(message.replace("{PLAYER}", player.getName())));
			} else {
				sender.sendMessage(new TextComponent(ChatColor.DARK_RED + "Add a message! Example: " + ChatColor.ITALIC + "/alert Welcome to the server, {PLAYER}!"));
			}
		} else {
			sender.sendMessage(new TextComponent(ChatColor.DARK_RED + "You do not have access to this command!"));
		}
	}

}
