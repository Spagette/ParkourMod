package com.spagette.parkourmod;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;



//handles events for ParkourMod
public class ParkourModEventHandler {


    @SubscribeEvent
    public void entityJoinWorld(LivingJumpEvent event){
        LivingEntity player = event.getEntityLiving();
        if(player.isAirBorne)
            player.setVelocity(0, 0.5, 0);

        System.out.println("player jumped");
        //event.getEntity().setVelocity(0,0,4.0);
    }
}
