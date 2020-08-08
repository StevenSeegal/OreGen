package com.dynu.stevenseegal.oregen.item;

import com.dynu.stevenseegal.oregen.lib.LibNames;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemDust extends ItemBaseMulti
{
    public ItemDust(String name, String... subNames)
    {
        super(name, subNames);
    }

    @Override
    public void registerToOreDict()
    {
        OreDictionary.registerOre(LibNames.OreDict.Items.COPPER_DUST, new ItemStack(this, 1, 0));
        OreDictionary.registerOre(LibNames.OreDict.Items.TIN_DUST, new ItemStack(this, 1, 1));
        OreDictionary.registerOre(LibNames.OreDict.Items.SILVER_DUST, new ItemStack(this, 1, 2));
        OreDictionary.registerOre(LibNames.OreDict.Items.LEAD_DUST, new ItemStack(this, 1, 3));
        OreDictionary.registerOre(LibNames.OreDict.Items.ALUMINUM_DUST, new ItemStack(this, 1, 4));
        OreDictionary.registerOre(LibNames.OreDict.Items.NICKEL_DUST, new ItemStack(this, 1, 5));
        OreDictionary.registerOre(LibNames.OreDict.Items.BRONZE_DUST, new ItemStack(this, 1, 6));
        OreDictionary.registerOre(LibNames.OreDict.Items.STEEL_DUST, new ItemStack(this, 1, 7));
        OreDictionary.registerOre(LibNames.OreDict.Items.URANIUM_DUST, new ItemStack(this, 1, 8));
        OreDictionary.registerOre(LibNames.OreDict.Items.PLATINUM_DUST, new ItemStack(this, 1, 9));
        OreDictionary.registerOre(LibNames.OreDict.Items.SULFUR_DUST, new ItemStack(this, 1, 10));
        OreDictionary.registerOre(LibNames.OreDict.Items.SALTPETER_DUST, new ItemStack(this, 1, 11));
        OreDictionary.registerOre(LibNames.OreDict.Items.COAL_DUST, new ItemStack(this, 1, 12));
        OreDictionary.registerOre(LibNames.OreDict.Items.IRON_DUST, new ItemStack(this, 1, 13));
        OreDictionary.registerOre(LibNames.OreDict.Items.GOLD_DUST, new ItemStack(this, 1, 14));
        OreDictionary.registerOre(LibNames.OreDict.Items.DIAMOND_DUST, new ItemStack(this, 1, 15));
        OreDictionary.registerOre(LibNames.OreDict.Items.IRIDIUM_DUST, new ItemStack(this, 1, 16));
        OreDictionary.registerOre(LibNames.OreDict.Items.MITHRIL_DUST, new ItemStack(this, 1, 17));
        OreDictionary.registerOre(LibNames.OreDict.Items.NTH_DUST, new ItemStack(this, 1, 18));
        OreDictionary.registerOre(LibNames.OreDict.Items.URU_DUST, new ItemStack(this, 1, 19));
        OreDictionary.registerOre(LibNames.OreDict.Items.THORIUM_DUST, new ItemStack(this, 1, 20));
        OreDictionary.registerOre(LibNames.OreDict.Items.ZINC_DUST, new ItemStack(this, 1, 21));
    }
}
