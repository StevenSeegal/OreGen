package com.dynu.stevenseegal.oregen.init;

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

    public static ItemUpgrade UPGRADE_ISIDED = new ItemUpgrade(LibNames.Items.UPGRADE_ISIDED);

    @Mod.EventBusSubscriber(modid = LibMod.MOD_ID)
    public static class RegistrationHandler
    {
        public static final Item[] ITEMS =
                {
                        ITEM_INGOT,
                        ITEM_DUST,
                        ITEM_NUGGET,

                        UPGRADE_ISIDED,
                };

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            for (Item item : ITEMS)
            {
                event.getRegistry().register(item.setRegistryName(getRegistryName(item.getUnlocalizedName())));
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
        }

        private static ResourceLocation getRegistryName(String input)
        {
            String name = input.substring(input.indexOf(LibMod.MOD_ID));
            name = name.replaceFirst("\\.", ":");
            return new ResourceLocation(name);
        }
    }
}