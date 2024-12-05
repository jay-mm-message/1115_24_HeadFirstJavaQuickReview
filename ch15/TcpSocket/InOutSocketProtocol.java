package ch15.TcpSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class InOutSocketProtocol {

    public void prompt(String msg) {
        System.out.println(msg);
    }

    public void server(BufferedReader in, PrintWriter out, Socket socket) {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String clientMsg = null;
        try {
            while (null != ((clientMsg = in.readLine()))) {
                prompt("Received from client: " + clientMsg);
                out.println("Server: " + clientMsg);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void client(BufferedReader in, PrintWriter out, Socket socket) {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        String userMessage = null;
        try {
            while(null != ((userMessage = userInput.readLine()))) {
                out.println(userMessage);
                String serverMsg = in.readLine();
                prompt(serverMsg);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
