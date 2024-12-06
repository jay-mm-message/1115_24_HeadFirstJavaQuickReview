package ch15.TcpSocket2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Tools {

    public Socket socket;
    public Tools t;

    public Client() {
        socket = null;
        t = new Tools();
    }
    // establish to server
    public void establish() {
        try {
            this.socket = new Socket("127.0.0.1", 4242);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        // send
    public void send() {
        String sendMsg = "12345abc";
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(this.socket.getOutputStream(), true);
            printWriter.println(sendMsg);
            t.prompt("Send: " + sendMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        // recv
    public static void main(String [] args) {
        Client client = new Client();
        client.establish();
        client.send();
    }
}
