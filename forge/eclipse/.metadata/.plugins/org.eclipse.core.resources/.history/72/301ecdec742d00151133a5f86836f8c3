package com.hohmangaming.starcraftmod.block;

import elliott.extraweaponsmod.StarGateTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class StarcraftModelBasedBlock extends Block implements ITileEntityProvider {

	public StarcraftModelBasedBlock(int i, Material m, CreativeTabs tab)
	{
		super(i, m);
		this.setCreativeTab(tab);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
    {
    	return false;
    }

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

    abstract public TileEntity createNewTileEntity(World world);
}
