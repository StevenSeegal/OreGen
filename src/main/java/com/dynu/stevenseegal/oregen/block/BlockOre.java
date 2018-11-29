package com.dynu.stevenseegal.oregen.block;

import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.init.ModItems;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

public class BlockOre extends BlockBase
{
    public static final PropertyEnum<OreType> ORE_TYPE = PropertyEnum.create("type", OreType.class);

    public BlockOre(String name)
    {
        super(name, 3.0F, 5.0F);

        this.setDefaultState(this.blockState.getBaseState().withProperty(ORE_TYPE, OreType.COPPER));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, ORE_TYPE);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(ORE_TYPE, OreType.byMetaData(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(ORE_TYPE).getMetaData();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (OreType type : OreType.values())
        {
            items.add(new ItemStack(this, 1, type.metaData));
        }
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        if (state.getValue(ORE_TYPE).getMetaData() == OreType.SULFUR.getMetaData() || state.getValue(ORE_TYPE).getMetaData() == OreType.SALTPETER.getMetaData())
        {
            return state.getValue(ORE_TYPE).getItemDropMeta();
        }
        else if (Config.GFL_CHUNK_MODE)
        {
            return state.getValue(ORE_TYPE).getItemDropMeta();
        }
        return state.getValue(ORE_TYPE).getMetaData();
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if (state.getValue(ORE_TYPE).getMetaData() == OreType.SULFUR.getMetaData() || state.getValue(ORE_TYPE).getMetaData() == OreType.SALTPETER.getMetaData())
        {
            return ModItems.ITEM_DUST;
        }
        else if (Config.GFL_CHUNK_MODE)
        {
            return ModItems.ITEM_CHUNK_DIRTY;
        }
        return Item.getItemFromBlock(this);
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        Random random = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, random, fortune) != Item.getItemFromBlock(this))
        {
            int xp = 0;
            if (state.getValue(ORE_TYPE).getMetaData() == OreType.SULFUR.getMetaData() || state.getValue(ORE_TYPE).getMetaData() == OreType.SALTPETER.getMetaData())
            {
                xp = MathHelper.getInt(random, state.getValue(ORE_TYPE).getMinXP(), state.getValue(ORE_TYPE).getMaxXP());
            }
            else if (Config.GFL_CHUNK_MODE)
            {
                xp = MathHelper.getInt(random, state.getValue(ORE_TYPE).getMinXP(), state.getValue(ORE_TYPE).getMaxXP());
            }
            return xp;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random)
    {
        int amount = 1;
        if (state.getValue(ORE_TYPE).getMetaData() == OreType.SULFUR.getMetaData())
        {
            amount = getNormalQuantityWithFortune(5, fortune, random);
        }
        else if (state.getValue(ORE_TYPE).getMetaData() == OreType.SALTPETER.getMetaData())
        {
            amount = getNormalQuantityWithFortune(2, fortune, random);
        }
        else if (Config.GFL_CHUNK_MODE)
        {
            amount = getChunkQuantityWithFortune(fortune, random);
        }
        return amount;
    }

    private int getNormalQuantityWithFortune(int defaultAmount, int fortune, Random random)
    {
        if (fortune > 0)
        {
            int bonus = random.nextInt(fortune + 2) -1;
            if (bonus < 0)
            {
                bonus = 0;
            }
            return defaultAmount * (bonus + 1);
        }
        else
        {
            return defaultAmount;
        }
    }

