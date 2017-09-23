package com.dynu.stevenseegal.oregen.handler;

import com.dynu.stevenseegal.oregen.lib.LibMod;
import com.dynu.stevenseegal.oregen.util.LogHelper;
import com.google.common.io.ByteStreams;
import com.google.gson.Gson;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = LibMod.MOD_ID)
public class CapeEventHandler
{
    private static Map<UUID, String> CAPE_USERS = new HashMap<UUID, String>();
    private static Map<String, ResourceLocation> PERSONAL_CAPES = new HashMap<String, ResourceLocation>();
    private static final ResourceLocation DEFAULT_CAPE = new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.CAPE_TEXTURE_DEFAULT);

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinWorldEvent event)
    {
        if (event.getEntity() instanceof AbstractClientPlayer && playerHasCape((AbstractClientPlayer)event.getEntity()))
        {
            AbstractClientPlayer player = (AbstractClientPlayer)event.getEntity();
            CapeUtils.queueCapeReplacement((AbstractClientPlayer)event.getEntity(), getCapeForPlayer(CAPE_USERS.get(player.getUniqueID())));
        }
    }

    private static boolean playerHasCape(AbstractClientPlayer player)
    {
        return CAPE_USERS.containsKey(player.getUniqueID()) ? true : false;
    }

    private static ResourceLocation getCapeForPlayer(String player)
    {
        ResourceLocation resourceLocation = DEFAULT_CAPE;
        if (PERSONAL_CAPES.containsKey(player))
        {
            resourceLocation = PERSONAL_CAPES.get(player);
        }
        return resourceLocation;
    }

    public static void loadCapeUsers()
    {
        try
        {
            InputStream connection = new URL(LibMod.CAPE_URL).openStream();
            String data = new String(ByteStreams.toByteArray(connection));
            connection.close();

            Map<String, String> json = new Gson().fromJson(data, Map.class);

            for (Map.Entry<String, String> entry : json.entrySet())
            {
                if (entry.getKey() != null && entry.getValue() != null && !entry.getKey().equals("") && !entry.getValue().equals(""))
                {
                    CAPE_USERS.put(UUID.fromString(entry.getKey()), entry.getValue());
                }
            }
        }
        catch (Exception e)
        {
            LogHelper.warn("Error loading Json from URL :" + e);
            LogHelper.warn("This is NOT a game breaking error!!!");
        }

        PERSONAL_CAPES.put("StevenSeegal", new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.CAPE_TEXTURE_STEVENSEEGAL));
        PERSONAL_CAPES.put("Y0ungSandwich", new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.CAPE_TEXTURE_YOUNGSANDWICH));
        PERSONAL_CAPES.put("G4m3_0v3r", new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.CAPE_TEXTURE_GAMEOVER));
        PERSONAL_CAPES.put("IRoomI", new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.CAPE_TEXTURE_IROOMI));
        PERSONAL_CAPES.put("Kamizura", new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.CAPE_TEXTURE_KAMIZURA));
        PERSONAL_CAPES.put("Mattokah", new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.CAPE_TEXTURE_MATTOKAH));
        PERSONAL_CAPES.put("TriffidDK", new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.CAPE_TEXTURE_TRIFFIDDK));
        PERSONAL_CAPES.put("C317C3", new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.CAPE_TEXTURE_CTHREE));

        // For testing only, need to be removed if all works well TODO
        PERSONAL_CAPES.put("StevenSeegalTEST", new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.CAPE_TEXTURE_STEVENSEEGAL));
        PERSONAL_CAPES.put("Y0ungSandwichTEST", new ResourceLocation(LibMod.MOD_ID, LibMod.Textures.CAPE_TEXTURE_STEVENSEEGAL));
    }
}
