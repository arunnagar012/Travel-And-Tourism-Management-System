/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Arun Nagar
 */
public class DeleteCustomer extends JFrame implements ActionListener{
    JButton b1 , b2;
    String user;
    DeleteCustomer(String username) {
        user = username;
        setBounds(660,240,850,650);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("DELETE CUSTOMER DETAILS");
        heading.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        heading.setBounds(110,10,300,30);
        add(heading);
        
        JLabel l1 = new JLabel("Username");
        l1.setBounds(30,70,100,30);
        l1.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l1);
        
        JLabel l1a = new JLabel();
        l1a.setBounds(250,70,200,30);
        l1a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l1a);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(30,120,100,30);
        l2.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l2);
        
        JLabel l2a = new JLabel();
        l2a.setBounds(250,120,200,30);
        l2a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l2a);
        
        JLabel l3 = new JLabel("ID");
        l3.setBounds(30,170,100,30);
        l3.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l3);
        
        JLabel l3a = new JLabel();
        l3a.setBounds(250,170,200,30);
        l3a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l3a);
        
        JLabel l4 = new JLabel("Number");
        l4.setBounds(30,220,100,30);
        l4.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l4);
        
        JLabel l4a = new JLabel();
        l4a.setBounds(250,220,200,30);
        l4a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l4a);
        
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(30,270,100,30);
        l5.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l5);
        
        JLabel l5a = new JLabel();
        l5a.setBounds(250,270,200,30);
        l5a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l5a);
        
         JLabel l6 = new JLabel("Country");
        l6.setBounds(30,320,100,30);
        l6.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l6);
        
        JLabel l6a = new JLabel();
        l6a.setBounds(250,320,200,30);
        l6a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l6a);
        
        JLabel l7 = new JLabel("Address");
        l7.setBounds(30,370,100,30);
        l7.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l7);
        
        JLabel l7a = new JLabel();
        l7a.setBounds(250,370,200,30);
        l7a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l7a);
        
        JLabel l8 = new JLabel("Phone");
        l8.setBounds(30,420,100,30);
        l8.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l8);
        
        JLabel l8a = new JLabel();
        l8a.setBounds(250,420,200,30);
        l8a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l8a);
        
        JLabel l9 = new JLabel("Email");
        l9.setBounds(30,470,100,30);
        l9.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l9);
        
        JLabel l9a = new JLabel();
        l9a.setBounds(250,470,200,30);
        l9a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(l9a);
        
        try {
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("Select * from customer where username ='" + username + "'");
           while(rs.next()) {
               l1a.setText(rs.getString(1));
               l2a.setText(rs.getString(4));
               l3a.setText(rs.getString(2));
               l4a.setText(rs.getString(3));
               l5a.setText(rs.getString(5));
               l6a.setText(rs.getString(6));
               l7a.setText(rs.getString(7));
               l8a.setText(rs.getString(8));
               l9a.setText(rs.getString(9));
           }
        }
        catch(Exception e) {
            
        }
        
        b1 = new JButton("Delete");
        b1.setBounds(70,540,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(b1);
        
        b2= new JButton("Back");
        b2.setBounds(210,540,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(380,90,400,400);
        add(l10);
        
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1) {
            try{
                Conn c = new Conn();
                c.s.executeUpdate("delete from account where username = '" + user + "'");
                c.s.executeUpdate("delete from bookPackage where username = '" + user + "'");
                c.s.executeUpdate("delete from bookHotel where username = '" + user + "'");
                c.s.executeUpdate("delete from customer where username = '" + user + "'");
                
                JOptionPane.showMessageDialog(null,"Customer Details Deleted Successfully");
                System.exit(0);
            }
            catch(Exception e) {
                e.printStackTrace();
            } 
        }
        else if(ae.getSource()==b2) {
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new DeleteCustomer("").setVisible(true);
    }
}
