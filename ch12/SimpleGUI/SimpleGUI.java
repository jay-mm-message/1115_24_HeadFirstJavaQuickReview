package ch12.SimpleGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleGUI implements ActionListener {
    JButton button;

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("Press me to continue");
        button.addActionListener(this);
        button.setForeground(Color.BLUE);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(button);
        //frame.add(button);
        //frame.add(new MyDrawPanel());
        JPanel panel = new MyDrawPanel();
        panel.add(button);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        int width = 700;
        int height = 700;
        frame.setSize(width, height);
        frame.setVisible(true);

    }

    // public void paintComponent(Graphics g) {
    //     g.setColor(Color.orange);
    //     g.fillRect(20, 50, 100, 100);
    // }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        button.setText("I've pressed the button");
        button.setForeground(Color.PINK);
    }
}
