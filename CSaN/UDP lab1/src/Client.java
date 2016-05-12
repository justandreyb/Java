import java.net.*;
import java.io.*;
import java.util.Date;

public class Client {

    public static final String TEST_UDP_CONNECTION = "Test connection";
    public static int NUMBER_OF_PACKETS = 0;
    public static int PACKET_SIZE = 0;


    public void runClient() throws IOException {

        byte[] buf = new byte[100];
        boolean isContinued = true;
         try
         {
             DatagramSocket clientSocket = new DatagramSocket(0);//InetAddress.getByName("192.168.1.11"));

             new Thread(new ReceiveDatagramPacket(clientSocket)).start();
             new Thread(new ReceiveMulticast()).start();

             DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName(/*"192.168.1.11*/"127.0.0.1"), 8000);
             System.out.println(clientSocket.getLocalSocketAddress());

             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             System.out.println("Client is starting");

             while (isContinued) {
                 String command = reader.readLine();
                 byte[] arrayCommand = command.getBytes();
                 sendPacket.setData(arrayCommand, 0, arrayCommand.length);
                 clientSocket.send(sendPacket);

                 if (command.contains(TEST_UDP_CONNECTION)) {
                     byte[] testConnection = command.getBytes();
                     if ((testConnection.length - 16) >= 1) {
                         byte[] countArray = new byte[testConnection.length - 16];
                         for (int index = 16; index < testConnection.length; index++)
                             countArray[index - 16] = testConnection[index];
                         NUMBER_OF_PACKETS = toInt(countArray);
                     }
                 }
                 if ("Quit".equals(command))
                     isContinued = false;
             }

         }
        catch (Exception e)
        {
            System.out.println("ERROR !");
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.runClient();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("End of working client.");
    }

    public class ReceiveDatagramPacket implements Runnable
    {
        DatagramSocket clientSocket;
        public ReceiveDatagramPacket(DatagramSocket datagramSocket)
        {
            this.clientSocket = datagramSocket;
        }

        @Override
        public void run() {
            byte[] buf = new byte[256];
            DatagramPacket recievePacket = new DatagramPacket(buf, buf.length);
            Date startTime = new Date(), finishTime;
            int countReceiveTest = 0;
            int globalSize = 0;
            while (true) {
                try {
                    clientSocket.receive(recievePacket);
                    //System.out.print("ANSWER RECEIVE : ");
                    String receiveCommand = new String(recievePacket.getData()).trim();
                    if (receiveCommand.equals("UNKNOWN COMMAND")) {
                        System.out.println("UNKNOWN COMMAND");
                    }
                    else if (receiveCommand.equals("TEST CONNECTION")) {
                        if (countReceiveTest < 1)
                            startTime = new Date();
                        countReceiveTest++;
                        PACKET_SIZE = recievePacket.getLength();
                        globalSize += PACKET_SIZE;
                    }
                    else if (receiveCommand.contains("END TEST")) {
                        finishTime = new Date();
                        double time = finishTime.getSeconds() - startTime.getSeconds();
                        int lostDataPercent = (countReceiveTest / NUMBER_OF_PACKETS) * 100;
                        System.out.println("Size of message: " + PACKET_SIZE + " bytes\n"
                                + "Messages count: " + countReceiveTest + "\n"
                                + "Global size: " + globalSize + "\n"
                                + "Connection speed: "
                                + (globalSize/time) + " kb/s" + "\n"
                                + "Recieving data: " + lostDataPercent + "%" );
                    }
                    else {
                        System.out.println((buf[0] + 1900) + ":" + (buf[1] + 1) + ":" + buf[2] + " " + buf[3] + ":" + buf[4] + ":" + buf[5]);
                    }


                } catch (Exception e) {
                    System.out.println("ERROR !");
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public class ReceiveMulticast implements Runnable
    {
        MulticastSocket multicastSocket;
        public ReceiveMulticast() throws IOException {
            this.multicastSocket = new MulticastSocket(4446);
        }

        public void run() {
            try {
                InetAddress group = InetAddress.getByName("239.255.255.255");
                multicastSocket.joinGroup(group);

                byte[] buf = new byte[20];
                DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
                multicastSocket.receive(datagramPacket);

                System.out.println((buf[0] + 1900) + ":" + (buf[1] + 1) + ":" + buf[2] + " " + buf[3] + ":" + buf[4] + ":" + buf[5]);

            } catch (UnknownHostException e) {
                System.out.println("ERROR WITH GetByName");
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("ERROR WITH JoinGroup");
                System.out.println(e.getMessage());
            }
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