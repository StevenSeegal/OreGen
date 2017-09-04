package com.dynu.stevenseegal.oregen.block;

public class BlockOre extends BlockBase
{
    public BlockOre(String name, Float hardness, String toolType, int harvestLevel)
    {
        super(name);
        setHardness(hardness);
        setHarvestLevel(toolType, harvestLevel);
    }
}
