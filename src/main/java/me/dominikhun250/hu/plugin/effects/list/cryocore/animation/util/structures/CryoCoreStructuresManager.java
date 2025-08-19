package me.dominikhun250.hu.plugin.effects.list.cryocore.animation.util.structures;

import me.dominikhun250.hu.plugin.KT;
import me.dominikhun250.hu.plugin.effects.list.cryocore.animation.util.structures.placer.IceSpikePlacer;
import me.dominikhun250.hu.plugin.effects.list.cryocore.animation.util.structures.placer.SnowBlockPlacer;
import me.dominikhun250.hu.plugin.effects.list.cryocore.animation.util.structures.helper.BlockStateHolder;
import me.dominikhun250.hu.plugin.effects.list.cryocore.animation.util.structures.placer.StructureRestorer;
import org.bukkit.*;

public class CryoCoreStructuresManager {

    private final KT plugin;
    private final SnowBlockPlacer snowBlockPlacer;
    private final IceSpikePlacer iceSpikePlacer;
    private final StructureRestorer structureRestorer;

    public CryoCoreStructuresManager(KT plugin) {
        this.plugin = plugin;
        this.snowBlockPlacer = new SnowBlockPlacer(plugin);
        this.iceSpikePlacer = new IceSpikePlacer(plugin);
        this.structureRestorer = new StructureRestorer(plugin);
    }

    public BlockStateHolder createBlockStateHolder() {
        return new BlockStateHolder();
    }

    public void randomlyPlaceSnowBlocks(Location center, int radius, BlockStateHolder holder, int batch, boolean allowStructure) {
        snowBlockPlacer.randomlyPlaceSnowBlocks(center, radius, holder, batch, allowStructure);
    }

    public void restoreGround(BlockStateHolder holder) {
        structureRestorer.restoreGround(holder);
    }

    public void spawnLargeIceSpikesBorder(Location center, int radius, BlockStateHolder holder, boolean allowStructure) {
        iceSpikePlacer.spawnLargeIceSpikesBorder(center, radius, holder, allowStructure);
    }
}