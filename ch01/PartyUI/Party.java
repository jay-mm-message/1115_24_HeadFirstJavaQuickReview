package ch01.PartyUI;

import javax.swing.*;
import java.awt.*;

public class Party {
    public void buildInvite() {

        JFrame frame = new JFrame("Party at Time's");

        // set frame site
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Exit the application when the window is closed
        frame.setLayout(new FlowLayout());
    
        // center the JLabel
        JLabel lblText = new JLabel("Party at Time's", SwingConstants.CENTER);
        JButton button1 = new JButton("You bet");
        JButton button2 = new JButton("Shoot me");
 
        frame.add(button1);
        frame.add(button2);

        // add JLabel to JFrame
        frame.getContentPane().add(lblText);

        // display it
        //frame.pack();
        frame.setVisible(true);
    }
}