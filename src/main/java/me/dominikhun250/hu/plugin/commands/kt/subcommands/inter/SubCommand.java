package me.dominikhun250.hu.plugin.commands.kt.subcommands.inter;

import org.bukkit.command.CommandSender;

public interface SubCommand {
    String getName();
    String getPermission();
    void execute(CommandSender sender, String[] args);
}