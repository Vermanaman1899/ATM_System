package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    String cardno;
    Transactions(String cardno){
        this.cardno = cardno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(510, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 500, 540);
        add(l2);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 10));
        
       
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");
        b8 = new JButton("LOG OUT");

        b1.setFont(new Font("System", Font.BOLD, 8));
        b2.setFont(new Font("System", Font.BOLD, 8));
        b3.setFont(new Font("System", Font.BOLD, 8));
        b4.setFont(new Font("System", Font.BOLD, 8));
        b5.setFont(new Font("System", Font.BOLD, 8));
        b6.setFont(new Font("System", Font.BOLD, 8));
        b7.setFont(new Font("System", Font.BOLD, 8));
        b8.setFont(new Font("System", Font.BOLD, 8));
        
        setLayout(null);

        l1.setBounds(100,200,250,25);
        l2.add(l1);
        //
        b1.setBounds(85,249,100,18);
        l2.add(b1);

        b2.setBounds(187,249,100,18);
        l2.add(b2);

        b3.setBounds(85,272,100,18);
        l2.add(b3);
        
        b4.setBounds(187,272,100,18);
        l2.add(b4);
        
        b5.setBounds(85,295,100,18);
        l2.add(b5);
        
        b6.setBounds(187,295,100,18);
        l2.add(b6);
        
        b7.setBounds(85,317,100,18);
        l2.add(b7);

        b8.setBounds(187,317,100,18);
        l2.add(b8);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        setSize(500,540);
        setUndecorated(true);
        setLocation(400,50);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Deposit(cardno).setVisible(true);
        }else if(ae.getSource()==b2){ 
            setVisible(false);
            new Withdrawl(cardno).setVisible(true);
        }else if(ae.getSource()==b3){ 
            setVisible(false);
            new FastCash(cardno).setVisible(true);
        }else if(ae.getSource()==b4){ 
            new MiniStatement(cardno).setVisible(true);
        }else if(ae.getSource()==b5){ 
            setVisible(false);
            new Pin(cardno).setVisible(true);
        }else if(ae.getSource()==b6){ 
            this.setVisible(false);
            new BalanceEnquiry(cardno).setVisible(true);
        }else if(ae.getSource()==b7) {
            System.exit(0);
        }else if(ae.getSource()==b8){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Transactions("").setVisible(true);
    }
}