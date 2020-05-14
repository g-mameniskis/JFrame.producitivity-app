package com.graysonmameniskis;

import javax.swing.*;
import java.util.Scanner;

public class App
{

    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MILLISECONDS_IN_SECOND = 1000;
    private static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args )
    {

        /**
         * @param args
         */

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame("SwingWorker Demo");
                MainFrame mainFrame = new MainFrame("SwingWorker Demo");
                mainFrame.number(25*SECONDS_IN_MINUTE);
            }
        });


//        MyTimerTask myTimerTask = new MyTimerTask();
//        Timer timer = new Timer();
//
//        System.out.println("Enter duration of timer: ");
//        int durationInput = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Enter length of break: ");
//        int breakInput = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Enter the number of cycles to perform: ");
//        int cycleInput = scanner.nextInt();
//        scanner.nextLine();
//
//        // timer.schedule accepts three actual arguments:
//            // 1. Timer task object (inherits from TimerTask class)
//            // 2. duration of timer
//            // 3. duration of  break between timer executions
//
//        long timerDuration = durationInput * (MILLISECONDS_IN_SECOND);
//        long breakDuration = breakInput * (MILLISECONDS_IN_SECOND);





//        for (int i = 0; i <= cycleInput; i++) {
//            timer.scheduleAtFixedRate(myTimerTask, timerDuration, breakDuration);
//
//
//            try {
//                Thread.sleep((timerDuration + breakDuration));
//            }catch (InterruptedException exc) {
//
//            }
//        }

        // Thread.sleep tells our program when to exit
        // Takes one actual argument
            // 1. Duration of thread's lifespan before timer program exits



        //timer.cancel();




//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        ScheduledFuture<?> future = scheduledExecutorService.scheduleAtFixedRate(myTimerTask, timerDuration, breakDuration, TimeUnit.SECONDS);
//        future.cancel(false);





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
