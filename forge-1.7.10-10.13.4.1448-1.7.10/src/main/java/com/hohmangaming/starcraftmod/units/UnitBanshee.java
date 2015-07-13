package com.hohmangaming.starcraftmod.units;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import elliott.starcraftmod.Ids;
import elliott.starcraftmod.block.StarcraftModelBasedBlock;
import elliott.starcraftmod.block.StarcraftModelBasedTileEntity;

public class UnitBanshee extends StarcraftModelBasedBlock {

	public class UnitBansheeTileEntity extends StarcraftModelBasedTileEntity {
		public UnitBansheeTileEntity() {
			super(4.0f);  // scale factor
		}
	}

	public UnitBanshee() {
		super(Ids.BLOCKID_UNIT_BANSHEE, Material.anvil, CreativeTabs.tabBlock);
    	setUnlocalizedName("banshee");
		this.setTextureName("starcraftmod:banshee");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new UnitBansheeTileEntity();
	}
}
