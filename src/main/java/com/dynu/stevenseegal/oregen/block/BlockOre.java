package com.dynu.stevenseegal.oregen.block;

import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.init.ModItems;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
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
        return state.getValue(ORE_TYPE).getMetaData();
    }

    public String getName(ItemStack itemStack)
    {
        return OreType.byMetaData(itemStack.getMetadata()).getName();
    }

    private List<ItemStack> getNonSilkTouchDrops(Item item, int metaData, int amount, int fortune, Random random)
    {
        NonNullList<ItemStack> dropList = NonNullList.create();
        int count = amount;

        if (fortune > 0)
        {
            int fort = random.nextInt(fortune + 2) - 1;
            if (fort < 0)
            {
                fort = 0;
            }
            count = count * (fort + 1);
        }

        for (int i = 0; i < count; i++)
        {
            dropList.add(new ItemStack(item, 1, metaData));
        }
        return dropList;
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack heldItem)
    {
        int blockStateMeta = state.getValue(ORE_TYPE).getMetaData();
        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, heldItem) == 0 && (blockStateMeta == OreType.SULFUR.getMetaData() || blockStateMeta == OreType.SALTPETER.getMetaData()))
        {
            List<ItemStack> dropList = new ArrayList<>();
            int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, heldItem);
            if (blockStateMeta == OreType.SULFUR.getMetaData())
            {
                dropList = getNonSilkTouchDrops(ModItems.ITEM_DUST, 10, 5, fortune, worldIn.rand);
            }
            else if (blockStateMeta == OreType.SALTPETER.getMetaData())
            {
                dropList = getNonSilkTouchDrops(ModItems.ITEM_DUST, 11, 2, fortune, worldIn.rand);
            }

            for (ItemStack itemStack : dropList)
            {
                spawnAsEntity(worldIn, pos, itemStack);
            }
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, heldItem);
        }
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
    }

    public enum OreType implements IStringSerializable
    {
        COPPER(0, "copper"),
        TIN(1, "tin"),
        SILVER(2, "silver"),
        LEAD(3, "lead"),
        ALUMINUM(4, "aluminum"),
        NICKEL(5, "nickel"),
        PLATINUM(6, "platinum"),
        URANIUM(7,"uranium"),
        SULFUR(8, "sulfur"),
        SALTPETER(9, "saltpeter");

        private static final OreType[] META_LOOKUP = new OreType[values().length];
        private int metaData;
        private String name;

        OreType(int metaData, String name)
        {
            this.metaData = metaData;
            this.name = name;
        }

        public int getMetaData()
        {
            return this.metaData;
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
