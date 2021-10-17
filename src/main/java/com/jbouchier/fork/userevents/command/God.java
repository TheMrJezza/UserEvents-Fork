package com.jbouchier.fork.userevents.command;

import com.jbouchier.fork.userevents.compatibilty.UtilPlayer;
import com.jbouchier.fork.userevents.config.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class God extends CmdTarget {

    private final UtilPlayer compatibility;

    public God(JavaPlugin plugin, UtilPlayer compatibility) {
        super(plugin, "god");
        this.compatibility = compatibility;
    }

    @Override
    protected void onExecute(CommandSender cs, Player target) {
        boolean enabled = !compatibility.isInvulnerable(target);
        compatibility.setInvulnerable(target, enabled);

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