package com.dynu.stevenseegal.oregen.block;

import com.dynu.stevenseegal.oregen.OreGen;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBase extends Block
{
    public BlockBase(String name, float hardness, float resistance, String toolType, int harvestLevel)
    {
        super(Material.ROCK);

        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(toolType, harvestLevel);
        setSoundType(SoundType.STONE);

        setUnlocalizedName(LibMod.MOD_ID + "." + name);
        setRegistryName(name);

        setCreativeTab(OreGen.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
