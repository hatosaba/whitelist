package si.f5.hatosaba.whitelist;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import static org.bukkit.ChatColor.*;
import static org.bukkit.ChatColor.YELLOW;

public class WhitelistListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onLogin(PlayerLoginEvent e) {
        Player player = e.getPlayer();

        if (Whitelist.plugin().isWhitelist()) {
            if (player.hasPermission("perm.whitelist")) return;
            e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "ホワイトリストに登録されていません");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("perm.whitelist")) {
            if (Whitelist.plugin().isWhitelist()) {
                player.sendMessage(YELLOW + "+----------------------+\n" +
                        " ホワイトリストは" + GREEN + "有効" + RESET + "です\n" +
                        YELLOW + "+----------------------+");
            }else {
                player.sendMessage(YELLOW + "+----------------------+\n" +
                        " ホワイトリストは" + RED + "無効" + RESET + "です\n" +
                        YELLOW + "+----------------------+");
            }
        }
    }
}