package me.dominikhun250.hu.plugin.effects.list.glowmissile;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.list.glowmissile.animation.GlowMissileLauncher;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class GlowMissileEffect implements KillEffect {
    private final KT plugin;

    public GlowMissileEffect(KT plugin) {
        this.plugin = plugin;
    }

    @Override
    public void play(Player killer, Location loc) {
        if (loc.getWorld() == null) return;

        GlowMissileLauncher.launch(plugin, loc.getBlock().getLocation().add(0.5, 1, 0.5), killer);
    }
}
