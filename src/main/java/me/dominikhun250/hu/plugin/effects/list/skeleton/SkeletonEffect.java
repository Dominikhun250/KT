package me.dominikhun250.hu.plugin.effects.list.skeleton;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.list.skeleton.animation.SkeletonAnimation;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SkeletonEffect implements KillEffect {

    private final KT plugin;

    public SkeletonEffect(KT plugin) {
        this.plugin = plugin;
    }

    public void play(Player deadPlayer, Location loc) {
        new SkeletonAnimation(plugin, loc, deadPlayer).start();
    }
}

// Made by: Dominikhun250