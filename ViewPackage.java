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
public class ViewPackage extends JFrame implements ActionListener{
    JButton b1;
    public ViewPackage(String username) {
       setBounds(600,240,1150,550);
       setLayout(null);
       getContentPane().setBackground(new Color(217, 250, 229));
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookedDetails.jpg"));
       Image i2 = i1.getImage().getScaledInstance(695,505,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel li = new JLabel(i3);
       li.setBounds(460,0,695,505);
       add(li);
       
       JLabel heading = new JLabel("VIEW PACKAGE DETAILS");
       heading.setBounds(90,10,300,30);
       heading.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(heading);
       
       JLabel l1 = new JLabel("Username :");
       l1.setBounds(30,50,150,30);
       l1.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l1);
       
       JLabel l1a = new JLabel();
       l1a.setBounds(250,50,150,30);
       l1a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l1a);
       
       JLabel l2 = new JLabel("Package :");
       l2.setBounds(30,100,150,30);
       l2.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l2);
       
       JLabel l2a = new JLabel();
       l2a.setBounds(250,100,150,30);
       l2a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l2a);
       
       JLabel l3 = new JLabel("Total Persons :");
       l3.setBounds(30,150,150,30);
       l3.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l3);
       
       JLabel l3a = new JLabel();
       l3a.setBounds(250,150,150,30);
       l3a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l3a);
       
       JLabel l4 = new JLabel("ID :");
       l4.setBounds(30,200,150,30);
       l4.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l4);
       
       JLabel l4a = new JLabel();
       l4a.setBounds(250,200,150,30);
       l4a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l4a);
       
       JLabel l5 = new JLabel("Number :");
       l5.setBounds(30,250,150,30);
       l5.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l5);
       
       JLabel l5a = new JLabel();
       l5a.setBounds(250,250,150,30);
       l5a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l5a);
       
       JLabel l6 = new JLabel("Phone :");
       l6.setBounds(30,300,150,30);
       l6.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l6);
       
       JLabel l6a = new JLabel();
       l6a.setBounds(250,300,150,30);
       l6a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l6a);
       
       JLabel l7 = new JLabel("Price :");
       l7.setBounds(30,350,150,30);
       l7.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l7);
       
       JLabel l7a = new JLabel();
       l7a.setBounds(250,350,150,30);
       l7a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       add(l7a);
       
       try {
            Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from bookpackage where username = '" + username + "'" );
           
           while(rs.next()) {
               l1a.setText(rs.getString("username"));
               l2a.setText(rs.getString("package"));
               l3a.setText(rs.getString("persons"));
               l4a.setText(rs.getString("id"));
               l5a.setText(rs.getString("number"));
               l6a.setText(rs.getString("phone"));
               l7a.setText(rs.getString("price"));
           }
       }
       catch(Exception e) {
          
       }
       
       
       b1 = new JButton("Back");
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       b1.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       b1.setBounds(170,420,140,30);
       b1.addActionListener(this);
       add(b1);
       
    //   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
           if(ae.getSource()==b1) {
               this.setVisible(false);
           } 
        }
        catch(Exception e) {
            
        }
    }
    public static void main(String[] args) {
        new ViewPackage("").setVisible(true);
    }
}
