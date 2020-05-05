package com.graysonmameniskis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerApp {

    private JLabel lblTime;
    private JButton startButton;
    private JButton stopButton;
    private JPanel panelMain;

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Get the current time of the system
            Date currentTime = new Date();

            //Set this time to our label
            lblTime.setText(currentTime.toString());
            //Get the timer's time
            //MyTimer myTimer = new MyTimer();
            //Set the timer's time to our label
            //lblTime.setText(myTimer.getElapsedMinutes());
        }
    });

    public JPanel getPanelMain() {
        return panelMain;
    }

    public TimerApp() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
    }
}
