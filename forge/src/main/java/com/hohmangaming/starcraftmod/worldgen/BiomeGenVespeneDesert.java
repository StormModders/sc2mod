package com.hohmangaming.starcraftmod.worldgen;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class BiomeGenVespeneDesert extends BiomeGenDesert {

	public static BiomeGenVespeneDesert createAndRegisterBiome(int id) {
		BiomeGenVespeneDesert biome = new BiomeGenVespeneDesert(id);
		BiomeDictionary.registerBiomeType(biome, BiomeDictionary.Type.SANDY);
		BiomeManager.addSpawnBiome(biome);
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
		setHeight(new BiomeGenBase.Height(0.15F, .05F));
//		setMinMaxHeight(0.1F, 0.2F);
	}
}
