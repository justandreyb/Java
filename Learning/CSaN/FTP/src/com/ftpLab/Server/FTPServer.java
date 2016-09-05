package com.ftpLab.Server;

import java.io.*;
import java.net.*;
import java.nio.channels.FileChannel;

public class FTPServer extends Thread{

    protected final static int PORT = 60000;
    private final static String ACCEPTCODE = "200";
    private final static String ERRORCODE = "400";
    private final static String HOME_DIRECTORY = "C:\\";
    //protected static int streamsCount = 0;
    //protected static DataOutputStream streams[] = new DataOutputStream[10];
    protected static File dir = new File("C:\\Qt");
    
    private static void seeDirectory(File dir) throws Exception{
        for (File file : dir.listFiles()){
            System.out.println(file.getCanonicalPath());
        }
    }    
    
    private static void signUp(DataInputStream fromClient,DataOutputStream toClient) throws Exception{
        boolean signing = false;
        String name,password;
        while (!signing){
            name = fromClient.readUTF();
            password = fromClient.readUTF();
            if ((name.equals("admin")) && (password.equals("123"))){
                toClient.writeUTF(ACCEPTCODE);
                System.out.println(name + " " + password + " is connecting...");
                signing = true;
            }
            else{
                toClient.writeUTF(ERRORCODE);
                System.out.println(name + " " + password + " try to connection");
            }
        }
    }
    
    public static void list(DataOutputStream toClient) throws Exception{
        File[] files = dir.listFiles();
        String fileInDirectory;
        for (File file : files){
            fileInDirectory = file.getAbsolutePath();
            toClient.writeUTF(fileInDirectory);
            //System.out.println(fileInDirectory);
        }
        toClient.writeUTF(ACCEPTCODE);
    }
    
    public static void changeToParentDir(DataOutputStream toClient) throws Exception{
        String currentDir = dir.getAbsolutePath();
        String message;
        if (!(currentDir.equals("C:\\"))){
            String parentDir = dir.getParent();
            File parentFile = new File(parentDir);
            dir = parentFile;
            message = "Current path changed to " + dir.getAbsolutePath();
            toClient.writeUTF(message);
            System.out.println(message);
        }
        else{
            message = "Current path not change, is it home directory!";
            toClient.writeUTF(message);
            System.out.println(message);
        }
    }
    
    private static void changeDir(DataInputStream fromClient,DataOutputStream toClient) throws Exception{
        String changedDir = fromClient.readUTF();
        boolean isFound = false;
        File[] files = dir.listFiles();
        String fileInDirectory;
        for (File file : files){
            if ((file.isDirectory()) && (file.getName().equals(changedDir)) && (!isFound)){
                dir = file;
                toClient.writeUTF("Directory changed to " + dir.getAbsolutePath());
                isFound = true;
            }
        }
        if (!isFound)
            toClient.writeUTF("Is it not a directory");
    }
    
    private static void nope(){
        
    }
    
    private static void makeDir(DataOutputStream toClient,DataInputStream fromClient) throws Exception{
        String dirName;
        dirName = fromClient.readUTF();
        File newDir = new File(dir.getAbsolutePath() + "\\" +dirName);
        if (newDir.mkdir())
            toClient.writeUTF(ACCEPTCODE);
        else
            toClient.writeUTF(ERRORCODE);
    }
    
    private static void deleteDir(DataInputStream fromClient,DataOutputStream toClient) throws Exception{
        String deletedDir = fromClient.readUTF();
        if (deletedDir.equals(ERRORCODE))
            return;
        boolean isFound = false;
        File[] files = dir.listFiles();
        for (File file : files){
            if ((file.getName().equals(deletedDir)) && (!isFound)){
                if (file.delete()){
                    toClient.writeUTF("Directory succesful delete!");
                    isFound = true;
                }
            }
        }
        if (!isFound)
            toClient.writeUTF("Something went wrong!");
    }
    
