package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

    public static final String CLIENT_ADDRESS = "127.0.0.1";
    public static final int CLIENT_PORT = 9000;

    public static void main(String[] args) throws IOException {
/*        GUI.Interface clientForm = new GUI.Interface();
        clientForm.run();*/
        System.out.println("Client is start : " + InetAddress.getByName(CLIENT_ADDRESS) + ":" + CLIENT_PORT + "\n");

        try {
            Socket clientSocket = new Socket(CLIENT_ADDRESS, CLIENT_PORT);
            String message;

            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            BufferedReader readerMessages = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                /*message = readerMessages.readLine();
                writer.write(message);
                writer.flush();*/
                byte buffer[] = new byte[8 * 512];
                int read = inputStream.read(buffer);
                message =  new String(buffer, 0, read);
                System.out.println(message);
            }
        }
        catch (Exception exception) {
            System.out.println("Init error : " + exception);
        }
    }
}
