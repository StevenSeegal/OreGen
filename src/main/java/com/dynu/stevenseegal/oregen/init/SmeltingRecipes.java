package com.dynu.stevenseegal.oregen.init;

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
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.COPPER_ORE, 1), new ItemStack(ModItems.COPPER_INGOT, 1), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.TIN_ORE, 1), new ItemStack(ModItems.TIN_INGOT, 1), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.SILVER_ORE, 1), new ItemStack(ModItems.SILVER_INGOT, 1), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.LEAD_ORE, 1), new ItemStack(ModItems.LEAD_INGOT, 1), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.ALUMINUM_ORE, 1), new ItemStack(ModItems.ALUMINUM_INGOT, 1), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.NICKEL_ORE, 1), new ItemStack(ModItems.NICKEL_INGOT, 1), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.URANIUM_ORE, 1), new ItemStack(ModItems.URANIUM_INGOT, 1), XP);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.PLATINUM_ORE, 1), new ItemStack(ModItems.PLATINUM_INGOT, 1), XP);

        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.COPPER_DUST, 1), new ItemStack(ModItems.COPPER_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.TIN_DUST, 1), new ItemStack(ModItems.TIN_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.SILVER_DUST, 1), new ItemStack(ModItems.SILVER_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.LEAD_DUST, 1), new ItemStack(ModItems.LEAD_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.ALUMINUM_DUST, 1), new ItemStack(ModItems.ALUMINUM_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.NICKEL_DUST, 1), new ItemStack(ModItems.NICKEL_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.BRONZE_DUST, 1), new ItemStack(ModItems.BRONZE_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.STEEL_DUST, 1), new ItemStack(ModItems.STEEL_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.URANIUM_DUST, 1), new ItemStack(ModItems.URANIUM_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.PLATINUM_DUST, 1), new ItemStack(ModItems.PLATINUM_INGOT, 1), NONE);
        
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.IRON_DUST, 1), new ItemStack(Items.IRON_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.GOLD_DUST, 1), new ItemStack(Items.GOLD_INGOT, 1), NONE);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.DIAMOND_DUST, 1), new ItemStack(Items.DIAMOND, 1), NONE);
    }
}