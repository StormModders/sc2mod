package com.hohmangaming.starcraftmod;

import com.hohmangaming.starcraftmod.block.StarcraftModelBasedTileEntitySpecialRenderer;
import com.hohmangaming.starcraftmod.entity.EntityZergling;
import com.hohmangaming.starcraftmod.entity.RenderZergling;
import com.hohmangaming.starcraftmod.units.ModelZergling;
import com.hohmangaming.starcraftmod.units.UnitBanshee;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy {
       
        @Override
        public void registerRenderers() {
        	ClientRegistry.bindTileEntitySpecialRenderer(
        			UnitBanshee.UnitBansheeTileEntity.class, 
        			new StarcraftModelBasedTileEntitySpecialRenderer("banshee.obj", "banshee_diffuse.png"));
        	
            RenderingRegistry.registerEntityRenderingHandler(EntityZergling.class, new RenderZergling(new ModelZergling(), 0.5F));
          //the 0.5F is the shadowsize
        }
}

