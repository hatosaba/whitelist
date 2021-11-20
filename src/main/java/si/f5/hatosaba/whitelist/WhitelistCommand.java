package si.f5.hatosaba.whitelist;

import com.github.elic0de.spigotcommandlib.CommandHandle;
import com.github.elic0de.spigotcommandlib.CommandHandler;
import org.bukkit.command.CommandSender;

public class WhitelistCommand implements CommandHandler {

    @CommandHandle(
            command = "whitelist",
            permission = "perm.whitelist",
            description = "ホワリス"
    )
    public void whitelist(CommandSender sender, boolean bool) {
        if(bool) {
            Whitelist.plugin().isWhitelist() = true;
        }
    }

}