package com.example.gasolineraspringboot.gasolinera;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

/**
 * GUI
 */
public class GUI {
    private static JFrame frame1;
    private static JPanel panel = new JPanel();
    private static JScrollPane scrollPane;
    private static ArrayList<JButton> buttons;
    private static int numSurtidores;

    public GUI(int numSurtidores){
        this.numSurtidores = numSurtidores;
        frame1 = new JFrame("Gasolinera");
        scrollPane = new JScrollPane(panel);
        frame1.setBounds(400,150,300,500);
        frame1.add(scrollPane, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(numSurtidores, 1));

        frame1.setVisible(true);
    }

    public static void setColorGray(int i, String msg) {
        buttons.get(i).setText("Surtidor " + (i+1) + msg);
        buttons.get(i).setBackground(Color.GRAY);

    }

    public static void setColorYellow(int i, String msg) {
        buttons.get(i).setText("Surtidor " + (i+1) + msg);
        buttons.get(i).setBackground(Color.YELLOW);

    }

    public static void setColorGreen(int i, String msg) {
        buttons.get(i).setText("Surtidor " + (i+1) + msg);
        buttons.get(i).setBackground(Color.GREEN);

    }


}