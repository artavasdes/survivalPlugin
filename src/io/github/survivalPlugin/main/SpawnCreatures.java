package io.github.minigameplugin.main;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

public class SpawnCreatures {

	public void spawnCreatures() {
		World world = null; // TODO
		// fix coords
		Entity en = world.spawnEntity(new Location(world, 0.5, 65, 0.5, 0, 0), EntityType.VILLAGER);
	    Villager v = (Villager) en;
	    v.setSilent(true);
	    v.setAI(false);
	    v.setInvulnerable(true);
	    v.setCollidable(false);
	    v.setCustomName(ChatColor.translateAlternateColorCodes('&', "&A&LTNT RUN"));
	    v.setCustomNameVisible(true);
	    v.setRemoveWhenFarAway(false);
	}
}
