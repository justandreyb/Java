package paintTCP.Server;

import java.io.*;
import java.net.*;

class Server extends Thread {

    protected final static int PORT = 60000;
    protected final static int STREAMS_COUNT = 10;
    protected static int streamsCount = 0;
    protected static DataOutputStream streams[] = new DataOutputStream[STREAMS_COUNT];

    public static void main(String args[]) throws Exception{
        //initializing stream
        InetAddress serverIP = InetAddress.getByName("localhost");
        ServerSocket serverSocket = new ServerSocket(PORT, 0,serverIP);
        System.out.println("Server is starting...");
        Picture.main(args);

        while (true){
            Socket clientSocket = serverSocket.accept();

            System.out.println("To server connected " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
            streams[streamsCount] = new DataOutputStream(clientSocket.getOutputStream());
            streamsCount++;
            new ThreadClient(clientSocket).start();
        }
    }

}

