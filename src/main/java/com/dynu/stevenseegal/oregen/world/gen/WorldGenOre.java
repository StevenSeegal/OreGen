package com.dynu.stevenseegal.oregen.world.gen;

import com.dynu.stevenseegal.oregen.config.Config;
import com.dynu.stevenseegal.oregen.lib.LibMod;
import com.dynu.stevenseegal.oregen.lib.LibNames;
import com.dynu.stevenseegal.oregen.util.LogHelper;
import com.google.common.collect.ArrayListMultimap;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenOre implements IWorldGenerator
{
    public static ArrayList<OreSettings> oreToGenerate = new ArrayList<>();

    public static OreSettings addOreToGenerate(String name, IBlockState state, int veinSize, int veinsPerChunk, int minY, int maxY, int ratio)
    {
        LogHelper.debug("Added ore " + name + " to GEN, CONFIG AIR: " + Config.GENERATE_AIR);
        OreSettings gen = new OreSettings(name, state, veinSize + 2, Config.GENERATE_AIR ? Blocks.AIR : Blocks.STONE, minY, maxY, veinsPerChunk, ratio);
        oreToGenerate.add(gen);
        return gen;
    }

    public void generateOres(Random random, int chunkX, int chunkZ, World world, boolean newGen)
    {
        for (OreSettings gen : oreToGenerate)
        {
            if (newGen || Config.RETROGEN_ENABLED)
            {
                gen.generate(world, random, chunkX * 16, chunkZ * 16);
                //LogHelper.debug("Generating: " + gen.name);
            }
        }
    }

    @SubscribeEvent
    public void onChunckSave(ChunkDataEvent.Save event)
    {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        event.getData().setTag(LibMod.MOD_ID, nbtTagCompound);
        nbtTagCompound.setInteger(LibNames.Config.NBT.RETROGEN, Config.RETROGEN_VERSION);
    }

    @SubscribeEvent
    public void onChunkLoad(ChunkDataEvent.Load event)
    {
        if (event.getWorld().provider.getDimension() == 0)
        {
            if (Config.RETROGEN_ENABLED)
            {
                if (event.getData().getCompoundTag(LibMod.MOD_ID).hasKey(LibNames.Config.NBT.RETROGEN))
                {
                    int chuckVersion = event.getData().getCompoundTag(LibMod.MOD_ID).getInteger(LibNames.Config.NBT.RETROGEN);
                    if (chuckVersion < Config.RETROGEN_VERSION)
                    {
                        LogHelper.debug("Chunk: " + event.getChunk().getPos() + " Has v: " + chuckVersion + " and retroGen v: " + Config.RETROGEN_VERSION + " YES retrogen");
                        RETROGEN_CHUNKS.put(event.getWorld().provider.getDimension(), event.getChunk().getPos());
                    }
                    else
                    {
                        LogHelper.debug("Chunk: " + event.getChunk().getPos() + " Has v: " + chuckVersion + " and retroGen v: " + Config.RETROGEN_VERSION + " NO retrogen");
                    }
                }
            }
            else
            {
                LogHelper.debug("RETROGEN DISABLED");
            }
        }
    }

    public static ArrayListMultimap<Integer, ChunkPos> RETROGEN_CHUNKS = ArrayListMultimap.create();
    @SubscribeEvent
    public void serverWorldTick(TickEvent.WorldTickEvent event)
    {
        if (event.side == Side.CLIENT || event.phase == TickEvent.Phase.START)
            return;
        int dim = event.world.provider.getDimension();
        int count = 0;
        List<ChunkPos> chunks = RETROGEN_CHUNKS.get(dim);
        if (chunks != null && chunks.size() > 0)
            for (int i = 0; i < 2; i++)
            {
                chunks = RETROGEN_CHUNKS.get(dim);
                if (chunks == null || chunks.size() <= 0)
                    break;
                count++;
                ChunkPos pos = chunks.get(0);
                long worldSeed = event.world.getSeed();
                Random random = new Random(worldSeed);
                long seedX = (random.nextLong() >> 3);
                long seedZ = (random.nextLong() >> 3);
                random.setSeed(seedX * pos.x + seedZ * pos.z ^ worldSeed);
                this.generateOres(random, pos.x, pos.z, event.world, false);
                chunks.remove(0);
            }
        if (count > 0)
        {
            if (Config.RETROGEN_LOG)
            {
                LogHelper.info("Retrogen complete. Count: " + count + " chunks. " + Math.max(0, chunks.size()) + " chunks remaining");
            }
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        this.generateOres(random, chunkX, chunkZ, world, true);
    }

    public static class OreSettings
    {
        String name;
        WorldGenMinable genMinable;
        int minY;
        int maxY;
        int veinsPerChunk;
        int ratio;

        public OreSettings(String name, IBlockState state, int maxVeinSize, Block replaceTarget, int minY, int maxY, int veinsPerChunk, int ratio)
        {
            this.name = name;
            this.genMinable = new WorldGenMinable(state, maxVeinSize, BlockMatcher.forBlock(replaceTarget));
            this.minY = minY;
            this.maxY = maxY;
            this.veinsPerChunk = veinsPerChunk;
            this.ratio = ratio;
        }

        public void generate(World world, Random random, int x, int z)
        {
            BlockPos pos;
            for (int i = 0; i < veinsPerChunk; i++)
                if (random.nextInt(100) < ratio)
                {
                    pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(maxY - minY), z + random.nextInt(16));
                    genMinable.generate(world, random, pos);
                }
        }
    }
}