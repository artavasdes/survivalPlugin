package io.github.minigameplugin.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Win {

    public static void checkForWin() {
    	if (Start.alive.size() == 1) {
	    	//Prints name of last player alive
    		for (Player p : Bukkit.getOnlinePlayers()) {
		    	Reset.returnTp(p);
		    	Reset.original(p);
    		}
		}
    }
}