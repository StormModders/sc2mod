package com.hohmangaming.starcraftmod.worldgen;

import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraftforge.common.BiomeDictionary;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class BiomeGenVespeneDesert extends BiomeGenDesert {

	public static BiomeGenVespeneDesert makeBiome(int id) {
		BiomeGenVespeneDesert biome = new BiomeGenVespeneDesert(id);
		BiomeDictionary.registerBiomeType(biome, BiomeDictionary.Type.DESERT);
		VespenePopulate.INSTANCE.excessiveBiomes.add(biome.biomeID);
		VespenePopulate.INSTANCE.surfaceDepositBiomes.add(biome.biomeID);
		return biome;
	}

	private BiomeGenVespeneDesert(int id) {
		super(id);
		setColor(16421912);
		setBiomeName("Desert Vespene Field");
		setDisableRain();
		setTemperatureRainfall(2.0F, 0.0F);
		setMinMaxHeight(0.1F, 0.2F);
	}
}