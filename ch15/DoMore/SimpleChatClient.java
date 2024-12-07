package ch15.DoMore;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleChatClient {

    public static void main(String[] args) {
        SimpleChatClient client = new SimpleChatClient();
        client.go();
    }

    public void DrawInterfaceWindow() {
       // Create a new JFrame
       JFrame frame = new JFrame("Ludicrously Simple Chat Client");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800, 500);

       // Create a JTextArea
       incoming = new JTextArea(15, 50);
       incoming.setLineWrap(true);
       incoming.setWrapStyleWord(true);
       incoming.setEditable(false);

       // Add the JTextArea to a JScrollPane
       JScrollPane qScroller = new JScrollPane(incoming);
       qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

       // Create a JTextField and a JButton
       outgoing = new JTextField(20);
       JButton sendButton = new JButton("Send");
       sendButton.addActionListener(new SendButtonListener());

       JPanel mainPanel = new JPanel();
       mainPanel.add(qScroller);
       mainPanel.add(outgoing);
       mainPanel.add(sendButton);

       frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
       frame.add(qScroller, BorderLayout.CENTER);
       frame.add(mainPanel, BorderLayout.SOUTH);
       frame.setVisible(true);
    }

    public void go() {
        DrawInterfaceWindow();
        // Prepare to communicate with the server.
        setUpNetworking();
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

    } // close go

    private void setUpNetworking() {
        try {
            socket = new Socket("127.0.0.1", 4242);
            InputStreamReader inputStreamReader = 
                new InputStreamReader(socket.getInputStream());
            this.bufferedReader = new BufferedReader(inputStreamReader);
            this.printWriter = new PrintWriter(socket.getOutputStream());
            prompt("networking established");
        } catch (UnknownHostException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace(); }
    } // close setUpNetworking

    BufferedReader bufferedReader;
    PrintWriter printWriter;
    Socket socket;

    class SendButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String inputText = outgoing.getText();
                if (!inputText.isEmpty()) {
                    String msgSend = new String("The client says: Hi, server, I sent a message to you:");
                    incoming.append(msgSend + "<" + inputText + ">" + "\n");
                    outgoing.setText("");
                }
                printWriter.println(inputText);
                printWriter.flush();
            } catch (Exception ex) { ex.printStackTrace(); }
            outgoing.setText(" ");
            outgoing.requestFocus();
        }
    } // close SendButtonListener

    JTextArea incoming;
    JTextField outgoing;

    class IncomingReader implements Runnable {

        @Override
        public void run() {
            String msg;
            try {
                prompt("IncomingReader Waiting....");
                while((msg = bufferedReader.readLine()) != null) {
                    if (!msg.equals("")) {
                        String serverMsg = new String("The server says: " + msg + "\n");
                        prompt(serverMsg);
                        incoming.append(serverMsg);        
                    }
                 }
                prompt("IncomingReader Write finish.");
            } catch (IOException e) { e.printStackTrace(); }
        }
    } // close IncomingReader

    private void prompt(String msg) {
        System.out.println(msg);
    }
} // close outer class
