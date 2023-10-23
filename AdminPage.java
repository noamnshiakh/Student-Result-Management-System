import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPage extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5;
    AdminPage(){
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
        add(b3);
        b4 = new JButton("All Students Result",null);
        b4.setBounds(0,300,250,35);
        add(b4);
        b5 = new JButton("Logout",null);
        b5.setBounds(50,375,150,35);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        add(b5);

        setBounds(250,125,800,500);
        setVisible(true);
        JPanel jp = new JPanel();
        jp.setBounds(0,0,250,500);
        jp.setBackground(Color.gray);
        add(jp);
        JPanel jp1 = new JPanel();
        jp1.setBounds(250,0,550,500);
        jp1.setBackground(Color.lightGray);
        add(jp1);
        JLabel l1 = new JLabel("Admin");
        l1.setBounds(30,10,100,35);
        l1.setFont(new Font("SERIF",Font.PLAIN,20));
        l1.setForeground(Color.white);
        jp.add(l1);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            new AddNewStudent();
            setVisible(false);
        }else if(ae.getSource() == b2){
            new AddResult();
            setVisible(false);
        }
    };
    public static void main(String[] args){
        new AdminPage();
    }
}
