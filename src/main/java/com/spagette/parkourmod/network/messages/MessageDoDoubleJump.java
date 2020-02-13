package com.spagette.parkourmod.network.messages;

import com.spagette.parkourmod.network.ParkourModPacketHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class MessageDoDoubleJump {

    //params:
    //1: disciminator (id)
    //2. MSG class
    //3. BiConsumer<MSG, PacketBuffer>
    //4. Function<PackerBuffer, MSG>
    //5. BiConsumer<MSG, Supplier<NetworkEvent.Context>>

    //MessageDoDoubleJump::write,
    // MessageDoDoubleJump::new,
    // MessageDoDoubleJump::handle

    private LivingEntity player;
    private UUID playerID;

    public MessageDoDoubleJump(LivingEntity plr){//new

        player=plr;
    }

    public MessageDoDoubleJump(PacketBuffer buf){

        playerID = buf.readUniqueId();
    }


    public void write(PacketBuffer buf){

        buf.writeUniqueId(player.getUniqueID());
    }

    public void handle(Supplier<NetworkEvent.Context> context){

        context.get().enqueueWork(() -> {
            ServerPlayerEntity playerEntity = context.get().getSender();
            if(playerEntity.getUniqueID()==playerID){
                player.setVelocity( 0, 1, 0);
            }
        });

        context.get().setPacketHandled(true);
    }

    public void send(){

        ParkourModPacketHandler.SIMPLE_CHANNEL.sendToServer(this);
    }
}
