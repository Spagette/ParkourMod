package com.spagette.parkourmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TestBlock extends Block {

    public TestBlock() {
        super(Properties.create(Material.EARTH)
                .sound(SoundType.SLIME)
                .hardnessAndResistance(0.5f)
                .lightValue(14)
        );
        setRegistryName("testblock");
    }
}
