package io.github.survivalPlugin.main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

//Creates a moving border with a runnable
public class Border {
    private int counter=100;

    public Border(int counter) {
        if (counter <= 0) {
            throw new IllegalArgumentException("counter must be greater than 0");
        } else {
            this.counter = counter;
        }
    }

    World world = Bukkit.getWorld("world");
    WorldBorder border = world.getWorldBorder();
    //sets radius of world
    public int radius = 250;
    //units border goes down by
    //public int reducer = 0;
    
    public static void shrinkBorder(Border border) {
    	new BukkitRunnable() {
		    @Override
		    public void run() {    
		        if (counter > 0) {
		        	border.setCenter(0,0);
		        	radius =-2;
		        	border.setSize(radius);
		        	
		        	//reducer=reducer+2;
		        } else {
		            //set world border
		        	border.setSize(50);
		            this.cancel();
		        }
		    }
    	}.runTaskTimer(Main.instance, 0L, 20L);
    }
}