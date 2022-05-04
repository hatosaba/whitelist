package si.f5.hatosaba.whitelist;

import com.cryptomorin.xseries.XSound;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.ChatColor.*;

public class WhitelistListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLogin(PlayerLoginEvent e) {
        Player player = e.getPlayer();

        if (Whitelist.plugin().isWhitelist()) {
            if (player.hasPermission("perm.whitelist")) return;
            e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, RED + "ホワイトリストに登録されていません");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        new BukkitRunnable() {
            @Override
            public void run() {
                if(player.hasPermission("perm.whitelist")) {
                    if (Whitelist.plugin().isWhitelist()) {
                        player.sendMessage(
                                YELLOW + "+----------------------+\n" +
                                        RESET + " ホワイトリストは" + GREEN + "有効" + RESET + "です\n" +
                                        YELLOW + "+----------------------+");
                    }else {
                        player.sendMessage(
                                YELLOW + "+----------------------+\n" +
                                        RESET + " ホワイトリストは" + RED + "無効" + RESET + "です\n" +
                                        YELLOW + "+----------------------+");
                    }
                    XSound.ENTITY_PLAYER_LEVELUP.play(player, 1F, 2F);
                }
            }
        }.runTaskLater(Whitelist.plugin(),  5 + 20L);
    }
}