package com.jbouchier.fork.userevents.compatibilty;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.UUID;

public class Legacy implements UtilPlayer, Listener {

    private final HashSet<UUID> god = new HashSet<>();

    public Legacy(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    private void onPlayerDamage(EntityDamageEvent evt) {
        evt.setCancelled(god.contains(evt.getEntity().getUniqueId()));
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    private void onTarget(EntityTargetLivingEntityEvent evt) {
        if (evt.getTarget() != null && evt.getEntity() instanceof Monster)
            evt.setCancelled(god.contains(evt.getTarget().getUniqueId()));
    }

    @Override
    public void setInvulnerable(Player player, boolean value) {
        if (value) {
            god.add(player.getUniqueId());
        } else god.remove(player.getUniqueId());
    }

    @Override
    public boolean isInvulnerable(HumanEntity player) {
        return god.contains(player.getUniqueId());
    }

    @Override
    public double getMaxHealth(Player player) {
        return player.getMaxHealth();
    }
}