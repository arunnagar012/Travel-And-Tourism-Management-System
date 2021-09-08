/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Arun Nagar
 */
public class Payment extends JFrame implements ActionListener {
    JButton b1,b2;
    Payment() {
        setBounds(650,240,800,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,800,600);
        add(l1);
        
        b1 = new JButton("Pay Now");
        b1.setBounds(170,10,120,40);
        b1.setFont(new Font("TimesRoman" , Font.BOLD , 20));
        b1.setBackground(new Color(109, 212, 247));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(520,10,120,40);
        b2.setFont(new Font("TimesRoman" , Font.BOLD , 20));
        b2.setBackground(new Color(109, 212, 247));
        b2.addActionListener(this);
        l1.add(b2);
        
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1) {
            this.setVisible(false);
            new Paytm().setVisible(true);
        }
        else if(ae.getSource()== b2) {
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Payment().setVisible(true);
    }
}
