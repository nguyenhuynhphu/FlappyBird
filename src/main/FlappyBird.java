/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 *
 * @author Nguyen Huynh Phu
 */
@SuppressWarnings("unchecked")
public class FlappyBird extends javax.swing.JFrame {

    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    int score = 0;
    boolean deadth = false;
    private ArrayList<JButton> columms = new ArrayList<>();
    Timer timer;
    public Random rand = new Random();

    private Point birdPos;
    private boolean pause = true;
    boolean collision;
    boolean firstAccess;
    private Vector data;
    private String medal;
    //private Rectangle birdRec;

    public FlappyBird() {
        initComponents();
        firstAccess = true;
        this.setResizable(false);
        this.setSize(800, 658);

        jPanel1.requestFocus(true);
        jPanel1.setSize(WIDTH, HEIGHT);
        jPanel1.setLayout(null);
        jPanel1.setBackground(Color.cyan);
        bird.setLocation(50, 250);
        bird.setIcon(new ImageIcon("src/img/a.png"));
        addColumm(true);
        addColumm(true);
        addColumm(true);
        addColumm(true);
        birdPos = bird.getLocation();
        actionPerformed();
        //loadPlayer();
        //timer.stop();
    }

    public void newGame() {
        if (firstAccess) {
            timer.start();
            firstAccess = false;
        } else {
            if (!deadth) {
                timer.stop();
                int choice = JOptionPane.showConfirmDialog(this, "Do you want to restart ?");
                if (choice == JOptionPane.YES_OPTION) {
                    setDefault();
                } else {
                    timer.start();
                }
            } else {
                setDefault();
            }
        }
        jPanel1.requestFocus();
    }

    public void setDefault() {
        score = 0;
        deadth = false;
        for (JButton columm : columms) {
            jPanel1.remove(columm);
        }
        columms = new ArrayList();
        pause = true;
        bird.setLocation(50, 250);
        addColumm(true);
        addColumm(true);
        addColumm(true);
        addColumm(true);
        birdPos = bird.getLocation();
        timer.restart();
    }

//    public void saveRecord() {
//        try {
//            File file = new File("src/data/data.txt");
//            FileWriter fr = new FileWriter(file);
//            for (int i = 0; i < data.size(); i++) {
//                Vector row = (Vector) data.get(i);
//                String tmp = (String) row.get(0) + "-" + (String) row.get(1) + "-" + (String) row.get(2);
//                fr.write(tmp);
//
//                fr.write("\n");
//            }
//            String line = playerName + "-" + score + "-" + medal;
//            fr.write(line);
//            fr.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public void addColumm(boolean start) {
        int space = 200;
        int width = 100;
        int height = 50 + rand.nextInt(300);
        if (start) {
            JButton tmp = new JButton();
            tmp.setSize(width, height);
            tmp.setLocation(650 + columms.size() * 200, HEIGHT - height + 10);
            tmp.setBackground(Color.GREEN);
            tmp.setText(tmp.getHeight() + "");
            jPanel1.add(tmp);
            JButton tmp1 = new JButton();
            tmp1.setSize(width, HEIGHT - height - space);
            tmp1.setLocation(650 + columms.size() * 200, 0);
            tmp1.setBackground(Color.GREEN);
            tmp1.setText(tmp1.getHeight() + "");
            jPanel1.add(tmp1);
            columms.add(tmp);
            columms.add(tmp1);
        } else {
            JButton tmp = new JButton();
            tmp.setSize(width, height);
            tmp.setLocation((int) columms.get(columms.size() - 1).getLocation().getX() + 350, HEIGHT - height + 10);
            tmp.setBackground(Color.GREEN);
            tmp.setText(tmp.getHeight() + "");
            jPanel1.add(tmp);

            JButton tmp1 = new JButton();
            tmp1.setSize(width, HEIGHT - height - space);
            tmp1.setLocation((int) columms.get(columms.size() - 1).getLocation().getX() + 350, 0);
            tmp1.setBackground(Color.GREEN);
            tmp1.setText(tmp1.getHeight() + "");
            jPanel1.add(tmp1);

            columms.add(tmp);
            columms.add(tmp1);
        }
    }

