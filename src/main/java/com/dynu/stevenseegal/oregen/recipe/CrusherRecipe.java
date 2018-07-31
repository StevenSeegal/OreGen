package com.dynu.stevenseegal.oregen.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreIngredient;

public class CrusherRecipe
{
    private ItemStack[] input = new ItemStack[1];
    private ItemStack output;
    private int crushTime;
    private boolean oreDict;
    private OreIngredient oreIngredient;

    public CrusherRecipe(ItemStack input, ItemStack output, int crushTime)
    {
        this.input[0] = input;
        this.output = output;
        this.crushTime = crushTime;
        this.oreDict = false;
    }

    public CrusherRecipe(OreIngredient oreIngredient, ItemStack output, int crushTime)
    {
        this.input[0] = ItemStack.EMPTY;
        this.output = output;
        this.crushTime = crushTime;
        this.oreDict = true;
        this.oreIngredient = oreIngredient;
    }

    public ItemStack getInput()
    {
        return input[0];
    }

    public ItemStack getOutput()
    {
        return output;
    }

    public int getCrushTime()
    {
        return crushTime;
    }

    public boolean isOreDict()
    {
        return oreDict;
    }

    public ItemStack[] getOreDictInputList()
    {
        if (this.isOreDict())
        {
            return this.oreIngredient.getMatchingStacks();
        }
        return this.input;
    }

    public boolean doesInputStackMatch(ItemStack inputStack)
    {
        boolean match = false;
        if (this.oreDict)
        {
            ItemStack[] oredictArray = oreIngredient.getMatchingStacks();
            if (oredictArray != null && oredictArray.length > 0)
            {
                for (ItemStack oredictStack : oredictArray)
                {
                    if (compareItemStacks(inputStack, oredictStack))
                    {
                        match = true;
                    }
                }
            }
        }
        else
        {
            if (!input[0].isEmpty() && input[0].getItem() != null)
            {
                match = compareItemStacks(inputStack, input[0]);
            }
        }
        return match;
    }

    private boolean compareItemStacks(ItemStack itemStack1, ItemStack itemStack2)
    {
        return itemStack2.getItem() == itemStack1.getItem() && (itemStack2.getMetadata() == 32767 || itemStack2.getMetadata() == itemStack1.getMetadata());
    }
}
