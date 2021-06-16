package io.github.survivalPlugin.main;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Start {
	// map boundaries for survival
	static int x1 = 0;
	static int x2 = 0;
	static int z1 = 0;
	static int z2 = 0;
	static int y = 0;
	static boolean started = false;
	public static ArrayList<Player> alive = new ArrayList<Player>();
	
	public static void start() {
		alive.clear();
		started = true;
		teleport();
		Border border = new Border(100, 800, 2);
		Border.shrinkBorder(border);
		ChestLoot.add();
		for (Player p : Bukkit.getOnlinePlayers()) {
			alive.add(p);
		}
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 10);		
			GameScoreboard.updateScoreboard(p);
		}
	}
	
	// Spawns players in start location like the movie hunger games where the contestants spawn in pods.
	public static void teleport() {
		//Teleports players to set locations
		ArrayList<Location> locations = new ArrayList<Location>();
		World world = Bukkit.getWorld("world");
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
	
	//countdown to start game
	public static void countdown() throws InterruptedException {
		//5 second countdown until tnt
		Bukkit.broadcastMessage(ChatColor.GREEN + "Starting in 5...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage(ChatColor.GREEN + "4...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage(ChatColor.GREEN + "3...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage(ChatColor.GREEN + "2...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage(ChatColor.GREEN + "1...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage(ChatColor.GREEN + "Start!");
		start();
	}
	
	public static void checkForWin() throws InterruptedException {
    	if (alive.size() == 1) {
	    	// Prints name of last player alive
    		for (Player p : Bukkit.getOnlinePlayers()) {
    			p.sendTitle(ChatColor.YELLOW + Start.alive.get(0).getName(), ChatColor.YELLOW + "won the game", 20, 50, 20);
    			p.sendMessage(ChatColor.AQUA + Start.alive.get(0).getName() + " won the game!");
    			p.setGameMode(GameMode.ADVENTURE);
    			p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 10, 1);
    		}
	    	Start.started = false;
			TimeUnit.SECONDS.sleep(1);
			Border.borderReset();
	    	Reset.returnTp();
		}
    }
}