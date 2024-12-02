package me.stierprogrammer.classSMPPlugin;

import me.stierprogrammer.classSMPPlugin.Commands.BackCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ClassSMPPlugin extends JavaPlugin {
    PluginManager pm = getServer().getPluginManager();
    BackCommand backCommand = new BackCommand();

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("back")).setExecutor(backCommand);
    }
}
