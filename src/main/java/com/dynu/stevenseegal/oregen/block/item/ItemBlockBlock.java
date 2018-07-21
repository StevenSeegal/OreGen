package com.dynu.stevenseegal.oregen.block.item;

import com.dynu.stevenseegal.oregen.block.BlockBlock;
import com.dynu.stevenseegal.oregen.util.RarityHelper;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBlock extends ItemBlock
{
    public ItemBlockBlock(Block block)
    {
        super(block);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setNoRepair();
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return "tile.oregen.block." + BlockBlock.BlockType.byMetaData(stack.getMetadata()).getName();
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return RarityHelper.getRarityFor(BlockBlock.BlockType.byMetaData(stack.getMetadata()).getName());
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }
}
