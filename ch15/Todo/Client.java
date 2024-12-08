package ch15.Todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void go() {
        // establish connected
        Socket socket;
        try {
            socket = new Socket("127.0.0.1", 4242);
            PrintWriter toServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            toServer.println("Hi server");
            toServer.flush();

            BufferedReader getServerMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String receiveMsg = null;
            while((receiveMsg = getServerMsg.readLine()) != null) {
                System.out.println("From server: " + receiveMsg);
                toServer.println("Hi server");
                toServer.flush();
                if (receiveMsg.equals("CLOSE_CLIENT")) {
                    toServer.println("CLOSE_SERVER");
                    toServer.flush();
                    break;
                }
                toServer.println("CLOSE_SERVER");
            }
            socket.close();
            System.out.println("client close finish");
        } catch (UnknownHostException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace(); }
    }
    public static void main(String[] args) {
        Client client = new Client();
        client.go();
    }
}
