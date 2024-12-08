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

    BufferedReader serverReader;
    PrintWriter serverWriter;
    Socket socket;

    JTextArea boardShow;
    JTextField boardEdit;

    public static void main(String[] args) {
        SimpleChatClient client = new SimpleChatClient();
        client.go();
    }

    class SendButtonListener implements ActionListener {

        public String fMsg(String s) {
            String msg = new String("The client says: Hi, server, I sent a message to you:");
            msg += "<" + s + ">\n";
            return msg;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String inputText = boardEdit.getText();
                if (!inputText.isEmpty()) {
                    boardShow.append(fMsg(inputText));
                    boardEdit.setText("");
                    serverWriter.println(inputText);
                    serverWriter.flush();
                }
            } catch (Exception ex) { ex.printStackTrace(); }
            boardEdit.setText(" ");
            boardEdit.requestFocus();
        }
    } // close SendButtonListener

    public void DrawInterfaceWindow() {
       // Create a new JFrame
       JFrame frame = new JFrame("Ludicrously Simple Chat Client");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800, 500);

       // Create a JTextArea
       boardShow = new JTextArea(15, 50);
       boardShow.setLineWrap(true);
       boardShow.setWrapStyleWord(true);
       boardShow.setEditable(false);

       // Add the JTextArea to a JScrollPane
       JScrollPane qScroller = new JScrollPane(boardShow);
       qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

       // Create a JTextField and a JButton
       boardEdit = new JTextField(20);
       JButton sendButton = new JButton("Send");
       sendButton.addActionListener(new SendButtonListener());

       JPanel mainPanel = new JPanel();
       mainPanel.add(qScroller);
       mainPanel.add(boardEdit);
       mainPanel.add(sendButton);

       frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
       frame.add(qScroller, BorderLayout.CENTER);
       frame.add(mainPanel, BorderLayout.SOUTH);
       frame.setVisible(true);
    }

    private void setUpNetworking() {
        try {
            socket = new Socket("127.0.0.1", 4242);
            this.serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.serverWriter = new PrintWriter(socket.getOutputStream());
            prompt("networking established");
        } catch (UnknownHostException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace(); }
    } // close setUpNetworking

    public void go() {
        DrawInterfaceWindow();
        
        // Prepare to communicate with the server.
        setUpNetworking();

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
    } // close go

    class IncomingReader implements Runnable {

        @Override
        public void run() {
            String msg;
            try {
                while((msg = serverReader.readLine()) != null) {
                    if (!msg.equals("")) {
                        boardShow.append(fServerMsg(msg));    
                    }
                 }
            } catch (IOException e) { e.printStackTrace(); }
        }

        public String fServerMsg(String s) {
            String msg = new String("The server says: " + s + "\n");
            return msg;
        }
    } // close IncomingReader

    private void prompt(String msg) {
        System.out.println(msg);
    }
} // close outer class
