package com.hohmangaming.starcraftmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.Fluid;
import buildcraft.energy.BlockBuildcraftFluid;

public class BlockStarcraftModFluid extends BlockBuildcraftFluid {

	public BlockStarcraftModFluid(int id, Fluid fluid, Material material) {
		super(id, fluid, material);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.theIcon = new Icon[] { iconRegister.registerIcon("starcraftmod:" + fluidName + "_still"), iconRegister.registerIcon("starcraftmod:" + fluidName + "_flow") };
	}

}