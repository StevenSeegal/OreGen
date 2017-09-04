package com.dynu.stevenseegal.oregen.block;

import com.dynu.stevenseegal.oregen.OreGen;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBase extends Block
{
    public BlockBase(Material blockMaterialIn, MapColor blockMapColorIn)
    {
        super(blockMaterialIn, blockMapColorIn);
    }

    public BlockBase(String name)
    {
        super(Material.ROCK);
        setUnlocalizedName(LibMod.MOD_ID + "." + name);
        setRegistryName(name);
        setSoundType(SoundType.STONE);

        setCreativeTab(OreGen.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
