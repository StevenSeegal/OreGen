package com.dynu.stevenseegal.oregen;

import com.dynu.stevenseegal.oregen.lib.LibMod;
import com.dynu.stevenseegal.oregen.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
        //
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        //
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //
    }
}
