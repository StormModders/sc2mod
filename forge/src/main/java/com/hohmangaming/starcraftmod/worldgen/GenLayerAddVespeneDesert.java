package com.hohmangaming.starcraftmod.worldgen;

import com.hohmangaming.starcraftmod.Ids;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class GenLayerAddVespeneDesert extends GenLayerBiomeReplacer {

	protected static final double NOISE_FIELD_SCALE = 0.001;
	protected static final double NOISE_FIELD_THRESHOLD = 0.7;

	public GenLayerAddVespeneDesert(final long worldSeed, final long seed, final GenLayer parent) {
		super(worldSeed, seed, parent, NOISE_FIELD_SCALE, NOISE_FIELD_THRESHOLD, Ids.BIOME_VESPENE_DESERT);
	}

	@Override
	protected boolean canReplaceBiome(int biomeId) {
		return biomeId == BiomeGenBase.desert.biomeID;
	}
}
