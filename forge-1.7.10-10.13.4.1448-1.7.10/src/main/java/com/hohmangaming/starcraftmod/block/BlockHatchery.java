package com.hohmangaming.starcraftmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import elliott.starcraftmod.Ids;
import elliott.starcraftmod.StarcraftMod;

public class BlockHatchery extends Block {

	public static int BLOCKID = Ids.BLOCKID_HATCHERY;
	
	public BlockHatchery() {
		super(BLOCKID, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setTextureName("starcraftmod:mineral");
    	this.setHardness(2.5F);
    	this.setResistance(180000.0F);
    	this.setStepSound(Block.soundStoneFootstep);
    	this.setUnlocalizedName("blockHatchery");
	}

}
