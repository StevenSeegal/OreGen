package com.dynu.stevenseegal.oregen;

import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.handler.GuiHandler;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import com.dynu.stevenseegal.oregen.proxy.IProxy;
import com.dynu.stevenseegal.oregen.util.LogHelper;
import com.dynu.stevenseegal.oregen.util.OreDictUtils;
import com.dynu.stevenseegal.oregen.world.gen.WorldGenOre;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = LibMod.MOD_ID, name = LibMod.MOD_NAME, version = LibMod.MOD_VERSION, dependencies = LibMod.MOD_DEPENDENCIES, acceptedMinecraftVersions = LibMod.MOC_ACCEPTED_MC_VERSIONS)
public class OreGen
{
    @SidedProxy(clientSide = LibMod.MOD_CLIENT_PROXY, serverSide = LibMod.MOD_SERVER_PROXY)
    public static IProxy proxy;

    @Mod.Instance
    public static OreGen instance;

    public static final CreativeTabOreGen creativeTab = new CreativeTabOreGen();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        WorldGenOre worldGenOre = new WorldGenOre();
        GameRegistry.registerWorldGenerator(worldGenOre, 0);
        MinecraftForge.EVENT_BUS.register(worldGenOre);
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        OreDictUtils.registerExtraVanillaItems();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
        if (Config.PRINT_OREDICT)
        {
            OreDictUtils.exportOreDictEntries();
        }
        LogHelper.info("Finished loading.");
    }
}