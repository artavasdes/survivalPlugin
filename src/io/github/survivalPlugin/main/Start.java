package io.github.minigameplugin.main;
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
		Location l = new Location(world,10,70,10);
		locations.add(l);
		Location l2 = new Location(world,15,70,10);
		locations.add(l2);
		Location l3 = new Location(world,20,70,10);
		locations.add(l3);
		Location l4 = new Location(world,25,70,10);
		locations.add(l4);
		Location l5 = new Location(world,30,70,10);
		locations.add(l5);
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
	
	public static void tntDrop() {
		World world = Bukkit.getWorld("world");
		for (int i = x1; i <= x2; i++) {
			for (int j = z1; j <= z2; j++) {
				Location loc = new Location(world, i, y, j);
				FallingBlock tnt = (FallingBlock) world.spawnFallingBlock(loc, Material.TNT.createBlockData());
			}
		}
	}
}

