package com.graysonmameniskis;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

// Ref: https://www.caveofprogramming.com/java-multithreading/java-multithreading-swing-swingworker-part-15.html

public class DemoFrame extends JFrame {

    private JLabel imageLabel = new JLabel("0:00");

    private final int MINUTES_TO_SECONDS = 60;

    public DemoFrame(String title) {
        super(title);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        add(imageLabel, gc);

//        gc.gridx = 0;
//        gc.gridy = 1;
//        gc.weightx = 1;
//        gc.weighty = 1;
//        add(statusLabel, gc);

//        gc.gridx = 0;
//        gc.gridy = 2;
//        gc.weightx = 1;
//        gc.weighty = 1;
//        add(startButton, gc);

//        startButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                start();
//            }
//        });

        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
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

                start();
                for (int i = 0; i < 1 * MINUTES_TO_SECONDS; i++) {
                    // counts each iteration with 1 second intervals
                    Thread.sleep(1000);
                    System.out.println("Hello: " + i);
                    // optional: use publish to send values to process(), which
                    // you can then use to update the GUI.


                }


                return false;
            }


            @Override
            // This is called when the thread finishes.
            // Can safely update GUI here.
            protected void done() {

                try {
                    Boolean status = get();
//                    statusLabel.setText("Completed with status: " + status);
                    //statusLabel.setText("Times Up!");

                    // attempting to create a new JFrame upon completion
                    SwingUtilities.invokeLater(new Runnable() {


                        @Override
                        public void run() {
                            new DemoFrame("Demo");

                        }
                    });

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

