package com.jbouchier.fork.userevents.compatibilty;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public interface UtilPlayer {
    void setInvulnerable(Player player, boolean value);

    boolean isInvulnerable(HumanEntity player);

    double getMaxHealth(Player player);
}
