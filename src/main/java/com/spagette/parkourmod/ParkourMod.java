package com.spagette.parkourmod;

import com.spagette.parkourmod.items.ParkourBoots;
import com.spagette.parkourmod.lists.ArmorMaterialList;
import com.spagette.parkourmod.setup.ClientProxy;
import com.spagette.parkourmod.setup.IProxy;
import com.spagette.parkourmod.setup.ModSetup;
import com.spagette.parkourmod.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("parkourmod")
public class ParkourMod
{
    public static String modid = "parkourmod";
    //handles being on client or server side
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public ParkourMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event){
            event.getRegistry().register(new ParkourBoots());
            MinecraftForge.EVENT_BUS.register(new ParkourModEventHandler());
        }
    }
}
