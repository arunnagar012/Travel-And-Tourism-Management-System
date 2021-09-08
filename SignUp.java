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
public class SignUp extends JFrame implements ActionListener{
   JButton b1 , b2;
   JTextField j1 , j2 , j3, j4;
   Choice c1;
   SignUp() {
       setBounds(600,250,900,400);
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JPanel p1 = new JPanel();
       p1.setBounds(0,0,500,400);
       p1.setBackground(new Color(133,193,233));
       p1.setLayout(null);
       add(p1);
       
       JPanel p2 = new JPanel();
       p2.setBounds(500,0,400,400);
       p2.setLayout(null);
//       p2.setBackground(Color.MAGENTA);
       add(p2);
       
       JLabel l1 = new JLabel("Username");
       l1.setFont(new Font("Tahoma", Font.BOLD , 15 ));
       l1.setBounds(50,40,100,25);
       p1.add(l1);
       
       j1 = new JTextField();
       j1.setFont(new Font("Tahoma", Font.PLAIN , 15 ));
       j1.setBounds(200,40,180,25);
       j1.setBorder(BorderFactory.createEmptyBorder());
       p1.add(j1);
       
       JLabel l2 = new JLabel("Name");
       l2.setFont(new Font("Tahoma", Font.BOLD , 15 ));
       l2.setBounds(50,80,100,25);
       p1.add(l2);
       
       j2 = new JTextField();
       j2.setFont(new Font("Tahoma", Font.PLAIN , 15 ));
       j2.setBounds(200,80,180,25);
       j2.setBorder(BorderFactory.createEmptyBorder());
       p1.add(j2);
       
       JLabel l3 = new JLabel("Password");
       l3.setFont(new Font("Tahoma", Font.BOLD , 15 ));
       l3.setBounds(50,120,100,25);
       p1.add(l3);
       
       j3 = new JTextField();
       j3.setFont(new Font("Tahoma", Font.PLAIN , 15 ));
       j3.setBounds(200,120,180,25);
       j3.setBorder(BorderFactory.createEmptyBorder());
       p1.add(j3);
       
       JLabel l4 = new JLabel("Security Question");
       l4.setFont(new Font("Tahoma", Font.BOLD , 15 ));
       l4.setBounds(50,160,140,25);
       p1.add(l4);
       
       c1 = new Choice();
       c1.add("Your Pet Name");
       c1.add("Your Lucky Numver");
       c1.add("Your Favourite Superhero");
       c1.add("Your Birth Place");
       c1.setBounds(200,160,180,25);
       p1.add(c1);
       
       JLabel l5 = new JLabel("Answer");
       l5.setFont(new Font("Tahoma", Font.BOLD , 15 ));
       l5.setBounds(50,200,100,25);
       p1.add(l5);
       
       j4 = new JTextField();
       j4.setFont(new Font("Tahoma", Font.PLAIN , 15 ));
       j4.setBounds(200,200,180,25);
       j4.setBorder(BorderFactory.createEmptyBorder());
       p1.add(j4);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/signup.png"));
       Image img = i1.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
       ImageIcon i2 = new ImageIcon(img);
       
       JLabel l6 = new JLabel(i2);
       l6.setBounds(0,0,400,400);
       p2.add(l6);
   
       b1 = new JButton("Create");
       b1.setBounds(80,270,100,25);
       b1.setBackground(Color.WHITE);
       b1.setForeground(new Color(133,193,233));
       b1.setFont(new Font("Tahoma" , Font.BOLD , 15));
       b1.addActionListener(this);
       p1.add(b1);
       
       b2 = new JButton("Back");
       b2.setBounds(250,270,100,25);
       b2.setBackground(Color.WHITE);
       b2.setForeground(new Color(133,193,233));
       b2.setFont(new Font("Tahoma" , Font.BOLD , 15));
       b2.addActionListener(this);
       p1.add(b2);
       
   //    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
    
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == b1) {
           String username = j1.getText();
           String name = j2.getText();
           String password = j3.getText();
           String security = c1.getSelectedItem();
           String answer = j4.getText();
           
           String query = "insert into account values('"+username+"' , '"+name+"' , '"+password+"' , '"+security+"' ,'"+answer+"')";
           
           try {
              Conn c = new Conn();
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Account Created Successfully");
              
              this.setVisible(false);
              new LogIn().setVisible(true);
           }
           catch(Exception e) {
             e.printStackTrace();
           }
           
       }
       else if(ae.getSource() == b2) {
          new LogIn().setVisible(true);
          this.setVisible(false);
       }
    }
    public static void main(String[] args) {
        new SignUp().setVisible(true);
    } 
}
