package com.spagette.parkourmod.items;

import com.spagette.parkourmod.ParkourMod;
import net.minecraft.item.Item;

public class ParkourBoots extends Item {

    public ParkourBoots(){
        super(new Item.Properties()
                .group(ParkourMod.setup.itemGroup)
                .maxStackSize(1));
        setRegistryName("parkourboots");
    }

}
