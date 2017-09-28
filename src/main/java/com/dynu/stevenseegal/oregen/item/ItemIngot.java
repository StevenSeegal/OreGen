package com.dynu.stevenseegal.oregen.item;

import com.dynu.stevenseegal.oregen.lib.LibNames;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemIngot extends ItemBaseMulti
{
    public ItemIngot(String name, String... subNames)
    {
        super(name, subNames);
    }

    @Override
    public void registerToOreDict()
    {
        OreDictionary.registerOre(LibNames.OreDict.Items.COPPER_INGOT, new ItemStack(this, 1, 0));
        OreDictionary.registerOre(LibNames.OreDict.Items.TIN_INGOT, new ItemStack(this, 1, 1));
        OreDictionary.registerOre(LibNames.OreDict.Items.SILVER_INGOT, new ItemStack(this, 1, 2));
        OreDictionary.registerOre(LibNames.OreDict.Items.LEAD_INGOT, new ItemStack(this, 1, 3));
        OreDictionary.registerOre(LibNames.OreDict.Items.ALUMINUM_INGOT, new ItemStack(this, 1, 4));
        OreDictionary.registerOre(LibNames.OreDict.Items.NICKEL_INGOT, new ItemStack(this, 1, 5));
        OreDictionary.registerOre(LibNames.OreDict.Items.BRONZE_INGOT, new ItemStack(this, 1, 6));
        OreDictionary.registerOre(LibNames.OreDict.Items.STEEL_INGOT, new ItemStack(this, 1, 7));
        OreDictionary.registerOre(LibNames.OreDict.Items.URANIUM_INGOT, new ItemStack(this, 1, 8));
        OreDictionary.registerOre(LibNames.OreDict.Items.PLATINUM_INGOT, new ItemStack(this, 1, 9));
    }
}
