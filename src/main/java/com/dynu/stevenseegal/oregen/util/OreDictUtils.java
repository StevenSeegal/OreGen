package com.dynu.stevenseegal.oregen.util;

import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.google.common.base.Charsets;
import net.minecraft.init.Items;
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
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.COAL, Items.COAL);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.BLAZE_ROD, Items.BLAZE_ROD);
    }
}