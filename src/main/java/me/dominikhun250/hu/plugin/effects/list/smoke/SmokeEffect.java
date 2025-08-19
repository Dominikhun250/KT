package me.dominikhun250.hu.plugin.effects.list.smoke;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.util.EffectUtils;
import me.dominikhun250.hu.plugin.utils.damage.DamageConfig;
import me.dominikhun250.hu.plugin.utils.damage.DamageUtils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SmokeEffect implements KillEffect {
    private final KT plugin;
    public SmokeEffect(KT plugin) { this.plugin = plugin; }

    @Override
    public void play(Player killer, Location loc) {
        loc.getWorld().playSound(loc, Sound.BLOCK_FIRE_EXTINGUISH, 2, 1);
        EffectUtils.playRepeatingParticle(plugin, loc, Particle.LARGE_SMOKE, 80, 1, 1, 1, 0.02, 2L, 10);
        DamageConfig damageConfig = DamageUtils.getDamageConfig("smoke", plugin);

        if (damageConfig.isEnabled()) {
            DamageUtils.applyDamageAround(killer, loc, damageConfig.getRadius(), damageConfig.getValue());
        }
    }
}

