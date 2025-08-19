package me.dominikhun250.hu.plugin.effects.list.firephoenix;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.list.firephoenix.animation.FirePhoenixLauncher;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class FirePhoenixEffect implements KillEffect {
    private final KT plugin;

    public FirePhoenixEffect(KT plugin) {
        this.plugin = plugin;
    }

    @Override
    public void play(Player killer, Location loc) {
        if (loc.getWorld() == null) return;
        FirePhoenixLauncher.launch(plugin, loc.clone().add(0.5, 1, 0.5), killer);
    }
}
