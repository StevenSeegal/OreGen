package com.dynu.stevenseegal.oregen.util;

import net.minecraft.util.IStringSerializable;

public enum EnumGFLDustToChunk implements IStringSerializable
{
    COPPER("orecopper", 0, 0),
    TIN("oretin", 1, 1),
    SILVER("oresilver", 2, 2),
    LEAD("orelead", 3, 3),
    ALUMINUM("orealuminum", 4, 4),
    NICKEL("orenickel", 5, 5),
    URANIUM("oreuranium", 8, 6),
    PLATINUM("oreplatinum", 9 ,7),
    IRIDIUM("oreiridium", 16, 8),
    MITHRIL("oremithril", 17, 9),
    NTH("orenth", 18, 10),
    URU("oreuru", 19, 11),
    IRON("oreiron", 13, 12),
    GOLD("oregold", 14 ,13);

    private String oreDictName;
    private int dustMeta;
    private int chunkMeta;

    EnumGFLDustToChunk(String oreDictName, int dustMeta, int chunkMeta)
    {
        this.oreDictName = oreDictName;
        this.dustMeta = dustMeta;
        this.chunkMeta = chunkMeta;
    }

    @Override
    public String getName()
    {
        return this.oreDictName;
    }

    @Override
    public String toString()
    {
        return this.getName();
    }

    public int getDustMeta()
    {
        return this.dustMeta;
    }

    public int getChunkMeta()
    {
        return this.chunkMeta;
    }

    public static int getChunkMeta(int dustMeta)
    {
        for (EnumGFLDustToChunk transform : values())
        {
            if (transform.getDustMeta() == dustMeta)
            {
                return transform.getChunkMeta();
            }
        }
        return 0;
    }

    public static boolean containsOre(String oreName)
    {
        for (EnumGFLDustToChunk transform : values())
        {
            if (transform.toString().equals(oreName.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }
}
