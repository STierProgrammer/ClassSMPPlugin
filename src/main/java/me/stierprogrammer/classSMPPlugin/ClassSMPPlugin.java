package me.stierprogrammer.classSMPPlugin;

import me.stierprogrammer.classSMPPlugin.Commands.BackCommand;
import me.stierprogrammer.classSMPPlugin.Commands.HomeCommands;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ClassSMPPlugin extends JavaPlugin {
    final String[] homeCommandsList = {"home", "sethome", "homes" };

    PluginManager pm = getServer().getPluginManager();
    BackCommand backCommand = new BackCommand();
    HomeCommands homeCommands = new HomeCommands();

    @Override
    public void onEnable() {
        for (final String homeCommand : homeCommandsList) {
            Objects.requireNonNull(getCommand(homeCommand)).setExecutor(homeCommands);
        }

        Objects.requireNonNull(getCommand("back")).setExecutor(backCommand);
    }
}
