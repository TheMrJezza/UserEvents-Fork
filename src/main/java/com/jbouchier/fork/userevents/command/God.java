package com.jbouchier.fork.userevents.command;

import com.jbouchier.fork.userevents.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class God extends BaseCommand {

    public God() {
        super("god");
    }

    @Override
    protected void onExecute(CommandSender cs, Player target) {
        boolean enabled = !target.isInvulnerable();
        target.setInvulnerable(enabled);

        if (cs == target) cs.sendMessage((enabled ? Messages.GOD_ENABLED_SELF : Messages.GOD_DISABLED_SELF).toString());
        else {
            cs.sendMessage(
                    (enabled ? Messages.GOD_ENABLED_TARGET : Messages.GOD_DISABLED_TARGET)
                            .toString().replace("%player%", target.getName())
            );
            target.sendMessage(
                    (enabled ? Messages.TARGET_OF_GOD_ENABLED : Messages.TARGET_OF_GOD_DISABLED)
                            .toString().replace("%player%", cs.getName())
            );
        }
    }
}