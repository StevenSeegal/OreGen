package com.dynu.stevenseegal.oregen.config;

import com.dynu.stevenseegal.oregen.block.BlockOre;
import com.dynu.stevenseegal.oregen.lib.LibCrusherRecipes;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.dynu.stevenseegal.oregen.proxy.ServerProxy;
import com.dynu.stevenseegal.oregen.util.LogHelper;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Config
{
    private static List<OreConfigHolder> ORE_CONFIG = new ArrayList<OreConfigHolder>();

    public static int RETROGEN_VERSION = 1;
    public static boolean RETROGEN_ENABLED = false;
    public static boolean RETROGEN_LOG = false;
    public static boolean GENERATE_AIR = false;
    public static boolean PRINT_OREDICT = false;

    public static int HARVEST_COPPER = 1;
    public static int HARVEST_TIN = 1;
    public static int HARVEST_SILVER = 2;
    public static int HARVEST_LEAD = 2;
    public static int HARVEST_ALUMINUM = 1;
    public static int HARVEST_NICKEL = 2;
    public static int HARVEST_SULFUR = 2;
    public static int HARVEST_SALTPETER = 2;
    public static int HARVEST_URANIUM = 2;
    public static int HARVEST_PLATINUM = 2;
    public static int HARVEST_BRONZE = 1;
    public static int HARVEST_STEEL = 2;
    public static int HARVEST_IRIDIUM = 3;
    public static int HARVEST_MITHRIL = 3;
    public static int HARVEST_NTH = 3;
    public static int HARVEST_URU = 3;
    public static int HARVEST_THORIUM = 3;

    public static String[] DEFAULT_CRUSHER_RECIPES;
    public static String[] CUSTOM_CRUSHER_RECIPES;

    public static void initConfigHolder(Configuration cfg)
    {
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.COPPER.getMetaData(), 7, 10, 40, 100, 60, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.TIN.getMetaData(),7,10,16,64,60, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.SILVER.getMetaData(),6,6,5,20,30, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.LEAD.getMetaData(),7,8,16,48,40, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.ALUMINUM.getMetaData(),5,6,16,64,40, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.NICKEL.getMetaData(),4,2,5,20,30, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.SULFUR.getMetaData(),4,3,5,16,20, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.SALTPETER.getMetaData(),3,2,5,16,20, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.URANIUM.getMetaData(),3,6,5,64,50, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.PLATINUM.getMetaData(),3,3,5,32,30, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.IRIDIUM.getMetaData(),2,2,5,32,10, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.MITHRIL.getMetaData(),2,2,5,32,10, 0));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.NTH.getMetaData(), 4, 6, 16, 120, 50, -1));
        ORE_CONFIG.add(new OreConfigHolder(BlockOre.OreType.URU.getMetaData(), 3, 6, 1, 120,40, 1));
    }

    public static void loadConfiguration(Configuration cfg)
    {
        RETROGEN_VERSION = cfg.getInt(LibNames.Config.Key.Retrogen.RETROGEN_VERSION, LibNames.Config.Category.RETROGEN, RETROGEN_VERSION, 1, 20, LibNames.Config.Comment.RETROGEN_VERSION);
        RETROGEN_ENABLED = cfg.getBoolean(LibNames.Config.Key.Retrogen.RETROGEN_ENABLED, LibNames.Config.Category.RETROGEN, RETROGEN_ENABLED, LibNames.Config.Comment.RETROGEN_ENABLED);
        RETROGEN_LOG = cfg.getBoolean(LibNames.Config.Key.Retrogen.RETROGEN_LOG, LibNames.Config.Category.DEBUG, RETROGEN_LOG, LibNames.Config.Comment.RETROGEN_LOG);
        GENERATE_AIR = cfg.getBoolean(LibNames.Config.Key.Debug.GENERATE_AIR, LibNames.Config.Category.DEBUG, GENERATE_AIR, LibNames.Config.Comment.GENERATE_AIR);
        PRINT_OREDICT = cfg.getBoolean(LibNames.Config.Key.Debug.PRINT_OREDICT, LibNames.Config.Category.DEBUG, PRINT_OREDICT, LibNames.Config.Comment.PRINT_OREDICT);

        HARVEST_COPPER = cfg.getInt(LibNames.Config.Key.Harvest.COPPER, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_COPPER, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.COPPER));
        HARVEST_TIN = cfg.getInt(LibNames.Config.Key.Harvest.TIN, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_TIN, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.TIN));
        HARVEST_SILVER = cfg.getInt(LibNames.Config.Key.Harvest.SILVER, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_SILVER, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.SILVER));
        HARVEST_LEAD = cfg.getInt(LibNames.Config.Key.Harvest.LEAD, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_LEAD, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.LEAD));
        HARVEST_ALUMINUM = cfg.getInt(LibNames.Config.Key.Harvest.ALUMINUM, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_ALUMINUM, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.ALUMINUM));
        HARVEST_NICKEL = cfg.getInt(LibNames.Config.Key.Harvest.NICKEL, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_NICKEL, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.NICKEL));
        HARVEST_SULFUR = cfg.getInt(LibNames.Config.Key.Harvest.SULFUR, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_SULFUR, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.SULFUR));
        HARVEST_SALTPETER = cfg.getInt(LibNames.Config.Key.Harvest.SALTPETER, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_SALTPETER, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.SALTPETER));
        HARVEST_URANIUM = cfg.getInt(LibNames.Config.Key.Harvest.URANIUM, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_URANIUM, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.URANIUM));
        HARVEST_PLATINUM = cfg.getInt(LibNames.Config.Key.Harvest.PLATINUM, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_PLATINUM, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.PLATINUM));
        HARVEST_BRONZE = cfg.getInt(LibNames.Config.Key.Harvest.BRONZE, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_BRONZE, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.BRONZE));
        HARVEST_STEEL = cfg.getInt(LibNames.Config.Key.Harvest.STEEL, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_STEEL, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.STEEL));
        HARVEST_IRIDIUM = cfg.getInt(LibNames.Config.Key.Harvest.IRIDIUM, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_IRIDIUM, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.IRIDIUM));
        HARVEST_MITHRIL = cfg.getInt(LibNames.Config.Key.Harvest.MITHRIL, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_MITHRIL, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.MITHRIL));
        HARVEST_NTH = cfg.getInt(LibNames.Config.Key.Harvest.NTH, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_NTH, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.NTH));
        HARVEST_URU = cfg.getInt(LibNames.Config.Key.Harvest.URU, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_URU, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.URU));
        HARVEST_THORIUM = cfg.getInt(LibNames.Config.Key.Harvest.THORUIM, LibNames.Config.Category.HARVEST_LEVEL, HARVEST_THORIUM, 0, 3, String.format(LibNames.Config.Comment.HARVEST_LEVEL, LibNames.Config.Key.Harvest.THORUIM));

        DEFAULT_CRUSHER_RECIPES = cfg.getStringList(LibNames.Config.Key.CrusherRecipes.DEFAULT, LibNames.Config.Category.CRUSHER_RECIPES, LibCrusherRecipes.defaultRecipes, LibNames.Config.Comment.DEFAULT_CRUSHER_RECIPES);
        CUSTOM_CRUSHER_RECIPES = cfg.getStringList(LibNames.Config.Key.CrusherRecipes.CUSTOM, LibNames.Config.Category.CRUSHER_RECIPES, LibCrusherRecipes.customRecipes, LibNames.Config.Comment.CUSTOM_CRUShER_RECIPES);

        for (OreConfigHolder holder : ORE_CONFIG)
        {
            holder.loadConfiguration(cfg);
        }
    }

    public static void readConfig()
    {
        Configuration cfg = ServerProxy.CONFIG;
        try
        {
            cfg.load();
            initConfigHolder(cfg);
            loadConfiguration(cfg);
        }
        catch (Exception e)
        {
            LogHelper.error("Error reading Config: " + e);
        }
        finally
        {
            if (cfg.hasChanged())
                cfg.save();
        }
    }

    public static List<OreConfigHolder> getOreConfigHolderList()
    {
        return ORE_CONFIG;
    }
}
