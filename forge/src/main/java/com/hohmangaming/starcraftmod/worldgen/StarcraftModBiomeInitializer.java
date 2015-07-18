package com.hohmangaming.starcraftmod.worldgen;

import com.hohmangaming.starcraftmod.StarcraftMod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class StarcraftModBiomeInitializer {

	public StarcraftModBiomeInitializer() {
	}

	@SubscribeEvent
	public void initBiomes(WorldTypeEvent.InitBiomeGens event) {
		if (StarcraftMod.biomeGenVespeneDesert != null) {
			event.newBiomeGens[0] = new GenLayerAddVespeneDesert(event.seed, 1500L, event.newBiomeGens[0]);
			event.newBiomeGens[1] = new GenLayerAddVespeneDesert(event.seed, 1500L, event.newBiomeGens[1]);
			event.newBiomeGens[2] = new GenLayerAddVespeneDesert(event.seed, 1500L, event.newBiomeGens[2]);
		}
		if (StarcraftMod.biomeGenVespeneOcean != null) {
			event.newBiomeGens[0] = new GenLayerAddVespeneOcean(event.seed, 1500L, event.newBiomeGens[0]);
			event.newBiomeGens[1] = new GenLayerAddVespeneOcean(event.seed, 1500L, event.newBiomeGens[1]);
			event.newBiomeGens[2] = new GenLayerAddVespeneOcean(event.seed, 1500L, event.newBiomeGens[2]);
		}

//		int range = GenLayerBiomeReplacer.OFFSET_RANGE;
//		Random rand = new Random(event.seed);
//		double xOffset = rand.nextInt(range) - (range / 2);
//		double zOffset = rand.nextInt(range) - (range / 2);
//		double noiseScale = GenLayerAddOilOcean.NOISE_FIELD_SCALE;
//		double noiseThreshold = GenLayerAddOilOcean.NOISE_FIELD_THRESHOLD;
//		for (int x = -5000; x < 5000; x += 128) {
//			for (int z = -5000; z < 5000; z += 128) {
//				if (SimplexNoise.noise((x + xOffset) * noiseScale, (z + zOffset) * noiseScale) > noiseThreshold) {
//					System.out.printf("Oil Biome: %d, %d\n", x, z);
//				}
//			}
//		}
	}
}
