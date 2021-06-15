package io.github.survivalPlugin.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.scheduler.BukkitRunnable;

import test.Border;
import test.Main;
import test.Start;

//Creates a moving border with a runnable
public class Border {

	private static World world = Bukkit.getWorld("world");
	private static WorldBorder b = world.getWorldBorder();
	private static int counter;
	public static int radius; // sets radius of world
	public static int reducer; // units border goes down by

public Border(int counter, int radius, int reducer) {
    if (counter <= 0) {
        throw new IllegalArgumentException("counter must be greater than 0");
    } else {
  	  Border.counter = counter;
        Border.radius = radius;
        Border.reducer = reducer;
    }
}

public static void shrinkBorder(Border border) {
	new BukkitRunnable() {
		    @Override
		    public void run() {    
		        if (counter > 0) { 
		        	radius -= reducer;
		        	b.setSize(radius);
		        	b.setCenter(new Location(Bukkit.getWorld("world"), 0, 0, 0));
		        } 
		        if (!Start.started || counter <= 0){
		            //set world border
		        	b.setSize(50);
		            cancel();
		        }
		    }
	}.runTaskTimer(Main.instance, 0L, 20L);
}

public static void borderReset() {
	  radius = 500;
	  b.setSize(500);
}
}