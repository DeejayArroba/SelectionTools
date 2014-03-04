package me.deejayarroba.selectiontools.selection;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WandEvents implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getPlayer().getItemInHand().getType() == Material.FEATHER) {
			if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
				PlayerSelections.pos1.put(e.getPlayer().getName(), e.getClickedBlock().getLocation());
				e.getPlayer().sendMessage("Position 1 set!");
				e.setCancelled(true);
			} else if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				PlayerSelections.pos2.put(e.getPlayer().getName(), e.getClickedBlock().getLocation());
				e.getPlayer().sendMessage("Position 2 set!");
				e.setCancelled(true);
			}
		}
	}

}
