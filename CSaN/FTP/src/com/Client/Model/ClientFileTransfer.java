package com.Client.Model;

import java.net.*;
import java.io.*;

public class ClientFileTransfer {

    Socket clientSocket;

    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    BufferedReader bufferedReader;

    ClientFileTransfer (Socket socket) {

        try {
            clientSocket = socket;
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }
        catch(Exception exception) {
            System.out.println("Error : " + exception);
        }
    }
    void SendFile() throws Exception {

        String filename;
        System.out.print("Enter File Name :");
        filename = bufferedReader.readLine();

        File file = new File(filename);
        if (!file.exists())
        {
            System.out.println("File not Exists...");
            dataOutputStream.writeUTF("File not found");
            return;
        }

        dataOutputStream.writeUTF(filename);

        String msgFromServer=dataInputStream.readUTF();
        if (msgFromServer.compareTo("File Already Exists")==0)
        {
            String Option;
            System.out.println("File Already Exists. Want to OverWrite (Y/N) ?");
            Option =bufferedReader.readLine();
            if (Option.equals("Y")) {
                dataOutputStream.writeUTF("Y");
            }
            else {
                dataOutputStream.writeUTF("N");
                return;
            }
        }

        System.out.println("Sending File ...");
        FileInputStream fin=new FileInputStream(file);
        int ch;
        do
        {
            ch=fin.read();
            dataOutputStream.writeUTF(String.valueOf(ch));
        }
        while(ch!=-1);
        fin.close();
        System.out.println(dataInputStream.readUTF());

    }

    void ReceiveFile() throws Exception
    {
        String fileName;
        System.out.print("Enter File Name :");
        fileName=bufferedReader.readLine();
        dataOutputStream.writeUTF(fileName);
        String msgFromServer=dataInputStream.readUTF();

        if (msgFromServer.compareTo("File Not Found")==0)
        {
            System.out.println("File not found on Server ...");
            return;
        }
        else if(msgFromServer.compareTo("READY")==0)
        {
            System.out.println("Receiving File ...");
            File file=new File(fileName);
            if (file.exists())
            {
                String Option;
                System.out.println("File Already Exists. Want to OverWrite (Y/N) ?");
                Option=bufferedReader.readLine();
                if (Option=="N")
                {
                    dataOutputStream.flush();
                    return;
                }
            }
            FileOutputStream fout=new FileOutputStream(file);
            int ch;
            String temp;
            do
            {
                temp=dataInputStream.readUTF();
                ch=Integer.parseInt(temp);
                if (ch!=-1)
                {
                    fout.write(ch);
                }
            }while(ch!=-1);
            fout.close();
            System.out.println(dataInputStream.readUTF());

        }


    }

    public void displayMenu() throws Exception
    {
        while(true)
        {
            System.out.println("[ MENU ]");
            System.out.println("1. Send File");
            System.out.println("2. Receive File");
            System.out.println("3. Exit");
            System.out.print("\nEnter Choice :");
            int choice;
            choice=Integer.parseInt(bufferedReader.readLine());
            if (choice==1)
            {
                dataOutputStream.writeUTF("SEND");
                SendFile();
            }
            else if(choice==2)
            {
                dataOutputStream.writeUTF("GET");
                ReceiveFile();
            }
            else
            {
                dataOutputStream.writeUTF("DISCONNECT");
                System.exit(1);
            }
        }
    }
}
}
