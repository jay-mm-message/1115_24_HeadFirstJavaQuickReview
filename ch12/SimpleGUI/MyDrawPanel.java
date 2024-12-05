package ch12.SimpleGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        // Cast to Graphics2D for more control
        Graphics2D g2d = (Graphics2D) g;

        // Set background color
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw a rectangle
        g2d.setColor(Color.BLUE);
        g2d.fillRect(50, 50, 100, 60);

        // Draw a circle
        g2d.setColor(Color.PINK);
        g2d.fillOval(200, 50, 80, 80);

        // Draw a line
        g2d.setColor(Color.BLACK);
        g2d.drawLine(50, 150, 300, 150);

        // Draw text
        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("Custom Painting with paintComponent!", 50, 200);
    }    
}
