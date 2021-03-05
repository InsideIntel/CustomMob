package me.insideintel.commands;

import me.insideintel.mobs.TestMob;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class TestCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;

        Player player = (Player) commandSender;

        if (command.getName().equalsIgnoreCase("test")) {
            Location loc = player.getLocation();
            TestMob villager = new TestMob(((CraftWorld)player.getWorld()).getHandle());

            villager.setPositionRotation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
            ((CraftWorld)loc.getWorld()).getHandle().addEntity(villager, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }


        return false;
    }
}
