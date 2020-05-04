package com.graysonmameniskis;

import javax.swing.*;

public class App
{
    public static void main( String[] args )
    {

        JFrame frame = new JFrame("TimerApp");
        frame.setContentPane(new TimerApp().getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

//        NewTab newTab = new NewTab();
//        if (newTab.isMinutesElapsed25()) {
//            newTab.openNewTab();
//        }

    }
}
