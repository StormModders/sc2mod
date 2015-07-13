package com.hohmangaming.starcraftmod.worldgen;

import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraftforge.common.BiomeDictionary;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class BiomeGenVespeneOcean extends BiomeGenOcean {

	public static BiomeGenVespeneOcean makeBiome(int id) {
		BiomeGenVespeneOcean biome = new BiomeGenVespeneOcean(id);
		BiomeDictionary.registerBiomeType(biome, BiomeDictionary.Type.WATER);
		VespenePopulate.INSTANCE.excessiveBiomes.add(biome.biomeID);
		VespenePopulate.INSTANCE.surfaceDepositBiomes.add(biome.biomeID);
		return biome;
	}

	private BiomeGenVespeneOcean(int id) {
		super(id);
		setBiomeName("Ocean Vespene Field");
		setColor(112);
		setMinMaxHeight(-1.0F, 0.4F);
	}
}