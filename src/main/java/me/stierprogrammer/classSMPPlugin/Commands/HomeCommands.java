package me.stierprogrammer.classSMPPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class HomeCommands implements CommandExecutor {
    HashMap<UUID, HashMap<String, Location>> homesMap = new HashMap<>();

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command.");

            return true;
        }

        if (command.getName().equalsIgnoreCase("sethome")) {
            if (args.length < 1) {
                player.sendMessage(ChatColor.RED + "Usage: /sethome <name>");

                return true;
            }

            String homeName = args[0].toLowerCase();

            homesMap.putIfAbsent(player.getUniqueId(), new HashMap<>());
            homesMap.get(player.getUniqueId()).put(homeName, player.getLocation());

            player.sendMessage(
                    ChatColor.GREEN + "" +
                       ChatColor.BOLD + "Home " +
                       ChatColor.AQUA +
                       ChatColor.BOLD + homeName +
                       ChatColor.GREEN +
                       ChatColor.BOLD + " has been set!"
            );

            return true;
        }
        else if (command.getName().equalsIgnoreCase("home")) {
            if (args.length < 1) {
                player.sendMessage(ChatColor.RED + "Usage: /home <name>");

                return true;
            }

            String homeName = args[0].toLowerCase();

            HashMap<String, Location> homes = homesMap.get(player.getUniqueId());

            if (homes != null && homes.containsKey(homeName)) {
                player.teleport(homes.get(homeName));
                player.sendMessage(ChatColor.GREEN + "Teleported to: " + ChatColor.BOLD + homeName + " home!");
            }
            else {
                player.sendMessage(ChatColor.RED + "Home " + ChatColor.BOLD + homeName + " does not exist!");
            }

            return true;
        }
        else if (command.getName().equalsIgnoreCase("homes")) {
            HashMap<String, Location> homes = homesMap.get(player.getUniqueId());

            if (homes != null && !homes.isEmpty()) {
                player.sendMessage(ChatColor.GREEN + "Homes: " + String.join(", ", homes.keySet()));
            }
            else {
                player.sendMessage(ChatColor.RED + "You have no homes set!");
            }

            return true;
        }

        return true;
    }
}
