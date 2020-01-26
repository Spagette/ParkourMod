package com.spagette.parkourmod.items;

import com.spagette.parkourmod.ParkourMod;
import net.minecraft.item.Item;

public class TestItem extends Item {

    public TestItem(){
        super(new Item.Properties()
                .group(ParkourMod.setup.itemGroup)
                .maxStackSize(16));
        setRegistryName("testitem");
    }

}
