/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

/**
 *
 * @author Arun Nagar
 */
public class BookHotel extends JFrame implements ActionListener{
    Choice c1 ,c2 , c3;
    JTextField t1 , t2;
    JLabel l2a,l8a,l9a,l10a,l11a;
    JButton b1,b2,b3;
    
    BookHotel(String username) {
        setBounds(550,240,1150,700);
        getContentPane().setBackground(new Color(213, 247, 224));
        setLayout(null);
        
        JLabel l1 = new JLabel("BOOK HOTEL");
        l1.setFont(new Font("Tahoma" , Font.BOLD , 24));
        l1.setBounds(100,10,300,30);
        add(l1);
        
        JLabel l2 = new JLabel("Username :");
        l2.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l2.setBounds(30,70,150,30);
        add(l2);
        
        l2a = new JLabel();
        l2a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l2a.setBounds(250,70,150,30);
        add(l2a);
        
        JLabel l3 = new JLabel("Select Hotel :");
        l3.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l3.setBounds(30,120,150,30);
        add(l3);
        
        c1 = new Choice();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()) {
                c1.add(rs.getString("name"));
            }
        }
        catch(Exception e) {}
        c1.setBounds(250,120,150,30);
        c1.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(c1);
        
        JLabel l4 = new JLabel("Total Persons :");
        l4.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l4.setBounds(30,170,150,30);
        add(l4);
        
        t1 = new JTextField();
        t1.setBounds(250,170,150,30);
        t1.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(t1);
        
        JLabel l5 = new JLabel("No. Of Days :");
        l5.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l5.setBounds(30,220,150,30);
        add(l5);
        
        t2 = new JTextField();
        t2.setBounds(250,220,150,30);
        t2.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(t2);
        
        JLabel l6 = new JLabel("AC/Non-AC :");
        l6.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l6.setBounds(30,270,150,30);
        add(l6);
        
        c2 = new Choice();
        c2.add("AC");
        c2.add("Non-AC");
        c2.setBounds(250,270,150,30);
        c2.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(c2);
        
        JLabel l7= new JLabel("Food Included ? :");
        l7.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l7.setBounds(30,320,180,30);
        add(l7);
        
        c3 = new Choice();
        c3.add("YES");
        c3.add("NO");
        c3.setBounds(250,320,150,30);
        c3.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(c3);
        
        JLabel l8 = new JLabel("ID :");
        l8.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l8.setBounds(30,370,150,30);
        add(l8);
        
        l8a = new JLabel();
        l8a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l8a.setBounds(250,370,150,30);
        add(l8a);
        
        JLabel l9 = new JLabel("Number :");
        l9.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l9.setBounds(30,420,150,30);
        add(l9);
        
        l9a = new JLabel();
        l9a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l9a.setBounds(250,420,150,30);
        add(l9a);
        
        JLabel l10= new JLabel("Phone :");
        l10.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l10.setBounds(30,470,150,30);
        add(l10);
        
        l10a = new JLabel();
        l10a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l10a.setBounds(250,470,200,30);
        add(l10a);
        
        JLabel l11= new JLabel("Total Price :");
        l11.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l11.setBounds(30,520,150,30);
        add(l11);
        
        l11a = new JLabel();
        l11a.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l11a.setForeground(Color.red);
        l11a.setBounds(220,520,400,30);
        add(l11a);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            
            while(rs.next()) {
                l2a.setText(rs.getString("username"));
                l8a.setText(rs.getString("id"));
                l9a.setText(rs.getString("number"));
                l10a.setText(rs.getString("phone"));
            }
        }
        catch(Exception e) {
            
        }
        
        b1 = new JButton("Check Price");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50,580,130,30);
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(b1);
        
        b2 = new JButton("Book");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,580,130,30);
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        b3.setBounds(350,580,130,30);
        b3.addActionListener(this);
        b3.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500,50,650,500);
        add(l12);
        
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + c1.getSelectedItem() + "'");
                while(rs.next()) {
                    int cost = Integer.parseInt(rs.getString("cost_per_day"));
                    int food = Integer.parseInt(rs.getString("food_charges"));
                    int ac = Integer.parseInt(rs.getString("ac_charges"));
                    
                    int persons = Integer.parseInt(t1.getText());
                    int days = Integer.parseInt(t2.getText());
                    
                    String acprice = c2.getSelectedItem();
                    String foodprice = c3.getSelectedItem();
                    
                    if(persons*days > 0) {
                        int total = 0;
                        total += acprice.equals("AC") ? ac : 0;
                        total += foodprice.equals("YES") ? food : 0;
                        total += cost;
                        
                        total  = total*persons*days;
                        l11a.setText("" + total);
                    }
                    else {
                        l11a.setText("Please enter a valid number");
                    }
                }
            }
            catch(Exception e) {
                
            }
        }
        else if(ae.getSource()==b2) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookHotel values('"+l2a.getText()+"' ,'"+c1.getSelectedItem()+"' , '"+t1.getText()+"' ,'"+t2.getText()+"' , '"+c2.getSelectedItem()+"' , '"+c3.getSelectedItem()+"' ,'"+l8a.getText()+"' ,'"+l9a.getText()+"' ,'"+l10a.getText()+"' ,'"+l11a.getText()+"')");
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
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
        new BookHotel("").setVisible(true);
    }
}
