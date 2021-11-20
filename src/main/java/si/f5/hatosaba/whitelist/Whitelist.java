package si.f5.hatosaba.whitelist;

import org.bukkit.plugin.java.JavaPlugin;
import si.f5.hatosaba.whitelist.listeners.LoginListener;

public final class Whitelist extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new LoginListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
