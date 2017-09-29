package com.dynu.stevenseegal.oregen.init;

import com.dynu.stevenseegal.oregen.block.*;
import com.dynu.stevenseegal.oregen.block.item.ItemBlockBlock;
import com.dynu.stevenseegal.oregen.block.item.ItemBlockOre;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.dynu.stevenseegal.oregen.tileentity.TileEntityCrusher;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(LibMod.MOD_ID)
public class ModBlocks
{
    public static BlockOre BLOCK_ORE = new BlockOre(LibNames.Blocks.BLOCK_ORE);
    public static BlockBlock BLOCK_BLOCK = new BlockBlock(LibNames.Blocks.BLOCK_BLOCK);

    public static MachineCrusher MACHINE_CRUSHER = new MachineCrusher(LibNames.Blocks.MACHINE_CRUSHER, false);
    public static MachineCrusher MACHINE_CRUSHER_RUNNING = new MachineCrusher(LibNames.Blocks.MACHINE_CRUSHER_RUNNING, true);

    @Mod.EventBusSubscriber(modid = LibMod.MOD_ID)
    public static class RegistrationHandler
    {
        public static final Block[] BLOCKS =
                {
                        BLOCK_ORE,
                        BLOCK_BLOCK,

                        MACHINE_CRUSHER,
                        MACHINE_CRUSHER_RUNNING,
                };

        public static final ItemBlock[] ITEM_BLOCKS =
                {
                        new ItemBlockOre(BLOCK_ORE),
                        new ItemBlockBlock(BLOCK_BLOCK),

                        new ItemBlock(MACHINE_CRUSHER),
                        new ItemBlock(MACHINE_CRUSHER_RUNNING),
                };

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            event.getRegistry().registerAll(BLOCKS);
        }

        @SubscribeEvent
        public static void registerItemBlocks(final RegistryEvent.Register<Item> event)
        {
            for (ItemBlock itemBlock : ITEM_BLOCKS)
            {
                event.getRegistry().register(itemBlock.setRegistryName(getRegistryName(itemBlock.getBlock().getUnlocalizedName())));
            }
            setHarvestLevel();
            registerTileEntities();
            registerToOreDict();
        }

        public static void registerToOreDict()
        {
            for (Block block : BLOCKS)
            {
                if (block instanceof IBlockRegistryHandler)
                {
                    ((IBlockRegistryHandler) block).registerToOreDict();
                }
            }
        }

        public static void registerTileEntities()
        {
            GameRegistry.registerTileEntity(TileEntityCrusher.class, "_" + LibNames.Blocks.MACHINE_CRUSHER);
        }

        public static void setHarvestLevel()
        {
            for (Block block : BLOCKS)
            {
                if (block instanceof IBlockRegistryHandler)
                {
                    ((IBlockRegistryHandler) block).setHarvestLevel();
                }
            }
        }

        private static ResourceLocation getRegistryName(String input)
        {
            String name = input.substring(input.indexOf(LibMod.MOD_ID));
            name = name.replaceFirst("\\.", ":");
            return new ResourceLocation(name);
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event)
        {
            for (Block block : BLOCKS)
            {
                if (block instanceof IBlockRegistryHandler)
                {
                    ((IBlockRegistryHandler) block).initModel();
                }
            }
        }
    }
}