    private static void renameDir(DataInputStream fromClient,DataOutputStream toClient) throws Exception{
        String changedDir = fromClient.readUTF();
        if (changedDir.equals(ERRORCODE))
            return;
        String newName = fromClient.readUTF();
        if (newName.equals(ERRORCODE))
            return;
        File newFName = new File(dir.getAbsolutePath() + "\\" + newName);
        boolean isFound = false;
        File[] files = dir.listFiles();
        for (File file : files){
            if ((file.isDirectory()) && (file.getName().equals(changedDir)) && (!isFound)){
                file.renameTo(newFName);
                toClient.writeUTF("Renamed to " + newName);
                isFound = true;
            }
        }
        if (!isFound)
            toClient.writeUTF("Error");
    }
    
    private static void lastChanges(DataInputStream fromClient,DataOutputStream toClient) throws Exception{
        String findingDir = fromClient.readUTF();
        boolean isFound = false;
        File[] files = dir.listFiles();
        for (File file : files){
            if ((file.getName().equals(findingDir)) && (!isFound)){
                toClient.writeUTF("Last changes " + file.lastModified()/60 + " ms from 1 January 1970");
                isFound = true;
            }
        }
        if (!isFound)
            toClient.writeUTF("Error");
    }
    
    
    private static void fSize(DataInputStream fromClient,DataOutputStream toClient) throws Exception{
        String findingDir = fromClient.readUTF();
        boolean isFound = false;
        File[] files = dir.listFiles();
        for (File file : files){
            if ((file.getName().equals(findingDir)) && (!isFound)){
                toClient.writeUTF("Size: " + file.length() + " bytes");
                isFound = true;
            }
        }
        if (!isFound)
            toClient.writeUTF("Error");
    }
    
    private static void copyFile(DataInputStream fromClient,DataOutputStream toClient,File file) throws Exception{
        byte[] buffer = new byte[1024];
        int length;
        FileInputStream fis = new FileInputStream(file);
        while ((length = fis.read(buffer)) > 0) {
                
                toClient.write(buffer);
                System.out.println(buffer[0]);
            }
    }
    
    private static void sendFile(DataInputStream fromClient,DataOutputStream toClient) throws Exception{
        long countOfBuf = 0,countOfBytes;
        String findingDir = fromClient.readUTF();
        boolean isFound = false;
        File[] files = dir.listFiles();
        
        for (File file : files){
            
            if ((file.getName().equals(findingDir)) && (!isFound) && (file.isFile())){
                toClient.writeUTF(ACCEPTCODE);
                countOfBuf = file.length()/1024;
                countOfBytes = file.length();
                toClient.writeLong(countOfBuf);
                toClient.writeLong(countOfBytes);
                copyFile(fromClient,toClient,file);
                isFound = true;
            }
        }
        if (!isFound)
            toClient.writeUTF("Error");
    }
    
    public static void main(String[] args) throws Exception{
        
        //initializing stream
        InetAddress serverIP = null;
        int command = 0;
        serverIP = InetAddress.getByName("localhost");
        ServerSocket sSocket = new ServerSocket(PORT, 0,serverIP);
        System.out.println("Server is starting...");
        Socket cSocket = sSocket.accept();
        DataInputStream fromClient = new DataInputStream(cSocket.getInputStream());
        DataOutputStream toClient = new DataOutputStream(cSocket.getOutputStream());
        System.out.println("To server connected " + cSocket.getInetAddress() + ":" + cSocket.getPort());
        signUp(fromClient, toClient);
        
        while (true){
            
            command = fromClient.readInt();
            System.out.println(cSocket.getInetAddress() + ":" + cSocket.getPort() + " get command " + command);
            switch (command){
                case 1:
                    signUp(fromClient,toClient);
                    break;
                case 2:
                    list(toClient);
                    break;
                case 3:
                    changeToParentDir(toClient);
                    break;
                case 4:
                    changeDir(fromClient,toClient);
                    break;
                case 5:
                    nope();
                    break;
                case 6:
                    makeDir(toClient,fromClient);
                    break;
                case 7:
                    deleteDir(fromClient,toClient);
                    break;
                case 8:
                    renameDir(fromClient,toClient);
                    break;
                case 9:
                    lastChanges(fromClient,toClient);
                    break;
                case 10:
                    fSize(fromClient,toClient);
                    break;
                case 11:
                    sendFile(fromClient,toClient);
                    break;
            }
            
        }
    }
    
}
