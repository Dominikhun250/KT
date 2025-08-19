package me.dominikhun250.hu.plugin.effects.list.cryocore;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.list.cryocore.animation.CryoCoreLauncher;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CryoCoreEffect implements KillEffect {
    private final KT plugin;

    public CryoCoreEffect(KT plugin) {
        this.plugin = plugin;
    }

    @Override
    public void play(Player killer, Location loc) {
        if (loc.getWorld() == null) return;
        int multiplier = plugin.getConfig().getInt("effects.cryocore.duration-multiplier", 1);
        CryoCoreLauncher.launchWithCustomDuration(plugin, loc.clone().add(0.5, 0, 0.5), killer, multiplier);
    }
}
