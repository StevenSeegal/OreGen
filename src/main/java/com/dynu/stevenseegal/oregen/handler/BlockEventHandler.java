package com.dynu.stevenseegal.oregen.handler;

import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.init.ModItems;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

@Mod.EventBusSubscriber(modid = LibMod.MOD_ID)
public class BlockEventHandler
{
    public static Random RANDOM = new Random();

    @SubscribeEvent
    public static void onHarvestDropsEvent(BlockEvent.HarvestDropsEvent event)
    {
        if (Config.GFL_CHUNK_MODE && !event.getWorld().isRemote && event.getHarvester() != null && !event.isSilkTouching())
        {
            if (event.getState().getBlock() == Blocks.IRON_ORE)
            {
                int amount = getChunkQuantityWithFortune(event.getFortuneLevel());
                event.getDrops().clear();
                event.getDrops().add(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, amount, 12));
            }
            else if (event.getState().getBlock() == Blocks.GOLD_ORE)
            {
                int amount = getChunkQuantityWithFortune(event.getFortuneLevel());
                event.getDrops().clear();
                event.getDrops().add(new ItemStack(ModItems.ITEM_CHUNK_DIRTY, amount, 13));
            }
        }
    }

    @SubscribeEvent
    public static void onBreakEvent(BlockEvent.BreakEvent event)
    {
        if (Config.GFL_CHUNK_MODE && !event.getWorld().isRemote && event.getPlayer() != null && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, event.getPlayer().getHeldItemMainhand()) <= 0)
        {
            if (event.getState().getBlock() == Blocks.IRON_ORE || event.getState().getBlock() == Blocks.GOLD_ORE)
            {
                int xp = MathHelper.getInt(RANDOM, 0, 2);
                event.setExpToDrop(xp);
            }
        }
    }

    private static int getChunkQuantityWithFortune(int fortune)
    {
        if (fortune > 0 && RANDOM.nextFloat() <= Config.GFL_DOUBLE_CHUNK_CHANCE)
        {
            return 2;
        }
        return 1;
    }
}
