/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Arun Nagar
 */
public class LogIn extends JFrame implements ActionListener{
    JButton b1 , b2 , b3;
    JTextField t1;
    JPasswordField t2;
    LogIn() {
          
        setBounds(500,300,900,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
//        JPanel p1 = new JPanel();
//        p1.setBackground(new Color(131,193,233));
//        p1.setBounds(0,0,400,400);
//        p1.setLayout(null);
//        add(p1);
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/login.png"));
//        Image img = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(img);
//        JLabel l1 = new JLabel(i2);
//        l1.setBounds(100,110,200,200);
//        p1.add(l1);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/loginBackground.png"));
        Image i4 = i3.getImage().getScaledInstance(900, 400, Image.SCALE_DEFAULT);
        ImageIcon i5 = new ImageIcon(i4);
        JLabel la = new JLabel(i5);
        la.setBounds(0,0,900,400);
        add(la);
        
//        JPanel p2 = new JPanel();
//        p2.setLayout(null);
//        p2.setBounds(400, 30, 450, 300);
//        la.add(p2);
        
        JLabel l2 = new JLabel("Username");
        l2.setBounds(300,20,100,25);
        l2.setForeground(new Color(31, 237, 17));
        l2.setFont(new Font("SAN_SERIF" , Font.BOLD , 20));
        la.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(300,60,300,30);
        t1.setBorder(BorderFactory.createEmptyBorder());
        t1.setFont(new Font("SAN_SERIF" , Font.PLAIN , 16));
        la.add(t1);
        
        JLabel l3 = new JLabel("Password");
        l3.setBounds(300,110,100,25);
        l3.setForeground(new Color(31, 237, 17));
        l3.setFont(new Font("SAN_SERIF" , Font.BOLD , 20));
        la.add(l3);
        
        t2 = new JPasswordField();
        t2.setBounds(300,150,300,30);
        t2.setBorder(BorderFactory.createEmptyBorder());
        t2.setFont(new Font("SAN_SERIF" , Font.PLAIN , 16));
        la.add(t2);
        
        b1 = new JButton("Login");
        b1.setBounds(300,220,130,30);
        b1.setBackground(new Color(133,193,233));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SAN_SERIF" , Font.PLAIN , 16));
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        la.add(b1);
        
        b2 = new JButton("Signup");
        b2.setBounds(470,220,130,30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(new Color(133,193,233));
        b2.setFont(new Font("SAN_SERIF" , Font.PLAIN , 16));
        b2.setBorder(new LineBorder(new Color(133,193,233)));
        b2.addActionListener(this);
        la.add(b2);
        
        b3 = new JButton("Forgot Password");
        b3.setBounds(370,280,160,30);
        b3.setBackground(Color.WHITE);
        b3.setForeground(new Color(133,193,233));
        b3.setFont(new Font("SAN_SERIF" , Font.PLAIN , 16));
        b3.setBorder(new LineBorder(new Color(133,193,233)));
        b3.addActionListener(this);
        la.add(b3);
        
        JLabel l4 = new JLabel("Trouble in Login...");
        l4.setBounds(540,283,150,25);
        l4.setFont(new Font("SAN_SERIF" , Font.PLAIN , 16));
        l4.setForeground(Color.red);
        la.add(l4);
        
        setVisible(true);
        
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        Conn c = new Conn();
        if(ae.getSource()== b1) {
            try{
               String username = t1.getText();
               String password = t2.getText();
               
               String sql = "select * from account where username = '" + username + "' AND password = '" + password + "'";
               ResultSet rs = c.s.executeQuery(sql);
               
               if(rs.next()) {
                   this.setVisible(false);
                   new Loading(username).setVisible(true);
               }
               else {
                   JOptionPane.showMessageDialog(null, "Invalid Login !!!");
               }
               
            }
            catch(Exception e) {
                
            }
        }
        else if(ae.getSource() == b2) {
            this.setVisible(false);
            new SignUp().setVisible(true);
    
        }
        else if(ae.getSource() == b3) {
            this.setVisible(false);
            new ForgotPassword().setVisible(true);
        }
    }
     
    public static void main(String[] args) {
        new LogIn();
    }
}
