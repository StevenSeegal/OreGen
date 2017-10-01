package com.dynu.stevenseegal.oregen.item;

public class ItemUpgrade extends ItemBaseMulti
{
    public ItemUpgrade(String name, String... subNames)
    {
        super(name, subNames);
        this.setMaxStackSize(8);
    }
}
