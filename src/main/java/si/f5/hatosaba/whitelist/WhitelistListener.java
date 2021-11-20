package si.f5.hatosaba.whitelist;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import si.f5.hatosaba.whitelist.Whitelist;

import java.util.stream.Collectors;

public class WhitelistListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onLogin(PlayerLoginEvent e) {
        Player player = e.getPlayer();

        if (Whitelist.plugin().isWhitelist()) {
            if (player.hasPermission("perm.whitelist")) {
                //ホワリスに追加
                player.setWhitelisted(true);
                return;
            } else {
                //権限がない場合ホワリスから削除
                if (Bukkit.getWhitelistedPlayers().stream().map(offlinePlayer -> offlinePlayer.getName()).collect(Collectors.toList()).contains(player.getName())) {
                    player.setWhitelisted(false);
                }
            }
            //キック
            e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "ホワイトリストに登録されていません");
        }
    }
}
