package si.f5.hatosaba.whitelist.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Player player = e.getPlayer();

        if (Bukkit.isWhitelistEnforced()) {
            if (player.hasPermission("perm.whitelist")) {
                //ホワリスに追加
                player.setWhitelisted(true);
                return;
            } else {
                //権限がない場合ホワリスから削除
                if (Bukkit.getWhitelistedPlayers().contains(player)) {
                    player.setWhitelisted(false);
                }
            }
            //キック
            e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "ホワイトリストに登録されていません");
        }
    }
}
