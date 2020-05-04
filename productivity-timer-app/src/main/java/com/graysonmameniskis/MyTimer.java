//package com.graysonmameniskis;
//
//public class MyTimer {
//
//    public void initGUI() {
//
//        timer = new MyTimer(speed, this);
//        timer.setInitialDelay(pause);
//        timer.start();
//
//
//
//
//
////        JFrame frame = new JFrame("Timer");
////        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
////        frame.setPreferredSize(new Dimension(800, 600));
////        frame.setLayout(null);
////
////        Calendar now = Calendar.getInstance();
////        tijd = new JLabel(dateFormat.format(now.getTime()));
////        tijd.setBounds(100, 100, 125, 125);
////        window.add(tijd);
////
////        new Timer(1000, new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                Calendar now = Calendar.getInstance();
////                tijd.setText(dateFormat.format(now.getTime()));
////            }
////        }).start();
////
////        pack();
////    }
//
//
//
////    private long startTime;
////    private long elapsedTime;
////    private long elapsedSeconds;
////    private long secondsDisplay;
////    private long elapsedMinutes;
////
////    public Timer() {
////        this.startTime = System.currentTimeMillis();
////        this.elapsedTime = System.currentTimeMillis() - startTime;
////        this.elapsedSeconds = elapsedTime / 1000;
////        this.secondsDisplay = elapsedSeconds % 60;
////        this.elapsedMinutes = elapsedSeconds / 60;
////    }
////
////    public long getElapsedMinutes() {
////        return elapsedMinutes;
////    }
////
////    public void start() {
////
////    }
////
////    public void displayTime() {
////        System.out.println(elapsedTime);
////    }
//
//}
