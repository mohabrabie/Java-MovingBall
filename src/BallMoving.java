/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohab
 */

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohab
 */
public class BallMoving extends Applet {

    int x = 10, y = 80;
    boolean on = false;
    int flag = 0;
    int flag1 = 0;

    @Override
    public void init() {
        Button start = new Button("Start");
        Button stop = new Button("Stop");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                on = true;

            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                on = false;

            }
        });
        add(start);
        add(stop);
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                while (true) {
                    if (on == true) {
                        System.out.print("true");
                        if (flag == 0) {
                            x += 10;
                            if (x >= 450) {
                                flag = 1;
                                x = 450;
                            }
                        } else if (flag == 1) {
                            x -= 10;
                            if (x <= 0) {
                                flag = 0;
                                x = 0;
                            }
                        }
                        if (flag1 == 0) {
                            y += 10;
                            if (y >= 450) {
                                flag1 = 1;
                                y = 450;
                            }
                        } else if (flag1 == 1) {
                            y -= 10;
                            if (y <= 0) {
                                flag1 = 0;
                                y = 0;
                            }
                        }
                    }
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BallMoving.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        th.start();
    }

    public void paint(Graphics g) {
        resize(500, 500);
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
    }
}
