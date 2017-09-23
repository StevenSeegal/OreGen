package com.dynu.stevenseegal.oregen.handler;

import com.dynu.stevenseegal.oregen.util.LogHelper;
import com.dynu.stevenseegal.oregen.util.ReflectionHelper;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.lang.invoke.MethodHandle;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CapeUtils
{
    private static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
    private static final MethodHandle GET_PLAYER_INFO = ReflectionHelper.findMethod(AbstractClientPlayer.class, "getPlayerInfo", "func_175155_b");
    private static final MethodHandle GET_PLAYER_TEXTURES = ReflectionHelper.findFieldGetter(NetworkPlayerInfo.class, "playerTextures", "field_187107_a");

    static void queueCapeReplacement(AbstractClientPlayer player, ResourceLocation resourceLocation)
    {
        String displayName = player.getDisplayNameString();
        THREAD_POOL.submit(() ->
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                LogHelper.warn("Cape delay interrupted for " + displayName +  " : " + e);
                LogHelper.warn("This is NOT a game breaking error!!!");
            }
            Minecraft.getMinecraft().addScheduledTask(() -> replaceCape(player, resourceLocation));
        });
    }

    private static void replaceCape(AbstractClientPlayer player, ResourceLocation resourceLocation)
    {
        String displayName = player.getDisplayNameString();
        NetworkPlayerInfo playerInfo;

        try
        {
            playerInfo = (NetworkPlayerInfo)GET_PLAYER_INFO.invokeExact(player);
        }
        catch (Throwable e)
        {
            LogHelper.warn("Failed to get NetworkPlayerInfo from " + displayName + " : " + e);
            LogHelper.warn("This is NOT a game breaking error!!!");
            return;
        }
        if (playerInfo == null)
        {
            LogHelper.warn("NetworkPlayer is Null for " + displayName);
            LogHelper.warn("This is NOT a game breaking error!!!");
            return;
        }
        Map<MinecraftProfileTexture.Type, ResourceLocation> playerTextures;
        try
        {
            playerTextures = (Map<MinecraftProfileTexture.Type, ResourceLocation>)GET_PLAYER_TEXTURES.invokeExact(playerInfo);
        }
        catch (Throwable e)
        {
            LogHelper.warn("Failed to get player textures for " + displayName + " : " + e);
            LogHelper.warn("This is NOT a game breaking error!!!");
            return;
        }
        playerTextures.put(MinecraftProfileTexture.Type.CAPE, resourceLocation);
        player.sendMessage(new TextComponentString(TextFormatting.DARK_GREEN + "Enjoy your cape!"));
        LogHelper.info("Replaced cape for " + displayName);
    }
}
