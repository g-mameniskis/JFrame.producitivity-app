package com.graysonmameniskis;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TaskExecutionControl {

    // two timer tasks: one for 25 minutes, one for 5 minutes, for the most part

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public void displayTimerForTwentyFiveMinutes() {
        final Runnable timer = new Runnable() {
            public void run() { System.out.println("timer"); }
        };
        final ScheduledFuture<?> imageHandle =
                scheduler.scheduleAtFixedRate(timer, 1, 10, TimeUnit.SECONDS);
        scheduler.schedule(new Runnable() {
            public void run() { imageHandle.cancel(true); }
        }, 60 * 60, TimeUnit.SECONDS);
    }

    public void displayImageForFiveMinutes() {
        final Runnable image = new Runnable() {
            public void run() { System.out.println("image"); }
        };
        final ScheduledFuture<?> imageHandle =
                scheduler.scheduleAtFixedRate(image, 5, 5, TimeUnit.SECONDS);
        scheduler.schedule(new Runnable() {
            public void run() { imageHandle.cancel(true); }
        }, 60 * 60, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter the timer's duration: ");
//        int input  = scanner.nextInt();
//        scanner.nextLine();

        TaskExecutionControl taskExecutionControl = new TaskExecutionControl();
        taskExecutionControl.displayTimerForTwentyFiveMinutes();
        taskExecutionControl.displayImageForFiveMinutes();
    }
}

