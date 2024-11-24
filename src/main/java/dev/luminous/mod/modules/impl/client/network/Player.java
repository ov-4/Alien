package dev.luminous.mod.modules.impl.client.network;

import net.minecraft.client.MinecraftClient;

public class Player {
    public static String getPlayerName() {
        String playerName = MinecraftClient.getInstance().player.getName().getString();
        return playerName;
    }
}
