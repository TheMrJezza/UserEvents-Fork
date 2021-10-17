package com.jbouchier.fork.userevents.config;

import com.jbouchier.fork.userevents.UserEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class Language extends BaseYaml {
    public static final Language INSTANCE = new Language();

    private Language() {
        super("language.yml", JavaPlugin.getPlugin(UserEvents.class));
    }

    @Override
    protected void onReload() {
        for (Messages msg : Messages.values()) msg.readMessage(this);
    }
}