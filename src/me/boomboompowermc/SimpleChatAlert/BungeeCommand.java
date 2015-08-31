package me.boomboompowermc.SimpleChatAlert;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BungeeCommand extends Command {

	public BungeeCommand(String label) {
		super(label);
		BungeeAlert.instance.getProxy().getPluginManager().registerCommand(BungeeAlert.instance, this);
	}

	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("sca.alert")) {
			if (args.length > 0) {
				String message = ChatColor.translateAlternateColorCodes('&', "&4&lALERT: &c&l" + join(args, " "));
				for (ProxiedPlayer player : BungeeAlert.instance.getProxy().getPlayers())
					player.sendMessage(new TextComponent(message.replace("{PLAYER}", player.getName()).replace("{SERVER}", player.getServer().getInfo().getName())));
			} else {
				sender.sendMessage(new TextComponent(ChatColor.RED + "" + ChatColor.BOLD + "Please add a message to alert on the sever!"));
				sender.sendMessage(new TextComponent(ChatColor.RED + "" + ChatColor.BOLD + "Example: " + ChatColor.GRAY + ChatColor.ITALIC + "/alert &c&lWelcome &cto the &o{SERVER} &cserver, &o{PLAYER}&c!"));
			}
		} else {
			sender.sendMessage(new TextComponent(ChatColor.RED + "You do not have permission to execute this command!"));
		}
	}

	private String join (String[] array, String seperator) {
		if (array.length == 0) return "";
		String string = "";
		for (String word : array) string += seperator + word;
		return string.substring(seperator.length());
	}

}
