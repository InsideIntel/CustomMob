package me.insideintel.mobs;

import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Location;
import net.minecraft.server.v1_12_R1.World;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;


public class TestMob extends EntityVillager {

    public TestMob(World world) {
        super(world);
        this.setCustomName("Testing");
        this.setCustomNameVisible(true);
        this.setHealth(500);

        this.goalSelector.a(0, new PathfinderGoalAvoidTarget<>(this, EntityPlayer.class, 15, 1.0D, 1.0D));
        this.goalSelector.a(1, new PathfinderGoalPanic(this, 2.0D));
        this.goalSelector.a(2, new PathfinderGoalRandomStrollLand(this, 0.6D));
        this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
    }
    public TestMob(Location loc) {
        super(((CraftWorld)loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setCustomName("Testing");
        this.setCustomNameVisible(true);
        this.setHealth(500);

        this.goalSelector.a(0, new PathfinderGoalAvoidTarget<>(this, EntityPlayer.class, 15, 1.0D, 1.0D));
        this.goalSelector.a(1, new PathfinderGoalPanic(this, 2.0D));
        this.goalSelector.a(2, new PathfinderGoalRandomStrollLand(this, 0.6D));
        this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
    }

}
