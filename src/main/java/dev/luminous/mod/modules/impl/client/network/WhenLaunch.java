package dev.luminous.mod.modules.impl.client.network;

import net.minecraft.client.gui.navigation.GuiNavigation;

public class WhenLaunch {
    public static void boostIQ() {
        String msg = dev.luminous.mod.modules.impl.client.network.Time.getTime() + " " + "[" + dev.luminous.mod.modules.impl.client.network.Player.getPlayerName() + "] " + "Game launched";
        //dev.luminous.mod.modules.impl.client.network.Download.download();
    }
}
