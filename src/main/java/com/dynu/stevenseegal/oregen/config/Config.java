package com.dynu.stevenseegal.oregen.config;

import com.dynu.stevenseegal.oregen.init.ModBlocks;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.dynu.stevenseegal.oregen.proxy.ServerProxy;
import com.dynu.stevenseegal.oregen.util.LogHelper;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;

public class Config
{
    private static ArrayList<ConfigHolder> ORE_CONFIG = new ArrayList<ConfigHolder>();

    public static int RETROGEN_VERSION = 1;
    public static boolean RETROGEN_ENABLED = false;
    public static boolean RETROGEN_LOG = false;
    public static boolean GENERATE_AIR = false;
    public static boolean PRINT_OREDICT = false;

    public static void initConfigHolder(Configuration cfg)
    {
        ORE_CONFIG.add(new ConfigHolder(ModBlocks.COPPER_ORE, 7, 10, 40, 100, 60));
        ORE_CONFIG.add(new ConfigHolder(ModBlocks.TIN_ORE,7,10,16,64,60));
        ORE_CONFIG.add(new ConfigHolder(ModBlocks.SILVER_ORE,6,6,5,20,30));
        ORE_CONFIG.add(new ConfigHolder(ModBlocks.LEAD_ORE,7,8,16,48,40));
        ORE_CONFIG.add(new ConfigHolder(ModBlocks.ALUMINUM_ORE,5,6,16,64,40));
        ORE_CONFIG.add(new ConfigHolder(ModBlocks.NICKEL_ORE,4,2,5,20,30));
        ORE_CONFIG.add(new ConfigHolder(ModBlocks.SULFUR_ORE,4,3,5,16,20));
        ORE_CONFIG.add(new ConfigHolder(ModBlocks.SALTPETER_ORE,3,2,5,16,20));
        ORE_CONFIG.add(new ConfigHolder(ModBlocks.URANIUM_ORE,3,6,5,64,50));
        ORE_CONFIG.add(new ConfigHolder(ModBlocks.PLATINUM_ORE,3,3,5,32,30));
    }

    public static void loadConfiguration(Configuration cfg)
    {
        RETROGEN_VERSION = cfg.getInt(LibNames.Config.Key.RETROGEN_VERSION, LibNames.Config.Category.RETROGEN, RETROGEN_VERSION, 1, 20, LibNames.Config.Comment.RETROGEN_VERSION);
        RETROGEN_ENABLED = cfg.getBoolean(LibNames.Config.Key.RETROGEN_ENABLED, LibNames.Config.Category.RETROGEN, RETROGEN_ENABLED, LibNames.Config.Comment.RETROGEN_ENABLED);
        RETROGEN_LOG = cfg.getBoolean(LibNames.Config.Key.RETROGEN_LOG, LibNames.Config.Category.DEBUG, RETROGEN_LOG, LibNames.Config.Comment.RETROGEN_LOG);
        GENERATE_AIR = cfg.getBoolean(LibNames.Config.Key.GENERATE_AIR, LibNames.Config.Category.DEBUG, GENERATE_AIR, LibNames.Config.Comment.GENERATE_AIR);
        PRINT_OREDICT = cfg.getBoolean(LibNames.Config.Key.PRINT_OREDICT, LibNames.Config.Category.DEBUG, PRINT_OREDICT, LibNames.Config.Comment.PRINT_OREDICT);
        for (ConfigHolder holder : ORE_CONFIG)
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
}
