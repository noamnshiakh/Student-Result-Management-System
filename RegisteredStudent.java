import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proteanit.sql.*;

public class RegisteredStudent extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5;
    JTable table;
    RegisteredStudent(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        b1 = new JButton("Add New Student",null);
        b1.setBounds(0,75,250,35);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Add Result",null);
        b2.setBounds(0,150,250,35);
        b2.addActionListener(this);
        add(b2);
        b3 = new JButton("Registered Students",null);
        b3.setBounds(0,225,250,35);
        b3.addActionListener(this);
        add(b3);
        b4 = new JButton("All Students Result",null);
        b4.setBounds(0,300,250,35);
        b3.setBackground(Color.blue);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b4);
        b5 = new JButton("Logout",null);
        b5.setBounds(50,375,150,35);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        add(b5);

        JLabel l1 = new JLabel("RollNo");
        l1.setBounds(270,5,50,25);
        add(l1);
        JLabel l2 = new JLabel("Physics");
        l2.setBounds(360,5,50,25);
        add(l2);
        JLabel l3 = new JLabel("Maths");
        l3.setBounds(450,5,50,25);
        add(l3);
        JLabel l4 = new JLabel("EM");
        l4.setBounds(560,5,50,25);
        add(l4);
        JLabel l5 = new JLabel("DBMS");
        l5.setBounds(650,5,50,25);
        add(l5);
        JLabel l6 = new JLabel("OS");
        l6.setBounds(740,5,50,25);
        add(l6);

        table = new JTable();
        table.setBounds(250,35,550,485);
        add(table);

        setBounds(250,125,800,500);
        setVisible(true);
        JPanel jp = new JPanel();
        jp.setBounds(0,0,250,500);
        jp.setBackground(Color.gray);
        add(jp);
        JPanel jp1 = new JPanel();
        jp1.setBounds(250,0,550,500);
        jp1.setBackground(Color.white);
        add(jp1);
        JLabel l7 = new JLabel("Admin");
        l7.setBounds(30,10,100,35);
        l7.setFont(new Font("SERIF",Font.PLAIN,20));
        l7.setForeground(Color.white);
        jp.add(l7);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Conn c = new Conn();
        String str = "Select * from Result";
        ResultSet rs = null;
        try {
            rs = c.s.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(ae.getSource() == b2){
            new RegisteredStudent();
            setVisible(false);
        } else if (ae.getSource() == b1) {
            new AddNewStudent();
            setVisible(false);
        }
    };
    public static void main(String[] args){
        new RegisteredStudent();
    }
}
