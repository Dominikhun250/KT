package me.dominikhun250.hu.plugin.commands.kt;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.commands.kt.manager.KTCManager;
import me.dominikhun250.hu.plugin.commands.kt.subcommands.inter.SubCommand;
import me.dominikhun250.hu.plugin.economy.EconomyManager;
import me.dominikhun250.hu.plugin.economy.KillCoinsEco;
import me.dominikhun250.hu.plugin.gui.GUIManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KTCommand implements CommandExecutor {

    private KTCManager manager;
    private final GUIManager guiManager;
    private final KT plugin;

    public KTCommand(KT plugin, GUIManager guiManager, EconomyManager eco) {
        this.plugin = plugin;
        this.manager = new KTCManager(plugin, guiManager, eco);
        this.guiManager = guiManager;
    }

    public void updateEconomyManager(EconomyManager economyManager) {
        this.manager = new KTCManager(plugin, guiManager, economyManager);
        plugin.getLogger().info("KTCommand updated with new EconomyManager: " +
                (economyManager.isUsingInternal() ? "Internal" : "External"));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                guiManager.openGUI(player);
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.only_players")));
            }
            return true;
        }

        SubCommand sub = manager.getSubCommand(args[0]);
        if (sub != null) {
            if (sub.getPermission() != null && !sender.hasPermission(sub.getPermission())) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.commands_no_perm")));
                return true;
            }
            sub.execute(sender, args);
        }
        return true;
    }
}
