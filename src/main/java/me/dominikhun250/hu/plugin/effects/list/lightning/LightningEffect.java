package me.dominikhun250.hu.plugin.effects.list.lightning;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.util.EffectUtils;
import me.dominikhun250.hu.plugin.utils.damage.DamageConfig;
import me.dominikhun250.hu.plugin.utils.damage.DamageUtils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LightningEffect implements KillEffect {

    private final KT plugin;
    public LightningEffect(KT plugin) { this.plugin = plugin; }

    @Override
    public void play(Player killer, Location loc) {
        loc.getWorld().strikeLightningEffect(loc);

        loc.getWorld().playSound(loc, Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1.8f, 1f);

        EffectUtils.playRepeatingParticle(plugin, loc, Particle.ENCHANTED_HIT, 150, 1.2, 1.5, 1.2, 0.2, 2L, 5);
        DamageConfig damageConfig = DamageUtils.getDamageConfig("lightning", plugin);

        if (damageConfig.isEnabled()) {
            DamageUtils.applyDamageAround(killer, loc, damageConfig.getRadius(), damageConfig.getValue());
        }
    }
}
