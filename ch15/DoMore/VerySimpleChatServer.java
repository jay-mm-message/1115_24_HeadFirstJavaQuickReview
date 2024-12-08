package ch15.DoMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class VerySimpleChatServer {

    ArrayList<PrintWriter> clientWriterList;

    class ClientHandler implements Runnable {
        BufferedReader clientReader;
        Socket sock;

        public ClientHandler(Socket clientSocket) {
            try {
                //sock = clientSocket;
                // InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) { e.printStackTrace(); }
        } // close constructor

        public String addTag(String msg) {
            return new String("<" + msg + ">");
        }

        public String msgFormat(String msg) {
            String fMsg = new String();
            fMsg += "Hi, ";
            fMsg += addTag(Thread.currentThread().getName());
            fMsg += ": I received your message.";
            fMsg += addTag(msg);
            fMsg += "\n";

            return fMsg;
        }
        @Override
        public void run() {
            try {
                String msg;
                //String responseMsg = new String();
                prompt("Thread running waiting...");
                while((msg = clientReader.readLine()) != null) {
                    prompt("Server read: " + msgFormat(msg));
                    tellEveryone(msgFormat(msg));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   // close run
    }   // close inner class

    public static void main(String [] args) {
        new VerySimpleChatServer().go();
    }

    public void prepareT(Socket s, int n) {
        Thread t = new Thread(new ClientHandler(s));
        t.setName("T_" + Integer.toString(n));
        t.start();
    }
    
    public void go() {
        clientWriterList = new ArrayList<PrintWriter>();
        int threadNum = 0;

        try (ServerSocket serverSocket = new ServerSocket(4242))  {
            while(true) {
                prompt("Waiting client connected...");
                Socket clientSocket = serverSocket.accept();
                prompt("client connected finish.");

                // PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
                // clientOutputStreams.add(printWriter);
                clientWriterList.add(new PrintWriter(clientSocket.getOutputStream()));
                prepareT(clientSocket, ++threadNum);
                prompt("got a connection");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void tellEveryone(String msg) {
        for(PrintWriter client : clientWriterList) {
            try {
                client.println(msg);
                client.flush();
            } catch (Exception e) { e.printStackTrace(); }
        }

        // Iterator<PrintWriter> it = clientWriterList.iterator();
        // while(it.hasNext()) {
        //     try {
        //         PrintWriter clientWriter = it.next();
        //         clientWriter.println(msg);
        //         clientWriter.flush();
        //     } catch (Exception e) { e.printStackTrace(); }
        // } // end while
    } // close tellEveryone

    public void prompt(String msg) {
        System.out.println(msg);
    }

} // close class
