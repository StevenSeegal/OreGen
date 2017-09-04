package com.dynu.stevenseegal.oregen.item;

import com.dynu.stevenseegal.oregen.OreGen;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ItemBase extends Item
{
    public ItemBase(String name)
    {
        setUnlocalizedName(LibMod.MOD_ID + "." + name);
        setRegistryName(name);

        setCreativeTab(OreGen.creativeTab);
    }

    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
