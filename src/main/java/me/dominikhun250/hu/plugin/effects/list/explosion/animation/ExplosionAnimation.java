package me.dominikhun250.hu.plugin.effects.list.explosion.animation;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.list.explosion.animation.util.ExplosionUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ExplosionAnimation {

    public static void launchExplosionTNT(KT plugin, Location center, Player killer) {
        for (int i = 0; i < 6; i++) {
            ExplosionUtils.launchCosmeticTNT(plugin, center, killer);
        }
    }
}
