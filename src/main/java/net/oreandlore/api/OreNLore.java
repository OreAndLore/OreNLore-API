package net.oreandlore.api;

import net.oreandlore.api.utils.PluginVersion;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class OreNLore extends JavaPlugin {

    private final File langFile = new File(this.getDataFolder(), "lang.yml");
    private FileConfiguration lang = YamlConfiguration.loadConfiguration(this.langFile);
    private static OreNLore instance;

    @Override
    public void onEnable() {
        if (!langFile.exists()) saveResource("lang.yml", false);


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

    public File getLangFile() {
        return langFile;
    }
    public FileConfiguration getLang() {
        return lang;
    }
}
