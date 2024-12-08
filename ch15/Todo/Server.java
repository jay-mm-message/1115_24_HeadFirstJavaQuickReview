package ch15.Todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void go() {
        ServerSocket srvSocket;
        Socket clientSocket;
        try {
            srvSocket = new ServerSocket(4242);
            clientSocket = srvSocket.accept();
            BufferedReader clientReader = 
                new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String receiveMsg = null;
            while ((receiveMsg = clientReader.readLine()) != null) {
                System.out.println("From client: " + receiveMsg);
                PrintWriter toClient = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                toClient.println("Hi client");
                toClient.flush();
                if (receiveMsg.equals("CLOSE_SERVER")) {
                    toClient.println("CLOSE_CLIENT");
                    toClient.flush();
                    break;
                }
                toClient.println("CLOSE_CLIENT");
            }
            srvSocket.close();
            System.out.println("server close finish");
        } catch (IOException e) { e.printStackTrace(); }
    }
    public static void main(String [] args) {
        Server server = new Server();
        server.go();
    }
}
