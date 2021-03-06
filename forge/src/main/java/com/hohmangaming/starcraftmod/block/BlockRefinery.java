package com.hohmangaming.starcraftmod.block;

import com.hohmangaming.starcraftmod.StarcraftMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

/**
 * GCCoreBlockRefinery.java
 * 
 * This file is part of the Galacticraft project
 * 
 * @author micdoodle8
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockRefinery extends Block
{
	private IIcon iconFront;
	private IIcon iconBack;
	private IIcon iconTop;
	private IIcon iconSide;

	public BlockRefinery()
	{
		super(Material.rock);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockTextureName(StarcraftMod.ASSET_PREFIX + "refinery");
		this.setBlockName("blockRefinery");
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IIconRegister)
	{
		this.iconFront = par1IIconRegister.registerIcon(StarcraftMod.ASSET_PREFIX + "refinery_front");
		this.iconBack = par1IIconRegister.registerIcon(StarcraftMod.ASSET_PREFIX + "refinery_back");
		this.iconTop = par1IIconRegister.registerIcon(StarcraftMod.ASSET_PREFIX + "refinery_top");
		this.iconSide = par1IIconRegister.registerIcon(StarcraftMod.ASSET_PREFIX + "refinery_side");
	}
//
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
//	{
//		final TileEntity te = par1World.getBlockTileEntity(par2, par3, par4);
//
//		if (te instanceof GCCoreTileEntityRefinery)
//		{
//			final GCCoreTileEntityRefinery refinery = (GCCoreTileEntityRefinery) te;
//
//			if (refinery.processTicks > 0)
//			{
//				par1World.getBlockMetadata(par2, par3, par4);
//				final float var7 = par2 + 0.5F;
//				final float var8 = par3 + 1.1F;
//				final float var9 = par4 + 0.5F;
//				final float var10 = 0.0F;
//				final float var11 = 0.0F;
//
//				for (int i = -1; i <= 1; i++)
//				{
//					for (int j = -1; j <= 1; j++)
//					{
//						par1World.spawnParticle("smoke", var7 + var11 + i * 0.2, var8, var9 + var10 + j * 0.2, 0.0D, 0.01D, 0.0D);
//						par1World.spawnParticle("flame", var7 + var11 + i * 0.1, var8 - 0.2, var9 + var10 + j * 0.1, 0.0D, 0.0001D, 0.0D);
//					}
//				}
//			}
//		}
//	}
//
//	@Override
//	public boolean onMachineActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
//	{
//		entityPlayer.openGui(GalacticraftCore.instance, -1, world, x, y, z);
//		return true;
//	}
//
//	@Override
//	public boolean onUseWrench(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int side, float hitX, float hitY, float hitZ)
//	{
//		final int metadata = par1World.getBlockMetadata(x, y, z);
//		final int original = metadata;
//
//		int change = 0;
//
//		// Re-orient the block
//		switch (original)
//		{
//		case 0:
//			change = 3;
//			break;
//		case 1:
//			change = 1;
//			break;
//		case 2:
//			change = 2;
//			break;
//		case 3:
//			change = 0;
//			break;
//		}
//
//		par1World.setBlockMetadataWithNotify(x, y, z, change, 3);
//		return true;
//	}
//
//	@Override
//	public TileEntity createTileEntity(World world, int metadata)
//	{
//		return new GCCoreTileEntityRefinery();
//	}
//
//	@Override
//	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
//	{
//		final GCCoreTileEntityRefinery var7 = (GCCoreTileEntityRefinery) par1World.getBlockTileEntity(par2, par3, par4);
//
//		if (var7 != null)
//		{
//			for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
//			{
//				final ItemStack var9 = var7.getStackInSlot(var8);
//
//				if (var9 != null)
//				{
//					final float var10 = this.refineryRand.nextFloat() * 0.8F + 0.1F;
//					final float var11 = this.refineryRand.nextFloat() * 0.8F + 0.1F;
//					final float var12 = this.refineryRand.nextFloat() * 0.8F + 0.1F;
//
//					while (var9.stackSize > 0)
//					{
//						int var13 = this.refineryRand.nextInt(21) + 10;
//
//						if (var13 > var9.stackSize)
//						{
//							var13 = var9.stackSize;
//						}
//
//						var9.stackSize -= var13;
//						final EntityItem var14 = new EntityItem(par1World, par2 + var10, par3 + var11, par4 + var12, new ItemStack(var9.itemID, var13, var9.getItemDamage()));
//
//						if (var9.hasTagCompound())
//						{
//							var14.getEntityItem().setTagCompound((NBTTagCompound) var9.getTagCompound().copy());
//						}
//
//						final float var15 = 0.05F;
//						var14.motionX = (float) this.refineryRand.nextGaussian() * var15;
//						var14.motionY = (float) this.refineryRand.nextGaussian() * var15 + 0.2F;
//						var14.motionZ = (float) this.refineryRand.nextGaussian() * var15;
//						par1World.spawnEntityInWorld(var14);
//					}
//				}
//			}
//		}
//
//		super.breakBlock(par1World, par2, par3, par4, par5, par6);
//	}

	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 1 || side == 0)
		{
			return this.iconTop; // and bottom
		}
		
		if (side == 2)
			return this.iconBack;
		
		if (side == 3)
			return this.iconFront;
		return this.iconSide;
	}

//	@Override
//	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack)
//	{
//		final int angle = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
//		int change = 0;
//
//		switch (angle)
//		{
//		case 0:
//			change = 3;
//			break;
//		case 1:
//			change = 1;
//			break;
//		case 2:
//			change = 2;
//			break;
//		case 3:
//			change = 0;
//			break;
//		}
//
//		world.setBlockMetadataWithNotify(x, y, z, change, 3);
//	}
}
