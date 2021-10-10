package com.jbouchier.fork.userevents;

import com.jbouchier.fork.userevents.command.Feed;
import com.jbouchier.fork.userevents.command.Fly;
import com.jbouchier.fork.userevents.command.God;
import com.jbouchier.fork.userevents.command.Heal;
import org.bukkit.plugin.java.JavaPlugin;

public class UserEvents extends JavaPlugin {

    public void onEnable() {
        Language.INSTANCE.reload();
        new Heal();
        new Feed();
        new God();
        new Fly();
    }
}