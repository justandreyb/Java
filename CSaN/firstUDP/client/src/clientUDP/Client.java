package clientUDP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    private final static int PACKETSIZE = 100;
    private final static int COUNTOFPACKETS = 1000;

    public static void main(String args[]) {

        BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;
        String ip;
        int action;
        DatagramSocket socket = null;
        Scanner reader = new Scanner(System.in);

        try {
            System.out.print("Input server ip: ");
            ip = reader.nextLine();
            InetAddress host = InetAddress.getByName(ip);
            int port = 9000;
            int result = 0;

            socket = new DatagramSocket();
            socket.connect(host, port);
            System.out.print("Input message: ");
            String currMessage = reader.nextLine();
            byte[] sendingData = currMessage.getBytes();
            DatagramPacket packet = new DatagramPacket(sendingData, sendingData.length, host, port);


            while (!exit) {

                System.out.println("Enter the command (0 - Exit, 1 - Send package to server, 2 - Test UDP connection)");
                action = reader.nextInt();

                switch (action) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        socket.send(packet);
                        socket.setSoTimeout(2000);
                        packet.setData(new byte[PACKETSIZE]);
                        socket.receive(packet);
                        //for (int i=0; i<hostmas.length; i++)
                        //System.out.println(hostmas[i]);
                        System.out.println("Server " + packet.getAddress() + " " + packet.getPort() + " send message: " + new String(packet.getData()));
                        // System.out.println( new String(packet.getData()) );
                        return;
                    }
                    default: {
                        for (int i = 0; i < COUNTOFPACKETS; i++) {
                            socket.send(packet);
                            //socket.setSoTimeout(2000);
                            packet.setData(new byte[PACKETSIZE]);
                            //socket.receive(packet);
                            System.out.println("Server " + packet.getAddress() + " " + packet.getPort() + " send message: " + new String(packet.getData()));
                            result++;
                        }
                    }
                }

                System.out.println("Package send: " + result);
                result = 0;
            }
        } catch (Exception e) {
            System.out.println(e);

        } finally {
            if (socket != null) {
                {
                    socket.disconnect();
                    socket.close();
                }
            }
        }
    }
}































