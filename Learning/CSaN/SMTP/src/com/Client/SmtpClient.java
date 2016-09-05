/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtpclient;

import java.io.*;
import java.net.Socket;
/**
 *
 * @author PC
 */
public class SmtpClient {

    private static BufferedReader fromServer;
    private static PrintWriter toServer;
    private static final String SENDER = "ot@kogo.ru";
    private static final String RECIEVER = "komu@to.com";
    
    protected static void send(String s) throws IOException {
    if (s != null) {
  
      toServer.println(s);
      toServer.flush();
    }
    String line = fromServer.readLine();
    System.out.println("Server send: " + line);
  }
    
    public static void main(String[] args) {
        
    try {
        Socket s = new Socket("localhost", 25);
        toServer = new PrintWriter(s.getOutputStream());
        fromServer = new BufferedReader(new java.io.InputStreamReader(s.getInputStream()));
        send(null);
        send("HELO " + java.net.InetAddress.getLocalHost().getHostName());
        send("MAIL FROM: " + SENDER);
        send("RCPT TO: " + RECIEVER);
        send("DATA");
        toServer.println("From: Some User <ot@kogo.ru>");
        toServer.println("To: User <komu@to.com>");
        toServer.println("Subject:" + "Message");
        toServer.println("Content-Type: text/plain");
        //toServer.println("Hi");
        send(".");
        s.close();
    } 
    catch (Exception e) { System.out.println("Error: " + e); }
    }
    
}
