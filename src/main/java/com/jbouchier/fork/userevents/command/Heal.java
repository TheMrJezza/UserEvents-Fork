package com.jbouchier.fork.userevents.command;

import com.jbouchier.fork.userevents.compatibilty.UtilPlayer;
import com.jbouchier.fork.userevents.config.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Heal extends CmdTarget {

    private final UtilPlayer compatibility;

    public Heal(JavaPlugin plugin, UtilPlayer compatibility) {
        super(plugin, "heal");
        this.compatibility = compatibility;
    }

    @Override
    protected void onExecute(CommandSender cs, Player target) {
        target.setHealth(compatibility.getMaxHealth(target));
        target.setFoodLevel(20);
        if (cs == target) cs.sendMessage(Messages.HEAL_SELF.toString());
        else {
            cs.sendMessage(Messages.HEAL_TARGET.toString().replace("%player%", target.getName()));
            target.sendMessage(Messages.TARGET_OF_HEAL.toString().replace("%player%", cs.getName()));
        }
    }
}