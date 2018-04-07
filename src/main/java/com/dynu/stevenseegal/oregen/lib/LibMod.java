package com.dynu.stevenseegal.oregen.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class LibMod
{
    public static final String MOD_ID = "oregen";
    public static final String MOD_NAME = "OreGen";
    public static final String MOD_VERSION = "@MC_VERSION@-@VERSION@";
    public static final String MOD_DEPENDENCIES = "required-after:forge@[14.23.0.2491,)";
    public static final String MOC_ACCEPTED_MC_VERSIONS = "[1.12]";
    public static final String MOD_CLIENT_PROXY = "com.dynu.stevenseegal.oregen.proxy.ClientProxy";
    public static final String MOD_SERVER_PROXY = "com.dynu.stevenseegal.oregen.proxy.ServerProxy";

    public static final String GUI_CRUSHER_BACKGROUND = "textures/gui/crusher.png";

    public static final class GenReplacedBlocks
    {
        public static final Block OVERWORLD = Blocks.STONE;
        public static final Block NETHER = Blocks.NETHERRACK;
        public static final Block END = Blocks.END_STONE;
        public static final Block AIR = Blocks.AIR;
    }
}
