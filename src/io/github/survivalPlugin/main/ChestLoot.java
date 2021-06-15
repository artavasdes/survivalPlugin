package io.github.survivalPlugin.main;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChestLoot {
	//removes loot from chest
	public static void remove(){
		World world = Bukkit.getWorld("world");
		for (Chunk c : world.getLoadedChunks()) {

            for (BlockState b : c.getTileEntities()) {

                if (b instanceof Chest) {
                    Chest chest = (Chest) b;
                    Inventory inventory = chest.getBlockInventory();
                    inventory.clear();
                    
                }
            }
		}
		
	}
		
	//adds random loot to chest
	public static void add() {
		World world = Bukkit.getWorld("world");
		for (Chunk c : world.getLoadedChunks()) {

            for (BlockState b : c.getTileEntities()) {

                if (b instanceof Chest) {
                    Chest chest = (Chest) b;
                    Inventory inventory = chest.getBlockInventory();
                    Material[] randomItems = {Material.AIR, Material.APPLE, Material.STICK, 
                    		Material.STONE_SWORD, Material.WOODEN_SWORD, Material.STONE_AXE, Material.DIAMOND_PICKAXE, 
                    		Material.ARROW, Material.BOW };
                   

                    for (int i = 0; i < randomItems.length; i++) {
                        Random rand = new Random();
                        //int intRandom1 = rand.nextInt(35) + 9;
                        //int intItens = rand.nextInt(randomItens.length);

                        int max = 9;
                        for (int amount = 0; amount < max; amount++) {
                            inventory.addItem(new ItemStack(randomItems[rand.nextInt(randomItems.length)]));
                        }
                    }
                }
            }
		}
	}
}
