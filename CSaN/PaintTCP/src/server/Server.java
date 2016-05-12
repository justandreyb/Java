//http://code.makery.ch/library/javafx-8-tutorial/ru/part2/
package server;

import java.io.*;
import java.net.*;

/**
 * Server is now only for 1 client on port 9000;
 * To create multi-server :
 *      DEFAULT_SERVER_PORT in code change to client port from args[] (*in Client.java too)
 */
public class Server extends Thread{

    public static final int DEFAULT_SERVER_PORT = 9000;
    public static final String HOST = "127.0.0.1";
    //public static final String CORRECT_RECEIVE = "MESSAGE DELIVERED";
    public static final String DEFAULT_COORDINATS = "000 000";

    Socket clientsSocket;
    int Index;

    public static void main(String[] args) throws IOException {
/*        GUI.Interface serverForm = new GUI.Interface();
        serverForm.run();*/

        int numberOfConnections = 1;
        ServerSocket serverSocket = new ServerSocket(DEFAULT_SERVER_PORT, 0, InetAddress.getByName(HOST));
        System.out.println("Server is started : " + InetAddress.getByName(HOST) + ":" + DEFAULT_SERVER_PORT + "\n");
        while(true) {
            new Server(numberOfConnections, serverSocket.accept());
            numberOfConnections++;
        }

    }

    public Server(int numberOfConnections, Socket serverSocket) {

        this.Index = numberOfConnections;
        this.clientsSocket = serverSocket;

        //New stream for client
        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = clientsSocket.getInputStream();
            OutputStream outputStream = clientsSocket.getOutputStream();
            //It's can be change to BufferedReader / BufferedWriter..
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            BufferedReader readerServer = new BufferedReader(new InputStreamReader(System.in));

            String coordinats;

            while (true) {

                //byte buffer[] = new byte[8 * 512];
                //Get X lX, Y, lY in byte[] [*** ***]
                /*int read = inputStream.read(buffer);
                String data = new String(buffer, 0, read);

                data = "Client #" + Index + " : " + data;
                */
                //coordinats = DEFAULT_COORDINATS;
                coordinats = readerServer.readLine();

                System.out.println(coordinats);
                writer.write(coordinats);
                writer.flush();

                /*data = readerServer.readLine();
                writer.write("\n" + data);
                writer.flush();*/

            }
        }
        catch (Exception exception) {
            System.out.println("Init error : " + exception);
        }
    }
}