    private int getChunkQuantityWithFortune(int fortune, Random random)
    {
        if (fortune > 0 && random.nextFloat() <= Config.GFL_DOUBLE_CHUNK_CHANCE)
        {
            return 2;
        }
        return 1;
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        return true;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, state.getValue(ORE_TYPE).metaData);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initModel()
    {
        for (OreType type : OreType.values())
        {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), type.getMetaData(), new ModelResourceLocation(this.getRegistryName(), "type=" + OreType.byMetaData(type.getMetaData()).getName()));
        }
    }

    @Override
    public void registerToOreDict()
    {
        OreDictionary.registerOre(LibNames.OreDict.Blocks.COPPER_ORE, new ItemStack(this, 1, OreType.COPPER.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.TIN_ORE, new ItemStack(this, 1, OreType.TIN.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.SILVER_ORE, new ItemStack(this, 1, OreType.SILVER.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.LEAD_ORE, new ItemStack(this, 1, OreType.LEAD.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.ALUMINUM_ORE, new ItemStack(this, 1, OreType.ALUMINUM.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.NICKEL_ORE, new ItemStack(this, 1, OreType.NICKEL.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.PLATINUM_ORE, new ItemStack(this, 1, OreType.PLATINUM.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.URANIUM_ORE, new ItemStack(this, 1, OreType.URANIUM.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.SULFUR_ORE, new ItemStack(this, 1, OreType.SULFUR.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.SALTPETER_ORE, new ItemStack(this, 1, OreType.SALTPETER.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.IRIDIUM_ORE, new ItemStack(this, 1, OreType.IRIDIUM.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.MITHRIL_ORE, new ItemStack(this, 1, OreType.MITHRIL.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.NTH_ORE, new ItemStack(this, 1, OreType.NTH.getMetaData()));
        OreDictionary.registerOre(LibNames.OreDict.Blocks.URU_ORE, new ItemStack(this, 1, OreType.URU.getMetaData()));
    }

    @Override
    public void setHarvestLevel()
    {
        setHarvestLevel("pickaxe", 2);
        setHarvestLevel("pickaxe", Config.HARVEST_COPPER, getStateFromMeta(OreType.COPPER.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_TIN, getStateFromMeta(OreType.TIN.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_SILVER, getStateFromMeta(OreType.SILVER.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_LEAD, getStateFromMeta(OreType.LEAD.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_ALUMINUM, getStateFromMeta(OreType.ALUMINUM.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_NICKEL, getStateFromMeta(OreType.NICKEL.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_PLATINUM, getStateFromMeta(OreType.PLATINUM.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_URANIUM, getStateFromMeta(OreType.URANIUM.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_SULFUR, getStateFromMeta(OreType.SULFUR.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_SALTPETER, getStateFromMeta(OreType.SALTPETER.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_IRIDIUM, getStateFromMeta(OreType.IRIDIUM.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_MITHRIL, getStateFromMeta(OreType.MITHRIL.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_NTH, getStateFromMeta(OreType.NTH.getMetaData()));
        setHarvestLevel("pickaxe", Config.HARVEST_URU, getStateFromMeta(OreType.URU.getMetaData()));
    }

    public enum OreType implements IStringSerializable
    {
        COPPER(0, "copper", 0, 0, 2),
        TIN(1, "tin", 1, 0, 2),
        SILVER(2, "silver", 2, 1, 3),
        LEAD(3, "lead", 3, 0, 2),
        ALUMINUM(4, "aluminum", 4, 0, 2),
        NICKEL(5, "nickel", 5, 2, 4),
        PLATINUM(6, "platinum", 7, 2, 5),
        URANIUM(7,"uranium", 6, 0, 2),
        SULFUR(8, "sulfur", 10, 0, 2),
        SALTPETER(9, "saltpeter", 11, 0, 2),
        IRIDIUM(10, "iridium", 8, 3, 6),
        MITHRIL(11, "mithril", 9, 3, 6),
        NTH(12, "nth", 10, 0, 2),
        URU(13, "uru", 11, 0, 2);

        private static final OreType[] META_LOOKUP = new OreType[values().length];
        private int metaData;
        private int itemDropMeta;
        private int minXP;
        private int maxXP;
        private String name;

        OreType(int metaData, String name, int itemDropMeta, int minXP, int maxXP)
        {
            this.metaData = metaData;
            this.name = name;
            this.itemDropMeta = itemDropMeta;
            this.minXP = minXP;
            this.maxXP = maxXP;
        }

        public int getMetaData()
        {
            return this.metaData;
        }

        public int getItemDropMeta()
        {
            return this.itemDropMeta;
        }

        public int getMinXP()
        {
            return this.minXP;
        }

        public int getMaxXP()
        {
            return this.maxXP;
        }

        @Override
        public String getName()
        {
            return this.name;
        }

        @Override
        public String toString()
        {
            return this.getName();
        }

        public static OreType byMetaData(int metaData)
        {
            if (metaData < 0 || metaData >= META_LOOKUP.length)
            {
                metaData = 0;
            }
            return META_LOOKUP[metaData];
        }

        static
        {
            for (OreType type : values())
            {
                META_LOOKUP[type.getMetaData()] = type;
            }
        }
    }
}
