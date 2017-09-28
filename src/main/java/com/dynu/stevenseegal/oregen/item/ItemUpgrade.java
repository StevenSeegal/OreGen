package com.dynu.stevenseegal.oregen.item;

import com.dynu.stevenseegal.oregen.OreGen;
import com.dynu.stevenseegal.oregen.init.IItemRegistryHandler;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemUpgrade extends Item implements IItemRegistryHandler
{
    public ItemUpgrade(String name)
    {
        setUnlocalizedName(LibMod.MOD_ID + "." + name);
        setMaxStackSize(0);

        setCreativeTab(OreGen.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void registerToOreDict()
    {
    }
}
