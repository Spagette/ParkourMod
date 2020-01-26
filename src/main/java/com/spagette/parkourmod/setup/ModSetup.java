package com.spagette.parkourmod.setup;

import com.spagette.parkourmod.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

    public static ItemGroup itemGroup = new ItemGroup("parkourmod") {
        @Override
        public ItemStack createIcon(){
            return new ItemStack(ModBlocks.TESTBLOCK);
        }
    };

    public void init(){

    }
}