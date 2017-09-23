package com.dynu.stevenseegal.oregen.tileentity;

import com.dynu.stevenseegal.oregen.block.MachineCrusher;
import com.dynu.stevenseegal.oregen.handler.CrusherRecipeManager;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import javax.annotation.Nullable;

public class TileEntityCrusher extends TileEntity implements ITickable, ISidedInventory
{
    private static final int[] SLOT_TOP = new int[] {0};
    private static final int[] SLOT_BOTTOM = new int[] {2};
    private static final int[] SLOT_SIDE = new int[] {1};

    private NonNullList<ItemStack> crusherInventory = NonNullList.withSize(3, ItemStack.EMPTY);

    private int crusherCrushTime;
    private int currentItemCrushTime;
    private int crushTime;
    private int totalCrushTime;
    private boolean iSidedUpgrade = false;

    @Override
    public int getSizeInventory()
    {
        return this.crusherInventory.size();
    }

    @Override
    public boolean isEmpty()
    {
        for (ItemStack itemStack : this.crusherInventory)
        {
            if (!itemStack.isEmpty())
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index)
    {
        return this.crusherInventory.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.crusherInventory, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.crusherInventory, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        ItemStack itemStack = this.crusherInventory.get(index);
        boolean flag = !stack.isEmpty() &&stack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(stack, itemStack);
        this.crusherInventory.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }
        if (index == 0 && !flag)
        {
            this.totalCrushTime = this.getCrushTime(stack);
            this.crushTime = 0;
            this.markDirty();
        }
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        if (this.world.getTileEntity(this.pos) != this)
        {
            return false;
        }
        else
        {
            return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public void openInventory(EntityPlayer player)
    {
    }

    @Override
    public void closeInventory(EntityPlayer player)
    {
    }

    @Override
    public void clear()
    {
        this.crusherInventory.clear();
    }

    @Override
    public void update()
    {
        boolean flag = this.isCrushing();
        boolean flag1 = false;

        if (this.isCrushing())
        {
            --this.crusherCrushTime;
        }

        if (!this.world.isRemote)
        {
            ItemStack itemStack = this.crusherInventory.get(1);
            if (this.isCrushing() || !itemStack.isEmpty() && !this.crusherInventory.get(0).isEmpty())
            {
                if (!this.isCrushing() && this.canCrush())
                {
                    this.crusherCrushTime = getItemBurnTime(itemStack);
                    this.currentItemCrushTime = this.crusherCrushTime;

                    if (this.isCrushing())
                    {
                        flag1 = true;

                        if (!itemStack.isEmpty())
                        {
                            Item item = itemStack.getItem();
                            itemStack.shrink(1);

                            if (itemStack.isEmpty())
                            {
                                ItemStack item1 = item.getContainerItem(itemStack);
                                this.crusherInventory.set(1, item1);
                            }
                        }
                    }
                }

                if (this.isCrushing() && this.canCrush())
                {
                    ++this.crushTime;

                    if (this.crushTime == this.totalCrushTime)
                    {
                        this.crushTime = 0;
                        this.totalCrushTime = this.getCrushTime(this.crusherInventory.get(0));
                        this.crushItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.crushTime = 0;
                }
            }
            else if (!this.isCrushing() && this.crushTime > 0)
            {
                this.crushTime = MathHelper.clamp(this.crushTime - 2, 0, this.totalCrushTime);
            }

            if (flag != this.isCrushing())
            {
                flag1 = true;
                MachineCrusher.setState(this.isCrushing(), this.world, this.pos);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    @Override
    public String getName()
    {
        return LibNames.Gui.CRUSHER_TITLE;
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName()
    {
        return new TextComponentTranslation(LibNames.Gui.CRUSHER_TITLE);
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }

    public int getCrushTime(ItemStack itemStack)
    {
        return CrusherRecipeManager.instance().getCrushTime(itemStack);
    }

    public static int getItemBurnTime(ItemStack itemStack)
    {
        if (itemStack.isEmpty())
        {
            return 0;
        }
        else
        {
            return TileEntityFurnace.getItemBurnTime(itemStack);
        }
    }

    public static boolean isItemFuel(ItemStack itemStack)
    {
        return getItemBurnTime(itemStack) > 0;
    }

    public boolean isCrushing()
    {
        return this.crusherCrushTime > 0;
    }

    private boolean canCrush()
    {
        if ((this.crusherInventory.get(0)).isEmpty())
        {
            return false;
        }
        else
        {
            ItemStack recipeStack = CrusherRecipeManager.instance().getCrushingResult(this.crusherInventory.get(0));

            if (recipeStack.isEmpty())
            {
                return false;
            }
            else
            {
                ItemStack outputSlot = this.crusherInventory.get(2);

                if (outputSlot.isEmpty())
                {
                    return true;
                }
                else if (!outputSlot.isItemEqual(recipeStack))
                {
                    return false;
                }
                else if (outputSlot.getCount() + recipeStack.getCount() <= this.getInventoryStackLimit() && outputSlot.getCount() + recipeStack.getCount() <= outputSlot.getMaxStackSize())
                {
                    return true;
                }
                else
                {
                    return outputSlot.getCount() + recipeStack.getCount() <= recipeStack.getMaxStackSize();
                }
            }
        }
    }

    public void crushItem()
    {
        if (this.canCrush())
        {
            ItemStack inputSlotStack = this.crusherInventory.get(0);
            ItemStack crushResult = CrusherRecipeManager.instance().getCrushingResult(inputSlotStack);
            ItemStack outputSlotStack = this.crusherInventory.get(2);

            if (outputSlotStack.isEmpty())
            {
                this.crusherInventory.set(2, crushResult.copy());
            }
            else if (outputSlotStack.getItem() == crushResult.getItem())
            {
                outputSlotStack.grow(crushResult.getCount());
            }
            inputSlotStack.shrink(1);
        }
    }

    @SideOnly(Side.CLIENT)
    public static boolean isCrushing(IInventory inventory)
    {
        return inventory.getField(0) > 0;
    }



    @Override
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.crusherCrushTime;
            case 1:
                return this.currentItemCrushTime;
            case 2:
                return this.crushTime;
            case 3:
                return this.totalCrushTime;
            default:
                return 0;
        }
    }

    @Override
    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.crusherCrushTime = value;
                break;
            case 1:
                this.currentItemCrushTime = value;
                break;
            case 2:
                this.crushTime = value;
                break;
            case 3:
                this.totalCrushTime = value;
        }
    }

    @Override
    public int getFieldCount()
    {
        return 4;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side)
    {
        if (side == EnumFacing.DOWN)
        {
            return SLOT_BOTTOM;
        }
        else if (side == EnumFacing.UP)
        {
            return SLOT_TOP;
        }
        else
        {
            return SLOT_SIDE;
        }
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 2)
        {
            return false;
        }
        else if (index != 1)
        {
            return true;
        }
        else
        {
            return isItemFuel(stack);
        }
    }

    public boolean hasISidedUpgrade()
    {
        return this.iSidedUpgrade;
    }

    public boolean insertUpgrade()
    {
        if (this.hasISidedUpgrade())
        {
            return false;
        }
        else
        {
            this.iSidedUpgrade = true;
            return true;
        }
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.hasISidedUpgrade() ? this.isItemValidForSlot(index, itemStackIn) : false;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
    {
        return this.hasISidedUpgrade() ? true : false;
    }

    IItemHandler handlerTop = new SidedInvWrapper(this, EnumFacing.UP);
    IItemHandler handlerBottom = new SidedInvWrapper(this, EnumFacing.DOWN);
    IItemHandler handlerSide = new SidedInvWrapper(this, EnumFacing.WEST);

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        if (facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            if (facing == EnumFacing.DOWN)
            {
                return (T) handlerBottom;
            }
            else if (facing == EnumFacing.UP)
            {
                return (T) handlerTop;
            }
            else
            {
                return (T) handlerSide;
            }
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.crusherInventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.crusherInventory);
        this.crusherCrushTime = compound.getInteger(LibNames.NBT.CRUSHERCRUSHTIME);
        this.crushTime = compound.getInteger(LibNames.NBT.CRUSHTIME);
        this.totalCrushTime = compound.getInteger(LibNames.NBT.TOTALCRUSHTIME);
        this.currentItemCrushTime = compound.getInteger(LibNames.NBT.CURRENTITEMCRUSHTIME);
        this.iSidedUpgrade = compound.getBoolean(LibNames.NBT.ISIDEDUPGRADE);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger(LibNames.NBT.CRUSHERCRUSHTIME, this.crusherCrushTime);
        compound.setInteger(LibNames.NBT.CRUSHTIME, this.crushTime);
        compound.setInteger(LibNames.NBT.TOTALCRUSHTIME, this.totalCrushTime);
        compound.setInteger(LibNames.NBT.CURRENTITEMCRUSHTIME, this.currentItemCrushTime);
        compound.setBoolean(LibNames.NBT.ISIDEDUPGRADE, this.iSidedUpgrade);
        ItemStackHelper.saveAllItems(compound, this.crusherInventory);

        return compound;
    }
}
