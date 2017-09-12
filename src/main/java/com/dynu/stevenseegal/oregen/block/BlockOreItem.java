package com.dynu.stevenseegal.oregen.block;

import com.dynu.stevenseegal.oregen.init.ModBlocks;
import com.dynu.stevenseegal.oregen.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockOreItem extends BlockOre
{
    public BlockOreItem(String name, float hardness, float resistance)
    {
        super(name, hardness, resistance);
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        return true;
    }

    @Override
    public int quantityDropped(Random random)
    {
        if (this == ModBlocks.SULFUR_ORE)
        {
            return 3;
        }
        else if (this == ModBlocks.SALTPETER_ORE)
        {
            return 2;
        }
        return 1;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0)
        {
            int i = random.nextInt(fortune + 2) - 1;
            if (i < 0)
            {
                i = 0;
            }
            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if (this == ModBlocks.SULFUR_ORE)
        {
            return ModItems.SULFUR_DUST;
        }
        else if (this == ModBlocks.SALTPETER_ORE)
        {
            return ModItems.SALTPETER_DUST;
        }
        else
        {
            return Item.getItemFromBlock(this);
        }
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = 0;
            if (this == ModBlocks.SULFUR_ORE)
            {
                i = MathHelper.getInt(rand, 0, 2);
            }
            else if (this == ModBlocks.SALTPETER_ORE)
            {
                i = MathHelper.getInt(rand, 1, 5);
            }
            return i;
        }
        return 0;
    }
}
