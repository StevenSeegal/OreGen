package com.dynu.stevenseegal.oregen.lib;

public class LibNames
{
    public static final class Blocks
    {
        public static final String COPPER_ORE = "oreCopper";
        public static final String TIN_ORE = "oreTin";
        public static final String SILVER_ORE = "oreSilver";
        public static final String LEAD_ORE = "oreLead";
        public static final String ALUMINUM_ORE = "oreAluminum";
        public static final String NICKEL_ORE = "oreNickel";
        public static final String SULFUR_ORE = "oreSulfur";
        public static final String SALTPETER_ORE = "oreSaltpeter";
        public static final String URANIUM_ORE = "oreUranium";
        public static final String PLATINUM_ORE = "orePlatinum";

        public static final String COPPER_BLOCK = "blockCopper";
        public static final String TIN_BLOCK = "blockTin";
        public static final String SILVER_BLOCK = "blockSilver";
        public static final String LEAD_BLOCK = "blockLead";
        public static final String ALUMINUM_BLOCK = "blockAluminum";
        public static final String NICKEL_BLOCK = "blockNickel";
        public static final String BRONZE_BLOCK = "blockBronze";
        public static final String STEEL_BLOCK = "blockSteel";
        public static final String URANIUM_BLOCK = "blockUranium";
        public static final String PLATINUM_BLOCK = "blockPlatinum";
    }

    public static final class Items
    {
        public static final String COPPER_INGOT = "ingotCopper";
        public static final String TIN_INGOT = "ingotTin";
        public static final String SILVER_INGOT = "ingotSilver";
        public static final String LEAD_INGOT = "ingotLead";
        public static final String ALUMINUM_INGOT = "ingotAluminum";
        public static final String NICKEL_INGOT = "ingotNickel";
        public static final String BRONZE_INGOT = "ingotBronze";
        public static final String STEEL_INGOT = "ingotSteel";
        public static final String URANIUM_INGOT = "ingotUranium";
        public static final String PLATINUM_INGOT = "ingotPlatinum";

        public static final String COPPER_NUGGET = "nuggetCopper";
        public static final String TIN_NUGGET = "nuggetTin";
        public static final String SILVER_NUGGET = "nuggetSilver";
        public static final String LEAD_NUGGET = "nuggetLead";
        public static final String ALUMINUM_NUGGET = "nuggetAluminum";
        public static final String NICKEL_NUGGET = "nuggetNickel";
        public static final String BRONZE_NUGGET = "nuggetBronze";
        public static final String STEEL_NUGGET = "nuggetSteel";
        public static final String URANIUM_NUGGET = "nuggetUranium";
        public static final String PLATINUM_NUGGET = "nuggetPlatinum";

        public static final String COPPER_DUST = "dustCopper";
        public static final String TIN_DUST = "dustTin";
        public static final String SILVER_DUST = "dustSilver";
        public static final String LEAD_DUST = "dustLead";
        public static final String ALUMINUM_DUST = "dustAluminum";
        public static final String NICKEL_DUST = "dustNickel";
        public static final String BRONZE_DUST = "dustBronze";
        public static final String STEEL_DUST = "dustSteel";
        public static final String SULFUR_DUST = "dustSulfur";
        public static final String SALTPETER_DUST = "dustSaltpeter";
        public static final String URANIUM_DUST = "dustUranium";
        public static final String PLATINUM_DUST = "dustPlatinum";
    }

    public static final class Config
    {
        public static final class Key
        {
            public static final String RETROGEN_VERSION = "RetroGenVersion";
            public static final String RETROGEN_ENABLED = "RetroGenEnabled";
            public static final String RETROGEN_LOG = "LogRetroGen";
            public static final String GENERATE_AIR = "GenerateAir";
            public static final String PRINT_OREDICT = "PrintOreDict";
        }

        public static final class Category
        {
            public static final String GENERAL = "General";
            public static final String GENERATION = "Generation";
            public static final String RETROGEN = "RetroGen";
            public static final String DEBUG = "Debug";
            public static final String HARVEST_LEVEL = "HarvestLevel";
        }

        public static final class Comment
        {
            public static final String ORE = "Generate %s in the world";
            public static final String SETTINGS = "Need 5 numeric arguments. Format: veinSize,veinsPerChunk,minY,maxY,ratio";
            public static final String HARVEST_LEVEL = "Set the harvest level for %s. 0=wood, 1=stone, 2=iron, 3=diamond";

            public static final String RETROGEN_VERSION = "RetroGen version";
            public static final String RETROGEN_ENABLED= "Enable RetroGen";
            public static final String RETROGEN_LOG = "Show RetroGen in log";
            public static final String GENERATE_AIR = "[DEBUG ONLY] Generate Ores in the air instead of underground";
            public static final String PRINT_OREDICT = "Print the full OreDictionary to file 'OredictDump.txt'. This file can be found in the root of your Minecraft instance";
        }

        public static final class NBT
        {
            public static final String RETROGEN = "RetroGen";
        }
    }
}