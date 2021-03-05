package me.insideintel;

import me.insideintel.commands.TestCMD;
import me.insideintel.events.BlockPlace;
import me.insideintel.events.EntityDamage;
import me.insideintel.events.EntityDeath;
import me.insideintel.utls.CustomEntities;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class CustomMobs extends JavaPlugin {
    public List<ItemStack> stolenItems = new ArrayList<>();

    @Override
    public void onEnable() {
        CustomEntities.registerEntities();
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new EntityDamage(), this);
        pm.registerEvents(new EntityDeath(this), this);
        pm.registerEvents(new BlockPlace(this), this);
        getCommand("test").setExecutor(new TestCMD());
    }
    @Override
    public void onDisable() {
        CustomEntities.unregisterEntities();

    }

}
