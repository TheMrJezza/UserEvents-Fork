package com.jbouchier.fork.userevents.command;

import com.jbouchier.fork.userevents.config.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public abstract class CmdBase implements CommandExecutor {

    protected final String command;

    CmdBase(JavaPlugin plugin, String command) {
        this.command = command;
        Objects.requireNonNull(plugin.getCommand(command)).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
        if (cs.hasPermission("userevents." + this.command)) execute(cs, args);
        else cs.sendMessage(Messages.NO_PERMISSION.toString());
        return true;
    }

    protected abstract void execute(CommandSender cs, String[] args);
}