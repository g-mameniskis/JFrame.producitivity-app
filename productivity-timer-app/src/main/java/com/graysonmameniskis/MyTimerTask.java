package com.graysonmameniskis;

import javax.swing.*;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

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
}
