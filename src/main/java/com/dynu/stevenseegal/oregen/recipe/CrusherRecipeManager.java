package com.dynu.stevenseegal.oregen.recipe;

import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.util.LogHelper;
import com.dynu.stevenseegal.oregen.util.StringUtils;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreIngredient;
import scala.actors.threadpool.Arrays;

import java.util.List;

public class CrusherRecipeManager
{
    private static final CrusherRecipeManager INSTANCE = new CrusherRecipeManager();
    private static List<CrusherRecipe> crusherRecipeList = Lists.newArrayList();

    public static CrusherRecipeManager getInstance()
    {
        return INSTANCE;
    }

    private CrusherRecipeManager()
    {
    }

    public void loadRecipes()
    {
        createRecipes(Arrays.asList(Config.DEFAULT_CRUSHER_RECIPES), false);
        createRecipes(Arrays.asList(Config.CUSTOM_CRUSHER_RECIPES), true);
    }

    public void createRecipes(List<String> inputList, boolean custom)
    {
        int totalRecipes = inputList.size();
        int injectedRecipes = 0;
        int line = 0;
        String prefix = "default";
        if (custom)
        {
            prefix  = "custom";
        }
        if (totalRecipes == 0)
        {
            return;
        }
        LogHelper.info("-Start injecting " + totalRecipes + " " + prefix + " recipes.");
        List<String> customRecipeList = inputList;

        for (String customRecipe : customRecipeList)
        {
            int crushTime = 0;
            boolean oreDict =false;
            String oreDictName = "";

            String[] splittedRecipe = customRecipe.split("-");
            if (customRecipe.isEmpty())
            {
                continue;
            }
            line++;
            if (splittedRecipe.length != 3)
            {
                LogHelper.error("Parse error in <" + StringUtils.toUpperCase(prefix) + " Recipes>, line: " + line + ", '" + customRecipe + "'. Reason: Need 3 arguments.");
                continue;
            }

            List<Object> itemStackList = Lists.newArrayList();
            for (String recipePart : splittedRecipe)
            {
                if (recipePart.contains(":"))
                {
                    if (recipePart.startsWith("oredict:"))
                    {
                        oreDict = true;
                        oreDictName = recipePart.substring(8);
                    }
                    else
                    {
                        Object itemStack = parseItemStack(recipePart);

                        if (itemStack instanceof ItemStack && !((ItemStack) itemStack).isEmpty())
                        {
                            itemStackList.add(itemStack);
                        }
                        else
                        {
                            LogHelper.error("Parse error in <" + StringUtils.toUpperCase(prefix) + " Recipes>, line: " + line + ", '" + customRecipe + "'. Reason: '" + recipePart + "' is an invalid item.");
                        }
                    }
                }
                else
                {
                    try
                    {
                        crushTime = Integer.parseInt(recipePart);
                        if (crushTime <= 0)
                        {
                            crushTime = 200;
                            LogHelper.error("Error in <" + StringUtils.toUpperCase(prefix) + " Recipes>, line: " + line + ", '" + customRecipe + "'. Reason: Crushtime must be higher then 0. Recipe is added with default Crushtime: " + crushTime);
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        LogHelper.error("Parse error in <" + StringUtils.toUpperCase(prefix) + " Recipes>, line: " + line + ", '" + customRecipe + "'. Reason: Crushtime must be a valid integer.");
                    }
                }
            }

            if (oreDict && itemStackList.size() == 1 && crushTime > 0)
            {
                OreIngredient oreIngredient = new OreIngredient(oreDictName);
                if (oreIngredient.getMatchingStacks().length > 0)
                {
                    crusherRecipeList.add(new CrusherRecipe(oreIngredient, (ItemStack) itemStackList.get(0), crushTime));
                    injectedRecipes++;
                }
                else
                {
                    LogHelper.error("Parse error in <" + StringUtils.toUpperCase(prefix) + " Recipes>, line: " + line + ", '" + customRecipe + "'. Reason: '" + oreDictName + "' is an invalid Ore Dictionary entry.");
                }

            }
            else if (!oreDict && itemStackList.size() == 2 && crushTime > 0)
            {
                crusherRecipeList.add(new CrusherRecipe((ItemStack) itemStackList.get(0), (ItemStack) itemStackList.get(1), crushTime));
                injectedRecipes++;
            }
        }
        LogHelper.info("-Successfully injected " + injectedRecipes  + " out of " + totalRecipes + " " + prefix + " recipes.");
        if (injectedRecipes < totalRecipes)
        {
            LogHelper.info("There is an error in one or more of the recipes, please check the log above and fix them.");
        }
    }

    private Object parseItemStack(String recipePart)// throws Exception
    {
        String[] parts = recipePart.split("#");

        int amount = parts.length == 1 ? 1 : Integer.parseInt(parts[1]);
        if (parts.length == 2)
        {
            recipePart = recipePart.substring(0, recipePart.indexOf("#"));
        }

        parts = recipePart.split(":");
        int meta = parts.length == 2 ? 0 : Integer.parseInt(parts[2]);

        NBTTagCompound compound = new NBTTagCompound();
        compound.setString("id", parts[0] + ":" + parts[1]);
        compound.setByte("Count", (byte) amount);
        compound.setShort("Damage", (short) meta);
        return new ItemStack(compound);
    }

    public ItemStack getCrushingResult(ItemStack inputStack)
    {
        for (CrusherRecipe recipe : crusherRecipeList)
        {
            if (recipe.doesInputStackMatch(inputStack))
            {
                return recipe.getOutput();
            }
        }
        return ItemStack.EMPTY;
    }

    public int getCrushTime(ItemStack inputStack)
    {
        for (CrusherRecipe recipe : crusherRecipeList)
        {
            if (recipe.doesInputStackMatch(inputStack))
            {
                return recipe.getCrushTime();
            }
        }
        return 200;
    }

    public List<CrusherRecipe> getCrusherRecipeList()
    {
        return crusherRecipeList;
    }
}
