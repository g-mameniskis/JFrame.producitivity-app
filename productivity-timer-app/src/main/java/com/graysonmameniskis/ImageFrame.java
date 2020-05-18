//package com.graysonmameniskis;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.concurrent.ExecutionException;
//
//// Ref: https://www.caveofprogramming.com/java-multithreading/java-multithreading-swing-swingworker-part-15.html
//
//public class ImageFrame extends JFrame {
//
//    private ImageFrame imageFrame = new ImageFrame();
//    private ImageIcon imageIcon = new ImageIcon("timer.png");
//    JLabel background = new JLabel("", imageIcon, JLabel.CENTER);
//
//    public ImageFrame() {
//
//        setLayout(new GridBagLayout());
//        GridBagConstraints gc = new GridBagConstraints();
//        gc.fill = GridBagConstraints.NONE;
//
//        gc.gridx = 0;
//        gc.gridy = 0;
//        gc.weightx = 1;
//        gc.weighty = 1;
//        add(background, gc);
//
////        setSize(300, 400);
////        setDefaultCloseOperation(EXIT_ON_CLOSE);
////        setVisible(true);
////        ImageIcon imageIcon = new ImageIcon("timer.png");
////        background = new JLabel("", imageIcon, JLabel.CENTER);
////        background.setBounds(0, 0, 300, 400);
////        add(background);
//
//
//        setSize(300, 400);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setVisible(true);
//
//
//        background.(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                start();
//            }
//        });
//    }
//
//    private void start() {
//
//        // Use SwingWorker<Void, Void> and return null from doInBackground if
//        // you don't want any final result and you don't want to update the GUI
//        // as the thread goes along.
//        // First argument is the thread result, returned when processing finished.
//        // Second argument is the value to update the GUI with via publish() and process()
//        SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {
//
//            @Override
//            /*
//             * Note: do not update the GUI from within doInBackground.
//             */
//            protected Boolean doInBackground() throws Exception {
//
//                // Simulate useful work
//
//                for (int i = 0; i < 1 * 60; i++) {
//                    // counts each iteration with 1 second intervals
//                    Thread.sleep(1000);
//                    System.out.println("hi: " + i);
//
//                }
//
//                return false;
//            }
//
//            @Override
//            // This is called when the thread finishes.
//            // Can safely update GUI here.
//            protected void done() {
//
//                try {
//                    Boolean status = get();
////                    statusLabel.setText("Completed with status: " + status);
//
//                    imageFrame.dispose();
//
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//            }
//
//        };
//
//        worker.execute();
//    }
//}
//
