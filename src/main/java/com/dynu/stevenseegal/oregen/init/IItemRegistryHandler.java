package com.dynu.stevenseegal.oregen.init;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IItemRegistryHandler
{
    @SideOnly(Side.CLIENT)
    void initModel();
    void registerToOreDict();
}
