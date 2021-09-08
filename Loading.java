/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Arun Nagar
 */
public class Loading extends JFrame implements Runnable{
    JProgressBar b1;
    Thread t;
    String username;
    public void run() {
        try{
            for(int i=1 ; i<=101 ; i++) {
                int n = b1.getMaximum();
                int m = b1.getValue();
                
                if(m<n) {
                    b1.setValue(b1.getValue()+1);
                }
                else {
                    i = 101;
          
                    // Home
                     setVisible(false);
                      new Dashboard(username).setVisible(true);
                 
                }
                Thread.sleep(50);
            }
              
        }
        catch(Exception e) {
            
        }
    }
    Loading( String user){
        username = user;
        t = new Thread(this);
        
        setBounds(700,250,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Travel And Tourism Application");
        l1.setBounds(50,20,600,40);
        l1.setFont(new Font("Raleway" , Font.BOLD , 35));
        l1.setForeground(Color.BLUE);
        add(l1);
        
        b1 = new JProgressBar();
        b1.setBounds(160,100,300,25);
        b1.setStringPainted(true);
        add(b1);
        
        JLabel l2 = new JLabel("Please Wait...");
        l2.setBounds(255,130,120,25);
        l2.setFont(new Font("Tahoma" , Font.BOLD , 16));
        l2.setForeground(Color.RED);
        add(l2);
        
        JLabel l3 = new JLabel("Welcome " + username + " !");
        l3.setBounds(50,310,160,25);
        l3.setFont(new Font("Tahoma" , Font.BOLD , 16));
        l3.setForeground(Color.RED);
        add(l3);
        
        t.start();
    //    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }
    
    public static void main(String[] args) {
        new Loading("").setVisible(true);
    }
}
