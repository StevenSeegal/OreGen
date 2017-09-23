package com.dynu.stevenseegal.oregen.inventory;

import com.dynu.stevenseegal.oregen.tileentity.TileEntityCrusher;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCrusherFuel extends Slot
{
    public SlotCrusherFuel(IInventory inventoryIn, int index, int xPosition, int yPosition)
    {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return TileEntityCrusher.isItemFuel(stack);
    }
}
