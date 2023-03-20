package net.oreandlore.api;

import net.oreandlore.api.utils.PluginVersion;
import org.bukkit.plugin.java.JavaPlugin;

public final class OreNLore extends JavaPlugin {
    private static OreNLore instance;

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public PluginVersion getServerVersion(){
        String serverVersion = getServer().getVersion();
        for(PluginVersion version : PluginVersion.values()){
            if(serverVersion.contains(version.getVersionString())){
                return version;
            }
        }
        return PluginVersion.UNKNOWN_VERSION;
    }

    public static OreNLore getInstance() {
        return instance;
    }
}
