package ch15.TcpSocket2;

import java.io.BufferedReader;
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
        t.prompt("Client send begin...");
        String sendMsg = "12345abc";
        try {
            PrintWriter printWriter = new PrintWriter(this.socket.getOutputStream(), true);
            printWriter.println(sendMsg);
            t.prompt("Client Send: " + sendMsg);
            //printWriter.println("ACK");
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.prompt("Client send finish.");
    }
        // recv
    public void recv() {
        t.prompt("Client recv waiting.....");
        try {
            BufferedReader bufferedReader = t.streamToBuff(socket.getInputStream());
            String recvMsg = null;
            while(null != (recvMsg = bufferedReader.readLine())) {
                if (recvMsg.equals("ACK")) {
                    break;
                } else {
                    t.prompt("From sever recvMsg: " + recvMsg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.prompt("Client recv finish.");
    }
    
    // go
    public void go(int times) {
        t.prompt("Client recv waiting.....");
        try {
            PrintWriter printWriter = new PrintWriter(this.socket.getOutputStream(), true);
            printWriter.println("ready go");

            BufferedReader bufferedReader = t.streamToBuff(socket.getInputStream());
            String sendMsg = "abc12345";
            String recvMsg = null;
            while(null != (recvMsg = bufferedReader.readLine()) && times != 0) {
                t.prompt("From sever recvMsg: " + recvMsg);
                t.prompt("Send to server: " + sendMsg);
                printWriter.println(sendMsg);
                times = times - 1;
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.prompt("Client recv finish.");
    }
    public static void main(String [] args) {
        Client client = new Client();
        client.establish();
        client.go(20);
    }
}
