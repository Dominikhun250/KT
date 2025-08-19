package me.dominikhun250.hu.plugin.commands.kt.subcommands.list;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.commands.kt.subcommands.inter.SubCommand;
import me.dominikhun250.hu.plugin.storage.EffectStorage;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand implements SubCommand {

    private final KT plugin;

    public SetCommand(KT plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "set";
    }

    @Override
    public String getPermission() {
        return "kt.set";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("messages.only_players")));
            return;
        }
        Player player = (Player) sender;

        if (args.length < 2) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("messages.miss_usage")));
            return;
        }

        String effect = args[1].toLowerCase();
        if (effect.equalsIgnoreCase("none")) {
            EffectStorage.removeEffect(player);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("messages.effect_removed")));
            return;
        }

        if (!plugin.getGuiManager().getEffects().containsKey(effect)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("messages.effect_not_found")));
            return;
        }


        boolean hasPermission = player.hasPermission("kt." + effect + ".use");
        boolean hasBought = plugin.getEconomyManager().hasBoughtEffect(player, effect);
        boolean ecoEnabled = plugin.getEconomyManager().isEnabled();

        if (!player.isOp() && !hasPermission && (!ecoEnabled || !hasBought)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("messages.no_permissions")));
            return;
        }

        String current = EffectStorage.getEffect(player);
        if (effect.equalsIgnoreCase(current)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("messages.effect_already_set")));
            return;
        }

        EffectStorage.setEffect(player, effect);
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        plugin.getConfig().getString("messages.effect_set"))
                .replace("%effect%", effect));
    }
}
