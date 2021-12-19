package si.f5.hatosaba.whitelist;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import static org.bukkit.ChatColor.YELLOW;
import static org.bukkit.ChatColor.RED;
import static org.bukkit.ChatColor.RESET;

public class WhitelistListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onLogin(PlayerLoginEvent e) {
        Player player = e.getPlayer();
        boolean isWhitelist = Whitelist.plugin().isWhitelist();

        if (isWhitelist) {
            if (player.hasPermission("perm.whitelist")) return;
            e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "ホワイトリストに登録されていません");
        }

        if(!player.hasPermission("hatosaba.admin")) return;

        if (isWhitelist) {
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
