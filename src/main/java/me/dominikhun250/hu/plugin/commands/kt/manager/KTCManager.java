package me.dominikhun250.hu.plugin.commands.kt.manager;

import me.dominikhun250.hu.plugin.commands.kt.KTCommand;
import me.dominikhun250.hu.plugin.commands.kt.subcommands.list.*;
import me.dominikhun250.hu.plugin.commands.kt.subcommands.inter.SubCommand;
import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.economy.EconomyManager;
import me.dominikhun250.hu.plugin.economy.KillCoinsEco;
import me.dominikhun250.hu.plugin.gui.GUIManager;

import java.util.HashMap;
import java.util.Map;

public class KTCManager {

    private final Map<String, SubCommand> subCommands = new HashMap<>();

    public KTCManager(KT plugin, GUIManager guiManager, EconomyManager eco) {
        registerSubCommand(new ReloadCommand(plugin, guiManager));
        registerSubCommand(new SetCommand(plugin));
        registerSubCommand(new TestCommand(plugin));
        registerSubCommand(new KillCoinsCommand(plugin, eco));
        registerSubCommand(new SecureSuggestionCommand(plugin));
        registerSubCommand(new SecureReviewCommand(plugin));
    }

    private void registerSubCommand(SubCommand command) {
        subCommands.put(command.getName().toLowerCase(), command);
    }

    public SubCommand getSubCommand(String name) {
        return subCommands.get(name.toLowerCase());
    }
}
