package com.jbouchier.fork.userevents.command;

import com.jbouchier.fork.userevents.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Fly extends BaseCommand {

    public Fly() {
        super("fly");
    }

    @Override
    protected void onExecute(CommandSender cs, Player target) {
        boolean enabled = !target.getAllowFlight();
        target.setAllowFlight(enabled);
        if (!enabled) {
            target.setFlying(false);
            target.setFallDistance(-Float.MAX_VALUE);
        }

        if (cs == target) cs.sendMessage((enabled ? Messages.FLY_ENABLED_SELF : Messages.FLY_DISABLED_SELF).toString());
        else {
            cs.sendMessage(
                    (enabled ? Messages.FLY_ENABLED_TARGET : Messages.FLY_DISABLED_TARGET)
                            .toString().replace("%player%", target.getName())
            );
            target.sendMessage(
                    (enabled ? Messages.TARGET_OF_FLY_ENABLED : Messages.TARGET_OF_FLY_DISABLED)
                            .toString().replace("%player%", cs.getName())
            );
        }
    }
}