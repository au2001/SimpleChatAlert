package me.boomboompowermc.SimpleChatAlert;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Alert extends JavaPlugin {

	public UpdateChecker updateChecker;
	public static Alert instance;

	public void onEnable() {
		instance = this;
		saveDefaultConfig();

		String version = getDescription().getVersion();
		
		log("&e--------------------------------------------");
		log("&bThe &cSimpleChatAlert &bPlugin has been enabled!");
		log("&bAny bugs? Report them! - &9boomboompower [Dev]");
		log("&e--------------------------------------------");
		log("&aYou Are Using Build Version: &b" + version);

		getCommand("alert").setExecutor(new AlertCommand());
		if (getConfig().getBoolean("AutoUpdater")) {
			updateChecker = new UpdateChecker(version);
			if (updateChecker.updateNeeded()); {
				log("A new version of SimpleChatAlert is available: " + updateChecker.getLastestVersion());
				log("You can get it from: " + updateChecker.getLink());
			}
		}
		
		try {
	        MetricsLite metrics = new MetricsLite(this);
	        metrics.start();
	    } catch (IOException e) {
	    	log("&c&lFailed to submit statistics to mcstats.org:");
	        e.printStackTrace();
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
