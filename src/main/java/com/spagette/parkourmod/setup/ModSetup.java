package com.spagette.parkourmod.setup;

import com.spagette.parkourmod.blocks.ModBlocks;
import com.spagette.parkourmod.items.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

    public static ItemGroup itemGroup = new ItemGroup("parkourmod") {
        @Override
        public ItemStack createIcon(){
            return new ItemStack(ModItems.PARKOURBOOTS);
        }
    };

    public void init(){

    }
}