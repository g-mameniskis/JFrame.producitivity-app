package com.graysonmameniskis;

public class MyTimer {


//        timer = new MyTimer(speed, this);
//        timer.setInitialDelay(pause);
//        timer.start();
//
//
//
//
//
//        JFrame frame = new JFrame("Timer");
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setPreferredSize(new Dimension(800, 600));
//        frame.setLayout(null);
//
//        Calendar now = Calendar.getInstance();
//        tijd = new JLabel(dateFormat.format(now.getTime()));
//        tijd.setBounds(100, 100, 125, 125);
//        window.add(tijd);
//
//        new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Calendar now = Calendar.getInstance();
//                tijd.setText(dateFormat.format(now.getTime()));
//            }
//        }).start();
//
//        pack();
//    }


// User input for number of minutes for work
// User input for number of minutes for break
// User input for number of cycles
// take minutes of work number and convert it to a time
// Build countdown from work number to zero
// take minutes of break number and convert it to a time
// Build countdown from break number to zero
// repeat number of times the cycle is expected


    private long startTime;
    private long elapsedTime;
    private long elapsedSeconds;
    private long secondsDisplay;
    private long elapsedMinutes;

    MyTimer() {
        this.startTime = System.currentTimeMillis();
        //this.elapsedTime = System.currentTimeMillis() - startTime;
        //this.elapsedSeconds = elapsedTime / 1000;
        //this.secondsDisplay = elapsedSeconds % 60;
        //this.elapsedMinutes = elapsedSeconds / 60;
    }

    public String getElapsedMinutes() {
        return Long.toString(elapsedMinutes);
    }

    public long getStartTime() {
        return startTime;
    }

    public long setElapsedTime() {
        return this.elapsedTime = System.currentTimeMillis() - getStartTime();
    }

    public long setElapsedSeconds() {
        return this.elapsedSeconds = setElapsedTime() / 1000;
    }

    public long setSecondsDisplay() {
        return this.secondsDisplay = setElapsedSeconds() % 60;
    }

    public long setElapsedMinutes() {
        return this.elapsedMinutes = setElapsedSeconds() / 60;
    }
}
