package me.deejayarroba.selectiontools.selection;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Sphere {

	Location centerLocation;
	List<Block> blocks = new ArrayList<Block>();

	public Sphere(Location centerLocation, int radius) {

		Location centerBlockLocation = centerLocation.getBlock().getLocation();

		this.centerLocation = new Location(centerBlockLocation.getWorld(), centerBlockLocation.getX() + 0.5,
				centerBlockLocation.getY() + 0.5, centerBlockLocation.getZ() + 0.5);
		World world = centerLocation.getWorld();

		Location pos1 = new Location(centerLocation.getWorld(), centerLocation.getX() + radius, centerLocation.getY() + radius, centerLocation.getZ() + radius);
		Location pos2 = new Location(centerLocation.getWorld(), centerLocation.getX() - radius, centerLocation.getY() - radius, centerLocation.getZ() - radius);

		int x1 = pos1.getBlockX();
		int y1 = pos1.getBlockY();
		int z1 = pos1.getBlockZ();

		int x2 = pos2.getBlockX();
		int y2 = pos2.getBlockY();
		int z2 = pos2.getBlockZ();

		for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
			for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
				for (int z = Math.min(z1, z2); z <= Math.max(z1, z2); z++) {
					Block block = world.getBlockAt(x, y, z);
					if (block.getLocation().distance(centerLocation) <= radius) {
						blocks.add(block);
					}
				}
			}
		}
	}

	public void setBlocks(Material material) {
		for (Block block : blocks) {
			block.setType(material);
		}
	}

}
