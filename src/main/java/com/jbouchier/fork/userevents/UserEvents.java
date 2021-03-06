package com.jbouchier.fork.userevents;

import com.jbouchier.fork.userevents.command.*;
import com.jbouchier.fork.userevents.compatibilty.Default;
import com.jbouchier.fork.userevents.compatibilty.Legacy;
import com.jbouchier.fork.userevents.compatibilty.UtilPlayer;
import com.jbouchier.fork.userevents.config.Language;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class UserEvents extends JavaPlugin {

    public void onEnable() {

        boolean useLegacy = true;
        try {
            Class.forName("org.bukkit.attribute.AttributeInstance");
            useLegacy = false;
        } catch (ClassNotFoundException ignored) {
        }

        final UtilPlayer util = useLegacy ? new Legacy(this) : new Default();

        Language.INSTANCE.reload();
        new Heal(this, util);
        new Feed(this);
        new God(this, util);
        new Fly(this);
        new UEReload(this);

        getServer().getPluginManager().registerEvents(new Listener() {
            @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
            private void onPlayerStarve(FoodLevelChangeEvent evt) {
                evt.setCancelled(util.isInvulnerable(evt.getEntity()));
            }
        }, this);
    }
}