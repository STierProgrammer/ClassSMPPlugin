package me.stierprogrammer.classSMPPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] strings
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");

            return true;
        }

        if (player.getLastDeathLocation() == null) {
            player.sendMessage(ChatColor.RED + "The last death location couldn't be found!");
        }
        else {
            player.teleport(player.getLastDeathLocation());
        }

        return true;
    }

}
