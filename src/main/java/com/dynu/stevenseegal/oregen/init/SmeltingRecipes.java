package com.dynu.stevenseegal.oregen.init;

import com.dynu.stevenseegal.oregen.block.BlockOre;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class SmeltingRecipes
{
    private static float XP = 0.2F;
    private static float NONE = 0.0F;

    @SubscribeEvent
    public static void registerSmeltingRecipes(RegistryEvent.Register<IRecipe> event)
    {
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.COPPER.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 0), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.TIN.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 1), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.SILVER.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 2), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.LEAD.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 3), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.ALUMINUM.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 4), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.NICKEL.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 5), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.URANIUM.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 8), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.PLATINUM.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 9), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.IRIDIUM.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 10), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.BLOCK_ORE, 1, BlockOre.OreType.MITHRIL.getMetaData()), new ItemStack(ModItems.ITEM_INGOT, 1, 11), XP);

        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 0), new ItemStack(ModItems.ITEM_INGOT, 1, 0), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 1), new ItemStack(ModItems.ITEM_INGOT, 1, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 2), new ItemStack(ModItems.ITEM_INGOT, 1, 2), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 3), new ItemStack(ModItems.ITEM_INGOT, 1, 3), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 4), new ItemStack(ModItems.ITEM_INGOT, 1, 4), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 5), new ItemStack(ModItems.ITEM_INGOT, 1, 5), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 6), new ItemStack(ModItems.ITEM_INGOT, 1, 6), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 7), new ItemStack(ModItems.ITEM_INGOT, 1, 7), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 8), new ItemStack(ModItems.ITEM_INGOT, 1, 8), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 9), new ItemStack(ModItems.ITEM_INGOT, 1, 9), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 16), new ItemStack(ModItems.ITEM_INGOT, 1, 10), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 17), new ItemStack(ModItems.ITEM_INGOT, 1, 11), NONE);

        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 13), new ItemStack(Items.IRON_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 14), new ItemStack(Items.GOLD_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ITEM_DUST, 1, 15), new ItemStack(Items.DIAMOND, 1), NONE);
    }
}