package net.txsla.creativecontainers;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Container;
import org.bukkit.block.ShulkerBox;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class events implements Listener {

    @EventHandler
    public static void onInteract(BlockPlaceEvent e) {
        Player p = e.getPlayer();

        // get data of placed container
        Block block = e.getBlock();
        Material type = block.getType();
        String name = block.getType().name();
        Container container;

        // Check if item is a storage block
        try { container = (Container) block.getState(); } catch(Exception ex) {return;}

        // Create inventory for placed container
        String title = container.getCustomName();
        if (title == null) title = name.toLowerCase();
        Inventory i = Bukkit.createInventory(p, 27, title);

        // Load items into inventory
        ItemStack[] items = container.getInventory().getContents();
        if (items == null) return;
        for (ItemStack item : items) {
            if (item != null) {
                i.setItem(i.firstEmpty(), item);
            }
        }

        // Open Inventory
        e.setCancelled(true);
        p.openInventory(i);

    }

}
