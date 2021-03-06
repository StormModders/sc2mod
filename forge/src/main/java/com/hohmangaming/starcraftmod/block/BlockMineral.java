package com.hohmangaming.starcraftmod.block;

import java.util.Random;

import com.hohmangaming.starcraftmod.StarcraftMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMineral extends Block {

	public BlockMineral() {
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockTextureName("starcraftmod:mineral");
    	this.setHardness(2.5F);
    	this.setResistance(180000.0F);
    	this.setStepSound(Block.soundTypeStone);
    	this.setBlockName("blockMineral");
	}

    /**
     * Returns the quantity of items to drop on block destruction.
     */
	@Override
    public int quantityDropped(Random par1Random)
    {
        return 3;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
	@Override
    public int quantityDroppedWithBonus(int i, Random par2Random)
    {
        if (i > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, par2Random, i))  //BOBHO TODO - I think I need to override getItemDropped to return the mineral item
        {
            int j = par2Random.nextInt(i + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(par2Random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(par2Random);
        }
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
	@Override
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        this.dropXpOnBlockBreak(par1World, par2, par3, par4, MathHelper.getRandomIntegerInRange(par1World.rand, 0, 2));
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
	@Override
    public int damageDropped(int par1)
    {
        return 0;
    }

}
