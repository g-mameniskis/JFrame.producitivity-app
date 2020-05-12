package com.graysonmameniskis;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TaskExecutionControl {

    // two timer tasks: one for 25 minutes, one for 5 minutes, for the most part
    MyTimerTask myTimerTask = new MyTimerTask();
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    static Scanner scanner = new Scanner(System.in);
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MILLISECONDS_IN_SECOND = 1000;

    public static void main(String[] args) {
        System.out.println("Please enter the timer's duration: ");
        int timerDurationInput  = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the timer's break duration: ");
        int timerBreakInput  = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the number of timers to execute: ");
        int numberOfTimers = scanner.nextInt();
        scanner.nextLine();

        long breakDuration = timerBreakInput * (SECONDS_IN_MINUTE);
        long timerDuration = timerDurationInput * (SECONDS_IN_MINUTE) + breakDuration;
        long timerCycleDuration = numberOfTimers * timerDuration;

        TaskExecutionControl taskExecutionControl = new TaskExecutionControl();
        taskExecutionControl.displayTimerForTwentyFiveMinutes(timerDuration, timerCycleDuration);
        taskExecutionControl.displayImageForFiveMinutes(timerDuration, breakDuration, timerCycleDuration);
    }

    public void displayTimerForTwentyFiveMinutes(long timerDuration, long timerCycle) {
        final Runnable timer = () -> myTimerTask.jFrameCreation();
        final ScheduledFuture<?> timerHandle =
                scheduler.scheduleWithFixedDelay(timer, 1, timerDuration, TimeUnit.SECONDS);
        //        }, 60 * 60, TimeUnit.SECONDS);
        scheduler.schedule(() -> { timerHandle.cancel(true); }, timerCycle * 60, TimeUnit.SECONDS);
    }

    public void displayImageForFiveMinutes(long timerOn, long timerWaitTime, long timerCycle) {
        final Runnable image = new Runnable() {
            public void run() { myTimerTask.printImage(); }
        };
        final ScheduledFuture<?> imageHandle =
                scheduler.scheduleAtFixedRate(image, timerWaitTime, timerOn, TimeUnit.SECONDS);
        scheduler.schedule(new Runnable() {
            public void run() { imageHandle.cancel(true); }
        }, timerCycle * 60, TimeUnit.SECONDS);
    }






    // Attempting to generify the method above
//    public void skeleton(String input, int initialDelay, int periodDuration) {
//        if (input.equals("timer")) {
//            final Runnable image = new Runnable() {
//                public void run() {
//                    myTimerTask.printTime();
//                }
//            };
//        } else if (input.equals("break")) {
//            final Runnable image = new Runnable() {
//                public void run() {
//                    myTimerTask.printImage();
//                }
//            };
//        }
//        final ScheduledFuture<?> imageHandle =
//                scheduler.scheduleAtFixedRate(image, 5, 5, TimeUnit.SECONDS);
//        scheduler.schedule(new Runnable() {
//            public void run() { imageHandle.cancel(true); }
//        }, 60 * 60, TimeUnit.SECONDS);
//    }

//    new Thread(() -> someMethod().start());
//    new Thread(this::someMethod).start();
}

