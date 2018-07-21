package com.dynu.stevenseegal.oregen.integration.jei;

import com.dynu.stevenseegal.oregen.init.ModBlocks;
import com.dynu.stevenseegal.oregen.integration.jei.crusher.CrusherRecipeCategory;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import net.minecraft.item.ItemStack;

import java.util.List;

@JEIPlugin
public class JeiPlugin implements IModPlugin
{
    public static final String CRUSHER_UID = "oregen.crusher";
    public static List<ItemStack> FUEL_LIST;

    @Override
    public void register(IModRegistry registry)
    {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

        FUEL_LIST = registry.getIngredientRegistry().getFuels();

        CrusherRecipeCategory.register(registry, jeiHelpers, guiHelper);
        Descriptions.addDescriptions(registry);

        blacklistItems(jeiHelpers.getIngredientBlacklist());
    }

    private void blacklistItems(IIngredientBlacklist blacklist)
    {
        blacklist.addIngredientToBlacklist(new ItemStack(ModBlocks.MACHINE_CRUSHER_RUNNING));
    }
}
