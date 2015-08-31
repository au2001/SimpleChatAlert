
package me.boomboompowermc;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.boomboompowermc.Alert;
import me.boomboompowermc.UpdateChecker;
import me.boomboompowermc.AlertCommand;
import me.boomboompowermc.SCAalert;

public class Alert extends JavaPlugin implements Listener {

	protected Logger log;
	protected UpdateChecker updateChecker;
	public boolean AutoUpdater  = false;
		
	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		ConsoleCommandSender Onlogger = Bukkit.getConsoleSender();
		Onlogger.sendMessage("§e--------------------------------------------");
		Onlogger.sendMessage("§bThe §cSimpleChatAlert §bPlugin has been enabled!");
		Onlogger.sendMessage("§bAny bugs, report them! - §9boomboompower [Dev]");
		Onlogger.sendMessage("§e--------------------------------------------");
		Onlogger.sendMessage("§aYou Are Using Build Version: §b" + pdfFile.getVersion());
		getCommand("alert").setExecutor(new AlertCommand());
		getCommand("simplechatalert:alert").setExecutor(new SCAalert());
		this.saveDefaultConfig();
		this.AutoUpdater = this.getConfig().getBoolean("AutoUpdater");
		if (this.AutoUpdater == true) {
			this.log = this.getLogger();
			this.updateChecker = new UpdateChecker(this, "http://dev.bukkit.org/bukkit-plugins/Simple-Chat-Alert/files.rss");
			if (this.updateChecker.updateNeeded()); {
				this.log.info("A new version of SimpleChatAlert is availible: " + this.updateChecker.getVersion());
				this.log.info("You can get it from: " + this.updateChecker.getLink());
			}
		this.reloadConfig();
		}
	}
	
	@Override
	public void onDisable() {
		ConsoleCommandSender Offlogger = Bukkit.getConsoleSender();
		Offlogger.sendMessage("§e--------------------------------------------");
		Offlogger.sendMessage("§bThe §cSimpleChatAlert §bPlugin has been disabled!");
		Offlogger.sendMessage("§bAny bugs, report them! - §9boomboompower [Dev]");
		Offlogger.sendMessage("§e--------------------------------------------");
		this.saveConfig();
		
	}
	
}
