package io.github.minigameplugin.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		//startup
		//reloads
		//plugin reloads
		//register events
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new JoinEvents(), this);
	}
	
	@Override
	public void onDisable() {
		//shutdown
		//reloads
		//plugin reloads
	}
	
	//reset
	

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("reset")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("reset.use")) {
					player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD+"Resetting Minigame!");	
					//reset minigame
					Reset.returnTp();
					return true;
				}
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command, contact a server mod!");
				return true;
			}
			else {
				//reset command for server
				sender.sendMessage("Resetting minigame");
				return true;
			}
		}
		if(label.equalsIgnoreCase("start")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
					player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD+"Starting Game Soon!");
					//start game
					Start.teleport();
					Start.countdown();
					Start.tntDrop();
					//TODO, add method for starting game
					return true;
			}
			else {
				//reset command for server
				sender.sendMessage("Starting Game");
				return true;
			}
		}
		return false;
	}
}
