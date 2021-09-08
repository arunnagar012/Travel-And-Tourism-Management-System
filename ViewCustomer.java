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

public class ViewCustomer extends JFrame implements ActionListener {

    JComboBox c1;
    JRadioButton r1, r2;
    JButton b1, b2;

    ViewCustomer(String user) {
        setBounds(600, 250,870,700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l = new JLabel("CUSTOMER DETAILS ");
        l.setBounds(240, 5, 300, 25);
        l.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l.setForeground(Color.BLUE);
        add(l);

        JLabel l1 = new JLabel("Username :");
        l1.setBounds(30, 50, 150, 25);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);

        JLabel l1a = new JLabel();
        l1a.setBounds(220, 50, 150, 25);
        l1a.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1a);

        JLabel l2 = new JLabel("ID :");
        l2.setBounds(30, 125, 150, 25);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l2);

        JLabel l2a = new JLabel();
        l2a.setBounds(220, 125 ,150, 25);
        l2a.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l2a);
        
        JLabel l3 = new JLabel("Number :");
        l3.setBounds(30,200,150, 25);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l3);

        JLabel l3a = new JLabel();
        l3a.setBounds(220, 200, 150, 25);
        l3a.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l3a);

        JLabel l4 = new JLabel("Name :");
        l4.setBounds(30, 275, 150, 25);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l4);

        JLabel l4a = new JLabel();
        l4a.setBounds(220, 275, 150, 25);
        l4a.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l4a);

        JLabel l5 = new JLabel("Gender :");
        l5.setBounds(30, 350, 150, 25);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l5);

        JLabel l5a = new JLabel();
        l5a.setBounds(220, 350, 150, 25);
        l5a.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l5a);

        JLabel l6 = new JLabel("Country :");
        l6.setBounds(400, 50, 150, 25);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l6);

        JLabel l6a = new JLabel();
        l6a.setBounds(600, 50, 150, 25);
        l6a.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l6a);

        JLabel l7 = new JLabel("Address :");
        l7.setBounds(400, 125, 150, 25);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l7);

        JLabel l7a = new JLabel();
        l7a.setBounds(600,125, 300, 25);
        l7a.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l7a);

        JLabel l8 = new JLabel("Phone :");
        l8.setBounds(400, 200, 150, 25);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l8);

        JLabel l8a = new JLabel();
        l8a.setBounds(600, 200, 150, 25);
        l8a.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l8a);

        JLabel l9 = new JLabel("Email id :");
        l9.setBounds(400, 275, 150, 25);
        l9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l9);

        JLabel l9a = new JLabel();
        l9a.setBounds(600,275, 300, 25);
        l9a.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l9a);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(370, 390, 100, 25);
        b2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(0,400,600, 300);
        add(l10);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/viewall.jpg"));
        Image i5 = i1.getImage().getScaledInstance(600,300, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l11 = new JLabel(i6);
        l11.setBounds(600,400,600,300);
        add(l11);
        
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+user+"'");
            
            while(rs.next()) {
                l1a.setText(rs.getString("username"));
                l2a.setText(rs.getString("id"));
                l3a.setText(rs.getString("number"));
                l4a.setText(rs.getString("name"));
                l5a.setText(rs.getString("gender"));
                l6a.setText(rs.getString("country"));
                l7a.setText(rs.getString("address"));
                l8a.setText(rs.getString("phone"));
                l9a.setText(rs.getString("email"));
                
            }
        }
        catch(Exception e) {
            
        }

     //   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewCustomer("").setVisible(true);
    }
}

