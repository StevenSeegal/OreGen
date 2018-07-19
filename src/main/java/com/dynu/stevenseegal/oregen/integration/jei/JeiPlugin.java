package com.dynu.stevenseegal.oregen.integration.jei;

import com.dynu.stevenseegal.oregen.init.ModBlocks;
import com.dynu.stevenseegal.oregen.integration.jei.crusher.CrusherRecipeCategory;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JeiPlugin implements IModPlugin
{
    public static final String CRUSHER_UID = "oregen.crusher";

    @Override
    public void register(IModRegistry registry)
    {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

        CrusherRecipeCategory.register(registry, jeiHelpers, guiHelper);

        OreDescriptions.addOreDescriptions(registry);

        blacklistItems(jeiHelpers.getIngredientBlacklist());
    }

    private void blacklistItems(IIngredientBlacklist blacklist)
    {
        blacklist.addIngredientToBlacklist(new ItemStack(ModBlocks.MACHINE_CRUSHER_RUNNING));
    }
}
