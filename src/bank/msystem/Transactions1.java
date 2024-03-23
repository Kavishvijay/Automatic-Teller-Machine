package bank.msystem;

//import icons.Deposite1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions1 extends JFrame implements ActionListener{ 

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    Transactions1(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 650, 850);
        add(l2);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 18));
        
       
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");
        
        setLayout(null);
        
        l1.setBounds(186,250,700,35);
        l2.add(l1);
        
        b1.setBounds(150,295,150,35);
        l2.add(b1);
        
        b2.setBounds(343,295,150,35);
        l2.add(b2);
        
        b3.setBounds(150,345,150,35);
        l2.add(b3);
        
        b4.setBounds(343,345,150,35);
        l2.add(b4);
        
        b5.setBounds(150,390,150,35);
        l2.add(b5);
        
        b6.setBounds(343,390,150,35);
        l2.add(b6);
        
        b7.setBounds(343,435,150,35);
        l2.add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        
        setSize(650,850);
        setLocation(450,30);
        setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
           setVisible(false);
            new Deposite1(pin).setVisible(true);
        }
        
        else if(ae.getSource()==b7){ 
            System.exit(0);
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    else if(ae.getSource()==b2){ 
            setVisible(false);
            new Withdrawl1(pin).setVisible(true);
        }
    else if(ae.getSource()==b3){ 
           setVisible(false);
            new FastCash1(pin).setVisible(true);
        }
    else if(ae.getSource()==b4){ 
           new MiniStatement1(pin).setVisible(true);
       }
    else if(ae.getSource()==b5){ 
           setVisible(false);
           new Pin1(pin).setVisible(true);
        }
    else if(ae.getSource()==b6){ 
           this.setVisible(false);
           new BalanceEnquiry1(pin).setVisible(true);
        } 

       
   }
   
    public static void main(String[] args){
        new Transactions1("").setVisible(true);
    }

   
}