package com.jbouchier.fork.userevents.config;

import org.bukkit.ChatColor;

public enum Messages {
    NO_PERMISSION, RELOAD_PLUGIN, INVALID_PLAYER, TARGET_NOT_PROVIDED,
    FLY_ENABLED_SELF, FLY_ENABLED_TARGET, TARGET_OF_FLY_ENABLED,
    FLY_DISABLED_SELF, FLY_DISABLED_TARGET, TARGET_OF_FLY_DISABLED,
    FEED_SELF, FEED_TARGET, TARGET_OF_FEED,
    HEAL_SELF, HEAL_TARGET, TARGET_OF_HEAL,
    GOD_ENABLED_SELF, GOD_ENABLED_TARGET, TARGET_OF_GOD_ENABLED,
    GOD_DISABLED_SELF, GOD_DISABLED_TARGET, TARGET_OF_GOD_DISABLED;

    private final String key;
    private String message;

    Messages() {
        key = name().toLowerCase().replace('_', '-');
        message = String.format("error-invalid-message:[%s]", key);
    }

    @Override
    public String toString() {
        return message;
    }

    void readMessage(Language language) {
        message = ChatColor.translateAlternateColorCodes('&',
                language.getYamlConfig().getString(key, message)
        );
    }
}

