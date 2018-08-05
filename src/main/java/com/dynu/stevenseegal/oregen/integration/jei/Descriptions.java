package com.dynu.stevenseegal.oregen.integration.jei;

import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.config.OreConfigHolder;
import com.dynu.stevenseegal.oregen.init.ModBlocks;
import com.dynu.stevenseegal.oregen.init.ModItems;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.dynu.stevenseegal.oregen.util.StringUtils;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;

import java.util.List;

public class Descriptions
{
    public static String emptyLine = "";

    public static void addDescriptions(IModRegistry registry)
    {
        addOreDescriptions(registry);
        addCrusherDescriptions(registry);
    }

    private static void addOreDescriptions(IModRegistry registry)
    {
        List<OreConfigHolder> oreConfigHolderList = Config.getOreConfigHolderList();

        for (OreConfigHolder oreConfig : oreConfigHolderList)
        {
            int meta = oreConfig.getMeta();
            String name = oreConfig.getJeiUnLocalizedName();

            if (oreConfig.isEnabled())
            {
                String spawnInfo = StringUtils.translate("jei.oregen.description.spawn");
                String maxY = StringUtils.translateFormatted("jei.oregen.description.max", oreConfig.getMaxY());
                String minY = StringUtils.translateFormatted("jei.oregen.description.min", oreConfig.getMinY());
                String dim = StringUtils.translateFormatted("jei.oregen.description.dim", getDimensionName(oreConfig.getGenDim()));
                registry.addDescription(new ItemStack(ModBlocks.BLOCK_ORE, 1, meta), name, emptyLine, spawnInfo, maxY, minY, dim);
            }
            else
            {
                String info = LibNames.Messages.TEXTCOLOR_RED + StringUtils.translate("jei.oregen.description.disabled");
                registry.addDescription(new ItemStack(ModBlocks.BLOCK_ORE, 1, meta), name, emptyLine, info);
            }
        }
    }

    private static void addCrusherDescriptions(IModRegistry registry)
    {
        ItemStack itemStackCrusher = new ItemStack(ModBlocks.MACHINE_CRUSHER);
        ItemStack itemStackUpgradeBlank = new ItemStack(ModItems.ITEM_UPGRADE, 1, 0);
        ItemStack itemStackUpgradeISided = new ItemStack(ModItems.ITEM_UPGRADE, 1, 1);
        ItemStack itemStackUpgradeMuffler = new ItemStack(ModItems.ITEM_UPGRADE, 1, 2);
        ItemStack itemStackUpgradeSpeed = new ItemStack(ModItems.ITEM_UPGRADE, 1, 3);

        String nameCrusher = itemStackCrusher.getDisplayName();
        String nameUpgradeBlank = itemStackUpgradeBlank.getDisplayName();
        String nameUpgradeISided = itemStackUpgradeISided.getDisplayName();
        String nameUpgradeMuffler = itemStackUpgradeMuffler.getDisplayName();
        String nameUpgradeSpeed = itemStackUpgradeSpeed.getDisplayName();

        String infoCrusher;
        if (!Config.GFL_CHUNK_MODE)
        {
            infoCrusher = StringUtils.translate("jei.oregen.description.crusher.normal");
        }
        else
        {
            infoCrusher = StringUtils.translate("jei.oregen.description.crusher.gflmode");
        }
        String infoUpgradeBlank = StringUtils.translate("jei.oregen.description.upgradeblank");
        String infoUpgradeISided = StringUtils.translate("jei.oregen.description.upgradeisided");
        String infoUpgradeMuffler = StringUtils.translate("jei.oregen.description.upgrademuffler");
        String infoUpgradeSpeed = StringUtils.translate("jei.oregen.description.upgradespeed");
        String infoUpgradeInsert = StringUtils.translate("jei.oregen.description.upgradeinsert");

        registry.addDescription(itemStackCrusher, nameCrusher, emptyLine, infoCrusher);
        registry.addDescription(itemStackUpgradeBlank, nameUpgradeBlank, emptyLine, infoUpgradeBlank);
        registry.addDescription(itemStackUpgradeISided, nameUpgradeISided, emptyLine, infoUpgradeISided, infoUpgradeInsert);
        registry.addDescription(itemStackUpgradeMuffler, nameUpgradeMuffler, emptyLine, infoUpgradeMuffler, infoUpgradeInsert);
        registry.addDescription(itemStackUpgradeSpeed, nameUpgradeSpeed, emptyLine, infoUpgradeSpeed, infoUpgradeInsert);
    }

    private static String getDimensionName(int dim)
    {
        if (dim == -1)
        {
            return "Nether";
        }
        else if (dim == 1)
        {
            return "End";
        }
        else
        {
            return "Overworld";
        }
    }
}
