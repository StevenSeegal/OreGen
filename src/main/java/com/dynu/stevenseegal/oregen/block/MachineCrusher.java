package com.dynu.stevenseegal.oregen.block;

import com.dynu.stevenseegal.oregen.OreGen;
import com.dynu.stevenseegal.oregen.init.IBlockRegistryHandler;
import com.dynu.stevenseegal.oregen.init.ModBlocks;
import com.dynu.stevenseegal.oregen.init.ModItems;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.dynu.stevenseegal.oregen.tileentity.TileEntityCrusher;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class MachineCrusher extends Block implements ITileEntityProvider, IBlockRegistryHandler
{
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    private boolean isCrushing;
    private static boolean keepInventory;

    public MachineCrusher(String name, boolean active)
    {
        super((Material.ROCK));
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setSoundType(SoundType.STONE);
        this.setUnlocalizedName(LibMod.MOD_ID + "." + name);
        this.setRegistryName(name);

        this.isCrushing = active;

        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

        if (name.equals(LibNames.Blocks.MACHINE_CRUSHER))
        {
            this.setCreativeTab(OreGen.creativeTab);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void registerToOreDict()
    {
    }

    @Override
    public void setHarvestLevel()
    {

    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.MACHINE_CRUSHER);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.MACHINE_CRUSHER);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(FACING).getIndex(); // OK?
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumFacing = EnumFacing.getFront(meta);

        if (enumFacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumFacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumFacing);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING}); //OK
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityCrusher();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if (isCrushing)
        {
            EnumFacing enumfacing = (EnumFacing)stateIn.getValue(FACING);
            double d0 = (double)pos.getX() + 0.5D;
            double d1 = (double)pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
            double d2 = (double)pos.getZ() + 0.5D;
            double d3 = 0.52D;
            double d4 = rand.nextDouble() * 0.6D - 0.3D;

            if (rand.nextDouble() < 0.1D)
            {
                //worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
                // TODO Sound?
            }

            switch (enumfacing)
            {
                case WEST:
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
                    break;
                case EAST:
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
                    break;
                case NORTH:
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 - 0.52D, 0.0D, 0.0D, 0.0D);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 - 0.52D, 0.0D, 0.0D, 0.0D);
                    break;
                case SOUTH:
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 + 0.52D, 0.0D, 0.0D, 0.0D);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 + 0.52D, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if (!(tileEntity instanceof TileEntityCrusher))
        {
            return false;
        }
        if (playerIn.getHeldItemMainhand().isItemEqual(new ItemStack(ModItems.UPGRADE_ISIDED)))
        {
            if (((TileEntityCrusher) tileEntity).insertUpgrade())
            {
                playerIn.sendStatusMessage(new TextComponentTranslation(LibNames.Messages.UPGRADE_DONE), false);
                playerIn.getHeldItemMainhand().shrink(1);
            }
            else
            {
                playerIn.sendStatusMessage(new TextComponentTranslation(LibNames.Messages.UPGRADE_ERROR), false);
            }
            return false;
        }
        playerIn.openGui(OreGen.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    public static void setState(boolean active, World world, BlockPos blockPos)
    {
        IBlockState blockState = world.getBlockState(blockPos);
        TileEntity tileEntity = world.getTileEntity(blockPos);
        keepInventory = true;
        if (active)
        {
            world.setBlockState(blockPos, ModBlocks.MACHINE_CRUSHER_RUNNING.getDefaultState().withProperty(FACING, blockState.getValue(FACING)), 3);
        }
        else
        {
            world.setBlockState(blockPos, ModBlocks.MACHINE_CRUSHER.getDefaultState().withProperty(FACING, blockState.getValue(FACING)), 3);
        }
        keepInventory = false;

        if (tileEntity != null)
        {
            tileEntity.validate();
            world.setTileEntity(blockPos, tileEntity);
        }
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!keepInventory)
        {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof TileEntityCrusher)
            {
                TileEntityCrusher tileEntityCrusher = (TileEntityCrusher)tileEntity;
                InventoryHelper.dropInventoryItems(worldIn, pos, tileEntityCrusher);
                if (((TileEntityCrusher) tileEntity).hasISidedUpgrade())
                {
                    ItemStack itemStack = new ItemStack(ModItems.UPGRADE_ISIDED);
                    InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemStack);
                }
            }
        }
        super.breakBlock(worldIn, pos, state);
    }
}
