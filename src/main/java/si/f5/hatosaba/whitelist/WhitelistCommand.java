package si.f5.hatosaba.whitelist;

import com.github.elic0de.spigotcommandlib.CommandHandle;
import com.github.elic0de.spigotcommandlib.CommandHandler;
import org.bukkit.command.CommandSender;

import static org.bukkit.ChatColor.*;
import static org.bukkit.ChatColor.YELLOW;

public class WhitelistCommand implements CommandHandler {

    @CommandHandle(
            command = "toggleWhitelist",
            permission = "perm.toggle-whitelist",
            description = "ホワリス"
    )
    public void whitelist(CommandSender sender) {
        Whitelist.plugin().toggleWhitelist();

        if (Whitelist.plugin().isWhitelist()) {
            sender.sendMessage(YELLOW + "+----------------------+\n" +
                    " ホワイトリストを" + GREEN + "有効" + RESET + "にしました\n" +
                    YELLOW + "+----------------------+");
        }else {
            sender.sendMessage(YELLOW + "+----------------------+\n" +
                    " ホワイトリストを" + RED + "無効" + RESET + "にしました\n" +
                    YELLOW + "+----------------------+");
        }
    }

}