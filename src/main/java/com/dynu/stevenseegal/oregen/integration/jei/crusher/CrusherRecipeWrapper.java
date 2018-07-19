package com.dynu.stevenseegal.oregen.integration.jei.crusher;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.Collections;
import java.util.List;

public class CrusherRecipeWrapper implements IRecipeWrapper
{
    private final List<List<ItemStack>> inputs;
    private final ItemStack output;

    public CrusherRecipeWrapper(List<ItemStack> inputs, ItemStack output)
    {
        this.inputs = Collections.singletonList(inputs);
        this.output = output;
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ingredients.setInputLists(ItemStack.class, inputs);
        ingredients.setOutput(ItemStack.class, output);
    }

    public List<List<ItemStack>> getInputs()
    {
        return inputs;
    }

    public List<ItemStack> getOutputs()
    {
        return Collections.singletonList(output);
    }
}
