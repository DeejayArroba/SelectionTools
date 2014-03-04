package me.deejayarroba.selectiontools.selection;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Selection {

	private Location pos1;
	private Location pos2;
	private World world;
	private List<Block> blocks = new ArrayList<Block>();

	public Selection(Location pos1, Location pos2) {

		if(pos1.getWorld().equals(pos2.getWorld())) {
			this.world = pos1.getWorld();
			this.pos1 = pos1;
			this.pos2 = pos2;

			int x1 = pos1.getBlockX();
			int y1 = pos1.getBlockY();
			int z1 = pos1.getBlockZ();

			int x2 = pos2.getBlockX();
			int y2 = pos2.getBlockY();
			int z2 = pos2.getBlockZ();

			int diffX = x1 - x2;
			int diffY = y1 - y2;
			int diffZ = z1 - z2;

			int incrementX = diffX >=0 ? 1 : -1;
			int incrementY = diffY >=0 ? 1 : -1;
			int incrementZ = diffZ >=0 ? 1 : -1;

			for(int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
				for(int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
					for(int z = Math.min(z1, z2); z <= Math.max(z1, z2); z++) {
						blocks.add(world.getBlockAt(x, y, z));
					}
				}
			}
		}


	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public void setCuboidBlocks(Material material) {
		for(Block block : getBlocks()) {
			block.setType(material);
		}
	}

}
