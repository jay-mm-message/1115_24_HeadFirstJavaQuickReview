package ch15.Todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    class ClientHandler implements Runnable {
        Socket clientSocket;
        public ClientHandler(Socket s) {
            this.clientSocket = s;
        }

        @Override
        public void run() {
            go();
        }
        
        public void go() {
            try {
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
                String msg = null;
                while((msg = fromClient.readLine()) != null) {
                    System.out.println("from client: " + Thread.currentThread().getName() + ":" + msg);
                    if (msg.equals("FIN")) {
                        break;
                    }
                }
                this.clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void go() {
        ServerSocket srvSocket;
        int id = 0;
        try {
            srvSocket = new ServerSocket(4242);
            while (true) {
                Socket clientSocket = srvSocket.accept();
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.setName("T_" + Integer.toString(++id));
                t.start();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
    public static void main(String [] args) {
        Server server = new Server();
        server.go();
    }
}
