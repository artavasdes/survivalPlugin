package io.github.minigameplugin.main;

import java.util.ArrayList;

import org.bukkit.event.Listener;

import io.github.minigameplugin.main.Location;
import io.github.minigameplugin.main.Player;
import io.github.minigameplugin.main.Start;

public class Queue implements Listener {
	//If enough players in queue, run start commandsArrayList<Player> list = new ArrayList<Player>();
	//If enough players in queue, run start commands
	
	public void glassCage(Player p) {
		Location loc = new Location(p.getWorld(), x, y, z); // TODO; insert coords to glass cage
		list.add(p);
		p.teleport(loc);
	}
	
	public void checkIfEnoughPlayers() throws InterruptedException {
		if (list.size() >= 3) { // minimum player limit
			Start.countdown();
		}
	}
}
