package com.dynu.stevenseegal.oregen.block;

import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class BlockBlock extends BlockBase
{
    public static final PropertyEnum<BlockType> BLOCK_TYPE = PropertyEnum.create("type", BlockType.class);

    public BlockBlock(String name)
    {
        super(name, 3.0F, 5.0F);

        this.setDefaultState(this.blockState.getBaseState().withProperty(BLOCK_TYPE, BlockType.COPPER));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, BLOCK_TYPE);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(BLOCK_TYPE, BlockType.byMetaData(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(BLOCK_TYPE).getMetaData();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (BlockType type : BlockType.values())
        {
            items.add(new ItemStack(this, 1, type.getMetaData()));
        }
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(BLOCK_TYPE).getMetaData();
    }

    public String getName(ItemStack itemStack)
    {
        return BlockType.byMetaData(itemStack.getMetadata()).getName();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initModel()
    {
        for (BlockType type : BlockType.values())
        {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), type.getMetaData(), new ModelResourceLocation(this.getRegistryName(), "type=" + BlockType.byMetaData(type.getMetaData()).getName()));
        }
    }

    @Override
    public void registerToOreDict()
    {
        OreDictionary.registerOre(LibNames.OreDict.Blocks.COPPER_BLOCK, new ItemStack(this, 1, BlockType.COPPER.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.TIN_BLOCK, new ItemStack(this, 1, BlockType.TIN.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.SILVER_BLOCK, new ItemStack(this, 1, BlockType.SILVER.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.LEAD_BLOCK, new ItemStack(this, 1, BlockType.LEAD.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.ALUMINUM_BLOCK, new ItemStack(this, 1, BlockType.ALUMINUM.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.NICKEL_BLOCK, new ItemStack(this, 1, BlockType.NICKEL.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.PLATINUM_BLOCK, new ItemStack(this, 1, BlockType.PLATINUM.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.URANIUM_BLOCK, new ItemStack(this, 1, BlockType.URANIUM.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.BRONZE_BLOCK, new ItemStack(this, 1, BlockType.BRONZE.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.STEEL_BLOCK, new ItemStack(this, 1, BlockType.STEEL.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.IRIDIUM_BLOCK, new ItemStack(this, 1, BlockType.IRIDIUM.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.MITHRIL_BLOCK, new ItemStack(this, 1, BlockType.MITHRIL.getMetaData()));
    }

    @Override
    public void setHarvestLevel()
    {
        setHarvestLevel("pickaxe", 2);
        setHarvestLevel("pickaxe", Config.HARVEST_COPPER, getStateFromMeta(BlockType.COPPER.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_TIN, getStateFromMeta(BlockType.TIN.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_SILVER, getStateFromMeta(BlockType.SILVER.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_LEAD, getStateFromMeta(BlockType.LEAD.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_ALUMINUM, getStateFromMeta(BlockType.ALUMINUM.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_NICKEL, getStateFromMeta(BlockType.NICKEL.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_PLATINUM, getStateFromMeta(BlockType.PLATINUM.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_URANIUM, getStateFromMeta(BlockType.URANIUM.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_BRONZE, getStateFromMeta(BlockType.BRONZE.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_STEEL, getStateFromMeta(BlockType.STEEL.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_IRIDIUM, getStateFromMeta(BlockType.IRIDIUM.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_MITHRIL, getStateFromMeta(BlockType.MITHRIL.getMetaData()));
    }

    public enum BlockType implements IStringSerializable
    {
        COPPER(0, "copper"),
        TIN(1, "tin"),
        SILVER(2, "silver"),
        LEAD(3, "lead"),
        ALUMINUM(4, "aluminum"),
        NICKEL(5, "nickel"),
        PLATINUM(6, "platinum"),
        URANIUM(7, "uranium"),
        BRONZE(8, "bronze"),
        STEEL(9, "steel"),
        IRIDIUM(10, "iridium"),
        MITHRIL(11, "mithril");

        private static final BlockType[] META_LOOKUP = new BlockType[values().length];
        private int metaData;
        private String name;

        BlockType(int metaData, String name)
        {
            this.metaData = metaData;
            this.name = name;
        }

        private int getMetaData()
        {
            return this.metaData;
        }

        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public String toString()
        {
            return this.getName();
        }

        public static BlockType byMetaData(int metaData)
        {
            if (metaData < 0 || metaData >= META_LOOKUP.length)
            {
                metaData = 0;
            }
            return META_LOOKUP[metaData];
        }

        static
        {
            for (BlockType type : values())
            {
                META_LOOKUP[type.getMetaData()] = type;
            }
        }
    }
}
