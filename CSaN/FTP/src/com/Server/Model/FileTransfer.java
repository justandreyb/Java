package com.Server.Model;

import java.io.*;
import java.net.*;

class FileTransfer extends Thread {

    Socket clientSocket;

    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    FileTransfer (Socket socket) {
        try {
            clientSocket = socket;
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            System.out.println("FTP Client Connected ...");
            start();

        }
        catch (Exception exception) {
            System.out.println("Error : " + exception);
        }
    }

    void SendFile() throws Exception {

        String filename = dataInputStream.readUTF();
        File file = new File(filename);
        if (!file.exists()) {
            dataOutputStream.writeUTF("File Not Found");
            return;
        }
        else {
            dataOutputStream.writeUTF("READY");
            FileInputStream fileInputStream = new FileInputStream(file);

            int ch;
            do {
                ch = fileInputStream.read();
                dataOutputStream.writeUTF(String.valueOf(ch));
            } while (ch != -1);

            fileInputStream.close();
            dataOutputStream.writeUTF("File Receive Successfully");
        }
    }

    void ReceiveFile() throws Exception {

        String filename = dataInputStream.readUTF();
        if (filename.compareTo("File not found") == 0) {
            return;
        }

        File file = new File(filename);
        String option;

        if (file.exists()) {
            dataOutputStream.writeUTF("File Already Exists");
            option = dataInputStream.readUTF();
        }
        else {
            dataOutputStream.writeUTF("SendFile");
            option = "Y";
        }

        if (option.compareTo("Y") == 0) {
            FileOutputStream fout = new FileOutputStream(file);
            int ch;
            String temp;
            do {
                temp = dataInputStream.readUTF();
                ch = Integer.parseInt(temp);
                if (ch != -1) {
                    fout.write(ch);
                }
            } while (ch != -1);
            fout.close();
            dataOutputStream.writeUTF("File Send Successfully");
        }
        else {
            return;
        }

    }

    public void run() {

        while (true) {
            try {
                System.out.println("Waiting for Command ...");
                String Command = dataInputStream.readUTF();

                if (Command.compareTo("GET") == 0) {
                    System.out.println("\tGET Command Received ...");
                    SendFile();
                    continue;
                }
                else if (Command.compareTo("SEND") == 0) {
                    System.out.println("\tSEND Command Received ...");
                    ReceiveFile();
                    continue;
                }
                else if (Command.compareTo("DISCONNECT") == 0) {
                    System.out.println("\tDisconnect Command Received ...");
                    System.exit(1);
                }
            }
            catch (Exception exception) {
                System.out.println("Error : " + exception);
            }
        }
    }
}
