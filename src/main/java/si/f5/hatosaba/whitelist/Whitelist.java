package si.f5.hatosaba.whitelist;

import com.github.elic0de.spigotcommandlib.registry.CommandLib;
import org.bukkit.plugin.java.JavaPlugin;

public final class Whitelist extends JavaPlugin {

    private static Whitelist plugin;
    private CommandLib commandLib;
    private WhitelistConfig config;

    private boolean isWhitelist = false;

    public static Whitelist plugin(){
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        commandLib = new CommandLib(this);
        commandLib.registerCommandHandler(new WhitelistCommand());
        config = new WhitelistConfig("config.yml");
        isWhitelist = config.isWhitelist();
        getServer().getPluginManager().registerEvents(new WhitelistListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        config.saveAll();
    }

    public WhitelistConfig config(){
        return config;
    }

    public boolean isWhitelist() {
        return isWhitelist;
    }

    public void toggleWhitelist() {

    }
}
