package io.github.survivalPlugin.main;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.bukkit.entity.Player;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.FallingBlock;


public class Start {
	// map boundaries TODO
	static int x1 = 0;
	static int x2 = 0;
	static int z1 = 0;
	static int z2 = 0;
	static int y = 0;
	
	public static void teleport() {
		//Teleports players to set locations
		ArrayList<Location> locations = new ArrayList<Location>();
		Player player = player.getPlayer();
		World world = player.getWorld();
		Location l = new Location(world,.5,53,-25.5);
		locations.add(l);
		Location l2 = new Location(world,.5,53,26.5);
		locations.add(l2);
		Location l3 = new Location(world,26.5,53,.5);
		locations.add(l3);
		Location l4 = new Location(world,-25.5,53,.5);
		locations.add(l4);
		Location l5 = new Location(world,-7.5,53,18.5);  
		locations.add(l5); 
		Location l6 = new Location(world,18.5,53,-17.5);
		locations.add(l6);
		Location l7 = new Location(world,5.5,53,-25.5);
		locations.add(l7);
		Location l8 = new Location(world,-9.5,53,24.5);
		locations.add(l8);
		Location l9 = new Location(world,10.5,53,24.5);
		locations.add(l9);
		Location l10 = new Location(world,-9.5,53,-23.5);
		locations.add(l10);
		Location l11 = new Location(world,-23.5,53,-9.5);
		locations.add(l11);
		Location l12 = new Location(world,24.5,53,10.5);
		locations.add(l12);
		int i = 0;
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.teleport(locations.get(i));
			i++;
		}
		
	}
	public static void countdown() throws InterruptedException {
		//5 second countdown until tnt
		Bukkit.broadcastMessage("Starting in 5...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage("4...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage("3...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage("2...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage("1...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage("Start!");
	}
			
}


