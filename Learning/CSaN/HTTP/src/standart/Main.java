package standart;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        ServerSocket httpSocket;
        try {
            httpSocket = new ServerSocket(8080);
            while (true) {
                Socket temp;
                temp = httpSocket.accept();
                System.out.println("Client accepted");
                new httpServer(temp).start();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
