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
public class BookPackage extends JFrame implements ActionListener{
    JLabel l2a,l5a,l6a,l7a,l8a;
    Choice c1;
    JTextField t1;
    JButton b1 , b2 , b3;
    BookPackage(String username) {
        setBounds(600,240,1100,560);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i3);
        l.setBounds(500,60,550,350);
        add(l);
        
        JLabel l1 = new JLabel("BOOK PACKAGE");
        l1.setBounds(100,10,250,30);
        l1.setFont(new Font("Yu Mincho" , Font.PLAIN ,25));
        add(l1);
        
        JLabel l2 = new JLabel("Username");
        l2.setBounds(40,70,100,30);
        l2.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        add(l2);
        
        l2a = new JLabel();
        l2a.setBounds(250,70,100,30);
        l2a.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        add(l2a);
        
        JLabel l3 = new JLabel("Select Package");
        l3.setBounds(40,120,150,30);
        l3.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        add(l3);
        
        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setFont(new Font("Tahoma" , Font.PLAIN ,15));
        c1.setBounds(250,125,150,30);
        add(c1);
        
        JLabel l4 = new JLabel("Total Persons");
        l4.setBounds(40,170,150,30);
        l4.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        add(l4);
        
        t1 = new JTextField("1");
        t1.setBounds(250,175,150,25);
        t1.setFont(new Font("Tahoma",Font.PLAIN , 20));
        add(t1);
        
        JLabel l5 = new JLabel("ID");
        l5.setBounds(40,220,100,30);
        l5.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        add(l5);
        
        l5a = new JLabel();
        l5a.setBounds(250,220,150,30);
        l5a.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        add(l5a);
        
        JLabel l6 = new JLabel("Number");
        l6.setBounds(40,270,100,30);
        l6.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        add(l6);
        
        l6a = new JLabel();
        l6a.setBounds(250,270,150,30);
        l6a.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        add(l6a);
        
        JLabel l7 = new JLabel("Phone");
        l7.setBounds(40,320,100,30);
        l7.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        add(l7);
        
        l7a = new JLabel();
        l7a.setBounds(250,320,150,30);
        l7a.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        add(l7a);
        
        JLabel l8 = new JLabel("Total Price");
        l8.setBounds(40,370,100,30);
        l8.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        add(l8);
        
        l8a = new JLabel();
        l8a.setBounds(250,370,200,30);
        l8a.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        l8a.setForeground(Color.red);
        add(l8a);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer where username ='"+username+"'");
            
            while(rs.next()) {
                l2a.setText(rs.getString("username"));
                l5a.setText(rs.getString("id"));
                l6a.setText(rs.getString("number"));
                l7a.setText(rs.getString("phone"));
       
            }
        }
        catch(Exception e) {
            
        } 
        
        b1 = new JButton("Check Price");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        b1.setBounds(60,440,120,25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Book Package");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        b2.setBounds(210,440,130,25);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        b3.setBounds(370,440,120,25);
        b3.addActionListener(this);
        add(b3);
        
    //    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1) {
            String p = c1.getSelectedItem();
            int cost = 0;
            if(p.equals("Gold Package")) {
                cost+= 12000;
            }
            else if(p.equals("Silver Package")) {
                cost += 24000;
            }
            else if(p.equals("Bronze Package")) {
                cost += 32000;
            }
            
            int persons = Integer.parseInt(t1.getText());
            
            cost *= persons;
            l8a.setText("Rs " + cost);
        }
        else if(ae.getSource()==b2) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookPackage values('" + l2a.getText() + "','" + c1.getSelectedItem()+"','" + t1.getText() + "','" + l5a.getText() + "','" + l6a.getText() + "','" + l7a.getText() + "','" + l8a.getText() + "')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                this.setVisible(false);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==b3) {
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new BookPackage("").setVisible(true);
    }
}
