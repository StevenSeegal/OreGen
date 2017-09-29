package com.dynu.stevenseegal.oregen.block.item;

import com.dynu.stevenseegal.oregen.block.BlockOre;
import com.dynu.stevenseegal.oregen.util.RarityHelper;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends ItemBlock
{
    public ItemBlockOre(Block block)
    {
        super(block);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setNoRepair();
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return "tile.oregen.ore." + BlockOre.OreType.byMetaData(stack.getMetadata()).getName();
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return RarityHelper.getRarityFor(BlockOre.OreType.byMetaData(stack.getMetadata()).getName());
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }
}
