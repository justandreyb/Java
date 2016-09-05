package standart;

import java.io.*;
import java.net.Socket;

public class httpServer extends Thread {

    private InputStream inputStream;
    private OutputStream outputStream;
    private Socket clientSocket;
    private RegExpr regExpr;

    private String GET_REQUEST;
    private String POST_REQUEST;
    private String HEAD_REQUEST;

    httpServer(Socket socket) {
        GET_REQUEST = new String("GET");
        POST_REQUEST = new String("POST");
        HEAD_REQUEST = new String("HEAD");
        clientSocket = socket;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            regExpr = new RegExpr();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void readInput() {
        try {
            byte buf[] = new byte[64*1024];
            inputStream.read(buf);
            String request = new String(buf);
            System.out.println(request);
            regExpr.setPattern("([A-Z]+) ");
            if (regExpr.getMatch(request).equals(GET_REQUEST)) {
                regExpr.setPattern("\\w /(.+) HTTP");
                writeGetResponse(regExpr.getMatch(request));
            } else {
                if (regExpr.getMatch(request).equals(POST_REQUEST)) {
                    regExpr.setPattern("=(.*?)(&|$)");
                    System.out.println("Data : " + regExpr.getMatches(request));
                    writePostResponse();
                } else {
                    if (regExpr.getMatch(request).equals(HEAD_REQUEST)) {
                        regExpr.setPattern("\\w /(.+) HTTP");
                        writeHeadResponse(regExpr.getMatch(request));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void writePostResponse () {
        String result = getResponse(0, "HTTP/1.1 200 OK\r\n");
        try {
            outputStream.write(result.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    private void writeHeadResponse(String path) {
        ServerFiles file = new ServerFiles(path);
        String conditionCode;
        long size;
        if (file.isExists()) {
            conditionCode = "HTTP/1.1 200 OK\r\n";
            size = file.getSize();
        } else {
            conditionCode = "HTTP/1.1 404 Not Found\r\n";
            size = new String("404 NOT FOUND").length() + 2;
        }
        String result;
        if (file.isExists()) {
            result = getResponse(size, conditionCode);
        } else {
            result = getResponse(size, conditionCode) + "404 NOT FOUND";
        }
        sendData(result);
    }


    private void writeGetResponse(String path) {
        ServerFiles file = new ServerFiles(path);
        String conditionCode;
        long size;
        if (file.isExists()) {
            conditionCode = "HTTP/1.1 200 OK\r\n";
            size = file.getSize();
        } else {
            conditionCode = "HTTP/1.1 404 Not Found\r\n";
            size = new String("404 NOT FOUND").length() + 2;
        }

        String result;
        if (file.isExists()) {
            result = getResponse(size, conditionCode) + file.getData();
        } else {
            result = getResponse(size, conditionCode) + "404 NOT FOUND";
        }
        sendData(result);
    }

    private void sendData(String temp) {
        try {
            outputStream.write(temp.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private String getResponse (long size, String conditionCode) {
        return new String(conditionCode +
                        "Server: java-server/1.0.0\r\n" +
                        "Content-type: text/html\r\n" +
                        "Content-Length: " + size + "\r\n" +
                        "Connection: close\r\n" + "\r\n\r\n"
        );
    }

    @Override
    public void run() {
        readInput();
        try {
            clientSocket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
