import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    JFrame portal;
    JButton std,admin;
    Main(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        ImageIcon i = new ImageIcon("icons/first.png");
        Image i2 = i.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,800,500);
        add(img);
        JLabel lb = new JLabel("Student Result Management System");
        lb.setBounds(175,50,700,30);
        lb.setFont(new Font("BOLD",Font.BOLD,25));
        lb.setForeground(Color.black);
        img.add(lb);
        std = new JButton("Student ");
        std.setBounds(50,200,100,35);
        std.setBackground(Color.black);
        std.setFont(new Font("serite",Font.PLAIN,15));
        std.setForeground(Color.white);
        std.addActionListener(this);
        img.add(std);
        admin = new JButton("Admin ");
        admin.setBounds(175,200,100,35);
        admin.setBackground(Color.black);
        admin.setFont(new Font("serite",Font.PLAIN,15));
        admin.setForeground(Color.white);
        admin.addActionListener(this);
        img.add(admin);
        setBounds(250,125,800,500);
        setVisible(true);
        while(true){
            lb.setVisible(false);
            try{
                Thread.sleep(350);
            }catch (Exception e){
                e.printStackTrace();
            }
            lb.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            lb.setVisible(false);
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == std){
            new Student();
        } else if (ae.getSource() == admin) {
            new Admin();
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}