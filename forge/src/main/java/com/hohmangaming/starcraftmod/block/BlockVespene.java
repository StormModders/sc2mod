package com.hohmangaming.starcraftmod.block;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockVespene extends BlockLiquid {

	public BlockVespene() {
		super(Material.water);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    	this.setBlockName("blockVespene");
		this.setBlockTextureName("starcraftmod:vespene_still");
	}
}
