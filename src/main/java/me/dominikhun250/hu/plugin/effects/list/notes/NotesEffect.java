package me.dominikhun250.hu.plugin.effects.list.notes;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.util.EffectUtils;
import me.dominikhun250.hu.plugin.utils.damage.DamageConfig;
import me.dominikhun250.hu.plugin.utils.damage.DamageUtils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class NotesEffect implements KillEffect {
    private final KT plugin;
    public NotesEffect(KT plugin) { this.plugin = plugin; }

    @Override
    public void play(Player killer, Location loc) {
        loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
        EffectUtils.playRepeatingParticle(plugin, loc, Particle.NOTE, 40, 1.5, 1.5, 1.5, 1, 2L, 8);
        DamageConfig damageConfig = DamageUtils.getDamageConfig("notes", plugin);

        if (damageConfig.isEnabled()) {
            DamageUtils.applyDamageAround(killer, loc, damageConfig.getRadius(), damageConfig.getValue());
        }
    }
}

