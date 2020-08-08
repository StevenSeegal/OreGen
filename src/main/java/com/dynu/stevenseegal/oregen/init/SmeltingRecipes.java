package com.dynu.stevenseegal.oregen.init;

import com.dynu.stevenseegal.oregen.block.BlockOre;
import com.dynu.stevenseegal.oregen.config.Config;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class SmeltingRecipes
{
    private static float XP = 0.2F;
    private static float NONE = 0.0F;

    @SubscribeEvent
    public static void registerSmeltingRecipes(RegistryEvent.Register<IRecipe> event)
    {
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.COPPER.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 0), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.TIN.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 1), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.SILVER.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 2), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.LEAD.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 3), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.ALUMINUM.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 4), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.NICKEL.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 5), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.URANIUM.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 8), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.PLATINUM.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 9), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.IRIDIUM.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 10), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.MITHRIL.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 11), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.NTH.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 12), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.URU.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 13), XP);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.ZINC.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 15), XP);

        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 0), new ItemStack(ModItems.ITEM_INGOT, 1, 0), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 1), new ItemStack(ModItems.ITEM_INGOT, 1, 1), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 2), new ItemStack(ModItems.ITEM_INGOT, 1, 2), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 3), new ItemStack(ModItems.ITEM_INGOT, 1, 3), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 4), new ItemStack(ModItems.ITEM_INGOT, 1, 4), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 5), new ItemStack(ModItems.ITEM_INGOT, 1, 5), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 6), new ItemStack(ModItems.ITEM_INGOT, 1, 6), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 7), new ItemStack(ModItems.ITEM_INGOT, 1, 7), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 8), new ItemStack(ModItems.ITEM_INGOT, 1, 8), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 9), new ItemStack(ModItems.ITEM_INGOT, 1, 9), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 16), new ItemStack(ModItems.ITEM_INGOT, 1, 10), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 17), new ItemStack(ModItems.ITEM_INGOT, 1, 11), NONE);

        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 18), new ItemStack(ModItems.ITEM_INGOT, 1, 12), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 19), new ItemStack(ModItems.ITEM_INGOT, 1, 13), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 20), new ItemStack(ModItems.ITEM_INGOT, 1, 14), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 21), new ItemStack(ModItems.ITEM_INGOT, 1, 15), NONE);

        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 13), new ItemStack(Items.IRON_INGOT, 1), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 14), new ItemStack(Items.GOLD_INGOT, 1), NONE);
        GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_DUST, 1, 15), new ItemStack(Items.DIAMOND, 1), NONE);

        if (Config.GFL_CHUNK_MODE)
        {
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 0), new ItemStack(ModItems.ITEM_INGOT, 1, 0), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 1), new ItemStack(ModItems.ITEM_INGOT, 1, 1), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 2), new ItemStack(ModItems.ITEM_INGOT, 1, 2), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 3), new ItemStack(ModItems.ITEM_INGOT, 1, 3), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 4), new ItemStack(ModItems.ITEM_INGOT, 1, 4), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 5), new ItemStack(ModItems.ITEM_INGOT, 1, 5), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 6), new ItemStack(ModItems.ITEM_INGOT, 1, 8), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 7), new ItemStack(ModItems.ITEM_INGOT, 1, 9), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 8), new ItemStack(ModItems.ITEM_INGOT, 1, 10), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 9), new ItemStack(ModItems.ITEM_INGOT, 1, 11), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 10), new ItemStack(ModItems.ITEM_INGOT, 1, 12), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 11), new ItemStack(ModItems.ITEM_INGOT, 1, 13), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 12), new ItemStack(Items.IRON_INGOT, 1), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 13), new ItemStack(Items.GOLD_INGOT, 1), XP);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, 1, 14), new ItemStack(ModItems.ITEM_INGOT, 1, 15), XP);

            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 0), new ItemStack(ModItems.ITEM_INGOT, 1, 0), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 1), new ItemStack(ModItems.ITEM_INGOT, 1, 1), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 2), new ItemStack(ModItems.ITEM_INGOT, 1, 2), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 3), new ItemStack(ModItems.ITEM_INGOT, 1, 3), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 4), new ItemStack(ModItems.ITEM_INGOT, 1, 4), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 5), new ItemStack(ModItems.ITEM_INGOT, 1, 5), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 6), new ItemStack(ModItems.ITEM_INGOT, 1, 8), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 7), new ItemStack(ModItems.ITEM_INGOT, 1, 9), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 8), new ItemStack(ModItems.ITEM_INGOT, 1, 10), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 9), new ItemStack(ModItems.ITEM_INGOT, 1, 11), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 10), new ItemStack(ModItems.ITEM_INGOT, 1, 12), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 11), new ItemStack(ModItems.ITEM_INGOT, 1, 13), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 12), new ItemStack(Items.IRON_INGOT, 1), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 13), new ItemStack(Items.GOLD_INGOT, 1), NONE);
            GameRegistry.addSmelting(new ItemStack(ModItems.ITEM_CHUNK_CLEAN, 1, 14), new ItemStack(ModItems.ITEM_INGOT, 1, 15), NONE);
        }
    }
}