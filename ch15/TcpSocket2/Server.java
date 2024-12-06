package ch15.TcpSocket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Tools {

    public Socket clientSocket;
    public Tools t;

    public Server() {
        clientSocket = null;
        t = new Tools();
    }
    // establish server
    public void establish() {
        try (ServerSocket serverSocket = new ServerSocket(4242)) {
            t.prompt("Server waiting client connect...");
            this.clientSocket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.prompt("client connected to server.");
    }
        // send
    public void send() {
        t.prompt("Server send begin...");
        String sendMsg = "adc12345";
        try {
            PrintWriter printWriter = new PrintWriter(this.clientSocket.getOutputStream(), true);
            printWriter.println(sendMsg);
            t.prompt("Server send: " + sendMsg);
            printWriter.println("ACK");
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.prompt("Server send finish.");
    }
        // recv
    public void recv() {
        t.prompt("Server recv waiting.....");
        try {
            BufferedReader bufferedReader = t.streamToBuff(clientSocket.getInputStream());
            String recvMsg = null;
            while(null != (recvMsg = bufferedReader.readLine())) {
                if (recvMsg.equals("ACK")) {
                    break;
                } else {
                    t.prompt("From client recvMsg: " + recvMsg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.prompt("Server recv finish.");
    }

    // go 
    public void go() {
        t.prompt("Server recv waiting.....");  
        try {
            PrintWriter printWriter = new PrintWriter(this.clientSocket.getOutputStream(), true);
            BufferedReader bufferedReader = t.streamToBuff(this.clientSocket.getInputStream());
            String sendMsg = "12345abc";
            String recvMsg = null;
            while(null != (recvMsg = bufferedReader.readLine())) {
                t.prompt("From client recvMsg: " + recvMsg);
                t.prompt("Send to client: " + sendMsg);
                printWriter.println(sendMsg);
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.prompt("Server recv finish.");
    }
    public static void main(String [] args) {
        Server server = new Server();
        server.establish();
        server.go();
    }
}
