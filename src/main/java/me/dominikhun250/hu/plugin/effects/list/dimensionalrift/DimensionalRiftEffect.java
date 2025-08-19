package me.dominikhun250.hu.plugin.effects.list.dimensionalrift;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.list.dimensionalrift.animation.DimensionalRiftLauncher;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class DimensionalRiftEffect implements KillEffect {
    private final KT plugin;

    public DimensionalRiftEffect(KT plugin) {
        this.plugin = plugin;
    }

    @Override
    public void play(Player killer, Location loc) {
        if (loc.getWorld() == null) return;
        DimensionalRiftLauncher.launch(plugin, loc.clone().add(0.5, 1, 0.5), killer);
    }
}
