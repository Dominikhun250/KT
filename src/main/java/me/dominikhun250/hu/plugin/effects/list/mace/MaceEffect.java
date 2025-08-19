package me.dominikhun250.hu.plugin.effects.list.mace;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.list.mace.animation.MaceLauncher;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class MaceEffect implements KillEffect {
    private final KT plugin;

    public MaceEffect(KT plugin) {
        this.plugin = plugin;
    }

    @Override
    public void play(Player killer, Location loc) {
        if (loc.getWorld() == null) return;
        MaceLauncher.launch(plugin, killer, loc.clone().add(0.5, 1, 0.5));
    }
}
