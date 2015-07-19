package com.hohmangaming.starcraftmod.block;

import com.hohmangaming.starcraftmod.StarcraftMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockVespene extends BlockFluidClassic {

	 protected IIcon[] icons;
	 
	public BlockVespene() {
		super(StarcraftMod.fluidVespene, StarcraftMod.materialVespene);
		setHardness(100.0F);
		setLightOpacity(3);
		disableStats();
    	this.setBlockName("blockVespene");
		this.setBlockTextureName(StarcraftMod.ASSET_PREFIX + "vespene_still");
        this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		icons = new IIcon[] {
				iconRegister.registerIcon(StarcraftMod.ASSET_PREFIX + "vespene_still"),
                iconRegister.registerIcon(StarcraftMod.ASSET_PREFIX + "vespene_flow")
		};
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ != 0 && p_149691_1_ != 1 ? this.icons[1] : this.icons[0];
    }

}
