
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    
    JPasswordField t1,t2,t3;
    JButton b1,b2;                               
    JLabel l1,l2,l3,l5;
    String cardno;
    Pin(String cardno){
        this.cardno = cardno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(510, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 500, 540);
        add(l4);
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 10));
        l1.setForeground(Color.WHITE);
        
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 9));
        l2.setForeground(Color.WHITE);
        
        l3 = new JLabel("Re-enter new PIN:");
        l3.setFont(new Font("System", Font.BOLD, 9));
        l3.setForeground(Color.WHITE);

        l5 = new JLabel("Enter your PIN:");
        l5.setFont(new Font("System", Font.BOLD, 9));
        l5.setForeground(Color.WHITE);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 20));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 20));

        t3 = new JPasswordField();
        t3.setFont(new Font("Raleway", Font.BOLD, 20));

        
        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(null);

        l1.setBounds(95,215,250,25);
        l4.add(l1);

        l2.setBounds(95,268,150,25);
        l4.add(l2);

        l3.setBounds(95,291,150,25);
        l4.add(l3);

        l5.setBounds(95,245,150,25);
        l4.add(l5);
        //

        t1.setBounds(190,272,95,19);
        l4.add(t1);
        
        t2.setBounds(190,295,95,19);
        l4.add(t2);

        t3.setBounds(190,248,95,19);
        l4.add(t3); //Old pin

        b1.setBounds(187,318,100,18);
        l4.add(b1);

        b2.setBounds(85,318,100,18);
        l4.add(b2);


        setSize(500,540);
        setUndecorated(true);
        setLocation(400,50);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource()==b1){

                Conn c1 = new Conn();

                String q4 = "select * from login where cardnumber = '"+cardno+"' ";
                ResultSet rs = c1.s.executeQuery(q4);

                String pin="";
                while(rs.next()){
                    pin=rs.getString(3);
//                    System.out.println(pin);
                }
//                String pin=rs.getString(2);
                String oldpin=t3.getText();
                String npin = t1.getText();
                String rpin = t2.getText();

                if (!oldpin.equals(pin) || oldpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Old Pin is incorrect, try again");
                    return;
                }

                if (npin.length()!=4){
                    JOptionPane.showMessageDialog(null, "Re-enter a new pin of 4 digits");
                    return;
                }

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "PIN does not match, try again");
                    return;
                }

//                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pin+"' ";

//                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==b2){
                new Transactions(cardno).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}
