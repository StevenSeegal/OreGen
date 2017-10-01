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
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.COAL, Items.COAL);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.BLAZE_ROD, Items.BLAZE_ROD);

        ItemStack blockWoolWhite = new ItemStack(Blocks.WOOL, 1, 0);
        ItemStack blockWoolOrange = new ItemStack(Blocks.WOOL, 1, 1);
        ItemStack blockWoolMagenta = new ItemStack(Blocks.WOOL, 1, 2);
        ItemStack blockWoolLightBlue = new ItemStack(Blocks.WOOL, 1, 3);
        ItemStack blockWoolYellow = new ItemStack(Blocks.WOOL, 1, 4);
        ItemStack blockWoolLime = new ItemStack(Blocks.WOOL, 1, 5);
        ItemStack blockWoolPink = new ItemStack(Blocks.WOOL, 1, 6);
        ItemStack blockWoolGray = new ItemStack(Blocks.WOOL, 1, 7);
        ItemStack blockWoolLightGray = new ItemStack(Blocks.WOOL, 1, 8);
        ItemStack blockWoolCyan = new ItemStack(Blocks.WOOL, 1, 9);
        ItemStack blockWoolPurple = new ItemStack(Blocks.WOOL, 1, 10);
        ItemStack blockWoolBlue = new ItemStack(Blocks.WOOL, 1, 11);
        ItemStack blockWoolBrown = new ItemStack(Blocks.WOOL, 1, 12);
        ItemStack blockWoolGreen = new ItemStack(Blocks.WOOL, 1, 13);
        ItemStack blockWoolRed = new ItemStack(Blocks.WOOL, 1, 14);
        ItemStack blockWoolBlack = new ItemStack(Blocks.WOOL, 1, 15);

        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_WHITE, blockWoolWhite);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_ORANGE, blockWoolOrange);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_MAGENTA, blockWoolMagenta);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_LIGHT_BLUE, blockWoolLightBlue);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_YELLOW, blockWoolYellow);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_LIME, blockWoolLime);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_PINK, blockWoolPink);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_GRAY, blockWoolGray);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_LIGHT_GREY, blockWoolLightGray);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_CYAN, blockWoolCyan);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_PURPLE, blockWoolPurple);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_BLUE, blockWoolBlue);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_BROWN, blockWoolBrown);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_GREEN, blockWoolGreen);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_RED, blockWoolRed);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL_BLACK, blockWoolBlack);

        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolWhite);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolOrange);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolMagenta);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolLightBlue);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolYellow);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolLime);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolPink);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolGray);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolLightGray);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolCyan);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolPurple);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolBlue);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolBrown);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolGreen);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolRed);
        OreDictionary.registerOre(LibNames.OreDict.Vanilla.WOOL, blockWoolBlack);
    }
}