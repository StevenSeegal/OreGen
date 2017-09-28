package com.dynu.stevenseegal.oregen.util;

import com.dynu.stevenseegal.oregen.block.BlockBlock;
import com.dynu.stevenseegal.oregen.block.BlockOre;
import com.dynu.stevenseegal.oregen.item.ItemDust;
import com.dynu.stevenseegal.oregen.item.ItemIngot;
import com.dynu.stevenseegal.oregen.item.ItemNugget;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.google.common.base.Charsets;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import java.io.PrintWriter;

public class OreDictUtils
{
    public static String getBlockOredictName(Block block, String registryName)
    {
        String returnString = null;
        if (block instanceof BlockOre)
        {
            String str = getFormattedOredictName(registryName, "ore", 3);
            if (str != null)
            {
                returnString = str;
            }
        }
        else if (block instanceof BlockBlock)
        {
            String str = getFormattedOredictName(registryName, "block", 5);
            if (str != null)
            {
                returnString = str;
            }
        }
        return returnString;
    }

    public static String getItemOredictName(Item item, String registryName)
    {
        String returnString = null;
        if (item instanceof ItemIngot)
        {
            String str = getFormattedOredictName(item.getRegistryName().toString(), "ingot", 5);
            if (str != null)
            {
                returnString = str;
            }
        }
        else if (item instanceof ItemNugget)
        {
            String str = getFormattedOredictName(item.getRegistryName().toString(), "nugget", 6);
            if (str != null)
            {
                returnString = str;
            }
        }
        else if (item instanceof ItemDust)
        {
            String str = getFormattedOredictName(item.getRegistryName().toString(), "dust", 4);
            if (str != null)
            {
                returnString = str;
            }
        }
        return returnString;
    }

    private static String getFormattedOredictName(String registryName, String prefix, int delimiter)
    {
        String returnStr = null;
        if (StringUtils.stripModName(registryName) != null)
        {
            String modStrippedName = StringUtils.stripModName(registryName);
            String itemName = StringUtils.stripPrefix(modStrippedName, delimiter);
            if (itemName != null && itemName.length() >= 1)
            {
                String formattedName = prefix + StringUtils.toUpperCase(itemName);
                returnStr = formattedName;
            }
        }
        return returnStr;
    }

    public static void exportOreDictEntries()
    {
        try
        {
            PrintWriter writer = new PrintWriter("OredictDump.txt", Charsets.UTF_8.toString());
            String[] oreDictEntries = OreDictionary.getOreNames();
            for (String oreDictName : oreDictEntries)
            {
                writer.println(oreDictName);
            }
            writer.close();
        }
        catch (Exception e)
        {
            LogHelper.error("Error dumping OreDictEntries: " + e);
        }
    }

    public static void registerExtraVanillaItems()
    {
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.COAL, Items.COAL);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.BLAZE_ROD, Items.BLAZE_ROD);
    }
}