package bank.msystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry1 extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;

    BalanceEnquiry1(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 650, 850);
        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 18));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(140,280,700,35);
        l3.add(l1);

        b1.setBounds(343,390,150,35);
        l3.add(b1);
        int balance = 0;
        try{
            Conn1 c1 = new Conn1();
            ResultSet rs = c1.s.executeQuery("select * from bank where Pinno = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);

        setSize(650, 850);
        setUndecorated(true);
        setLocation(450, 30);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions1(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry1("").setVisible(true);
    }
}
