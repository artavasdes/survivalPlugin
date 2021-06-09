package io.github.minigameplugin.tntrun;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.Listener;
import org.bukkit.util.io.BukkitObjectInputStream;

public class TNTRun implements Listener {
	// map boundaries TODO
	int x1;
	int x2;
	int z1;
	int z2;

	public void spawnTnt() {
		World world = Bukkit.getWorld("world");
		int y = 100; // TODO
		for (int i = x1; i <= x2; i++) {
			for (int j = z1; j <= z2; j++) {
				Location loc = new Location(world, i, y, j);
				FallingBlock tnt = (FallingBlock) world.spawnFallingBlock(loc, Material.TNT.createBlockData());
			}
		}
	}
}
