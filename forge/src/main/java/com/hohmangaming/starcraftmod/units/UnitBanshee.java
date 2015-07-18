package com.hohmangaming.starcraftmod.units;

import com.hohmangaming.starcraftmod.block.StarcraftModelBasedBlock;
import com.hohmangaming.starcraftmod.block.StarcraftModelBasedTileEntity;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class UnitBanshee extends StarcraftModelBasedBlock {

	public class UnitBansheeTileEntity extends StarcraftModelBasedTileEntity {
		public UnitBansheeTileEntity() {
			super(4.0f);  // scale factor
		}
	}

	public UnitBanshee() {
		super(Material.anvil, CreativeTabs.tabBlock);
    	setBlockName("banshee");
		this.setBlockTextureName("starcraftmod:banshee");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new UnitBansheeTileEntity();
	}
}
