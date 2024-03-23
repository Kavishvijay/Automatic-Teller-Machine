package bank.msystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement1 extends JFrame implements ActionListener{
 
    JButton b1, b2;
    JLabel l1;
    MiniStatement1(String pin){
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        setUndecorated(true);
        
        l1 = new JLabel();
        add(l1);
        
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.png"));
        Image i1 =logo.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel logo1 = new JLabel(i2);
        logo1.setBounds(110, 20, 30, 30);
        add(logo1);
        
        JLabel l2 = new JLabel("Indian Bank");
        l2.setBounds(150, 20, 120, 30);
        l2.setFont(new Font("system", Font.BOLD, 18));
        add(l2);
        
        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        
        try{
            Conn1 c = new Conn1();
            ResultSet rs = c.s.executeQuery("select * from login where Pinno = '"+pin+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("Cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("Cardno").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            Conn1 c1  = new Conn1();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where Pinno = '"+pin+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("Type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);
        
        b1.addActionListener(this);
        
        l1.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement1("").setVisible(true);
    }
    
}
