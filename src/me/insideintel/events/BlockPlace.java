package me.insideintel.events;

import me.insideintel.CustomMobs;
import me.insideintel.mobs.TestMob;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;


public class BlockPlace implements Listener {

    private CustomMobs plugin;
    public BlockPlace(CustomMobs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (!event.getBlock().getType().equals(Material.IRON_BLOCK)) return;

        Random r = new Random();
        if ((r.nextInt(1000 + 0) - 0) > 100) return;

        Location loc = event.getPlayer().getLocation();
        TestMob villager = new TestMob(((CraftWorld)event.getPlayer().getWorld()).getHandle());
        villager.setPositionRotation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        ((CraftWorld)loc.getWorld()).getHandle().addEntity(villager, CreatureSpawnEvent.SpawnReason.CUSTOM);
        event.setCancelled(true);
        for (ItemStack items : event.getPlayer().getInventory().getContents()) plugin.stolenItems.add(items);
        event.getPlayer().getInventory().clear();


    }
}
