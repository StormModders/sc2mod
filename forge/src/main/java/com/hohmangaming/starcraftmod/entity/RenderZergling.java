package com.hohmangaming.starcraftmod.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderZergling extends RenderLiving {
	
    private static final ResourceLocation zerglingTextures = new ResourceLocation("textures/entity/chicken.png");

    public RenderZergling(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderZergling(EntityZergling entityZergling, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(entityZergling, par2, par4, par6, par8, par9);
    }

    protected float getWingRotation(EntityZergling par1EntityZergling, float par2)
    {
    	return 0; // BOBHO TODO - handle the animation of zergling
//        float f1 = par1EntityZergling.field_70888_h + (par1EntityZergling.field_70886_e - par1EntityZergling.field_70888_h) * p_77044_2_;
//        float f2 = par1EntityZergling.field_70884_g + (par1EntityZergling.destPos - par1EntityZergling.field_70884_g) * p_77044_2_;
//        return (MathHelper.sin(f1) + 1.0F) * f2;
//
//    	// this came from 
//        float f1 = par1EntityZergling.field_70888_h + (par1EntityZergling.field_70886_e - par1EntityZergling.field_70888_h) * par2;
//        float f2 = par1EntityZergling.field_70884_g + (par1EntityZergling.destPos - par1EntityZergling.field_70884_g) * par2;
//        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderZergling((EntityZergling)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityLivingBase par1EntityLivingBase, float par2)
    {
        return this.getWingRotation((EntityZergling)par1EntityLivingBase, par2);
    }

    public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderZergling((EntityZergling)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return zerglingTextures;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderZergling((EntityZergling)par1Entity, par2, par4, par6, par8, par9);
    }

}
