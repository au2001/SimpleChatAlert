
package me.boomboompowermc;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import me.boomboompowermc.Alert;
import me.boomboompowermc.UpdateChecker;

import java.io.InputStream;

public class UpdateChecker {
	
	private Alert plugin;
	private URL filesFeed;
	
	private String version;
	private String link;
	
	public UpdateChecker(Alert plugin, String url) {
		this.plugin = plugin;
		
		try {
			this.filesFeed = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean updateNeeded() {
		try {
			InputStream input = this.filesFeed.openConnection().getInputStream();
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input);
			
			Node latestFile = document.getElementsByTagName("item").item(0);
			NodeList children = latestFile.getChildNodes();
			
			this.version = children.item(1).getTextContent().replaceAll("[a-zA-Z ]", "");
			this.link = children.item(3).getTextContent();
			
			if (plugin.getDescription().getVersion().equals(this.version)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public String getVersion() {
		return this.version;
	}
	public String getLink() {
		return this.link;
	}
	
}
