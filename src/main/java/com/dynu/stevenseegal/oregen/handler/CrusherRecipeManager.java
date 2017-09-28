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
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.COPPER_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 0), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.TIN_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 1), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.SILVER_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 2), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.LEAD_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 3), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.ALUMINUM_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 4), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.NICKEL_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 5), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.URANIUM_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 8), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.PLATINUM_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 9), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.SULFUR_ORE, new ItemStack(ModItems.ITEM_DUST, 5, 10), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.SALTPETER_ORE, new ItemStack(ModItems.ITEM_DUST, 5, 11), 400);

        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.COAL_ORE, new ItemStack(Items.COAL, 4, 0), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.IRON_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 13), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.GOLD_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 14), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.DIAMOND_ORE, new ItemStack(Items.DIAMOND, 2, 0), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.EMERALD_ORE, new ItemStack(Items.EMERALD, 2, 0), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.REDSTONE_ORE, new ItemStack(Items.REDSTONE, 5, 0), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.QUARTZ_ORE, new ItemStack(Items.QUARTZ, 5, 0), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.LAPIS_ORE, new ItemStack(Items.DYE, 5, 4), 400);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.GLOWSTONE_BLOCK, new ItemStack(Items.GLOWSTONE_DUST, 4, 0), 400);

        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.COPPER_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 0), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.TIN_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 1), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.SILVER_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 2), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.LEAD_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 3), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.ALUMINUM_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 4), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.NICKEL_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 5), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.BRONZE_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 6), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.STEEL_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 7), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.URANIUM_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 8), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.PLATINUM_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 9), 200);

        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.COAL, new ItemStack(ModItems.ITEM_DUST, 1, 12), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.IRON_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 13), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.GOLD_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 14), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.DIAMOND, new ItemStack(ModItems.ITEM_DUST, 1, 15), 200);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.BLAZE_ROD, new ItemStack(Items.BLAZE_POWDER, 5, 0), 200);
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
