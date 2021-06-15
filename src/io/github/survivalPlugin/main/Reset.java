package io.github.survivalPlugin.main;

//import java.util.ArrayList;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;


public class Reset {
	
	public static void returnTp() {
		//returns players back to glass platform
		World world = Bukkit.getWorld("world");
		Location l = new Location(world,5,124,4);

		for(Player p : Bukkit.getOnlinePlayers()) {
			p.setHealth(20);
			p.teleport(l);
		}
	}
	
}