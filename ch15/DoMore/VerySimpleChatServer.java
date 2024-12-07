package ch15.DoMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class VerySimpleChatServer {

    ArrayList<PrintWriter> clientOutputStreams;

    class ClientHandler implements Runnable {
        BufferedReader reader;
        Socket sock;

        public ClientHandler(Socket clientSocket) {
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (IOException e) { e.printStackTrace(); }
        } // close constructor

        public String addTag(String msg) {
            return new String("<" + msg + ">");
        }

        @Override
        public void run() {
            try {
                String msg;
                //String responseMsg = new String();
                prompt("Thread running waiting...");
                while((msg = reader.readLine()) != null) {
                    String responseMsg = new String();
                    responseMsg += "Hi, ";
                    responseMsg += addTag(Thread.currentThread().getName());
                    responseMsg += ": I received your message.";
                    responseMsg += addTag(msg);
                    responseMsg += "\n";

                    prompt("Server read: " + responseMsg);
                    tellEveryone(responseMsg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   // close run
    }   // close inner class

    public static void main(String [] args) {
        new VerySimpleChatServer().go();
    }

    public void go() {
        clientOutputStreams = new ArrayList<PrintWriter>();
        int threadNum = 0;

        try (ServerSocket serverSocket = new ServerSocket(4242))  {
            while(true) {
                prompt("Waiting client connected...");
                Socket clientSocket = serverSocket.accept();
                prompt("client connected finish.");

                PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(printWriter);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.setName("T_" + Integer.toString(++threadNum));
                t.start();

                prompt("got a connection");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void tellEveryone(String msg) {
        Iterator<PrintWriter> it = clientOutputStreams.iterator();
        prompt("clientOutStreams length: " + Integer.toString(clientOutputStreams.size()));
        while(it.hasNext()) {
            try {
                prompt("Server send: " + msg + ", begin.");
                PrintWriter printWriter = it.next();
                printWriter.println(msg);
                printWriter.flush();
                prompt("Server send: " + msg + ", finish.");
            } catch (Exception e) { e.printStackTrace(); }
        } // end while
    } // close tellEveryone

    public void prompt(String msg) {
        System.out.println(msg);
    }

} // close class