//    public void loadPlayer() {
//        try {
//            data = new Vector();
//            File file = new File("src/data/data.txt");
//            FileReader fr = new FileReader(file);
//            BufferedReader br = new BufferedReader(fr);
//            String line = "";
//            while ((line = br.readLine().trim()) != null) {
//                String[] tmp = line.trim().split("-");
//                System.out.println(tmp[0]);
//                Vector row = new Vector<>();
//                row.add(tmp[0]);
//                row.add(tmp[1]);
//                row.add(tmp[2]);
//                data.add(row);
//            }
//            System.out.println(data.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        bird = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        point = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setAutoscrolls(true);
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        bird.setText("Bird");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(bird, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(494, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(bird, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        jLabel2.setText("Score");

        btnNew.setText("New Game");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNew)
                            .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(point, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(point, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnNew)
                .addGap(31, 31, 31)
                .addComponent(btnPause)
                .addGap(421, 421, 421))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if (!deadth && timer.isRunning()) {
            if (evt.getKeyCode() == 32) {
                Point p = bird.getLocation();
                if (p.y - bird.getHeight() / 2 >= 0) {
                    p.setLocation(p.x, p.y - 70);
                    bird.setLocation(p);
                }
            }

        }
        jPanel1.updateUI();
    }//GEN-LAST:event_jPanel1KeyPressed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        if (!deadth) {
            if (pause) {
                pause = false;
                timer.stop();
            } else {
                timer.start();
                pause = true;
            }
        }
        //saveRecord();
        jPanel1.requestFocus(true);
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        newGame();
        //loadPlayer();
    }//GEN-LAST:event_btnNewActionPerformed
    public void checkDistance(JButton column) {

        Point colPos = column.getLocation();
        birdPos = bird.getLocation();

        if ((birdPos.x + bird.getWidth()) - colPos.x >= 0) {
            if (colPos.x - birdPos.x - bird.getWidth() == 0) {
                collision = true;
            }
            if ((colPos.x + column.getWidth()) - birdPos.x == 0) {
                collision = false;
                if (colPos.y == 0) {
                    score++;
                }
            }
            if (collision) {
                if (colPos.y == 0) {
                    if (birdPos.y <= column.getHeight()) {
                        deadth = true;
                    }
                } else {
                    if (birdPos.y + bird.getHeight() >= colPos.y) {
                        deadth = true;
                    }
                }
            }

        }
    }

    public void actionPerformed() {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    //Move columns
                    int speed = 10;
                    //Gravity
                    bird.setLocation(bird.getLocation().x, bird.getLocation().y + 10);

                    for (JButton columm : columms) {
                        Point tmp = columm.getLocation();
                        tmp.setLocation(tmp.x - speed, tmp.y);
                        columm.setLocation(tmp);
                        checkDistance(columm);
                    }
                    //Add and remove columns
                    for (int i = 0; i < columms.size(); i++) {
                        JButton column = columms.get(i);
                        Point tmp = column.getLocation();
                        if (tmp.getX() + column.getWidth() <= 0) {
                            columms.remove(column);
                            int size = columms.size();
                            if (size % 2 == 0) {
                                addColumm(false);
                            }
                        }
                    }

                    //Check Point
                    if (birdPos.y + bird.getHeight() / 2 + 10 >= HEIGHT) {
                        deadth = true;
                    }

                    for (JButton x : columms) {
                        Point colPos = x.getLocation();
                        int distance = (int) (colPos.x + x.getWidth() - (birdPos.getX() + bird.getWidth()));
                        if (distance <= 0 && distance >= -5 && x.getLocation().getY() == 0) {
                            //score++;
                        }
                    }
                    //Set score
                    point.setText(score + "");

                    //Deadth
                    if (deadth) {
                        timer.stop();
                        JOptionPane.showMessageDialog(null, "You dead !");
                        if (score < 10) {
                            medal = "No medal";
                        } else if (score >= 10 && score < 20) {
                            medal = "Bronze";
                        } else if (score >= 20 && score <= 30) {
                            medal = "Silver";
                        } else if (score > 30 && score < 40) {
                            medal = "Gold";
                        } else if (score >= 40) {
                            medal = "Platinum";
                        }
                        JOptionPane.showMessageDialog(null, "Your score : " + score + ", Your medal is : " + medal);
                        //saveRecord();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer = new Timer(40, taskPerformer);
        //timer.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlappyBird.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlappyBird.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlappyBird.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlappyBird.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlappyBird().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bird;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPause;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel point;
    // End of variables declaration//GEN-END:variables
}
