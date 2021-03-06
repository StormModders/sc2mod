/**
 * Copyright (c) SpaceToad, 2011 http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License
 * 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package com.hohmangaming.starcraftmod.worldgen;

import static net.minecraftforge.common.BiomeDictionary.Type.FOREST;
import static net.minecraftforge.common.BiomeDictionary.Type.SANDY;
import static net.minecraftforge.common.BiomeDictionary.Type.SNOWY;
import static net.minecraftforge.common.BiomeDictionary.Type.WASTELAND;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.hohmangaming.starcraftmod.StarcraftMod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fluids.IFluidBlock;

public class VespenePopulate {

	public static final VespenePopulate INSTANCE = new VespenePopulate();
	public static final EventType EVENT_TYPE = EnumHelper.addEnum(EventType.class, "STARCRAFTMOD_VESPENE", new Class[0], new Object[0]);
	private static final byte LARGE_WELL_HEIGHT = 16;
	private static final byte MEDIUM_WELL_HEIGHT = 6;
	public final Set<Integer> excessiveBiomes = new HashSet<Integer>();
	public final Set<Integer> surfaceDepositBiomes = new HashSet<Integer>();
	public final Set<Integer> excludedBiomes = new HashSet<Integer>();

	private enum GenType {

		LARGE, MEDIUM, LAKE, NONE
	};

	private VespenePopulate() {
		surfaceDepositBiomes.add(BiomeGenBase.desert.biomeID);
		surfaceDepositBiomes.add(BiomeGenBase.taiga.biomeID);

		excludedBiomes.add(BiomeGenBase.sky.biomeID);
		excludedBiomes.add(BiomeGenBase.hell.biomeID);
	}

	@SubscribeEvent
	public void populate(PopulateChunkEvent.Pre event) {
		boolean doGen = TerrainGen.populate(event.chunkProvider, event.world, event.rand, event.chunkX, event.chunkX, event.hasVillageGenerated, EVENT_TYPE);

		if (!doGen) {
			return;
		}

		generateVespene(event.world, event.rand, event.chunkX, event.chunkZ);
	}

	public void generateVespene(World world, Random rand, int chunkX, int chunkZ) {

		// shift to world coordinates
		int x = chunkX * 16 + 8 + rand.nextInt(16);
		int z = chunkZ * 16 + 8 + rand.nextInt(16);

		BiomeGenBase biome = world.getBiomeGenForCoords(x, z);

		// Do not generate vespene in the End or Nether
		if (excludedBiomes.contains(biome.biomeID)) {
			return;
		}

		boolean vespeneBiome = surfaceDepositBiomes.contains(biome.biomeID)
				|| BiomeDictionary.isBiomeOfType(biome, SANDY)
				|| (BiomeDictionary.isBiomeOfType(biome, WASTELAND) && !BiomeDictionary.isBiomeOfType(biome, SNOWY))
				|| (BiomeDictionary.isBiomeOfType(biome, FOREST) && BiomeDictionary.isBiomeOfType(biome, SNOWY));

		double bonus = vespeneBiome ? 3.0 : 1.0;
		bonus *= 1.0;  // BuildCraftEnergy.oilWellScalar;... looks like you can turn up oil gen
		if (excessiveBiomes.contains(biome.biomeID)) {
			bonus *= 30.0;
		} else if (StarcraftMod.debugMode) {
			bonus *= 20.0;
		}
		GenType type = GenType.NONE;
		if (rand.nextDouble() <= 0.0004 * bonus) {// 0.04%
			type = GenType.LARGE;
		} else if (rand.nextDouble() <= 0.001 * bonus) {// 0.1%
			type = GenType.MEDIUM;
		} else if (vespeneBiome && rand.nextDouble() <= 0.02 * bonus) {// 2%
			type = GenType.LAKE;
		}

		if (type == GenType.NONE) {
			return;
		}

		// Find ground level
		int groundLevel = getTopBlock(world, x, z);
		if (groundLevel < 5) {
			return;
		}

		double deviation = surfaceDeviation(world, x, groundLevel, z, 8);
		if (deviation > 0.45) {
			return;
		}

		// Generate a Well
		if (type == GenType.LARGE || type == GenType.MEDIUM) {
			int wellX = x;
			int wellZ = z;

			int wellHeight = MEDIUM_WELL_HEIGHT;
			if (type == GenType.LARGE) {
				wellHeight = LARGE_WELL_HEIGHT;
			}
			int maxHeight = groundLevel + wellHeight;
			if (maxHeight >= world.getActualHeight() - 1) {
				return;
			}

			// Generate a spherical cave deposit
			int wellY = 20 + rand.nextInt(10);

			int radius;
			if (type == GenType.LARGE) {
				radius = 8 + rand.nextInt(9);
			} else {
				radius = 4 + rand.nextInt(4);
			}

			int radiusSq = radius * radius;

			for (int poolX = -radius; poolX <= radius; poolX++) {
				for (int poolY = -radius; poolY <= radius; poolY++) {
					for (int poolZ = -radius; poolZ <= radius; poolZ++) {
						int distance = poolX * poolX + poolY * poolY + poolZ * poolZ;

						if (distance <= radiusSq) {
							world.setBlock(poolX + wellX, poolY + wellY, poolZ + wellZ, StarcraftMod.blockVespene, 0, distance == radiusSq ? 3 : 2);
						}
					}
				}
			}

			// Generate Lake around Spout
			int lakeRadius;
			if (type == GenType.LARGE) {
				lakeRadius = 25 + rand.nextInt(20);
//				if (BuildCraftCore.debugMode) {
//					lakeRadius += 40;
//				}
			} else {
				lakeRadius = 5 + rand.nextInt(10);
			}
			generateSurfaceDeposit(world, rand, biome, wellX, groundLevel, wellZ, lakeRadius);

			// Generate Spout
			// BOBHO TODO - not handling springs yet
			int baseY;
			if (type == GenType.LARGE && (StarcraftMod.debugMode || rand.nextDouble() <= 0.25)) {
				baseY = 0;
			} else {
				baseY = wellY;
			}

			if (world.getBlock(wellX, baseY, wellZ) == Blocks.bedrock) {
				world.setBlock(wellX, baseY, wellZ, StarcraftMod.blockVespene, 1, 3);  // this was a spring block
			}
			for (int y = baseY + 1; y <= maxHeight; ++y) {
				world.setBlock(wellX, y, wellZ, StarcraftMod.blockVespene);
			}

			if (type == GenType.LARGE) {
				for (int y = wellY; y <= maxHeight - wellHeight / 2; ++y) {
					world.setBlock(wellX + 1, y, wellZ, StarcraftMod.blockVespene);
					world.setBlock(wellX - 1, y, wellZ, StarcraftMod.blockVespene);
					world.setBlock(wellX, y, wellZ + 1, StarcraftMod.blockVespene);
					world.setBlock(wellX, y, wellZ - 1, StarcraftMod.blockVespene);
				}
			}

		} else if (type == GenType.LAKE) {
			// Generate a surface lake
			int lakeX = x;
			int lakeZ = z;
			int lakeY = groundLevel;

			Block block = world.getBlock(lakeX, lakeY, lakeZ);
			if (block == biome.topBlock) {
				generateSurfaceDeposit(world, rand, biome, lakeX, lakeY, lakeZ, 5 + rand.nextInt(10));
			}
		}
	}

	public void generateSurfaceDeposit(World world, Random rand, int x, int y, int z, int radius) {
		BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
		generateSurfaceDeposit(world, rand, biome, x, y, z, radius);
	}

	private void generateSurfaceDeposit(World world, Random rand, BiomeGenBase biome, int x, int y, int z, int radius) {
		int depth = rand.nextDouble() < 0.5 ? 1 : 2;

		// Center
		setVespeneColumnForLake(world, biome, x, y, z, depth, 2);

		// Generate tendrils, from the center outward
		for (int w = 1; w <= radius; ++w) {
			float proba = (float) (radius - w + 4) / (float) (radius + 4);

			setVespeneWithProba(world, biome, rand, proba, x, y, z + w, depth);
			setVespeneWithProba(world, biome, rand, proba, x, y, z - w, depth);
			setVespeneWithProba(world, biome, rand, proba, x + w, y, z, depth);
			setVespeneWithProba(world, biome, rand, proba, x - w, y, z, depth);

			for (int i = 1; i <= w; ++i) {
				setVespeneWithProba(world, biome, rand, proba, x + i, y, z + w, depth);
				setVespeneWithProba(world, biome, rand, proba, x + i, y, z - w, depth);
				setVespeneWithProba(world, biome, rand, proba, x + w, y, z + i, depth);
				setVespeneWithProba(world, biome, rand, proba, x - w, y, z + i, depth);

				setVespeneWithProba(world, biome, rand, proba, x - i, y, z + w, depth);
				setVespeneWithProba(world, biome, rand, proba, x - i, y, z - w, depth);
				setVespeneWithProba(world, biome, rand, proba, x + w, y, z - i, depth);
				setVespeneWithProba(world, biome, rand, proba, x - w, y, z - i, depth);
			}
		}

		// Fill in holes
		for (int dx = x - radius; dx <= x + radius; ++dx) {
			for (int dz = z - radius; dz <= z + radius; ++dz) {
				if (isVespene(world, dx, y, dz)) {
					continue;
				}
				if (isVespeneSurrounded(world, dx, y, dz)) {
					setVespeneColumnForLake(world, biome, dx, y, dz, depth, 2);
				}
			}
		}
	}

	private boolean isReplaceableFluid(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		return (block instanceof BlockLiquid || block instanceof IFluidBlock) && block.getMaterial() != Material.lava;
	}

	private boolean isVespene(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		return (block == StarcraftMod.blockVespene);
	}

	private boolean isReplaceableForLake(World world, BiomeGenBase biome, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		if (block == null) {
			return true;
		}
		if (block == biome.fillerBlock || block == biome.topBlock) {
			return true;
		}
		if (!block.getMaterial().blocksMovement()) {
			return true;
		}
		if (block.isReplaceableOreGen(world, x, y, z, Blocks.stone)) {
			return true;
		}
		if (block instanceof BlockFlower) {
			return true;
		}
		if (!block.isOpaqueCube()) {
			return true;
		}
		return false;
	}

	private boolean isVespeneAdjacent(World world, int x, int y, int z) {
		return isVespene(world, x + 1, y, z)
				|| isVespene(world, x - 1, y, z)
				|| isVespene(world, x, y, z + 1)
				|| isVespene(world, x, y, z - 1);
	}

	private boolean isVespeneSurrounded(World world, int x, int y, int z) {
		return isVespene(world, x + 1, y, z)
				&& isVespene(world, x - 1, y, z)
				&& isVespene(world, x, y, z + 1)
				&& isVespene(world, x, y, z - 1);
	}

	private void setVespeneWithProba(World world, BiomeGenBase biome, Random rand, float proba, int x, int y, int z, int depth) {
		if (rand.nextFloat() <= proba && world.getBlock(x, y - depth - 1, z) != null) {
			if (isVespeneAdjacent(world, x, y, z)) {
				setVespeneColumnForLake(world, biome, x, y, z, depth, 3);
			}
		}
	}

	private void setVespeneColumnForLake(World world, BiomeGenBase biome, int x, int y, int z, int depth, int update) {
		if (isReplaceableForLake(world, biome, x, y + 1, z)) {
			if (!world.isAirBlock(x, y + 2, z)) {
				return;
			}
//			if (isReplaceableFluid(world, x, y, z) || world.isBlockSolidOnSide(x, y - 1, z, ForgeDirection.UP)) {
			if (isReplaceableFluid(world, x, y, z) ) { // BOBHO TODO not sure what this isBlockSolidOnside was trying to do
				world.setBlock(x, y, z, StarcraftMod.blockVespene, 0, update);
			} else {
				return;
			}
			if (!world.isAirBlock(x, y + 1, z)) {
				world.setBlock(x, y + 1, z, StarcraftMod.blockVespene, 0, update);
			}

			for (int d = 1; d <= depth - 1; d++) {
//				if (isReplaceableFluid(world, x, y - d, z) || !world.isBlockSolidOnSide(x, y - d - 1, z, ForgeDirection.UP)) {
				if (isReplaceableFluid(world, x, y - d, z) ) { // BOBHO TODO not sure what this isBlockSolidOnside was trying to do
					return;
				}
				world.setBlock(x, y - d, z, StarcraftMod.blockVespene, 0, 2);
			}
		}
	}

	private int getTopBlock(World world, int x, int z) {
		Chunk chunk = world.getChunkFromBlockCoords(x, z);
		int y = chunk.getTopFilledSegment() + 15;

		int trimmedX = x & 15;
		int trimmedZ = z & 15;

		for (; y > 0; --y) {
			Block block = chunk.getBlock(trimmedX, y, trimmedZ);
			if (block == null) {
				continue;
			}
			if (block instanceof BlockLiquid) {
				return y;
			}
			if (block instanceof IFluidBlock) {
				return y;
			}
			if (!block.getMaterial().blocksMovement()) {
				continue;
			}
			if (block instanceof BlockFlower) {
				continue;
			}
			return y - 1;
		}

		return -1;
	}

	private double surfaceDeviation(World world, int x, int y, int z, int radius) {
		int diameter = radius * 2;
		double centralTendancy = y;
		double deviation = 0;
		for (int i = 0; i < diameter; i++) {
			for (int k = 0; k < diameter; k++) {
				deviation += getTopBlock(world, x - radius + i, z - radius + k) - centralTendancy;
			}
		}
		return Math.abs(deviation / centralTendancy);
	}
}
