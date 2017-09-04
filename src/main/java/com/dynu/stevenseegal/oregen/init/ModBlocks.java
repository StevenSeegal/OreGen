package com.dynu.stevenseegal.oregen.init;

import com.dynu.stevenseegal.oregen.block.BlockBase;
import com.dynu.stevenseegal.oregen.block.BlockBlock;
import com.dynu.stevenseegal.oregen.block.BlockOre;
import com.dynu.stevenseegal.oregen.lib.Harvest;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@GameRegistry.ObjectHolder(LibMod.MOD_ID)
public class ModBlocks
{
    public static BlockOre COPPER_ORE = new BlockOre(LibNames.Blocks.COPPER_ORE, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockOre TIN_ORE = new BlockOre(LibNames.Blocks.TIN_ORE, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockOre SILVER_ORE = new BlockOre(LibNames.Blocks.SILVER_ORE, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockOre LEAD_ORE = new BlockOre(LibNames.Blocks.LEAD_ORE, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockOre ALUMINUM_ORE = new BlockOre(LibNames.Blocks.ALUMINUM_ORE, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockOre NICKEL_ORE = new BlockOre(LibNames.Blocks.NICKEL_ORE, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockOre SULFUR_ORE = new BlockOre(LibNames.Blocks.SULFUR_ORE, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockOre SALTPETER_ORE = new BlockOre(LibNames.Blocks.SALTPETER_ORE, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockOre URANIUM_ORE = new BlockOre(LibNames.Blocks.URANIUM_ORE, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockOre PLATINUM_ORE = new BlockOre(LibNames.Blocks.PLATINUM_ORE, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);

    public static BlockBlock COPPER_BLOCK = new BlockBlock(LibNames.Blocks.COPPER_BLOCK, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockBlock TIN_BLOCK = new BlockBlock(LibNames.Blocks.TIN_BLOCK, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockBlock SILVER_BLOCK = new BlockBlock(LibNames.Blocks.SILVER_BLOCK, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockBlock LEAD_BLOCK = new BlockBlock(LibNames.Blocks.LEAD_BLOCK, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockBlock ALUMINUM_BLOCK = new BlockBlock(LibNames.Blocks.ALUMINUM_BLOCK, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockBlock NICKEL_BLOCK = new BlockBlock(LibNames.Blocks.NICKEL_BLOCK, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockBlock BRONZE_BLOCK = new BlockBlock(LibNames.Blocks.BRONZE_BLOCK, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockBlock STEEL_BLOCK = new BlockBlock(LibNames.Blocks.STEEL_BLOCK, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockBlock URANIUM_BLOCK = new BlockBlock(LibNames.Blocks.URANIUM_BLOCK, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);
    public static BlockBlock PLATINUM_BLOCK = new BlockBlock(LibNames.Blocks.PLATINUM_BLOCK, 5.0F, Harvest.Tool.PICKAXE, Harvest.Level.STONE);

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
                SULFUR_ORE,
                SALTPETER_ORE,
                URANIUM_ORE,
                PLATINUM_ORE,

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
                System.out.println("Registry name: " + registryName);
                ITEM_BLOCKS.add(item);
            }
            //register tileentities
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
            }
        }
    }
}
