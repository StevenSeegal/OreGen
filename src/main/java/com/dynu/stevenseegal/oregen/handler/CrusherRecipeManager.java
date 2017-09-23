package com.dynu.stevenseegal.oregen.handler;

import com.dynu.stevenseegal.oregen.init.ModItems;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.google.common.collect.Maps;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreIngredient;

import java.util.Map;

public class CrusherRecipeManager
{
    private static final CrusherRecipeManager CRUSHER_BASE = new CrusherRecipeManager();
    private final Map<OreIngredient, ItemStack> crusherRecipeList = Maps.newHashMap();
    private final Map<OreIngredient, Integer> crusherTimeList = Maps.newHashMap();

    public static CrusherRecipeManager instance()
    {
        return CRUSHER_BASE;
    }

    private CrusherRecipeManager()
    {
        this.addOreDictCrusherRecipe(LibNames.Blocks.COPPER_ORE, new ItemStack(ModItems.COPPER_DUST, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.Blocks.TIN_ORE, new ItemStack(ModItems.TIN_DUST, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.Blocks.SILVER_ORE, new ItemStack(ModItems.SILVER_DUST, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.Blocks.LEAD_ORE, new ItemStack(ModItems.LEAD_DUST, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.Blocks.ALUMINUM_ORE, new ItemStack(ModItems.ALUMINUM_DUST, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.Blocks.NICKEL_ORE, new ItemStack(ModItems.NICKEL_DUST, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.Blocks.URANIUM_ORE, new ItemStack(ModItems.URANIUM_DUST, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.Blocks.PLATINUM_ORE, new ItemStack(ModItems.PLATINUM_DUST, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.Blocks.SULFUR_ORE, new ItemStack(ModItems.SULFUR_DUST, 5), 400);
        this.addOreDictCrusherRecipe(LibNames.Blocks.SALTPETER_ORE, new ItemStack(ModItems.SALTPETER_DUST, 5), 400);

        this.addOreDictCrusherRecipe(LibNames.Vanilla.IRON_ORE, new ItemStack(ModItems.IRON_DUST, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.Vanilla.GOLD_ORE, new ItemStack(ModItems.GOLD_DUST, 2), 400);

        this.addOreDictCrusherRecipe(LibNames.Vanilla.COAL_ORE, new ItemStack(ModItems.COAL_DUST, 3), 400);
        this.addOreDictCrusherRecipe(LibNames.Vanilla.DIAMOND_ORE, new ItemStack(Items.DIAMOND, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.Vanilla.EMERALD_ORE, new ItemStack(Items.EMERALD, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.Vanilla.GLOWSTONE_BLOCK, new ItemStack(Items.GLOWSTONE_DUST, 4), 400);
        this.addOreDictCrusherRecipe(LibNames.Vanilla.REDSTONE_ORE, new ItemStack(Items.REDSTONE, 5), 400);
        this.addOreDictCrusherRecipe(LibNames.Vanilla.QUARTZ_ORE, new ItemStack(Items.QUARTZ, 5), 400);
        this.addOreDictCrusherRecipe(LibNames.Vanilla.LAPIS_ORE, new ItemStack(Items.DYE, 5, 4), 400);

        this.addOreDictCrusherRecipe(LibNames.Items.COPPER_INGOT, new ItemStack(ModItems.COPPER_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Items.TIN_INGOT, new ItemStack(ModItems.TIN_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Items.SILVER_INGOT, new ItemStack(ModItems.SILVER_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Items.LEAD_INGOT, new ItemStack(ModItems.LEAD_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Items.ALUMINUM_INGOT, new ItemStack(ModItems.ALUMINUM_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Items.NICKEL_INGOT, new ItemStack(ModItems.NICKEL_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Items.BRONZE_INGOT, new ItemStack(ModItems.BRONZE_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Items.STEEL_INGOT, new ItemStack(ModItems.STEEL_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Items.URANIUM_INGOT, new ItemStack(ModItems.URANIUM_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Items.PLATINUM_INGOT, new ItemStack(ModItems.PLATINUM_DUST, 1), 200);

        this.addOreDictCrusherRecipe(LibNames.Vanilla.COAL, new ItemStack(ModItems.COAL_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Vanilla.IRON_INGOT, new ItemStack(ModItems.IRON_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Vanilla.GOLD_INGOT, new ItemStack(ModItems.GOLD_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Vanilla.DIAMOND, new ItemStack(ModItems.DIAMOND_DUST, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.Vanilla.BLAZE_ROD, new ItemStack(Items.BLAZE_POWDER, 5), 200);
    }
    
    public void addOreDictCrusherRecipe(String oreDictName, ItemStack result, int crushTime)
    {
        OreIngredient ingredient = new OreIngredient(oreDictName);
        this.crusherRecipeList.put(ingredient, result);
        this.crusherTimeList.put(ingredient, crushTime);
    }
    
    public ItemStack getCrushingResult(ItemStack inputStack)
    {
        for (Map.Entry<OreIngredient, ItemStack> recipeEntry : this.crusherRecipeList.entrySet())
        {
            ItemStack[] oreIngredientList = recipeEntry.getKey().getMatchingStacks();
            for (ItemStack ingredient : oreIngredientList)
            {
                if (this.compareItemStacks(inputStack, ingredient))
                {
                    return recipeEntry.getValue();
                }
            }
        }
        return ItemStack.EMPTY;
    }
    
    public int getCrushTime(ItemStack inputStack)
    {
        for (Map.Entry<OreIngredient, Integer> crushTimeEntry : this.crusherTimeList.entrySet())
        {
            ItemStack[] oreIngredientList = crushTimeEntry.getKey().getMatchingStacks();
            for (ItemStack ingredient : oreIngredientList)
            {
                if (this.compareItemStacks(inputStack, ingredient))
                {
                    return crushTimeEntry.getValue();
                }
            }
        }
        return 400;
    }

    private boolean compareItemStacks(ItemStack itemStack1, ItemStack itemStack2)
    {
        return itemStack2.getItem() == itemStack1.getItem() && (itemStack2.getMetadata() == 32767 || itemStack2.getMetadata() == itemStack1.getMetadata());
    }
}
