package com.dynu.stevenseegal.oregen.integration.jei.crusher;

import com.dynu.stevenseegal.oregen.init.ModBlocks;
import com.dynu.stevenseegal.oregen.integration.jei.JeiPlugin;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.*;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CrusherRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<CrusherRecipeWrapper>
{
    private final int inputSlot = 0;
    private final int fuelSlot = 1;
    private final int outputSlot = 2;

    private final IDrawable background;
    private final IDrawableAnimated flame;
    private final IDrawableAnimated processBar;

    public CrusherRecipeCategory(IGuiHelper guiHelper)
    {
        ResourceLocation backgroundLocation = new ResourceLocation(LibMod.MOD_ID, LibMod.GUI_CRUSHER_BACKGROUND);
        background = guiHelper.createDrawable(backgroundLocation, 55, 16, 82, 54);

        IDrawableStatic flameDrawable = guiHelper.createDrawable(backgroundLocation, 176, 0, 14, 14);
        flame = guiHelper.createAnimatedDrawable(flameDrawable, 300, IDrawableAnimated.StartDirection.TOP, true);

        IDrawableStatic processBarDrawable = guiHelper.createDrawable(backgroundLocation, 176, 31, 24, 4);
        processBar = guiHelper.createAnimatedDrawable(processBarDrawable, 200, IDrawableAnimated.StartDirection.LEFT, false);
    }

    public static void register(IModRegistry registry, IJeiHelpers jeiHelpers, IGuiHelper guiHelper)
    {
        registry.addRecipeCategories(new CrusherRecipeCategory(guiHelper));
        registry.addRecipeHandlers(new CrusherRecipeHandler());
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.MACHINE_CRUSHER), JeiPlugin.CRUSHER_UID, VanillaRecipeCategoryUid.SMELTING);
        registry.addRecipes(CrusherRecipeMaker.getOredictCrusherRecipes(jeiHelpers));
    }

    @Override
    public String getUid()
    {
        return JeiPlugin.CRUSHER_UID;
    }

    @Override
    public String getTitle()
    {
        String localizedName = ModBlocks.MACHINE_CRUSHER.getLocalizedName();
        return localizedName != null ? localizedName : "Coal powered Crusher";
    }

    @Override
    public String getModName()
    {
        return LibMod.MOD_NAME;
    }

    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    @Override
    public void drawExtras(Minecraft minecraft)
    {
        flame.draw(minecraft, 2, 20);
        processBar.draw(minecraft, 25, 25);
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, CrusherRecipeWrapper crusherRecipeWrapper, IIngredients ingredients)
    {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

        guiItemStacks.init(inputSlot, true, 0, 0);
        guiItemStacks.init(outputSlot, false, 60, 18);

        guiItemStacks.set(ingredients);
    }
}
