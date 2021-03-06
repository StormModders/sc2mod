package com.hohmangaming.starcraftmod.schematic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class Schematic {

	public String path;
	public byte[] blocks;
	public byte[] datablocks;
	public short width;
	public short length;
	public short height;
	public short[] sizes;
	public boolean useMcDir = true;
	public NBTTagCompound nbtTagCompound;
	
	public Schematic(String p) {
		blocks = null;
		datablocks = null;
		width = 0;
		length = 0;
		height = 0;
		path = p;
		loadSchematic();
	}

	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void loadSchematic() {
		try {
	        URL schematic = Schematic.class.getResource(path);
			InputStream fileinputstream = schematic.openStream();
			NBTTagCompound nbt = CompressedStreamTools.readCompressed(fileinputstream);
			nbtTagCompound = nbt;
			
			blocks = nbt.getByteArray("Blocks");
			datablocks = nbt.getByteArray("Data");
			width = nbt.getShort("Width");
			length = nbt.getShort("Length");
			height = nbt.getShort("Height");
			sizes = new short[] {width, length, height};
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void generate(World world, int posX, int posY, int posZ, boolean spawnairblocks) {
		try {
			int xnum = 0;
			int ynum = 0;
			int znum = 0;
			for (int i = 0; i < blocks.length; i++) {
				if(((blocks[i] != 0) && (!spawnairblocks)) || (spawnairblocks == true)) {
					try {
						world.setBlock(posX + xnum, posY + ynum, posZ + znum, Block.getBlockById(blocks[i]), datablocks[i], 2);
					} catch(Exception e) {
						e.printStackTrace(System.out);
					}
//					world.setBlockMetadataWithNotify(posX + xnum, posY + ynum, posZ + znum, blocks[i], datablocks[i]);
				}
				
				if(xnum < width - 1) {
					xnum++;
				} else if((xnum >= width - 1) && (znum < length - 1)) {
					xnum = 0;
					znum++;
				} else if((xnum >= width - 1) && (znum >= length - 1) && (ynum < height - 1)) {
					xnum = 0;
					znum = 0;
					ynum++;
				}	
			}
			
			int chunkX = ((int) Math.floor((posX + xnum) / 16)) * 16;
			int chunkZ = ((int) Math.floor((posZ + znum) / 16)) * 16;
			
			Chunk chunk = world.getChunkFromChunkCoords(chunkX, chunkZ);
			
			NBTTagList var14 = nbtTagCompound.getTagList("Entities", 10); // BOBHO 10 = NBTTagCompount as specified in NBTBase
			if(var14 != null) {
				for(int var17 = 0; var17 < var14.tagCount(); ++var17) {
					NBTTagCompound var16 = var14.getCompoundTagAt(var17);
					Entity var18 = EntityList.createEntityFromNBT(var16, world);
					chunk.hasEntities = true;

					if(var18 != null) {
						chunk.addEntity(var18);
					}
				}
			}

			NBTTagList var15 = nbtTagCompound.getTagList("TileEntities", 10);
			if(var15 != null) {
				for(int var21 = 0; var21 < var15.tagCount(); ++var21) {
					NBTTagCompound var20 = var15.getCompoundTagAt(var21);
					TileEntity var13 = TileEntity.createAndLoadEntity(var20);

					if(var13 != null) {
						chunk.addTileEntity(var13);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}