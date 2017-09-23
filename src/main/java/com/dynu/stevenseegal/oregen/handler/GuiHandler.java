package com.dynu.stevenseegal.oregen.handler;

import com.dynu.stevenseegal.oregen.client.GuiCrusher;
import com.dynu.stevenseegal.oregen.inventory.ContainerCrusher;
import com.dynu.stevenseegal.oregen.tileentity.TileEntityCrusher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler
{
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos blockPos = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(blockPos);

        if(tileEntity instanceof TileEntityCrusher)
        {
            return new ContainerCrusher(player.inventory, (TileEntityCrusher)tileEntity);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos blockPos = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(blockPos);

        if(tileEntity instanceof TileEntityCrusher)
        {
            return new GuiCrusher(player.inventory, (TileEntityCrusher)tileEntity);
        }
        return null;
    }
}
