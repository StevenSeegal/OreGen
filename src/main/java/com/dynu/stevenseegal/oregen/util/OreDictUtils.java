package com.dynu.stevenseegal.oregen.util;

import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.google.common.base.Charsets;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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

        OreDictionary.registerOre(LibNames.OreDict.Vanilla.COAL, Items.COAL);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.BLAZE_ROD, Items.BLAZE_ROD);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.CLAY_BLOCK, Blocks.CLAY);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.BRICKS_BLOCK, Blocks.BRICK_BLOCK);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.NETHERBRICKS_BLOCK, Blocks.NETHER_BRICK);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.HARDENED_CLAY_BLOCK, Blocks.HARDENED_CLAY);

        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_DANDELION, Blocks.YELLOW_FLOWER);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_POPPY, new ItemStack(Blocks.RED_FLOWER, 1, 0));
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_BLUE_ORCHID, new ItemStack(Blocks.RED_FLOWER, 1, 1));
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_ALLIUM, new ItemStack(Blocks.RED_FLOWER, 1, 2));
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_AZURE_BLUET, new ItemStack(Blocks.RED_FLOWER, 1, 3));
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_TULIP_RED, new ItemStack(Blocks.RED_FLOWER, 1, 4));
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_TULIP_ORANGE, new ItemStack(Blocks.RED_FLOWER, 1, 5));
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_TULIP_WHITE, new ItemStack(Blocks.RED_FLOWER, 1, 6));
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_TULIP_PINK, new ItemStack(Blocks.RED_FLOWER, 1, 7));
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_OXEYE_DAISY, new ItemStack(Blocks.RED_FLOWER, 1, 8));

        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_SUNFLOWER, new ItemStack(Blocks.DOUBLE_PLANT, 1, 0));
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_LILAC, new ItemStack(Blocks.DOUBLE_PLANT, 1, 1));
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_ROSE_BUSH, new ItemStack(Blocks.DOUBLE_PLANT, 1, 4));
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.FLOWER_PEONY, new ItemStack(Blocks.DOUBLE_PLANT, 1, 5));

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