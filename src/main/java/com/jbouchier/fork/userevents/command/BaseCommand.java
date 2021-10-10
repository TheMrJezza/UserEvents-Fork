package com.jbouchier.fork.userevents.command;

import com.jbouchier.fork.userevents.Messages;
import com.jbouchier.fork.userevents.UserEvents;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public abstract class BaseCommand implements CommandExecutor {

    protected static final UserEvents PLUGIN = JavaPlugin.getPlugin(UserEvents.class);
    private final String command;

    BaseCommand(String command) {
        this.command = command;
        Objects.requireNonNull(PLUGIN.getCommand(command)).setExecutor(this);
    }

    public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
        if (!cs.hasPermission("userevents." + command)) {
            cs.sendMessage(Messages.NO_PERMISSION.toString());
            return true;
        }
        if (!(cs instanceof Player)) {
            if (args.length < 1) {
                cs.sendMessage(Messages.TARGET_NOT_PROVIDED.toString());
                return true;
            }
        }
        Player target;
        if (args.length < 1 || !cs.hasPermission("userevents." + command + ".other")) {
            if (cs instanceof Player) target = (Player) cs;
            else {
                cs.sendMessage(Messages.TARGET_NOT_PROVIDED.toString());
                return true;
            }
        } else target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            cs.sendMessage(Messages.INVALID_PLAYER.toString().replace("%input%", args[0]));
            return true;
        }

        onExecute(cs, target);
        return true;
    }

    protected abstract void onExecute(CommandSender cs, Player target);
}