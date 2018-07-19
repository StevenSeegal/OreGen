package com.dynu.stevenseegal.oregen.integration.jei.crusher;

import com.dynu.stevenseegal.oregen.integration.jei.JeiPlugin;
import com.dynu.stevenseegal.oregen.util.LogHelper;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class CrusherRecipeHandler implements IRecipeHandler<CrusherRecipeWrapper>
{
    @Override
    public Class<CrusherRecipeWrapper> getRecipeClass()
    {
        return CrusherRecipeWrapper.class;
    }

    @Override
    public String getRecipeCategoryUid(CrusherRecipeWrapper recipe)
    {
        return JeiPlugin.CRUSHER_UID;
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(CrusherRecipeWrapper recipe)
    {
        return recipe;
    }

    @Override
    public boolean isRecipeValid(CrusherRecipeWrapper recipe)
    {
        if (recipe.getInputs().isEmpty())
        {
            LogHelper.error("Error in JEI plugin. Input is empty.");
        }
        if (recipe.getOutputs().isEmpty())
        {
            LogHelper.error("Error in JEI plugin. Output is empty.");
        }
        return true;
    }
}
