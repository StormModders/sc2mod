package com.hohmangaming.starcraftmod.block;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class StarcraftModelBasedTileEntity extends TileEntity {
	
	protected float scaleFactor = 1;
	
	public StarcraftModelBasedTileEntity(float scaleFactor) {
		this.scaleFactor = scaleFactor;
	}
	
	public float getScaleFactor() {
		return scaleFactor;
	}

	public void setScaleFactor(float scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
		super.writeToNBT(par1);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
		super.readFromNBT(par1);
	}

}
