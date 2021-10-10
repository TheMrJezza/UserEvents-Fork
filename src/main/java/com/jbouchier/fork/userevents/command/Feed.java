package com.jbouchier.fork.userevents.command;

import com.jbouchier.fork.userevents.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Feed extends BaseCommand {

    public Feed() {
        super("feed");
    }

    @Override
    protected void onExecute(CommandSender cs, Player target) {
        target.setFoodLevel(20);
        if (cs == target) cs.sendMessage(Messages.FEED_SELF.toString());
        else {
            cs.sendMessage(Messages.FEED_TARGET.toString().replace("%player%", target.getName()));
            target.sendMessage(Messages.TARGET_OF_FEED.toString().replace("%player%", cs.getName()));
        }
    }
}