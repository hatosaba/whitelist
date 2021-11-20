package si.f5.hatosaba.whitelist;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class WhitelistListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onLogin(PlayerLoginEvent e) {
        Player player = e.getPlayer();

        if (Whitelist.plugin().isWhitelist()) {
            if (player.hasPermission("perm.whitelist")) return;

            e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "ホワイトリストに登録されていません");
        }
    }
}
