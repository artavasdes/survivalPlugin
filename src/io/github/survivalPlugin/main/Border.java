package io.github.survivalPlugin.main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

//Creates a moving border with a runnable
public class Border {

	private final JavaPlugin plugin;
    
    private int counter=100;

    public Border(JavaPlugin plugin, int counter) {
        this.plugin = plugin;
        if (counter <= 0) {
            throw new IllegalArgumentException("counter must be greater than 0");
        } else {
            this.counter = counter;
        }
    }

    World world = Bukkit.getWorld("world");
    WorldBorder border = world.getWorldBorder();
    //sets radius of world
    public int radius = 300;
    //units border goes down by
    public int reducer = 0;
    
    public void shrinkBorder() {
    	new BukkitRunnable() {
		    @Override
		    public void run() {    
		        if (counter > 0) { 
		        	border.setSize(radius-reducer);
		        	border.setCenter(0,0);
		        	reducer=reducer+2;
		        } else {
		            //set world border
		        	border.setSize(100);
		            this.cancel();
		        }
		    }
    	}.runTaskTimer(Main.instance, 0L, 20L);
    }
}