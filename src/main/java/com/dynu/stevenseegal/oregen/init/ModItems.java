package com.dynu.stevenseegal.oregen.init;

import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.item.*;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(LibMod.MOD_ID)
public class ModItems
{
    public static ItemIngot ITEM_INGOT = new ItemIngot(LibNames.Items.ITEM_INGOT, LibNames.Items.INGOTS);
    public static ItemDust ITEM_DUST = new ItemDust(LibNames.Items.ITEM_DUST, LibNames.Items.DUSTS);
    public static ItemNugget ITEM_NUGGET = new ItemNugget(LibNames.Items.ITEM_NUGGET, LibNames.Items.NUGGETS);
    public static ItemUpgrade ITEM_UPGRADE = new ItemUpgrade(LibNames.Items.ITEM_UPGRADE, LibNames.Items.UPGRADES);
    public static ItemChunkDirty ITEM_CHUNK_DIRTY = new ItemChunkDirty(LibNames.Items.ITEM_CHUNK_DIRTY, LibNames.Items.CHUNK_DIRTY);
    public static ItemChunkClean ITEM_CHUNK_CLEAN = new ItemChunkClean(LibNames.Items.ITEM_CHUNK_CLEAN, LibNames.Items.CHUNK_CLEAN);

    @Mod.EventBusSubscriber(modid = LibMod.MOD_ID)
    public static class RegistrationHandler
    {
        public static final Item[] ITEMS =
                {
                        ITEM_INGOT,
                        ITEM_DUST,
                        ITEM_NUGGET,
                        ITEM_UPGRADE,
                };

        public static final Item[] CHUNKS =
                {
                        ITEM_CHUNK_DIRTY,
                        ITEM_CHUNK_CLEAN,
                };

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            for (Item item : ITEMS)
            {
                event.getRegistry().register(item.setRegistryName(getRegistryName(item.getUnlocalizedName())));
            }
            if (Config.GFL_CHUNK_MODE)
            {
                for (Item chunk : CHUNKS)
                {
                    event.getRegistry().register(chunk.setRegistryName(getRegistryName(chunk.getUnlocalizedName())));
                }
            }
            registerToOreDict();
        }

        public static void registerToOreDict()
        {
            for (Item item : ITEMS)
            {
                if (item instanceof IItemRegistryHandler)
                {
                    ((IItemRegistryHandler) item).registerToOreDict();
                }
            }
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event)
        {
            for (Item item : ITEMS)
            {
                if (item instanceof IItemRegistryHandler)
                {
                    ((IItemRegistryHandler) item).initModel();
                }
            }
            if (Config.GFL_CHUNK_MODE)
            {
                for (Item chunk : CHUNKS)
                {
                    ((IItemRegistryHandler) chunk).initModel();
                }
            }
        }

        private static ResourceLocation getRegistryName(String input)
        {
            String name = input.substring(input.indexOf(LibMod.MOD_ID));
            name = name.replaceFirst("\\.", ":");
            return new ResourceLocation(name);
        }
    }
}