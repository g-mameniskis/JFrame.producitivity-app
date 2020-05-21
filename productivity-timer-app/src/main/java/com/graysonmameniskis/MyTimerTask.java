package com.graysonmameniskis;

import javax.swing.*;
import java.awt.*;

public class MyTimerTask extends ImageFrame {

    private ImageFrame imageFrame = new ImageFrame();
    private ImageIcon imageIcon = new ImageIcon("timer.png");
    JLabel background = new JLabel("", imageIcon, JLabel.CENTER);

    public void run() {
        System.out.println("TESTING TIMERTASK");
    }

    public void printTime() {
        System.out.println("Time");
    }

    public void printImage() {
        System.out.println("Image");
    }

    public void jFrameCreation() {
        JFrame frame = new JFrame("TimerApp");
        frame.setContentPane(new TimerApp().getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void createImageFrame() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        add(background, gc);

        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        ImageIcon imageIcon = new ImageIcon("timer.png");
        background = new JLabel("", imageIcon, JLabel.CENTER);
        background.setBounds(0, 0, 300, 400);
        add(background);


    }
}
