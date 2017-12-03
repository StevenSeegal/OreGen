package com.dynu.stevenseegal.oregen.item;

import com.dynu.stevenseegal.oregen.lib.LibNames;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemNugget extends ItemBaseMulti
{
    public ItemNugget(String name, String... subNames)
    {
        super(name, subNames);
    }

    @Override
    public void registerToOreDict()
    {
        OreDictionary.registerOre(LibNames.OreDict.Items.COPPER_NUGGET, new ItemStack(this, 1, 0));
        OreDictionary.registerOre(LibNames.OreDict.Items.TIN_NUGGET, new ItemStack(this, 1, 1));
        OreDictionary.registerOre(LibNames.OreDict.Items.SILVER_NUGGET, new ItemStack(this, 1, 2));
        OreDictionary.registerOre(LibNames.OreDict.Items.LEAD_NUGGET, new ItemStack(this, 1, 3));
        OreDictionary.registerOre(LibNames.OreDict.Items.ALUMINUM_NUGGET, new ItemStack(this, 1, 4));
        OreDictionary.registerOre(LibNames.OreDict.Items.NICKEL_NUGGET, new ItemStack(this, 1, 5));
        OreDictionary.registerOre(LibNames.OreDict.Items.BRONZE_NUGGET, new ItemStack(this, 1, 6));
        OreDictionary.registerOre(LibNames.OreDict.Items.STEEL_NUGGET, new ItemStack(this, 1, 7));
        OreDictionary.registerOre(LibNames.OreDict.Items.URANIUM_NUGGET, new ItemStack(this, 1, 8));
        OreDictionary.registerOre(LibNames.OreDict.Items.PLATINUM_NUGGET, new ItemStack(this, 1, 9));
        OreDictionary.registerOre(LibNames.OreDict.Items.IRIDIUM_NUGGET, new ItemStack(this, 1, 10));
        OreDictionary.registerOre(LibNames.OreDict.Items.MITHRIL_NUGGET, new ItemStack(this, 1, 11));
        OreDictionary.registerOre(LibNames.OreDict.Items.NTH_NUGGET, new ItemStack(this, 1, 12));
        OreDictionary.registerOre(LibNames.OreDict.Items.URU_NUGGET, new ItemStack(this, 1, 13));
        OreDictionary.registerOre(LibNames.OreDict.Items.THORIUM_NUGGET, new ItemStack(this, 1, 14));
    }
}
