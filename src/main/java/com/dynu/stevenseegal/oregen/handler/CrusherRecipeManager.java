package com.dynu.stevenseegal.oregen.handler;

import com.dynu.stevenseegal.oregen.init.ModItems;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.google.common.collect.Maps;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreIngredient;

import java.util.Map;

public class CrusherRecipeManager
{
    private static final CrusherRecipeManager CRUSHER_BASE = new CrusherRecipeManager();
    private final Map<OreIngredient, ItemStack> crusherRecipeList = Maps.newHashMap();
    private final Map<OreIngredient, Integer> crusherTimeList = Maps.newHashMap();

    private int CRUSHTIME_NORMAL = 200;
    private int CRUSHTIME_ORE = 400;
    private int CRUSHTIME_BLOCK = 1800;

    public static CrusherRecipeManager instance()
    {
        return CRUSHER_BASE;
    }

    private CrusherRecipeManager()
    {
        
        // OreGen
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.COPPER_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 0), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.TIN_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 1), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.SILVER_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 2), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.LEAD_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 3), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.ALUMINUM_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 4), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.NICKEL_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 5), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.URANIUM_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 8), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.PLATINUM_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 9), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.SULFUR_ORE, new ItemStack(ModItems.ITEM_DUST, 5, 10), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.SALTPETER_ORE, new ItemStack(ModItems.ITEM_DUST, 5, 11), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.IRIDIUM_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 16), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.MITHRIL_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 17), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.NTH_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 18), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.URU_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 19), CRUSHTIME_ORE);

        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.COPPER_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 0), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.TIN_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 1), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.SILVER_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 2), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.LEAD_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 3), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.ALUMINUM_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 4), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.NICKEL_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 5), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.BRONZE_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 6), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.STEEL_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 7), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.URANIUM_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 8), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.PLATINUM_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 9), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.IRIDIUM_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 16), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.MITHRIL_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 17), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.NTH_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 18), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.URU_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 19), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Items.THORIUM_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 20), CRUSHTIME_NORMAL);

        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.COPPER_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 0), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.TIN_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 1), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.SILVER_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 2), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.LEAD_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 3), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.ALUMINUM_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 4), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.NICKEL_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 5), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.BRONZE_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 6), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.STEEL_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 7), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.URANIUM_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 8), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.PLATINUM_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 9), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.IRIDIUM_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 16), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.MITHRIL_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 17), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.NTH_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 18), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.URU_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 19), CRUSHTIME_BLOCK);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Blocks.THORIUM_BLOCK, new ItemStack(ModItems.ITEM_DUST, 9, 20), CRUSHTIME_BLOCK);

        // Vanilla
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.COAL_ORE, new ItemStack(Items.COAL, 4, 0), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.IRON_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 13), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.GOLD_ORE, new ItemStack(ModItems.ITEM_DUST, 2, 14), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.DIAMOND_ORE, new ItemStack(Items.DIAMOND, 2, 0), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.EMERALD_ORE, new ItemStack(Items.EMERALD, 2, 0), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.REDSTONE_ORE, new ItemStack(Items.REDSTONE, 5, 0), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.QUARTZ_ORE, new ItemStack(Items.QUARTZ, 5, 0), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.LAPIS_ORE, new ItemStack(Items.DYE, 8, 4), CRUSHTIME_ORE);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.GLOWSTONE_BLOCK, new ItemStack(Items.GLOWSTONE_DUST, 4, 0), CRUSHTIME_ORE);

        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.COAL, new ItemStack(ModItems.ITEM_DUST, 1, 12), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.IRON_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 13), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.GOLD_INGOT, new ItemStack(ModItems.ITEM_DUST, 1, 14), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.DIAMOND, new ItemStack(ModItems.ITEM_DUST, 1, 15), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.BLAZE_ROD, new ItemStack(Items.BLAZE_POWDER, 5, 0), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.COBBLESTONE, new ItemStack(Blocks.GRAVEL, 1), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.GRAVEL, new ItemStack(Blocks.SAND, 1), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.SANDSTONE, new ItemStack(Blocks.SAND, 2), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.QUARTZ_BLOCK, new ItemStack(Items.QUARTZ, 4), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.CLAY_BLOCK, new ItemStack(Items.CLAY_BALL, 4), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.HARDENED_CLAY_BLOCK, new ItemStack(Items.CLAY_BALL, 4), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.BRICKS_BLOCK, new ItemStack(Items.BRICK, 4), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.NETHERBRICKS_BLOCK, new ItemStack(Items.NETHERBRICK, 4), CRUSHTIME_NORMAL);

        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.WOOL, new ItemStack(Items.STRING, 4), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.BONE, new ItemStack(Items.DYE, 6, 15), CRUSHTIME_NORMAL);

        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_DANDELION, new ItemStack(Items.DYE, 4, 11), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_POPPY, new ItemStack(Items.DYE, 4, 1), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_BLUE_ORCHID, new ItemStack(Items.DYE, 4, 12), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_ALLIUM, new ItemStack(Items.DYE, 4, 13), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_AZURE_BLUET, new ItemStack(Items.DYE, 4, 7), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_TULIP_RED, new ItemStack(Items.DYE, 4, 1), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_TULIP_ORANGE, new ItemStack(Items.DYE, 4, 14), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_TULIP_WHITE, new ItemStack(Items.DYE, 4, 7), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_TULIP_PINK, new ItemStack(Items.DYE, 4, 9), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_OXEYE_DAISY, new ItemStack(Items.DYE, 4, 7), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_SUNFLOWER, new ItemStack(Items.DYE, 4, 11), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_LILAC, new ItemStack(Items.DYE, 4, 13), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_ROSE_BUSH, new ItemStack(Items.DYE, 4, 1), CRUSHTIME_NORMAL);
        this.addOreDictCrusherRecipe(LibNames.OreDict.Vanilla.FLOWER_PEONY, new ItemStack(Items.DYE, 4, 9), CRUSHTIME_NORMAL);
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

    public Map<OreIngredient, ItemStack> getOredictRecipeList()
    {
        return this.crusherRecipeList;
    }
}
