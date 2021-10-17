package com.jbouchier.fork.userevents.command;

import com.jbouchier.fork.userevents.config.Language;
import com.jbouchier.fork.userevents.config.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class UEReload extends CmdBase {

    public UEReload(JavaPlugin plugin) {
        super(plugin, "uereload");
    }

    @Override
    protected void execute(CommandSender cs, String[] args) {
        Language.INSTANCE.reload();
        cs.sendMessage(Messages.RELOAD_PLUGIN.toString());
    }
}