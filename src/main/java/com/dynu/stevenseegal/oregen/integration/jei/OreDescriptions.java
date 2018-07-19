package com.dynu.stevenseegal.oregen.integration.jei;

import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.config.OreConfigHolder;
import com.dynu.stevenseegal.oregen.init.ModBlocks;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.dynu.stevenseegal.oregen.util.StringUtils;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;

import java.util.List;

public class OreDescriptions
{
    public static void addOreDescriptions(IModRegistry registry)
    {
        List<OreConfigHolder> oreConfigHolderList = Config.getOreConfigHolderList();

        for (OreConfigHolder oreConfig : oreConfigHolderList)
        {
            String emptyLine = "";
            int meta = oreConfig.getMeta();
            String name = oreConfig.getJeiUnLocalizedName();

            if (oreConfig.isEnabled())
            {
                String spawnInfo = StringUtils.translate("jei.oregen.description.spawn") + ":";
                String maxY = StringUtils.translate("jei.oregen.description.max") + ": " + oreConfig.getMaxY();
                String minY = StringUtils.translate("jei.oregen.description.min") + ": " + oreConfig.getMinY();
                String dim = StringUtils.translate("jei.oregen.description.dim") + ": " + getDimensionName(oreConfig.getGenDim());
                registry.addDescription(new ItemStack(ModBlocks.BLOCK_ORE, 1, meta), name, emptyLine, spawnInfo, maxY, minY, dim);
            }
            else
            {
                String info = LibNames.Messages.TEXTCOLOR_RED + StringUtils.translate("jei.oregen.description.disabled");
                registry.addDescription(new ItemStack(ModBlocks.BLOCK_ORE, 1, meta), name, emptyLine, info);
            }
        }
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
