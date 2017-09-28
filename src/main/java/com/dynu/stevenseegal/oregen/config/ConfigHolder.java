package com.dynu.stevenseegal.oregen.config;

import com.dynu.stevenseegal.oregen.block.BlockOre;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.dynu.stevenseegal.oregen.util.LogHelper;
import com.dynu.stevenseegal.oregen.util.StringUtils;
import com.dynu.stevenseegal.oregen.world.gen.WorldGenOre;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.common.config.Configuration;

public class ConfigHolder
{
    private int veinSize;
    private int veinsPerChunk;
    private int minY;
    private int maxY;
    private int ratio;
    private IBlockState blockState;
    private String name;
    private boolean enabled;

    public ConfigHolder(IBlockState blockState, String name, int veinSize, int veinsPerChunk, int minY, int maxY, int ratio)
    {
        this.blockState = blockState;
        this.veinSize = veinSize;
        this.veinsPerChunk = veinsPerChunk;
        this.minY = minY;
        this.maxY = maxY;
        this.ratio = ratio;
        this.name = name;
        this.enabled = true;
    }

    public void loadConfiguration(Configuration cfg)
    {
        LogHelper.debug("ConfigHolder: " + name);
        this.enabled = cfg.getBoolean(name + "generate", LibNames.Config.Category.GENERATION, enabled, String.format(LibNames.Config.Comment.ORE, StringUtils.toUpperCase(name)));
        String settings = cfg.getString(name + "settings", LibNames.Config.Category.GENERATION, getDefaultSettings(), LibNames.Config.Comment.SETTINGS); //TODO COMMENT
        LogHelper.debug(settings);
        applySettings(settings);
    }

    private void applySettings(String settings)
    {
        String strippedString = settings.replaceAll("\\s", "");
        String[] settingArray = strippedString.split(",");
        if (settingArray.length != 5)
        {
            LogHelper.error(String.format("Error in Config for %s. Need 5 arguments. Ore is disabled", name));
            this.enabled = false;
            return;
        }
        for (String setting : settingArray)
        {
            LogHelper.debug("CHECK: " + StringUtils.isInteger(setting));
            if (!StringUtils.isInteger(setting))
            {
                LogHelper.error(String.format("Error in Config for %s. One ore more arguments isn't numeric. Ore is disabled", name));
                this.enabled = false;
                return;
            }
        }
        int veinSize = Integer.parseInt(settingArray[0]);
        if (veinSize < 1 || veinSize > 20)
        {
            LogHelper.error(String.format("Error in Config for %s. veinsize can only be 1-20. Ore is disabled", name));
            this.enabled = false;
            return;
        }
        int veinsPerChunk = Integer.parseInt(settingArray[1]);
        if (veinsPerChunk < 1 || veinsPerChunk> 20)
        {
            LogHelper.error(String.format("Error in Config for %s. veinspersize can only be 1-20. Ore is disabled", name));
            this.enabled = false;
            return;
        }

        int minY = Integer.parseInt(settingArray[2]);
        if (minY < 1 || minY > 255)
        {
            LogHelper.error(String.format("Error in Config for %s. minY can only be 1-255. Ore is disabled", name));
            this.enabled = false;
            return;
        }
        int maxY = Integer.parseInt(settingArray[3]);
        if (maxY < 1 || maxY > 255)
        {
            LogHelper.error(String.format("Error in Config for %s. maxY can only be 1-255. Ore is disabled", name));
            this.enabled = false;
            return;
        }
        if (minY > maxY)
        {
            LogHelper.error(String.format("Error in Config for %s. minY is greater then maxY. Ore is disabled", name));
            this.enabled = false;
            return;
        }
        int ratio = Integer.parseInt(settingArray[4]);
        if (ratio < 1 || ratio > 99)
        {
            LogHelper.error(String.format("Error in Config for %s. Ration can only be 1-99. Ore is disabled", name));
            this.enabled = false;
            return;
        }
        LogHelper.debug("CONTINUE");
        this.veinSize = veinSize;
        this.veinsPerChunk = veinsPerChunk;
        this.minY = minY;
        this.maxY = maxY;
        this.ratio = ratio;
        registerOreToWorldGenerator();
    }

    private String getDefaultSettings()
    {
        String setting = veinSize+","+veinsPerChunk+","+minY+","+maxY+","+ ratio;
        return setting;
    }

    public void registerOreToWorldGenerator()
    {
        if (enabled)
        {
            LogHelper.debug("REG TO GEN: Registering " + name + " blockname: " + name + " with settings: " + veinSize + " " + veinsPerChunk + " "+ minY + " " + maxY + " " + ratio);
            WorldGenOre.addOreToGenerate(name, blockState, veinSize, veinsPerChunk, minY, maxY, ratio);
        }
        else
        {
            LogHelper.debug("REG TO GEN: Ore " + name + " is disabled");
        }
    }
}