import java.net.*;
import java.io.*;

import java.util.Date;

public class Server {

    public static final int SERVER_PORT = 8000;

    public static final String QUIT_COMMAND = "Quit";
    public static final String DATE_COMMAND = "Date";
    public static final String DATE_ALL_COMMAND = "Date all";
    public static final String TEST_UDP_CONNECTION = "Test connection";
    public static final byte[] UNKNOWN_COMMAND = {'U', 'N', 'K', 'N', 'O', 'W', 'N', ' ', 'C', 'O', 'M', 'M', 'A', 'N', 'D'};


    public void runServer() throws IOException {
        DatagramSocket serverSocket;
        try
        {
            serverSocket = new DatagramSocket(SERVER_PORT/*, InetAddress.getByName(/*"192.168.1.15""127.0.0.1")*/);
            MulticastSocket multicastSocket = new MulticastSocket();

            boolean Continue = true;
            byte[] bufReceive = new byte[100];
            System.out.println("Server is started: " + serverSocket.getLocalAddress() + ":" + serverSocket.getLocalPort());
            DatagramPacket receivePacket = new DatagramPacket(bufReceive, 100);
            DatagramPacket sendPacket;
            while (Continue)
            {
                initializeBuffer(bufReceive);
                serverSocket.receive(receivePacket);
                System.out.println("_______________________________________________");
                System.out.println("    Client: " + receivePacket.getSocketAddress());

                String Action = new String(receivePacket.getData()).trim();
                int numberOfPackets = 0;
                if (Action.contains(TEST_UDP_CONNECTION)) {
                    byte[] testConnection = Action.getBytes();
                    if ((testConnection.length - 16) >= 1) {
                        byte[] countArray = new byte[testConnection.length - 16];
                        for (int index = 16; index < testConnection.length; index++)
                            countArray[index - 16] = testConnection[index];
                        numberOfPackets = toInt(countArray);
                        Action = TEST_UDP_CONNECTION;
                    }
                    else
                        Action = "Test connection (wrong argument)";
                }
                int lengthPacket;

                switch (Action)
                {
                    case QUIT_COMMAND :
                    {
                        System.out.println("    QUIT COMMAND RECEIVED");

                        serverSocket.close();
                        Continue = false;
                        System.out.println("    Server is closed!");
                        continue;
                    }

                    case DATE_COMMAND :
                    {
                        System.out.println("    DATE COMMAND RECEIVED");
                        Date date = new Date();
                        byte[] dateArray = {(byte)date.getYear(),(byte)date.getMonth(),(byte)date.getDate(),(byte)date.getHours(),(byte)date.getMinutes(),(byte)date.getSeconds()};
                        lengthPacket = dateArray.length;
                        sendPacket = new DatagramPacket(dateArray, lengthPacket, receivePacket.getAddress(), receivePacket.getPort());
                        serverSocket.send(sendPacket);
                        break;
                    }
                    case DATE_ALL_COMMAND:
                    {
                        System.out.println("    SEND DATE TO ALL CLIENTS");
                        Date date = new Date();
                        byte[] dateArray = {(byte)date.getYear(),(byte)date.getMonth(),(byte)date.getDate(),(byte)date.getHours(),(byte)date.getMinutes(),(byte)date.getSeconds()};
                        lengthPacket = dateArray.length;
                        sendPacket = new DatagramPacket(dateArray, lengthPacket, InetAddress.getByName(/*"192.168.1.255*/"239.255.255.255"), 4446 );
                        multicastSocket.send(sendPacket);
                        break;
                    }
                    case TEST_UDP_CONNECTION:
                    {
                        System.out.println("    TESTING UDP CONNECTION");
                        System.out.println("    The number of packets: " + numberOfPackets);
                        byte[] sendingData = "TEST CONNECTION".getBytes();
                        sendPacket = new DatagramPacket(sendingData, sendingData.length, receivePacket.getAddress(), receivePacket.getPort());
                        for (int count = 0; count < numberOfPackets; count++)
                            serverSocket.send(sendPacket);
                        byte[] sendingEnd = "END TEST".getBytes();
                        sendPacket = new DatagramPacket(sendingEnd, sendingEnd.length, receivePacket.getAddress(), receivePacket.getPort());
                        serverSocket.send(sendPacket);
                        break;
                    }
                    default:
                    {
                        System.out.println("    UNKNOWN COMMAND RECEIVE : " + Action);
                        lengthPacket = UNKNOWN_COMMAND.length;
                        sendPacket = new DatagramPacket(UNKNOWN_COMMAND, lengthPacket, receivePacket.getAddress(), receivePacket.getPort());
                        serverSocket.send(sendPacket);
                        byte[] wrongArg = "The number of packets must be after this command".getBytes();
                        if (Action == "Test connection (wrong argument)")
                            sendPacket = new DatagramPacket(wrongArg, wrongArg.length, receivePacket.getAddress(), receivePacket.getPort());
                            serverSocket.send(sendPacket);
                    }
                }

                System.out.println("    ANSWER SENT");
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("    ERROR !");
        }
    }

    public static void initializeBuffer(byte[] buffer) {
        for (int i = 0; i < buffer.length; i++)
        {
            buffer[i] = 0;
        }
    }

    public static void main(String[] args) {
        try {
            Server UDPSrv = new Server();
            UDPSrv.runServer();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static int toInt(byte[] bytes) {
        int translateToInt = 1;
        int result = 0;
        byte flag = 0;
        for (int index = 0; index < bytes.length; index++) {
            if (index == 1)
                translateToInt = translateToInt * 10;
            switch (bytes[index]) {
                case 48: {
                    flag = 0;
                    break;
                }
                case 49: {
                    flag = 1;
                    break;
                }
                case 50: {
                    flag = 2;
                    break;
                }
                case 51: {
                    flag = 3;
                    break;
                }
                case 52: {
                    flag = 4;
                    break;
                }
                case 53: {
                    flag = 5;
                    break;
                }
                case 54: {
                    flag = 6;
                    break;
                }
                case 55: {
                    flag = 7;
                    break;
                }
                case 56: {
                    flag = 7;
                    break;
                }
                case 57: {
                    flag = 8;
                    break;
                }
            }
            result = (result * translateToInt) + flag;
        }
        return result;
    }

}