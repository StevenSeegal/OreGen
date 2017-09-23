package com.dynu.stevenseegal.oregen.inventory;

import com.dynu.stevenseegal.oregen.handler.CrusherRecipeManager;
import com.dynu.stevenseegal.oregen.tileentity.TileEntityCrusher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerCrusher extends Container
{
    private final IInventory crusherInventory;
    private int crusherCrushTime;
    private int currentItemCrushTime;
    private int crushTime;
    private int totalCrushTime;

    public ContainerCrusher(InventoryPlayer playerInventory, IInventory crusherInventory)
    {
        this.crusherInventory = crusherInventory;

        this.addSlotToContainer(new Slot(crusherInventory, 0, 56, 17));
        this.addSlotToContainer(new SlotCrusherFuel(crusherInventory, 1, 56, 53));
        this. addSlotToContainer(new SlotCrusherOutput(playerInventory.player, crusherInventory, 2, 116, 35));

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; k++)
        {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }

    @Override
    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.crusherInventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.crusherInventory.isUsableByPlayer(playerIn);
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); i++)
        {
            IContainerListener iContainerListener = this.listeners.get(i);

            if (this.crushTime != this.crusherInventory.getField(2))
            {
                iContainerListener.sendWindowProperty(this, 2, this.crusherInventory.getField(2));
            }
            if (this.crusherCrushTime != this.crusherInventory.getField(0))
            {
                iContainerListener.sendWindowProperty(this, 0, this.crusherInventory.getField(0));
            }
            if (this.currentItemCrushTime != this.crusherInventory.getField(1))
            {
                iContainerListener.sendWindowProperty(this, 1, this.crusherInventory.getField(1));
            }
            if (this.totalCrushTime != this.crusherInventory.getField(3))
            {
                iContainerListener.sendWindowProperty(this, 3, this.crusherInventory.getField(3));
            }
        }

        this.crushTime = this.crusherInventory.getField(2);
        this.crusherCrushTime = this.crusherInventory.getField(0);
        this.currentItemCrushTime = this.crusherInventory.getField(1);
        this.totalCrushTime = this.crusherInventory.getField(3);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int data)
    {
        this.crusherInventory.setField(id, data);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();
            if (index == 2)
            {
                if (!this.mergeItemStack(itemStack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(itemStack1, itemStack);
            }
            else if (index != 1 && index != 0)
            {
                if (!CrusherRecipeManager.instance().getCrushingResult(itemStack1).isEmpty())
                {
                    if (!this.mergeItemStack(itemStack1, 0, 1, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (TileEntityCrusher.isItemFuel(itemStack1))
                {
                    if (!this.mergeItemStack(itemStack1, 1, 2, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemStack1, 30, 39, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemStack1, 3, 30, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemStack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
            if (itemStack1.getCount() == itemStack.getCount())
            {
                return ItemStack.EMPTY;
            }
            slot.onTake(playerIn, itemStack1);
        }
        return itemStack;
    }
}
