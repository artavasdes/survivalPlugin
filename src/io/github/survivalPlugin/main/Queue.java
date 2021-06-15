package io.github.survivalPlugin.main;

import java.util.ArrayList;
//import org.bukkit.*;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import test.Start;

public class Queue {
	static ArrayList<Player> list = new ArrayList<Player>();
	
	public static void glassCage(Player p) {
		Location loc = new Location(p.getWorld(), 40, 70, 0);
		list.add(p);
		p.teleport(loc);
	}
	
	public void checkIfEnoughPlayers() throws InterruptedException {
		if (list.size() >= 3) { // minimum player limit
			Start.countdown();
		}
		
	}
}
