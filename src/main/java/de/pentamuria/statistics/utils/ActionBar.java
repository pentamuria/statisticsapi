package de.pentamuria.statistics.utils;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;


public class ActionBar {
	
	
	public static void sendActionBar(final Player player, final String message) {
		
		player.spigot().sendMessage(net.md_5.bungee.api.ChatMessageType.ACTION_BAR,new TextComponent(message));
	}
	
	

}
