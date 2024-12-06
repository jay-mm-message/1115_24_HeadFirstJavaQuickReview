package ch15.TcpSocket2;

import java.io.BufferedReader;
import java.io.IOException;
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
        // recv
    public void recv() {
        try {
            BufferedReader bufferedReader = t.streamToBuff(clientSocket.getInputStream());
            String recvMsg = null;
            while(null != (recvMsg = bufferedReader.readLine())) {
                t.prompt("Recv: " + recvMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String [] args) {
        Server server = new Server();
        server.establish();
        server.recv();
    }
}
