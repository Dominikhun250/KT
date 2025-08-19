package me.dominikhun250.hu.plugin.effects.list.totem;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.util.EffectUtils;
import me.dominikhun250.hu.plugin.utils.damage.DamageConfig;
import me.dominikhun250.hu.plugin.utils.damage.DamageUtils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class TotemEffect implements KillEffect {
    private final KT plugin;
    public TotemEffect(KT plugin) { this.plugin = plugin; }

    @Override
    public void play(Player killer, Location loc) {
        loc.getWorld().playSound(loc, Sound.ITEM_TOTEM_USE, 2.0f, 1);
        EffectUtils.playRepeatingParticle(plugin, loc, Particle.TOTEM_OF_UNDYING, 300, 1.8, 2.5, 1.8, 0.3, 2L, 10);
        DamageConfig damageConfig = DamageUtils.getDamageConfig("totem", plugin);

        if (damageConfig.isEnabled()) {
            DamageUtils.applyDamageAround(killer, loc, damageConfig.getRadius(), damageConfig.getValue());
        }
    }
}
