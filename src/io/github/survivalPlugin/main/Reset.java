package io.github.survivalPlugin.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Reset {
	
	public static void returnTp() {
		//returns players back to glass platform
		ArrayList<Location> locations = new ArrayList<Location>();
		World world = Bukkit.getWorld("world");
		Location l = new Location(world,10,100,10);
		locations.add(l);
		Location l2 = new Location(world,15,100,10);
		locations.add(l2);
		Location l3 = new Location(world,20,100,10);
		locations.add(l3);
		Location l4 = new Location(world,25,100,10);
		locations.add(l4);
		Location l5 = new Location(world,30,100,10);
		locations.add(l5);
		int i = 0;
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.teleport(locations.get(i));
			p.setHealth(20);
			i++;
		}
	}
	
}