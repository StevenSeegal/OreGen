package com.dynu.stevenseegal.oregen.client;

import com.dynu.stevenseegal.oregen.inventory.ContainerCrusher;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import com.dynu.stevenseegal.oregen.tileentity.TileEntityCrusher;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCrusher extends GuiContainer
{
    private int animation = 0;
    private boolean reverse = false;

    public static final ResourceLocation GUI_BASE = new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.GUI_CRUSHER_BACKGROUND);
    private final InventoryPlayer playerInventory;
    private final IInventory crusherInventory;

    public GuiCrusher(InventoryPlayer playerInventory, IInventory crusherInventory)
    {
        super(new ContainerCrusher(playerInventory, crusherInventory));
        this.playerInventory = playerInventory;
        this.crusherInventory = crusherInventory;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.crusherInventory.getDisplayName().getFormattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        this.mc.getTextureManager().bindTexture(GUI_BASE);
        int xGui = (this.width - this.xSize) / 2;
        int yGui = (this.height - this. ySize) / 2;
        this.drawTexturedModalRect(xGui, yGui, 0, 0, this.xSize, this.ySize);

        if (TileEntityCrusher.isCrushing(this.crusherInventory))
        {
            int fuelBar = this.getCrushingLeftScaled(13);
            this.drawTexturedModalRect(xGui + 56, yGui + 36 + 12 - fuelBar, 176, 12 - fuelBar, 14, fuelBar + 1);
        }

        int progress = this.getCrushingProgressScaled(24);
        this.drawTexturedModalRect(xGui + 80, yGui + 41, 176, 31, progress + 1, 4);

        int ani = this.getAnimation(16);
        this.drawTexturedModalRect(xGui + 84, yGui + 25, 176, 30 - ani, 16, ani);
    }

    private int getCrushingProgressScaled(int pixels)
    {
        int i = this.crusherInventory.getField(2);
        int j = this.crusherInventory.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    private int getCrushingLeftScaled(int pixel)
    {
        int i = this.crusherInventory.getField(1);

        if (i == 0)
        {
            i = 200;
        }
        return this.crusherInventory.getField(0) * pixel / i;
    }

    private int getAnimation(int pixels)
    {
        if (hasWork())
        {
            if (!reverse)
            {
                animation++;
                if (animation == pixels)
                {
                    animation = pixels;
                    reverse = true;
                }
            }
            else
            {
                animation--;
                if (animation == 0)
                {
                    animation = 0;
                    reverse = false;
                }
            }
            return animation;
        }
        return 0;
    }

    private boolean hasWork()
    {
        int i = this.crusherInventory.getField(2);
        int j = this.crusherInventory.getField(3);
        return j != 0 && i != 0;
    }
}
