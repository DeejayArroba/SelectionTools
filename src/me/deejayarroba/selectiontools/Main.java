package me.deejayarroba.selectiontools;

import me.deejayarroba.selectiontools.selection.PlayerSelections;
import me.deejayarroba.selectiontools.selection.Selection;
import me.deejayarroba.selectiontools.selection.Sphere;
import me.deejayarroba.selectiontools.selection.WandEvents;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		getServer().getPluginManager().registerEvents(new WandEvents(), this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("setarea")) {
			if (sender instanceof Player) {
				if (args.length == 1 && Util.isInt(args[0])) {
					Player p = (Player) sender;
					if (PlayerSelections.pos1.get(p.getName()) != null && PlayerSelections.pos2.get(p.getName()) != null) {
						Selection selection = new Selection(PlayerSelections.pos1.get(p.getName()),
								PlayerSelections.pos2.get(p.getName()));
						for (Block block : selection.getBlocks()) {
							block.setType(Material.getMaterial(Integer.parseInt(args[0])));
						}
						Bukkit.broadcastMessage("Cuboid made!");
						return true;
					}
				}
			}
		} else if (label.equalsIgnoreCase("makesphere")) {
			if (sender instanceof Player) {
				if (args.length == 2) {
					Player p = (Player) sender;
					Sphere sphere = new Sphere(p.getLocation(), Integer.parseInt(args[0]));

					sphere.setBlocks(Material.getMaterial(Integer.parseInt(args[1])));

					Bukkit.broadcastMessage("Sphere made!");

					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void onDisable() {

	}

}
