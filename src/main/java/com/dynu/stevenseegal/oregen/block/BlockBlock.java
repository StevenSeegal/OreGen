package com.dynu.stevenseegal.oregen.block;

public class BlockBlock extends BlockBase
{
    public BlockBlock(String name, Float hardness, String toolType, int harvestLevel)
    {
        super(name);
        setHardness(hardness);
        setHarvestLevel(toolType, harvestLevel);
    }
}
