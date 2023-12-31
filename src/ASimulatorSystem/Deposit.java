
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String cardno;
    Deposit(String cardno){
        this.cardno = cardno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(510, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 500, 540);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 8));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 11));
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(100,200,250,25);
        l3.add(l1);
        
        t1.setBounds(110,245,150,20);
        l3.add(t1);

        b1.setBounds(125,280,120,20);
        l3.add(b1);

        b2.setBounds(125,305,120,20);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(500,540);
        setUndecorated(true);
        setLocation(400,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+cardno+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(cardno).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(cardno).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}