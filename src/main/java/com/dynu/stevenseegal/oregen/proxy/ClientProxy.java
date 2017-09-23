package com.dynu.stevenseegal.oregen.proxy;

import com.dynu.stevenseegal.oregen.handler.CapeEventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends ServerProxy
{
    @Override
    public void init(FMLInitializationEvent event)
    {
        CapeEventHandler.loadCapeUsers();
    }
}
