package me.boomboompowermc.SimpleChatAlert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import com.google.common.io.ByteStreams;

public class BungeeAlert extends Plugin {

	public UpdateChecker updateChecker;
	public static BungeeAlert instance;

	public void onEnable() {
		saveDefaultConfig();
		instance = this;
		String version = "4.3";

		log("&e--------------------------------------------");
		log("&bThe &cSimpleChatAlert &bPlugin has been enabled!");
		log("&bAny bugs? Report them! - &9boomboompower [Dev]");
		log("&e--------------------------------------------");
		log("&aYou Are Using Build Version: &b" + version);

		new BungeeCommand("balert");
		new BungeeCommand("simplechatalert");
		new BungeeCommand("scalert");
		new BungeeCommand("sca");

		File config = new File(getDataFolder(), "config.yml");
		Configuration configuration;
		try {
			configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(config);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		if (configuration.getBoolean("AutoUpdater")) {
			updateChecker = new UpdateChecker(version);
			if (updateChecker.updateNeeded()); {
				log("A new version of SimpleChatAlert is available: " + updateChecker.getLastestVersion());
				log("You can get it from: " + updateChecker.getLink());
			}
		}
	}

	private void saveDefaultConfig() {
		if (!getDataFolder().exists())
			getDataFolder().mkdir();

		File config = new File(getDataFolder(), "config.yml");
		if (!config.exists()) {
			try {
				config.createNewFile();
				InputStream is = getResourceAsStream("config.yml");
				OutputStream os = new FileOutputStream(config);
				ByteStreams.copy(is, os);
			} catch (IOException e) {
				throw new RuntimeException("Unable to create configuration file", e);
			}
		}
	}

	public void onDisable() {
		log("&e--------------------------------------------");
		log("&bThe &cSimpleChatAlert &bPlugin has been disabled!");
		log("&bAny bugs? Report them! - &9boomboompower [Dev]");
		log("&e--------------------------------------------");
	}

	public void log(String message) {
		getLogger().info(ChatColor.translateAlternateColorCodes('&', message));
	}

}
