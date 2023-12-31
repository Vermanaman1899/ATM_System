package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String cardno;

    BalanceEnquiry(String cardno) {
        this.cardno = cardno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(510, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 500, 540);
        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 10));

        l2 = new JLabel();
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 10));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(95,200,250,25);
        l3.add(l1);

        l2.setBounds(150,250,250,25);
        l3.add(l2);


        b1.setBounds(85,318,100,18);
        l3.add(b1);

        int balance = 0;
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where cardnumber = '"+cardno+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is:");
        l2.setText("Rs. "+balance+" /- ONLY");
        b1.addActionListener(this);

        setSize(500,540);
        setUndecorated(true);
        setLocation(400,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(cardno).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
