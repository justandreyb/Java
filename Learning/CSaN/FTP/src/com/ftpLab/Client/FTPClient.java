package com.ftpLab.Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FTPClient extends Thread{


    
    public static Socket cSocket;
    private final static String ACCEPTCODE = "200";
    private final static String ERRORCODE = "400";
    private final static String ABORT = "abort";
    
    protected static int getNum(){
            Scanner reader = new Scanner(System.in);
            int command = 0;
            System.out.println("Enter the command: ");
            command = reader.nextInt();
            return command;
    }

    private static void help(){
        System.out.println(
                "ABOR - to cancel command\n"
                + "0 - HELP\n"
                + "1 - REIN\n"
                + "2 - LIST\n"
                + "3 - CDUP\n"
                + "4 - CWD\n"
                + "5 - NOOP\n"
                + "6 - MKD\n"
                + "7 - RMD\n"
                + "8 - RNFR\n"
                + "9 - MDTM\n"
                + "10 - SIZE\n"
                + "11 - SND\n"
        );
    }

    private static void signUp(DataOutputStream toServer,DataInputStream fromServer) throws Exception{
        boolean signing = false;
        Scanner reader = new Scanner(System.in);
        String name,password,acceptCode;
        while (!signing){
            System.out.println("Input username:");
            name = reader.nextLine();
            System.out.println("Input password:");
            password = reader.nextLine();
            toServer.writeUTF(name);
            toServer.writeUTF(password);
            if ((acceptCode = fromServer.readUTF()).equals(ACCEPTCODE) ){
                System.out.println("Connecting is accept!");
                signing = true;
            }
            else
                System.out.println("Incorrect login or password!");
        }
        
    }

    private static void list(DataInputStream fromServer) throws Exception{
        String data = "";
        while (!(data.equals(ACCEPTCODE))){
            data = fromServer.readUTF();
            if (!(data.equals(ACCEPTCODE)))
                System.out.println(data);
        }
    }
    
    private static void changeToParentDir(DataInputStream fromServer) throws Exception{
       String message = fromServer.readUTF();
        System.out.println(message);
    }
    
    private static void nope(){
        
    }
    
    private static void changeDir(DataOutputStream toServer,DataInputStream fromServer) throws Exception{
        Scanner reader = new Scanner(System.in);
        String changedDir,message;
        System.out.println("Enter directory name: ");
        changedDir = reader.nextLine();
        toServer.writeUTF(changedDir);
        message = fromServer.readUTF();
        System.out.println(message);
    }
    
    
    private static void makeDir(DataOutputStream toServer, DataInputStream fromServer) throws Exception{
        Scanner reader = new Scanner(System.in);
        String dirName,message;
        System.out.println("Enter directory name: ");
        dirName = reader.nextLine();
        toServer.writeUTF(dirName);
        message = fromServer.readUTF();
        if (message.equals(ACCEPTCODE))
            System.out.println("Directory successfully created.");
        else
            System.out.println("Something went wrong.");
    }
    
    private static void deleteDir(DataOutputStream toServer,DataInputStream fromServer) throws Exception{
        Scanner reader = new Scanner(System.in);
        String deletedDir,message;
        System.out.println("Enter deleted file(or directory) name: ");
        deletedDir = reader.nextLine();
        if (deletedDir.equals(ABORT))
            toServer.writeUTF(ERRORCODE);
        toServer.writeUTF(deletedDir);
        message = fromServer.readUTF();
        System.out.println(message);
    }
    
    private static void renameDir(DataOutputStream toServer,DataInputStream fromServer) throws Exception{
        Scanner reader = new Scanner(System.in);
        String renamedDir,message,newName;
        System.out.println("Enter renamed directory name: ");
        renamedDir = reader.nextLine();
        if (renamedDir.equals(ABORT))
            toServer.writeUTF(ERRORCODE);
        
        System.out.println("Enter new name: ");
        newName = reader.nextLine();
        if (newName.equals(ABORT))
            toServer.writeUTF(ERRORCODE);
        toServer.writeUTF(renamedDir);
        toServer.writeUTF(newName);
        message = fromServer.readUTF();
        System.out.println(message);
    }
    
    private static void lastChanges(DataOutputStream toServer,DataInputStream fromServer) throws Exception{
        Scanner reader = new Scanner(System.in);
        String infoDir,message;
        System.out.println("Enter file name: ");
        infoDir = reader.nextLine();
        if (infoDir.equals(ABORT))
            toServer.writeUTF(ERRORCODE);
        toServer.writeUTF(infoDir);
        message = fromServer.readUTF();
        System.out.println(message);
    }
    
    private static void fSize(DataOutputStream toServer,DataInputStream fromServer) throws Exception{
        Scanner reader = new Scanner(System.in);
        String infoDir,message;
        System.out.println("Enter file name: ");
        infoDir = reader.nextLine();
        if (infoDir.equals(ABORT))
            toServer.writeUTF(ERRORCODE);
        toServer.writeUTF(infoDir);
        message = fromServer.readUTF();
        System.out.println(message);
    }
    
    private static void receiveFile(DataOutputStream toServer,DataInputStream fromServer) throws Exception{
        byte[] buffer = new byte[1024];
        int i = 0,j,k = 1;
        long count = 0,bytes = 0;
        Scanner reader = new Scanner(System.in);
        String fileName,message;
        System.out.println("Enter recieving file: ");
        fileName = reader.nextLine();
        toServer.writeUTF(fileName);
        if (fromServer.readUTF().equals(ACCEPTCODE)){
            count = fromServer.readLong();
            bytes = fromServer.readLong();
            File newFile = new File("C:\\Qt\\Client\\" + fileName);
            FileOutputStream fis = new FileOutputStream(newFile);
            for (j = 0; j <= count;j++) {
                i = 0;
           //     for (i = 0; i < 1023;i++)
           //         buffer[i] = 66;
                fromServer.read(buffer);
             //   fis.write(buffer);
              //  System.out.println(buffer[0]);
                while ((i < 1024)){
                    if ((k > bytes))
                        break;
                   // System.out.println(buffer[i]);
                    fis.write(buffer[i]);
                    i++;
                    k++;
                }
                //dopili
                
            }
            System.out.println("The file receiving is complete!");
            fis.close();
        }
    }
   

    public static void main(String[] args) throws Exception{
        //initializing stream
                cSocket = new Socket("localhost",60000);
                int command = 0;
                DataInputStream fromServer = new DataInputStream(cSocket.getInputStream());
                DataOutputStream toServer = new DataOutputStream(cSocket.getOutputStream());
                signUp(toServer,fromServer);
                
                while (true){
                    switch ((command = getNum())){
                        case 0:
                            help();
                            break;
                        case 1:
                            toServer.writeInt(command);
                            signUp(toServer,fromServer);
                            break;
                        case 2:
                            toServer.writeInt(command);
                            list(fromServer);
                            break;
                        case 3:
                            toServer.writeInt(command);
                            changeToParentDir(fromServer);
                            break;
                        case 4:
                            toServer.writeInt(command);
                            changeDir(toServer,fromServer);
                            break;
                        case 5:
                            toServer.writeInt(command);
                            nope();
                            break;
                        case 6:
                            toServer.writeInt(command);
                            makeDir(toServer,fromServer);
                            break;
                        case 7:
                            toServer.writeInt(command);
                            deleteDir(toServer,fromServer);
                            break;
                        case 8:
                            toServer.writeInt(command);
                            renameDir(toServer, fromServer);
                            break;
                        case 9:
                            toServer.writeInt(command);
                            lastChanges(toServer, fromServer);
                            break;
                        case 10:
                            toServer.writeInt(command);
                            fSize(toServer,fromServer);
                            break;
                        case 11:
                            toServer.writeInt(command);
                            receiveFile(toServer, fromServer);
                            break;
                    }
                }
    }
    
    
    
}
