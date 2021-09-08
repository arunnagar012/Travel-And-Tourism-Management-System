/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Arun Nagar
 */
public class ForgotPassword extends JFrame implements ActionListener {
    JTextField t1 , t2 , t3 , t4 , t5;
    JButton b1 , b2 , b3;
    ForgotPassword() {
        setBounds(500,250,920,410);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(600,60,250,250);
        add(l6);
        
        JPanel p = new JPanel();
        p.setBounds(20,25,530,310);
        p.setLayout(null);
        add(p);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel l1 = new JLabel("Username");
        l1.setBounds(30,20,100,25);
        l1.setFont(new Font("Tahoma" ,Font.BOLD , 15));
        p.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(225,20,160,25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        t1.setFont(new Font("Tahoma" ,Font.PLAIN , 15));
        
        p.add(t1);
        
        b1 = new JButton("Search");
        b1.setBounds(400,20,110,25);
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma" ,Font.BOLD , 13));
        p.add(b1);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(30,65,100,25);
        l2.setFont(new Font("Tahoma" ,Font.BOLD , 15));
        p.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(225,65,160,25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        t2.setFont(new Font("Tahoma" ,Font.PLAIN , 15));
        p.add(t2);
        
        JLabel l3 = new JLabel("Your Security Question");
        l3.setBounds(30,110,180,25);
        l3.setFont(new Font("Tahoma" ,Font.BOLD , 15));
        p.add(l3);
        
        t3 = new JTextField();
        t3.setBounds(225,110,285,25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        t3.setFont(new Font("Tahoma" ,Font.PLAIN, 15));
        p.add(t3);
        
        JLabel l4 = new JLabel("Answer");
        l4.setBounds(30,155,100,25);
        l4.setFont(new Font("Tahoma" ,Font.BOLD , 15));
        p.add(l4);
        
        t4 = new JTextField();
        t4.setBounds(225,155,160,25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        t4.setFont(new Font("Tahoma" ,Font.PLAIN , 15));
        p.add(t4);
        
        b2 = new JButton("Retrive");
        b2.setBounds(400,155,110,25);
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma" ,Font.BOLD , 13));
        p.add(b2);
        
        JLabel l5 = new JLabel("Password");
        l5.setBounds(30,200,100,25);
        l5.setFont(new Font("Tahoma" ,Font.BOLD , 15));
        p.add(l5);
        
        t5 = new JTextField();
        t5.setBounds(225,200,160,25);
        t5.setBorder(BorderFactory.createEmptyBorder());
        t5.setFont(new Font("Tahoma" ,Font.PLAIN , 15));
        p.add(t5);
        
        b3 = new JButton("Back");
        b3.setBounds(140,250,120,25);
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setFont(new Font("Tahoma" ,Font.BOLD , 13));
        p.add(b3);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        Conn c = new Conn();

        if(ae.getSource()==b1) {
            try{
            String sql = "select * from account where username = '" + t1.getText() + "'";
            ResultSet rs = c.s.executeQuery(sql);
            
            while(rs.next()) {
                t2.setText(rs.getString("name"));
                t3.setText(rs.getString("security"));
            }
            }
            catch(Exception e) {
                
            }
        }
        else if(ae.getSource()==b2){
            try{
            String sql = "select * from account where username = '" + t1.getText() + "' AND answer = '" + t4.getText() + "'";
            ResultSet rs = c.s.executeQuery(sql);
            
            while(rs.next()) {
                t5.setText(rs.getString("password"));
            }
            }
            catch(Exception e) {
                
            }
        }
        else if(ae.getSource()==b3) {
            this.setVisible(false);
            new LogIn().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new ForgotPassword().setVisible(true);
    }
}
