package com.jbouchier.fork.userevents.compatibilty;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public class Default implements UtilPlayer {

    @Override
    public void setInvulnerable(Player player, boolean value) {
        player.setInvulnerable(value);
    }

    @Override
    public boolean isInvulnerable(HumanEntity player) {
        return player.isInvulnerable();
    }

    @Override
    public double getMaxHealth(Player player) {
        AttributeInstance max = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        return max == null ? 20 : max.getValue();
    }
}