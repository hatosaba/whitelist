package si.f5.hatosaba.whitelist;

import com.github.elic0de.spigotcommandlib.CommandHandle;
import com.github.elic0de.spigotcommandlib.CommandHandler;
import org.bukkit.command.CommandSender;

public class WhitelistCommand implements CommandHandler {

    @CommandHandle(
            command = "toggleWhitelist",
            permission = "perm.whitelist",
            description = "ホワリス"
    )
    public void whitelist(CommandSender sender) {
        Whitelist.plugin().toggleWhitelist();
    }

}
