package com.hohmangaming.starcraftmod.worldgen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.hohmangaming.starcraftmod.StarcraftMod;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class StarcraftWorldGenerator implements IWorldGenerator {

	   public static List hatcherySpawnBiomes = Arrays.asList(new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.plains});
	   public static List xelnagaTemplsSpawnBiomes = Arrays.asList(new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.taiga,
			   BiomeGenBase.icePlains, BiomeGenBase.jungle});

       public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
       {
             switch(world.provider.dimensionId)
             {
                    case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
                    case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
                    case 1: generateEnd(world, random, chunkX * 16, chunkZ * 16);
             }
       }
      
       private void generateEnd(World world, Random random, int x, int z)
       {
            
       }

       private void generateSurface(World world, Random random, int x, int z)
       {
    	   // add our custom ores
           this.addOreSpawn(StarcraftMod.blockMineral, world, random, x, z, 16, 16, 3 + random.nextInt(3), 100, 15, 50);
           this.addOreSpawn(StarcraftMod.blockRichMineral, world, random, x, z, 16, 16, 2 + random.nextInt(3), 50, 15, 50);
           
           // add hatchery
           handleHatcherySpawning(world, random, x, z);
           
           handleXelnagaTempleSpawning(world, random, x, z);
       }

       private void generateNether(World world, Random random, int x, int z)
       {
            
       }

       public void handleXelnagaTempleSpawning(World world, Random random, int x, int z)
       {
    	   // size in x and z coords of a hatchery
    	   int dx=64;
    	   int dz=80;
    	   
	       int posX = x;// + 8; //random.nextInt(8);
	       int posZ = z;// + 8; //random.nextInt(8);

	       // make sure the area all around is a valid biome
    	   if ( ! world.getWorldChunkManager().areBiomesViable(posX, posZ, 0, xelnagaTemplsSpawnBiomes) ||
    			! world.getWorldChunkManager().areBiomesViable(posX+dx/2, posZ, 0, xelnagaTemplsSpawnBiomes) ||
    			! world.getWorldChunkManager().areBiomesViable(posX-dx/2, posZ, 0, xelnagaTemplsSpawnBiomes) ||
    			! world.getWorldChunkManager().areBiomesViable(posX, posZ+dz/2, 0, xelnagaTemplsSpawnBiomes) ||
    			! world.getWorldChunkManager().areBiomesViable(posX, posZ-dz/2, 0, xelnagaTemplsSpawnBiomes))
    		   return;

    	   // find the lowest spot in the area...
    	   int posY = world.getTopSolidOrLiquidBlock(posX, posZ);
    	   for(int xx=posX-dx/2;xx<=posX+dx/2;xx++)
    		   for(int zz=posZ-dz/2;zz<=posZ+dz/2;zz++) {
    			   int yy = world.getTopSolidOrLiquidBlock(xx, zz);
    			   if (yy < posY)
    				   posY = yy;
    		   }

//    	   // make sure the surface area is completely flag
//    	   if (!isAreaFlat(world, posX, posZ, dx, dz))
//    		   return;


    	   int shouldWeSpawn = random.nextInt(1000);
    	   if (shouldWeSpawn <= ( StarcraftMod.debugMode ? 10 : 5)) {
    		   System.out.println("**** Generating Xelnaga Temple ****");
    		   StarcraftMod.schematicXelnagaTemple.generate(world, posX, posY, posZ, true);
    	   }
       }
       
       public void handleHatcherySpawning(World world, Random random, int x, int z)
       {
    	   // size in x and z coords of a hatchery
    	   int dx=16;
    	   int dz=16;
    	   
	       int posX = x;// + 8; //random.nextInt(8);
	       int posZ = z;// + 8; //random.nextInt(8);

	       // make sure the area all around is a valid biome
    	   if ( ! world.getWorldChunkManager().areBiomesViable(posX, posZ, 0, hatcherySpawnBiomes) ||
    			! world.getWorldChunkManager().areBiomesViable(posX+dx/2, posZ, 0, hatcherySpawnBiomes) ||
    			! world.getWorldChunkManager().areBiomesViable(posX-dx/2, posZ, 0, hatcherySpawnBiomes) ||
    			! world.getWorldChunkManager().areBiomesViable(posX, posZ+dz/2, 0, hatcherySpawnBiomes) ||
    			! world.getWorldChunkManager().areBiomesViable(posX, posZ-dz/2, 0, hatcherySpawnBiomes))
    		   return;

    	   // make sure the surface area is completely flag
    	   if (!isAreaFlat(world, posX, posZ, dx, dz))
    		   return;

    	   int shouldWeSpawn = random.nextInt(100);
    	   if (shouldWeSpawn <= ( StarcraftMod.debugMode ? 60 : 30)) {
    		   System.out.println("**** Generating Hatchery ****");
    	       int posY = world.getTopSolidOrLiquidBlock(posX, posZ);
    		   StarcraftMod.schematicHatchery.generate(world, posX, posY, posZ, false);
    		   
    		   // spread creep...
        	   for(int xx=posX-dx;xx<=posX+dx*2;xx++)
        		   for(int zz=posZ-dz;zz<=posZ+dz*2;zz++) {
        			   if (xx >= posX && 
        				   xx <= posX+dx &&
        				   zz >= posZ &&
        				   zz <= posZ+dz)
        				   continue;
        			   long dist = Math.round(Math.hypot((double)(xx-(posX+dx/2)), (double)(zz-(posZ+dz/2))));
        			   if (dist > (((double)dx)*1.5))
        				   continue;
        			   int yy = world.getTopSolidOrLiquidBlock(xx, zz);
        			   world.setBlock(xx, yy, zz, StarcraftMod.blockCreep, 0, 2);
        		   }
    	   }
       }
       
       protected boolean isAreaFlat(World world, int posX, int posZ, int dx, int dz) {
    	   // make sure the surface area is completely flag
	       int posY = world.getTopSolidOrLiquidBlock(posX, posZ);
    	   for(int xx=posX-dx/2;xx<=posX+dx/2;xx++)
    		   for(int zz=posZ-dz/2;zz<=posZ+dz/2;zz++) {
    			   int yy = world.getTopSolidOrLiquidBlock(xx, zz);
    			   if (yy == (posY+1) && world.getBlock(xx, yy, zz).getMaterial() == Material.grass)
    				   continue; // tall grass is ok

    			   if (yy != posY) // is not flat, bail
    				   return false;
    			   
   				   if (world.getBlock(xx, yy, zz).getMaterial() == Material.water) // is water, bail
    				   return false;
    		   }
    	   return true;
       }
       
       /**
        * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
        *
        * @param The Block to spawn
        * @param The World to spawn in
        * @param A Random object for retrieving random positions within the world to spawn the Block
        * @param An int for passing the X-Coordinate for the Generation method
        * @param An int for passing the Z-Coordinate for the Generation method
        * @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
        * @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
        * @param An int for setting the maximum size of a vein
        * @param An int for the Number of chances available for the Block to spawn per-chunk
        * @param An int for the minimum Y-Coordinate height at which this block may spawn
        * @param An int for the maximum Y-Coordinate height at which this block may spawn
        **/
       public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
       {
             int maxPossY = minY + (maxY - 1);
             assert maxY > minY: "The maximum Y must be greater than the Minimum Y";
             assert maxX > 0 && maxX <= 16: "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
             assert minY > 0: "addOreSpawn: The Minimum Y must be greater than 0";
             assert maxY < 256 && maxY > 0: "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
             assert maxZ > 0 && maxZ <= 16: "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
            
             int diffBtwnMinMaxY = maxY - minY;
             for(int x = 0; x < chancesToSpawn; x++)
             {
                    int posX = blockXPos + random.nextInt(maxX);
                    int posY = minY + random.nextInt(diffBtwnMinMaxY);
                    int posZ = blockZPos + random.nextInt(maxZ);
                    (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
             }
       }
}
