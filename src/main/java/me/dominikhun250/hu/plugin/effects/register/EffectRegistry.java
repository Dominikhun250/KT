package me.dominikhun250.hu.plugin.effects.register;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.KillEffect;
import me.dominikhun250.hu.plugin.effects.KillEffectFactory;
import org.bukkit.configuration.ConfigurationSection;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

public class EffectRegistry {

    private final KT plugin;

    public EffectRegistry(KT plugin) {
        this.plugin = plugin;
    }

    public void loadEffects() {
        KillEffectFactory.clearEffects();
        Set<String> enabledEffects = new HashSet<>();

        ConfigurationSection section = plugin.getConfig().getConfigurationSection("effects");
        if (section == null) return;

        Reflections reflections = new Reflections("me.dominikhun250.hu.plugin.effects.list");
        Set<Class<? extends KillEffect>> classes = reflections.getSubTypesOf(KillEffect.class);

        for (Class<? extends KillEffect> clazz : classes) {
            String simpleName = clazz.getSimpleName();
            String key = simpleName.replace("Effect", "").toLowerCase();

            boolean enabled = section.getBoolean(key + ".enabled", true);
            if (!enabled) continue;

            try {
                Constructor<? extends KillEffect> constructor = clazz.getConstructor(KT.class);
                KillEffect effect = constructor.newInstance(plugin);

                KillEffectFactory.registerEffect(key, effect);
                enabledEffects.add(key);
            } catch (Exception e) {
                plugin.getLogger().warning("Impossibile registrare l'effetto: " + clazz.getName());
                e.printStackTrace();
            }
        }

        plugin.getGuiManager().reloadGUI(enabledEffects);
    }

    public int getLoadedEffectsCount() {
        return KillEffectFactory.getRegisteredEffects().size();
    }

}
