package com.dynu.stevenseegal.oregen.init;

import com.dynu.stevenseegal.oregen.block.*;
import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.dynu.stevenseegal.oregen.tileentity.TileEntityCrusher;
import com.dynu.stevenseegal.oregen.util.LogHelper;
import com.dynu.stevenseegal.oregen.util.OreDictUtils;
import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@GameRegistry.ObjectHolder(LibMod.MOD_ID)
public class ModBlocks
{
    public static BlockOre COPPER_ORE = new BlockOre(LibNames.Blocks.COPPER_ORE, 3.0F, 5.0F);
    public static BlockOre TIN_ORE = new BlockOre(LibNames.Blocks.TIN_ORE, 3.0F, 5.0F);
    public static BlockOre SILVER_ORE = new BlockOre(LibNames.Blocks.SILVER_ORE, 3.0F, 5.0F);
    public static BlockOre LEAD_ORE = new BlockOre(LibNames.Blocks.LEAD_ORE, 3.0F, 5.0F);
    public static BlockOre ALUMINUM_ORE = new BlockOre(LibNames.Blocks.ALUMINUM_ORE, 3.0F, 5.0F);
    public static BlockOre NICKEL_ORE = new BlockOre(LibNames.Blocks.NICKEL_ORE, 3.0F, 5.0F);
    public static BlockOre URANIUM_ORE = new BlockOre(LibNames.Blocks.URANIUM_ORE, 3.0F, 5.0F);
    public static BlockOre PLATINUM_ORE = new BlockOre(LibNames.Blocks.PLATINUM_ORE, 3.0F, 5.0F);
    public static BlockOreItem SULFUR_ORE = new BlockOreItem(LibNames.Blocks.SULFUR_ORE, 3.0F, 5.0F);
    public static BlockOreItem SALTPETER_ORE = new BlockOreItem(LibNames.Blocks.SALTPETER_ORE, 3.0F, 5.0F);

    public static BlockBlock COPPER_BLOCK = new BlockBlock(LibNames.Blocks.COPPER_BLOCK, 3.0F, 5.0F);
    public static BlockBlock TIN_BLOCK = new BlockBlock(LibNames.Blocks.TIN_BLOCK, 3.0F, 5.0F);
    public static BlockBlock SILVER_BLOCK = new BlockBlock(LibNames.Blocks.SILVER_BLOCK, 3.0F, 5.0F);
    public static BlockBlock LEAD_BLOCK = new BlockBlock(LibNames.Blocks.LEAD_BLOCK, 3.0F, 5.0F);
    public static BlockBlock ALUMINUM_BLOCK = new BlockBlock(LibNames.Blocks.ALUMINUM_BLOCK, 3.0F, 5.0F);
    public static BlockBlock NICKEL_BLOCK = new BlockBlock(LibNames.Blocks.NICKEL_BLOCK, 3.0F, 5.0F);
    public static BlockBlock BRONZE_BLOCK = new BlockBlock(LibNames.Blocks.BRONZE_BLOCK, 3.0F, 5.0F);
    public static BlockBlock STEEL_BLOCK = new BlockBlock(LibNames.Blocks.STEEL_BLOCK, 3.0F, 5.0F);
    public static BlockBlock URANIUM_BLOCK = new BlockBlock(LibNames.Blocks.URANIUM_BLOCK, 3.0F, 5.0F);
    public static BlockBlock PLATINUM_BLOCK = new BlockBlock(LibNames.Blocks.PLATINUM_BLOCK, 3.0F, 5.0F);

    public static MachineCrusher MACHINE_CRUSHER = new MachineCrusher(LibNames.Machine.CRUSHER, false);
    public static MachineCrusher MACHINE_CRUSHER_RUNNING = new MachineCrusher(LibNames.Machine.CRUSHER_RUNNING, true);

    @Mod.EventBusSubscriber(modid = LibMod.MOD_ID)
    public static class RegistrationHandler
    {
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        public static final Block[] BLOCKS = {
                COPPER_ORE,
                TIN_ORE,
                SILVER_ORE,
                LEAD_ORE,
                ALUMINUM_ORE,
                NICKEL_ORE,
                URANIUM_ORE,
                PLATINUM_ORE,
                SULFUR_ORE,
                SALTPETER_ORE,

                COPPER_BLOCK,
                TIN_BLOCK,
                SILVER_BLOCK,
                LEAD_BLOCK,
                ALUMINUM_BLOCK,
                NICKEL_BLOCK,
                BRONZE_BLOCK,
                STEEL_BLOCK,
                URANIUM_BLOCK,
                PLATINUM_BLOCK,

                MACHINE_CRUSHER,
                MACHINE_CRUSHER_RUNNING,
        };

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            final IForgeRegistry<Block> registry = event.getRegistry();
            registry.registerAll(BLOCKS);
        }

