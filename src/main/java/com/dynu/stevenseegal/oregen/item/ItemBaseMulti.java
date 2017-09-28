package com.dynu.stevenseegal.oregen.item;

import com.dynu.stevenseegal.oregen.OreGen;
import com.dynu.stevenseegal.oregen.init.IItemRegistryHandler;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBaseMulti extends Item implements IItemRegistryHandler
{
    protected String[] subNames;
    private String name;

    public ItemBaseMulti(String name, String... subNames)
    {
        this.setUnlocalizedName(LibMod.MOD_ID + "." + name);
        this.subNames = subNames;
        this.name = name;

        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setCreativeTab(OreGen.creativeTab);
    }

    public String[] getSubNames()
    {
        return this.subNames;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        if (getSubNames() != null)
        {
            if (stack.getItemDamage() < getSubNames().length)
            {
                return this.getUnlocalizedName() + "." + getSubNames()[stack.getItemDamage()];
            }
        }
        return this.getUnlocalizedName();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            if (getSubNames() != null)
            {
                for (int i = 0; i < getSubNames().length; i++)
                {
                    items.add(new ItemStack(this, 1, i));
                }
            }
            else
            {
                items.add(new ItemStack(this));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initModel()
    {
        for (int i = 0; i < getSubNames().length; i++)
        {
            ResourceLocation resourceLocation = new ResourceLocation(LibMod.MOD_ID, this.name + "/" + getSubNames()[i]);
            ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(resourceLocation, "inventory"));
        }
    }

    @Override
    public void registerToOreDict()
    {
    }
}
