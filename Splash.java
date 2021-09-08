/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Arun Nagar
 */
public class Splash {
    
    public static void main(String[] args) {
        SplashFrame frame = new SplashFrame();
        frame.setVisible(true);
        int x = 1;
        for(int i=1 ; i<=700 ; i+=6 , x+=7) {
         frame.setLocation(900-(x+i)/2,500-(i/2));
         frame.setSize(x+i,i);
         
         try {
             Thread.sleep(10);
         }
         catch(Exception e) {
             
         }
        }
        frame.setVisible(true);
    }
}

class SplashFrame extends JFrame implements Runnable {
    Thread t1;
    SplashFrame() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/splash.jpg"));
        Image img1 = i1.getImage().getScaledInstance(1600, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img1);
        JLabel l1 = new JLabel(i2);
        add(l1);     
//         setBounds(300,200,500,300);
        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();
    }
    public void run() {
        try{
           Thread.sleep(7000);
           this.setVisible(false);
           new LogIn().setVisible(true);
        }
        catch(Exception e) {
            
        }
    }
}
