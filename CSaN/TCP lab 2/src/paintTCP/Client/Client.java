package paintTCP.Client;

import java.io.*;
import java.net.*;

class Client extends Thread {

    public static Socket clientSocket;

    public static int byteArrayToInt(byte[] b,int i) {
        return   b[3+i] & 0xFF |
                (b[2+i] & 0xFF) << 8 |
                (b[1+i] & 0xFF) << 16 |
                (b[0+i] & 0xFF) << 24;
    }

    public static void main(String args[]) throws Exception {
        //initializing stream
        clientSocket = new Socket("localhost",60000);
        BufferedInputStream inFromServer = new BufferedInputStream(clientSocket.getInputStream());
        byte buf[] = new byte[1024];
        Picture.main(args);

        while (true){
            inFromServer.read(buf);
            int x = byteArrayToInt(buf,0);
            int y = byteArrayToInt(buf,4);
            int oldX = byteArrayToInt(buf,8);
            int oldY = byteArrayToInt(buf,12);
            Picture.drawPad.drawServerLine(x,y,oldX,oldY);

            System.out.println("FROM SERVER X: " + x + " Y: " + y + " OLDX: " + oldX + " OLDY: " + oldY);
        }
    }

}