        @SubscribeEvent
        public static void registerItemBlocks(final RegistryEvent.Register<Item> event)
        {
            final ArrayList<ItemBlock> items = new ArrayList<>();
            for (final Block block : BLOCKS)
            {
                ItemBlock itemBlock = new ItemBlock(block);
                items.add(itemBlock);
            }

            final IForgeRegistry<Item> registry = event.getRegistry();
            for (final ItemBlock item : items)
            {
                final Block block = item.getBlock();
                final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name.", block);
                registry.register(item.setRegistryName(registryName));
                ITEM_BLOCKS.add(item);

                String oredictName = OreDictUtils.getBlockOredictName(block, registryName.toString());
                if (oredictName != null)
                {
                    OreDictionary.registerOre(oredictName, new ItemStack(item));
                    LogHelper.debug("MODBLOCKS: getBlockOredictName for Block: " + registryName + " Value: " + oredictName);
                }
                else
                {
                    LogHelper.debug("MODBLOCKS: No OREDICT NAME");
                }
            }
            setHarvestLevel();
            registerTileEntities();
        }

        public static void registerTileEntities()
        {
            GameRegistry.registerTileEntity(TileEntityCrusher.class, "_" + LibNames.Machine.CRUSHER);
        }

        public static void setHarvestLevel()
        {
            COPPER_ORE.setHarvestLevel("pickaxe", Config.HARVEST_COPPER);
            TIN_ORE.setHarvestLevel("pickaxe", Config.HARVEST_TIN);
            SILVER_ORE.setHarvestLevel("pickaxe", Config.HARVEST_SILVER);
            LEAD_ORE.setHarvestLevel("pickaxe", Config.HARVEST_LEAD);
            ALUMINUM_ORE.setHarvestLevel("pickaxe", Config.HARVEST_ALUMINUM);
            NICKEL_ORE.setHarvestLevel("pickaxe", Config.HARVEST_NICKEL);
            URANIUM_ORE.setHarvestLevel("pickaxe", Config.HARVEST_URANIUM);
            PLATINUM_ORE.setHarvestLevel("pickaxe", Config.HARVEST_PLATINUM);
            SULFUR_ORE.setHarvestLevel("pickaxe", Config.HARVEST_SULFUR);
            SALTPETER_ORE.setHarvestLevel("pickaxe", Config.HARVEST_SALTPETER);

            COPPER_BLOCK.setHarvestLevel("pickaxe", Config.HARVEST_COPPER);
            TIN_BLOCK.setHarvestLevel("pickaxe", Config.HARVEST_TIN);
            SILVER_BLOCK.setHarvestLevel("pickaxe", Config.HARVEST_SILVER);
            LEAD_BLOCK.setHarvestLevel("pickaxe", Config.HARVEST_LEAD);
            ALUMINUM_BLOCK.setHarvestLevel("pickaxe", Config.HARVEST_ALUMINUM);
            NICKEL_BLOCK.setHarvestLevel("pickaxe", Config.HARVEST_NICKEL);
            BRONZE_BLOCK.setHarvestLevel("pickaxe", Config.HARVEST_BRONZE);
            STEEL_BLOCK.setHarvestLevel("pickaxe", Config.HARVEST_STEEL);
            URANIUM_BLOCK.setHarvestLevel("pickaxe", Config.HARVEST_URANIUM);
            PLATINUM_BLOCK.setHarvestLevel("pickaxe", Config.HARVEST_PLATINUM);
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event)
        {
            for (final Block block : BLOCKS)
            {
                if (block instanceof BlockBase)
                {
                    BlockBase blockBase = (BlockBase)block;
                    blockBase.initModel();
                }
                else if (block instanceof MachineCrusher)
                {
                    MachineCrusher machineCrusher = (MachineCrusher)block;
                    machineCrusher.initModel();
                }
            }
        }
    }
}
