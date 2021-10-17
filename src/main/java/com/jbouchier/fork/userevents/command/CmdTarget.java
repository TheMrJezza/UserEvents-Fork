package com.jbouchier.fork.userevents.command;

import com.jbouchier.fork.userevents.config.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CmdTarget extends CmdBase {

    CmdTarget(JavaPlugin plugin, String command) {
        super(plugin, command);
    }

    protected final void execute(CommandSender cs, String[] args) {
        final Player target;
        if (!(cs instanceof Player) && args.length < 1) {
            cs.sendMessage(Messages.TARGET_NOT_PROVIDED.toString());
            return;
        }

        if (args.length < 1 || !cs.hasPermission("userevents." + command + ".other")) {
            if (cs instanceof Player) target = (Player) cs;
            else {
                cs.sendMessage(Messages.TARGET_NOT_PROVIDED.toString());
                return;
            }
        } else target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            cs.sendMessage(Messages.INVALID_PLAYER.toString().replace("%input%", args[0]));
            return;
        }
        onExecute(cs, target);
    }

    protected abstract void onExecute(CommandSender cs, Player target);
}