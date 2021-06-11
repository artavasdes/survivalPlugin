package io.github.survivalPlugin.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Win {
//test
    public static void checkForWin() {
    	if (Start.alive.size() == 1) {
	    	//Prints name of last player alive
    		for (Player p : Bukkit.getOnlinePlayers()) {
    			p.setGameMode("adventure");
		    	Reset.returnTp(p);
		    	Reset.original(p);
    		}
		}
    }
}