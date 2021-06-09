package io.github.minigameplugin.main;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvents implements Listener {
	
	@EventHandler
	public void onJoin (PlayerJoinEvent e) {
		Player p = e.getPlayer();
//		Location spawn = new Location();
//		p.teleport(spawn);
		p.sendTitle(ChatColor.AQUA + "insert name", ChatColor.YELLOW + "Welcome!", 20, 50, 20);
		p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(400);
		p.setLevel(0);
		
		World world = p.getWorld();
		
		Location loc = new Location(world,0,70,0);
		p.teleport(loc);
		//p.setGameMode();
		
		//Add win event
		//Loops through until 1 person alive, then stops
		//run returnTP method
	}
	
}
