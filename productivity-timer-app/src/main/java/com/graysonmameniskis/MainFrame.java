package com.graysonmameniskis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

// Ref: https://www.caveofprogramming.com/java-multithreading/java-multithreading-swing-swingworker-part-15.html

public class MainFrame extends JFrame {

    private JLabel countLabel1 = new JLabel("0");
    private JLabel statusLabel = new JLabel("Task not completed.");
    private JButton startButton = new JButton("Start");

    private final int MINUTES_TO_SECONDS = 60;

    public MainFrame(String title) {
        super(title);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        add(countLabel1, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        add(statusLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        add(startButton, gc);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                start();
            }
        });

        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int number(int number) {
        return number;
    }

    private void start() {

        // Use SwingWorker<Void, Void> and return null from doInBackground if
        // you don't want any final result and you don't want to update the GUI
        // as the thread goes along.
        // First argument is the thread result, returned when processing finished.
        // Second argument is the value to update the GUI with via publish() and process()
        SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {

            @Override
            /*
             * Note: do not update the GUI from within doInBackground.
             */
            protected Boolean doInBackground() throws Exception {

                // Simulate useful work

                    for (int j = 0; j < 30 * MINUTES_TO_SECONDS; j++) {
                        for (int i = 0; i < 60; i++) {
                            // counts each iteration with 1 second intervals

                            Thread.sleep(1000);
                            System.out.println("Hello: " + i);

                            // optional: use publish to send values to process(), which
                            // you can then use to update the GUI.
                            String date = String.format("%02d:00", i);
                            // need to figure out how to format the count
                            // problem: publish only accepts "chunks" as parameters
                            publish(i);
                        }
                    }

                return false;
            }

            @Override
            // This will be called if you call publish() from doInBackground()
            // Can safely update the GUI here.
            protected void process(List<Integer> chunks) {
                Integer value = chunks.get(chunks.size() - 1);

//                BigDecimal roundThreeCalc = new BigDecimal("0");
//                BigDecimal var3600 = new BigDecimal("3600");
//                BigDecimal myremainder = roundThreeCalc.remainder(var3600);
//                BigDecimal seconds = new BigDecimal("0");
//                BigDecimal var60 = new BigDecimal("60");
//                seconds = (myremainder.remainder(var60));

//                String date = String.format("%02d:00", seconds);

                int count = 0;
                for (int i = 0; i < chunks.size(); i++) {
                    int newValue = chunks.get(i);
                    if (newValue == 0) {
                        count++;
                    }
                }

                System.out.println(count);
                countLabel1.setText("Current value: " + count + ":" + value);
            }

            @Override
            // This is called when the thread finishes.
            // Can safely update GUI here.
            protected void done() {

                try {
                    Boolean status = get();
                    statusLabel.setText("Completed with status: " + status);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        };

        worker.execute();
    }
}
