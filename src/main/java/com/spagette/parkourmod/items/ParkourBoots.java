package com.spagette.parkourmod.items;

import com.spagette.parkourmod.ParkourMod;
import com.spagette.parkourmod.lists.ArmorMaterialList;
import com.spagette.parkourmod.setup.ModSetup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ParkourBoots extends ArmorItem {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Properties properties = new Item.Properties()
            .group(ModSetup.itemGroup)
            .maxStackSize(1);

    public ParkourBoots(){
        super(ArmorMaterialList.parkour, EquipmentSlotType.FEET, properties);
        setRegistryName("parkourboots");
    }

    @SubscribeEvent
    public static void doubleJump(LivingEvent.LivingJumpEvent event){
        LOGGER.info("Player has jumped");
    }

}
