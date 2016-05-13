package com.Server.Model;

import java.net.*;

public class Server {

    public static void main(String args[]) throws Exception {

        ServerSocket socket = new ServerSocket(5217);
        System.out.println("FTP Server Started on Port Number 5217");

        while(true) {
            System.out.println("Waiting for Connection ...");
            FileTransfer transfer = new FileTransfer(socket.accept());
        }
    }
}
