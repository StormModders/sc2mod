package com.hohmangaming.starcraftmod.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;

public class MaterialVespene extends MaterialLiquid {

	public MaterialVespene() {
		super(MapColor.greenColor);
		this.setReplaceable();
		this.setNoPushMobility();
	}
}
