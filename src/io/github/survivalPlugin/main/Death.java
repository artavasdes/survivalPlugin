package io.github.survivalPlugin.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import test.GameScoreboard;
import test.Start;

public class Death implements Listener {
	// list of alive players
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) throws InterruptedException {
		if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (Start.alive.contains(p)) {
	            if (e.getDamage() >= p.getHealth()) {
	            	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_DEATH, 10, 1);
	            	Start.alive.remove(p);
	            	p.setGameMode(GameMode.SPECTATOR);
	            	for (Player player : Bukkit.getOnlinePlayers()) {
	        			GameScoreboard.updateScoreboard(player);
	            		player.sendMessage(ChatColor.YELLOW + p.getName() + ChatColor.RED + " died because of " 
	            				+ ChatColor.GOLD + e.getCause().toString());
	            	}
	            	p.teleport(new Location(p.getWorld(), 10, 50, 10));
	            	Start.checkForWin();
	            }
            }
        }
	}
	
	@EventHandler
	public void onLeaveEvent(PlayerQuitEvent e) throws InterruptedException {
		Player p = e.getPlayer();
		Start.alive.remove(p);
		Start.checkForWin();	
		for (Player player : Bukkit.getOnlinePlayers())
			GameScoreboard.updateScoreboard(player);
	}
}
