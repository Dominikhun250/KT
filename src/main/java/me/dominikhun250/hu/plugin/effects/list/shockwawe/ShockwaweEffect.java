package me.dominikhun250.hu.plugin.effects.list.shockwawe;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.list.shockwawe.animation.ShockwaweAnimation;
import org.bukkit.*;
import org.bukkit.entity.Player;

public class ShockwaweEffect implements KillEffect {

    private final KT plugin;

    public ShockwaweEffect(KT plugin) {
        this.plugin = plugin;
    }

    @Override
    public void play(Player killer, Location target) {
        World world = target.getWorld();
        if (world == null) return;

        new ShockwaweAnimation(plugin, world, target.clone().add(0, 1, 0)).start(killer);
    }
}
