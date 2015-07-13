package com.hohmangaming.starcraftmod.worldgen;

import com.hohmangaming.starcraftmod.Ids;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import buildcraft.BuildCraftEnergy;
import buildcraft.energy.worldgen.GenLayerBiomeReplacer;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class GenLayerAddVespeneOcean extends GenLayerBiomeReplacer {

	public static final double NOISE_FIELD_SCALE = 0.0005;
	public static final double NOISE_FIELD_THRESHOLD = 0.9;

	public GenLayerAddVespeneOcean(final long worldSeed, final long seed, final GenLayer parent) {
		super(worldSeed, seed, parent, NOISE_FIELD_SCALE, NOISE_FIELD_THRESHOLD, Ids.BIOME_VESPENE_OCEAN);
	}

	@Override
	protected boolean canReplaceBiome(int biomeId) {
		return biomeId == BiomeGenBase.ocean.biomeID;
	}
}
