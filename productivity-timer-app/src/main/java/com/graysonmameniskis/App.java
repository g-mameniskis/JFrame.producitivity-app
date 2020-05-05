package com.graysonmameniskis;

import java.util.Scanner;
import java.util.Timer;

public class App
{

    final private int SECONDS_IN_MINUTE = 60;
    public int MILLISECONDS_IN_SECOND = 1000;
    private static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args )
    {

        MyTimerTask myTimerTask = new MyTimerTask();
        Timer timer = new Timer();

        System.out.println("Enter duration of timer: ");
        int durationInput = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter length of break: ");
        int breakInput = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the number of cycles to perform: ");
        int cycleInput = scanner.nextInt();
        scanner.nextLine();

        timer.schedule(myTimerTask, (durationInput * 1000), (breakInput * 1000));
        try {
            Thread.sleep((((durationInput * 1000) + (breakInput * 1000)) * (cycleInput)));
        }catch (InterruptedException exc) {

        }

        timer.cancel();

//        JFrame frame = new JFrame("TimerApp");
//        frame.setContentPane(new TimerApp().getPanelMain());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);

//        NewTab newTab = new NewTab();
//        if (newTab.isMinutesElapsed25()) {
//            newTab.openNewTab();
//        }

    }
}
