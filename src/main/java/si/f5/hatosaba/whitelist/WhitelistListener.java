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
        if(player.hasPermission("hatosaba.admin")) {
            if (Whitelist.plugin().isWhitelist()) {
                player.sendMessage("§e----------------------\n" +
                        " ホワイトリストは" + RED + "有効" + RESET + "です" +
                        "----------------------");
            }else {
                player.sendMessage(YELLOW + "----------------------\n" +
                        " ホワイトリストは§c無効§rです\n" +
                        YELLOW +"----------------------");
            }
        }
    }
}
