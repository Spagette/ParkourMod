package com.spagette.parkourmod.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.item.ItemStack;


import java.util.Iterator;


//INFO ABOUT PLAYER OBJECT IN README**************

//handles events for ParkourMod
public class ClientHandler {

    final static int SPACE = 32;//ascii

//    @SubscribeEvent
//    public void parkourBootsSuperJump(LivingJumpEvent event){
//
//        LivingEntity player = event.getEntityLiving();
//        ItemStack items = player.getActiveItemStack();
//        Iterable<ItemStack> armor = player.getArmorInventoryList();
//        Iterator it = armor.iterator();
//        if("1 parkourboots".compareTo(it.next().toString())==0) {
//            player.setVelocity(0, 1, 0);
//            System.out.println("player jumped");
//        }
//    }

    @SubscribeEvent
    public void parkourBootsSecondJump(KeyInputEvent event){

        if(event.getKey() == SPACE ) {
            Minecraft mc = Minecraft.getInstance();
            ClientPlayerEntity player = mc.player;
            Iterable<ItemStack> armor = player.getArmorInventoryList();
            Iterator<ItemStack> it = armor.iterator();
            if ("1 parkourboots".compareTo(it.next().toString()) == 0) {
                player.setVelocity(0, 1, 0);
                System.out.println("player double jumped");
            }
        }
    }

}