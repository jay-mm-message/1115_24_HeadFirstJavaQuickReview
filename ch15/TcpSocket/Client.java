package ch15.TcpSocket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends InOutSocketProtocol {
    public void prompt(String msg) {
        System.out.println("Received from server: " + msg);
    }


    public void go() {
        try {
            Socket socket = new Socket("127.0.0.1", 4242);
            InOutSocketProtocol protocol = new InOutSocketProtocol();
            protocol.client(null, null, socket);

            socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }     
    }
}
