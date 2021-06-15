package io.github.survivalPlugin.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class GameScoreboard {
	private static HashMap<Player, Scoreboard> scoreboardHashMap = new HashMap<Player, Scoreboard>();

	public static void updateScoreboard (Player p) {
		ScoreboardManager m = Bukkit.getScoreboardManager();
		Scoreboard b = m.getNewScoreboard();
		
		@SuppressWarnings("deprecation")
		Objective o = b.registerNewObjective("dummy", "");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.RED + "      &LHUNGER GAMES     "));
		scoreboardHashMap.put(p, b);  
		
		int i = 13;
		
		if (Start.started) {
			Score s = o.getScore(ChatColor.translateAlternateColorCodes('&', ChatColor.GREEN + "&LAlive"));
			s.setScore(--i);
			
			for (Player player : Start.alive) {
				Score s1 = o.getScore(player.getName());
				s1.setScore(--i);
			}
			
			Score s2 = o.getScore("  ");
			s2.setScore(--i);
		}
		else {
			Score s = o.getScore(ChatColor.translateAlternateColorCodes('&', ChatColor.AQUA + "&LWaiting"));
			s.setScore(--i);
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				Score s1 = o.getScore(player.getName());
				s1.setScore(--i);
			}
			
			Score s2 = o.getScore("  ");
			s2.setScore(--i);
		}
		
		p.setScoreboard(scoreboardHashMap.get(p));
		}
}
