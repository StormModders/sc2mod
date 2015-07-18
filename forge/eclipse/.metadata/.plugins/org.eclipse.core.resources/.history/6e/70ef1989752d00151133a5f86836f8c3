package com.hohmangaming.starcraftmod.block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class StarcraftModelBasedTileEntitySpecialRenderer extends TileEntitySpecialRenderer{

	private IModelCustom model;
	private ResourceLocation texture;

	public StarcraftModelBasedTileEntitySpecialRenderer(String modelFileName, String textureFileName){
		model = AdvancedModelLoader.loadModel("/assets/starcraftmod/models/" + modelFileName);
		texture = new ResourceLocation("starcraftmod", "textures/models/" + textureFileName);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f){
		
		float scaleFactor = ((StarcraftModelBasedTileEntity)tileEntity).getScaleFactor();
		
		GL11.glPushMatrix();
		GL11.glTranslated(x, y+1.0, z);
		GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
 		model.renderAll();
		GL11.glPopMatrix();
	}
}
