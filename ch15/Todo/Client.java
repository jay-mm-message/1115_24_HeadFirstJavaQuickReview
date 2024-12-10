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

            for(int i = 0 ; i < 100 ; ++i) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                toServer.println("Hi server");
                toServer.flush();
            }
            toServer.println("FIN");
            toServer.flush();

            System.out.println("client close finish");
            socket.close();
        } catch (UnknownHostException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace(); }
    }
    public static void main(String[] args) {
        Client client = new Client();
        client.go();
    }
}
