package com.graysonmameniskis;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

// Ref: https://www.caveofprogramming.com/java-multithreading/java-multithreading-swing-swingworker-part-15.html

public class DemoFrame extends JFrame {

    private ImageIcon imageIcon = new ImageIcon("timer.png");
    //JLabel background = new JLabel("", imageIcon, JLabel.CENTER);
    JLabel background = new JLabel(imageIcon);

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
        add(background, gc);

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

        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        //ImageIcon imageIcon = new ImageIcon("timer.png");
        //background = new JLabel("", imageIcon, JLabel.CENTER);
        //background.setBounds(0, 0, 300, 400);
        add(background);
    }

    public void invoke() throws InterruptedException {
        for (int i = 0; i < 1 * MINUTES_TO_SECONDS; i++) {
            // counts each iteration with 1 second intervals
            Thread.sleep(1000);
            System.out.println("Hi: " + i);
            // optional: use publish to send values to process(), which
            // you can then use to update the GUI.


        }

        setVisible(false); //you can't see me!
        dispose();

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
                    System.out.println("Hi: " + i);
                    // optional: use publish to send values to process(), which
                    // you can then use to update the GUI.


                }

                setVisible(false); //you can't see me!
                dispose();
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

