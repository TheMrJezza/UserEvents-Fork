package com.jbouchier.fork.userevents;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public abstract class BaseYaml {
    private final File yamlFile;
    private final Plugin plugin;
    private YamlConfiguration config;

    BaseYaml(String fileName, Plugin plugin) {
        yamlFile = new File((this.plugin = plugin).getDataFolder(), fileName);
        reload();
    }

    public final void reload() {
        if (!yamlFile.exists()) plugin.saveResource(yamlFile.getName(), true);
        config = YamlConfiguration.loadConfiguration(yamlFile);
        onReload();
    }

    protected final YamlConfiguration getYamlConfig() {
        return config;
    }

    protected abstract void onReload();
}