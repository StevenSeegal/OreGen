package com.dynu.stevenseegal.oregen.integration.jei.crusher;

import com.dynu.stevenseegal.oregen.recipe.CrusherRecipe;
import com.dynu.stevenseegal.oregen.recipe.CrusherRecipeManager;
import com.dynu.stevenseegal.oregen.util.LogHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrusherRecipeMaker
{
    public static List<CrusherRecipeWrapper> getOredictCrusherRecipes(IJeiHelpers helpers)
    {
        IStackHelper stackHelper = helpers.getStackHelper();
        CrusherRecipeManager crusherRecipeManager = CrusherRecipeManager.getInstance();
        List<CrusherRecipe> crusherRecipes = crusherRecipeManager.getCrusherRecipeList();

        List<CrusherRecipeWrapper> recipes = new ArrayList<CrusherRecipeWrapper>();

        for (CrusherRecipe crusherRecipe : crusherRecipes)
        {
            ItemStack output = crusherRecipe.getOutput();
            ItemStack[] input = crusherRecipe.getOreDictInputList();

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
