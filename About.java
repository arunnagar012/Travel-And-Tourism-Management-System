/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Arun Nagar
 */
public class About extends JFrame implements ActionListener {
    String s;
    JButton b1;
    About() {
        setBounds(700,240,700,720);
        setLayout(null);
        getContentPane().setBackground(new Color(230, 247, 252));
        
        JLabel l1 = new JLabel("Travel and Tourism Management System");
        l1.setBounds(50,10,600,80);
        l1.setForeground(Color.red);
        l1.setFont(new Font("TimesRoman" , Font.BOLD , 30));
        
        JLabel l2 = new JLabel("About Us");
        l2.setBounds(50,100,200,30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("TimesRoman" , Font.BOLD , 25));
        add(l2);
        
        s = "The objective of the Travel and Tourism Management System project is to develop a system that automates the processes and activities of a travel and tourism agency.\n\n"+
            "The purpose is to design a system using which one can perform all operations related to traveling and sight-seeing.\n"+
            "The system allows one to easily access the relevant information and make necessary travel arrangements.\n"+
            "Users can decide about places they want to visit and make bookings online for travel and accommodation.\n\n" +
            "Advantages of Project :\n" +
            "- Gives Accurate Information\n"+
            "- Simplifies the Manual work\n"+
            "- It minimizes the documentation related work\n" +
            "- Provides up to date information\n" +
            "- Friendly Environment by providing warning messages\n"+
            "- travelers details can be provided\n" +
            "- booking confirmation notification\n\n" +
            "Tech Stack Used in Project :\n" +
            "Language Used -  Java Core \n" +
            "Concept Used - Swing , AWT , Multithreading , ActionEvents etc.\n" +
            "Database Used - MySQL Database";
            
        
        TextArea t1 = new TextArea(s,10,40,Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20,150,645,450);
        t1.setFont(new Font("TimesRoman" , Font.PLAIN , 20));
        t1.setBackground(new Color(196, 242, 228));
        add(t1);
        add(l1);
        
        b1 = new JButton("Back");
        b1.setBounds(280,620,100,30);
        b1.setBackground(new Color(203, 232, 245));
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        b1.setFont(new Font("TimesRoman" , Font.PLAIN , 20));
        add(b1);
        
        
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }
    public static void main(String[] args) {
        new About().setVisible(true);
    }
}
