package com.dynu.stevenseegal.oregen.util;

import net.minecraft.item.EnumRarity;

public class RarityHelper
{
    public static EnumRarity getRarityFor(String name)
    {
        if (name == null)
        {
            return EnumRarity.COMMON;
        }
        else if (name.equals("platinum"))
        {
            return EnumRarity.UNCOMMON;
        }
        else if (name.equals("iridium") || name.equals("mithril"))
        {
            return EnumRarity.RARE;
        }
        else
        {
            return EnumRarity.COMMON;
        }
    }
}
