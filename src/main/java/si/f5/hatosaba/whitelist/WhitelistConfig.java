package si.f5.hatosaba.whitelist;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class WhitelistConfig {

    private final Whitelist plugin = Whitelist.plugin();
    private FileConfiguration config;
    private final File file;
    private final String name;

    private boolean isWhitelist;

    public WhitelistConfig(String name){
        this.name = name;
        this.file = new File(plugin.getDataFolder(), name);
        saveDefault();
        load();
    }

    public void saveDefault(){
        if(!file.exists()) plugin.saveResource(name, false);
    }

    public FileConfiguration config(){
        if(config == null) reload();
        return config;
    }

    public void save(){
        if(config == null) return;

        try{
            config().save(file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void reload(){
        config = YamlConfiguration.loadConfiguration(file);
        InputStream stream = plugin.getResource(name);
        if(stream == null) return;
        config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(stream, StandardCharsets.UTF_8)));
    }

    public void update(){
        save();
        reload();
    }

    public void load() {
        FileConfiguration config = config();

        boolean isWhitelist = config.getBoolean("whitelist");
        this.isWhitelist = isWhitelist;
    }

    public void saveAll() {
        FileConfiguration config = config();

        config.set("whitelist", Whitelist.plugin().isWhitelist());

        update();
    }

    public boolean isWhitelist() {
        return isWhitelist;
    }

}
