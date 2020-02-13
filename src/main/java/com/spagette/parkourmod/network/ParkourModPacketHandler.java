package com.spagette.parkourmod.network;


import com.spagette.parkourmod.ParkourMod;
import com.spagette.parkourmod.network.messages.MessageDoDoubleJump;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ParkourModPacketHandler {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel SIMPLE_CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(ParkourMod.modid, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private int id = 0;
    public ParkourModPacketHandler(){
        this.SIMPLE_CHANNEL.registerMessage(id++, MessageDoDoubleJump.class, MessageDoDoubleJump::write, MessageDoDoubleJump::new, MessageDoDoubleJump::handle);
    }
//public <MSG> IndexedMessageCodec.MessageHandler<MSG> registerMessage(int index,
//                                                                     Class<MSG> messageType,
//                                                                     BiConsumer<MSG, PacketBuffer> encoder,
//                                                                     Function<PacketBuffer, MSG> decoder,
//                                                                     BiConsumer<MSG,Supplier<NetworkEvent.Context>> messageConsumer)

}
