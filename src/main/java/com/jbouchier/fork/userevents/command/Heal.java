package com.jbouchier.fork.userevents.command;

import com.jbouchier.fork.userevents.Messages;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Heal extends BaseCommand {

    public Heal() {
        super("heal");
    }

    @Override
    protected void onExecute(CommandSender cs, Player target) {
        AttributeInstance max = target.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        target.setHealth(max == null ? 20 : max.getDefaultValue());
        target.setFoodLevel(20);
        if (cs == target) cs.sendMessage(Messages.HEAL_SELF.toString());
        else {
            cs.sendMessage(Messages.HEAL_TARGET.toString().replace("%player%", target.getName()));
            target.sendMessage(Messages.TARGET_OF_HEAL.toString().replace("%player%", cs.getName()));
        }
    }
}