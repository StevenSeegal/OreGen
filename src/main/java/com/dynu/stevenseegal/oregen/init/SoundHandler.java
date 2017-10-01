package com.dynu.stevenseegal.oregen.init;

import com.dynu.stevenseegal.oregen.lib.LibMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LibMod.MOD_ID)
public class SoundHandler
{
    public static ResourceLocation resourceLocation = new ResourceLocation(LibMod.MOD_ID, "crusher_crush");
    public static SoundEvent CRUSHER_CRUSH = new SoundEvent(resourceLocation);

    @SubscribeEvent
    public static void init(RegistryEvent.Register<SoundEvent> event)
    {
        event.getRegistry().register(CRUSHER_CRUSH.setRegistryName(resourceLocation));
    }
}
