package com.dynu.stevenseegal.oregen.proxy;

import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class ServerProxy implements IProxy
{
    public static Configuration CONFIG;

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        File directory = event.getModConfigurationDirectory();
        CONFIG = new Configuration(new File(directory.getPath(), LibMod.MOD_ID + ".cfg"));
        Config.readConfig();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        if (CONFIG.hasChanged())
            CONFIG.save();
    }
}
