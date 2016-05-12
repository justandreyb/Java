package com.serverUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    private final static int PACKETSIZE = 100 ;

    public static void main( String args[] )
    {

        double lostDataPercent = 0;
        int count = 0;
        long time = 0, endingTime = 0;
        int port = 9000;

        try
        {
            DatagramSocket socket = new DatagramSocket( port ) ;

            System.out.println( "The server is ready..." ) ;

            for( ;; )
            {
                DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE) ;
                socket.receive( packet );
                if (time == 0)
                {
                    System.out.println("Data receiving is starting... Please wait");
                    time = System.currentTimeMillis();
                }
                System.out.println( packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()) ) ;
                count++;
                socket.setSoTimeout(2000);
            }

        }

        catch( Exception e )
        {
            lostDataPercent = ((100000 - count)/1000);
            endingTime = (System.currentTimeMillis() - time - 2000);
            System.out.println("Receive time: " + endingTime + " ms" + "\nSize of message: " + PACKETSIZE + " byte"
                    + "\nMessages count: " + count + "\nGlobal size: " + (PACKETSIZE*count) + "\nConnection speed: "
                    + ((PACKETSIZE*count)/endingTime) + " kb/s" + "\nData lost: " + lostDataPercent + "%" );
        }

    }
}
