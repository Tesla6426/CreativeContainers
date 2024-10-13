package net.txsla.creativecontainers;

import org.bukkit.plugin.java.JavaPlugin;

public final class CreativeContainers extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // Versions:
        // 1.21-R0.1-SNAPSHOT
        // 1.20.4-R0.1-SNAPSHOT
        getServer().getPluginManager().registerEvents(new events(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
