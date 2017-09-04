package com.dynu.stevenseegal.oregen.init;

import com.dynu.stevenseegal.oregen.item.ItemBase;
import com.dynu.stevenseegal.oregen.item.ItemDust;
import com.dynu.stevenseegal.oregen.item.ItemIngot;
import com.dynu.stevenseegal.oregen.item.ItemNugget;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

@GameRegistry.ObjectHolder(LibMod.MOD_ID)
public class ModItems
{
    public static ItemIngot COPPER_INGOT = new ItemIngot(LibNames.Items.COPPER_INGOT);
    public static ItemIngot TIN_INGOT = new ItemIngot(LibNames.Items.TIN_INGOT);
    public static ItemIngot SILVER_INGOT = new ItemIngot(LibNames.Items.SILVER_INGOT);
    public static ItemIngot LEAD_INGOT = new ItemIngot(LibNames.Items.LEAD_INGOT);
    public static ItemIngot ALUMINUM_INGOT = new ItemIngot(LibNames.Items.ALUMINUM_INGOT);
    public static ItemIngot NICKEL_INGOT = new ItemIngot(LibNames.Items.NICKEL_INGOT);
    public static ItemIngot BRONZE_INGOT = new ItemIngot(LibNames.Items.BRONZE_INGOT);
    public static ItemIngot STEEL_INGOT = new ItemIngot(LibNames.Items.STEEL_INGOT);
    public static ItemIngot URANIUM_INGOT = new ItemIngot(LibNames.Items.URANIUM_INGOT);
    public static ItemIngot PLATINUM_INGOT = new ItemIngot(LibNames.Items.PLATINUM_INGOT);

    public static ItemNugget COPPER_NUGGET = new ItemNugget(LibNames.Items.COPPER_NUGGET);
    public static ItemNugget TIN_NUGGET = new ItemNugget(LibNames.Items.TIN_NUGGET);
    public static ItemNugget SILVER_NUGGET = new ItemNugget(LibNames.Items.SILVER_NUGGET);
    public static ItemNugget LEAD_NUGGET = new ItemNugget(LibNames.Items.LEAD_NUGGET);
    public static ItemNugget ALUMINUM_NUGGET = new ItemNugget(LibNames.Items.ALUMINUM_NUGGET);
    public static ItemNugget NICKEL_NUGGET = new ItemNugget(LibNames.Items.NICKEL_NUGGET);
    public static ItemNugget BRONZE_NUGGET = new ItemNugget(LibNames.Items.BRONZE_NUGGET);
    public static ItemNugget STEEL_NUGGET = new ItemNugget(LibNames.Items.STEEL_NUGGET);
    public static ItemNugget URANIUM_NUGGET = new ItemNugget(LibNames.Items.URANIUM_NUGGET);
    public static ItemNugget PLATINUM_NUGGET = new ItemNugget(LibNames.Items.PLATINUM_NUGGET);

    public static ItemDust COPPER_DUST = new ItemDust(LibNames.Items.COPPER_DUST);
    public static ItemDust TIN_DUST = new ItemDust(LibNames.Items.TIN_DUST);
    public static ItemDust SILVER_DUST = new ItemDust(LibNames.Items.SILVER_DUST);
    public static ItemDust LEAD_DUST = new ItemDust(LibNames.Items.LEAD_DUST);
    public static ItemDust ALUMINUM_DUST = new ItemDust(LibNames.Items.ALUMINUM_DUST);
    public static ItemDust NICKEL_DUST = new ItemDust(LibNames.Items.NICKEL_DUST);
    public static ItemDust BRONZE_DUST = new ItemDust(LibNames.Items.BRONZE_DUST);
    public static ItemDust STEEL_DUST = new ItemDust(LibNames.Items.STEEL_DUST);
    public static ItemDust SULFUR_DUST = new ItemDust(LibNames.Items.SULFUR_DUST);
    public static ItemDust SALTPETER_DUST = new ItemDust(LibNames.Items.SALTPETER_DUST);
    public static ItemDust URANIUM_DUST = new ItemDust(LibNames.Items.URANIUM_DUST);
    public static ItemDust PLATINUM_DUST = new ItemDust(LibNames.Items.PLATINUM_DUST);

    @Mod.EventBusSubscriber(modid = LibMod.MOD_ID)
    public static class RegistrationHandler
    {
        public static final Set<Item> ITEMS = new HashSet<>();
        public static final Item[] items = {
                COPPER_INGOT,
                TIN_INGOT,
                SILVER_INGOT,
                LEAD_INGOT,
                ALUMINUM_INGOT,
                NICKEL_INGOT,
                BRONZE_INGOT,
                STEEL_INGOT,
                URANIUM_INGOT,
                PLATINUM_INGOT,

                COPPER_NUGGET,
                TIN_NUGGET,
                SILVER_NUGGET,
                LEAD_NUGGET,
                ALUMINUM_NUGGET,
                NICKEL_NUGGET,
                BRONZE_NUGGET,
                STEEL_NUGGET,
                URANIUM_NUGGET,
                PLATINUM_NUGGET,

                COPPER_DUST,
                TIN_DUST,
                SILVER_DUST,
                LEAD_DUST,
                ALUMINUM_DUST,
                NICKEL_DUST,
                BRONZE_DUST,
                STEEL_DUST,
                SULFUR_DUST,
                SALTPETER_DUST,
                URANIUM_DUST,
                PLATINUM_DUST,
        };

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            final IForgeRegistry<Item> registry = event.getRegistry();
            for (final Item item : items)
            {
                registry.register(item);
                ITEMS.add(item);
            }
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event)
        {
            for (final Item item : items)
            {
                if (item instanceof ItemBase)
                {
                    ItemBase itemBase = (ItemBase)item;
                    itemBase.initModel();
                }
            }
        }
    }
}
