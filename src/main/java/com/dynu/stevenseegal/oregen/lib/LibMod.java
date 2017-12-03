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

    public static final String CAPE_URL = "*";

    public static final class Textures
    {
        public static final String GUI_CRUSHER_BACKGROUND = "textures/gui/crusher.png";

        public static final String CAPE_TEXTURE_DEFAULT = "textures/capes/oregen.png";
        public static final String CAPE_TEXTURE_STEVENSEEGAL = "textures/capes/stevenseegal.png";
        public static final String CAPE_TEXTURE_YOUNGSANDWICH = "textures/capes/youngsandwich.png";
        public static final String CAPE_TEXTURE_GAMEOVER = CAPE_TEXTURE_DEFAULT;
        public static final String CAPE_TEXTURE_IROOMI = CAPE_TEXTURE_DEFAULT;
        public static final String CAPE_TEXTURE_KAMIZURA = CAPE_TEXTURE_DEFAULT;
        public static final String CAPE_TEXTURE_MATTOKAH = CAPE_TEXTURE_DEFAULT;
        public static final String CAPE_TEXTURE_TRIFFIDDK = CAPE_TEXTURE_DEFAULT;
        public static final String CAPE_TEXTURE_CTHREE = CAPE_TEXTURE_DEFAULT;
    }

    public static final class GenReplacedBlocks
    {
        public static final Block OVERWORLD = Blocks.STONE;
        public static final Block NETHER = Blocks.NETHERRACK;
        public static final Block END = Blocks.END_STONE;
        public static final Block AIR = Blocks.AIR;
    }
}
