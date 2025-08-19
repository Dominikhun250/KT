package me.dominikhun250.hu.plugin.effects.list.explosion;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.list.explosion.animation.ExplosionAnimation;
import me.dominikhun250.hu.plugin.utils.damage.DamageConfig;
import me.dominikhun250.hu.plugin.utils.damage.DamageUtils;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ExplosionEffect implements KillEffect {

    private final KT plugin;

    public ExplosionEffect(KT plugin) {
        this.plugin = plugin;
    }

    @Override
    public void play(Player killer, Location loc) {
        loc.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 2f, 1f);
        DamageConfig damageConfig = DamageUtils.getDamageConfig("explosion", plugin);
        if (damageConfig.isEnabled()) {
            DamageUtils.applyDamageAround(killer, loc, damageConfig.getRadius(), damageConfig.getValue());
        }
        ExplosionAnimation.launchExplosionTNT(plugin, loc, killer);
    }
}
