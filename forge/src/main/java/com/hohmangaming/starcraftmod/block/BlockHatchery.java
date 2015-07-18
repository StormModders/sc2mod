package com.hohmangaming.starcraftmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockHatchery extends Block {

	public BlockHatchery() {
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockTextureName("starcraftmod:mineral");
    	this.setHardness(2.5F);
    	this.setResistance(180000.0F);
    	this.setStepSound(Block.soundTypeStone);
    	this.setBlockName("blockHatchery");
	}

}
