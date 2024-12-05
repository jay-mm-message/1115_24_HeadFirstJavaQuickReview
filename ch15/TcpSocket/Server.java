package ch15.TcpSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server extends InOutSocketProtocol {

    public void prompt(String msg) {
        System.out.println(msg);
    }

    public void go() {
        try (ServerSocket serverSocket = new ServerSocket(4242)) {
            prompt("Server is waiting for connection...");
            Socket clientSocket = serverSocket.accept();
            prompt("Client connected.");

            InOutSocketProtocol protocol = new InOutSocketProtocol();
            protocol.server(null, null, clientSocket);

            clientSocket.close();
        }  catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
    }
}
