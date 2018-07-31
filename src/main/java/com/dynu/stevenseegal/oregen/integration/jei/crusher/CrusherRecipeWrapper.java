package com.dynu.stevenseegal.oregen.integration.jei.crusher;

import com.dynu.stevenseegal.oregen.recipe.CrusherRecipeManager;
import com.dynu.stevenseegal.oregen.tileentity.TileEntityCrusher;
import com.dynu.stevenseegal.oregen.util.StringUtils;
import mezz.jei.api.gui.ITooltipCallback;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class CrusherRecipeWrapper implements IRecipeWrapper, ITooltipCallback<ItemStack>
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

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
    {
        CrusherRecipeManager crusherRecipeManager = CrusherRecipeManager.getInstance();
        ItemStack input = (inputs.get(0)).get(0);

        if (input != null && input.getItem() != null)
        {
            String crushtime = StringUtils.translateFormatted("jei.oregen.gui.crusher.crushtime", crusherRecipeManager.getCrushTime(input));
            minecraft.fontRenderer.drawString(crushtime, recipeWidth - minecraft.fontRenderer.getStringWidth(crushtime), 0, Color.gray.getRGB());
        }
    }

    @Override
    public void onTooltip(int slot, boolean input, ItemStack itemStack, List<String> tooltip)
    {
        if (slot == CrusherRecipeCategory.fuelSlot && itemStack != null)
        {
            int crushtime = TileEntityCrusher.getItemBurnTime(itemStack);
            tooltip.add(StringUtils.translateFormatted("jei.oregen.gui.crusher.crushtime", crushtime));
        }
    }
}
