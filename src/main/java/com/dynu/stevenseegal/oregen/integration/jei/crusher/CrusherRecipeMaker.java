package com.dynu.stevenseegal.oregen.integration.jei.crusher;

import com.dynu.stevenseegal.oregen.handler.CrusherRecipeManager;
import com.dynu.stevenseegal.oregen.util.LogHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreIngredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CrusherRecipeMaker
{
    public static List<CrusherRecipeWrapper> getOredictCrusherRecipes(IJeiHelpers helpers)
    {
        IStackHelper stackHelper = helpers.getStackHelper();
        CrusherRecipeManager crusherRecipeManager = CrusherRecipeManager.instance();
        Map<OreIngredient, ItemStack> crusherRecipes = crusherRecipeManager.getOredictRecipeList();

        List<CrusherRecipeWrapper> recipes = new ArrayList<CrusherRecipeWrapper>();

        for (Map.Entry<OreIngredient, ItemStack> crusherRecipe : crusherRecipes.entrySet())
        {
            OreIngredient oreIngredient = crusherRecipe.getKey();
            ItemStack output = crusherRecipe.getValue();
            ItemStack[] input = oreIngredient.getMatchingStacks();

            if (input.length == 0 || output == null || output.getItem() == null)
            {
                LogHelper.error("Invalid crusher recipe.");
            }
            else
            {
                List<ItemStack> inputs = stackHelper.getAllSubtypes(Arrays.asList(input));
                CrusherRecipeWrapper recipe = new CrusherRecipeWrapper(inputs, output);
                recipes.add(recipe);
            }
        }
        return recipes;
    }

}
