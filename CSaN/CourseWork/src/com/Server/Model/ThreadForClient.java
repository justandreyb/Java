package com.Server.Model;

import java.net.*;
import java.io.*;

public class ThreadForClient extends Thread{
    private Socket socket;

    ThreadForClient(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public static int byteArrayToInt(byte[] b,int i) {
        return   b[3+i] & 0xFF |
                (b[2+i] & 0xFF) << 8 |
                (b[1+i] & 0xFF) << 16 |
                (b[0+i] & 0xFF) << 24;
    }

    @Override
    public void run() {
        byte buf[] = new byte[1024];
        String currentCommand = "";

        try {
            while(true) {
                BufferedInputStream inputReader = new BufferedInputStream(socket.getInputStream());
                inputReader.read(buf);

                System.out.println("[Received from " + this.socket.getInetAddress() +
                        ":" + this.socket.getPort() + "] " + currentCommand);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}