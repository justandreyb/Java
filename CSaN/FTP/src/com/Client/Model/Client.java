package com.Client.Model;

import java.net.*;

class Client {
    public static void main(String args[]) throws Exception {
        Socket socket = new Socket("127.0.0.1",5217);
        ClientFileTransfer t = new ClientFileTransfer(socket);
        t.displayMenu();
    }
}