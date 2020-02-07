package com.spagette.parkourmod;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.item.ItemStack;

import java.util.Iterator;


//INFO ABOUT PLAYER OBJECT IN README**************

//handles events for ParkourMod
public class ParkourModEventHandler {


    @SubscribeEvent
    public void parkourBootsSuperJump(LivingJumpEvent event){

        LivingEntity player = event.getEntityLiving();
        ItemStack items = player.getActiveItemStack();
        Iterable<ItemStack> armor = player.getArmorInventoryList();
        Iterator it = armor.iterator();
        if("1 parkourboots".compareTo(it.next().toString())==0) {
            player.setVelocity(0, 1, 0);
            System.out.println("player jumped");
        }
    }

    @SubscribeEvent
    public void parkourBootsSecondJump(LivingFallEvent event){

        LivingEntity player = event.getEntityLiving();
        Iterable<ItemStack> armor = player.getArmorInventoryList();
        Iterator<ItemStack> it = armor.iterator();
        if("1 parkourboots".compareTo(it.next().toString())==0){
            player.setVelocity( 0, 1, 0);
            System.out.println("player double jumped");
        }


    }

}
