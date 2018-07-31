package com.dynu.stevenseegal.oregen.util;

import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.google.common.base.Charsets;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.io.PrintWriter;

public class OreDictUtils
{
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
        int MAX_BLOCK_META = 16;
        int MAX_QUARTZ_META = 4;

        OreDictionary.registerOre(LibNames.OreDict.Vanilla.HARDENED_CLAY_BLOCK, Blocks.HARDENED_CLAY);

        for (int i = 0; i < MAX_BLOCK_META ; i++)
        {
            OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, new ItemStack(Blocks.WOOL, 1, i));
        }

        for (int i = 0; i < MAX_BLOCK_META; i++)
        {
            OreDictionary.registerOre(LibNames.OreDict.Vanilla.HARDENED_CLAY_BLOCK, new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, i));
        }

        for (int i = 0; i < MAX_QUARTZ_META; i++)
        {
            OreDictionary.registerOre(LibNames.OreDict.Vanilla.QUARTZ_BLOCK, new ItemStack(Blocks.QUARTZ_BLOCK, 1, i));
        }
    }
}