import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton Admin,cancel;
    Admin(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        //user textfield
        JLabel admin= new JLabel("Admin Login");
        admin.setFont(new Font("Bold",Font.PLAIN,25));
        admin.setBounds(80,20,200,30);
        add(admin);
        JLabel user = new JLabel("username");
        user.setBounds(40,80,100,30);
        add(user);
        username = new JTextField();
        username.setBounds(130,80,120,30);
        add(username);
        //pass textfield
        JLabel pass = new JLabel("password");
        pass.setBounds(40,130,100,30);
        add(pass);
        password = new JPasswordField();
        password.setBounds(130,130,120,30);
        add(password);
        //Admin button
        Admin = new JButton("Login");
        Admin.setBounds(40,210,100,30);
        Admin.setBackground(Color.black);
        Admin.setForeground(Color.white);
        Admin.addActionListener(this);
        add(Admin);
        //cancel button
        cancel = new JButton("cancel");
        cancel.setBounds(170,210,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        //images
        ImageIcon i1 = new ImageIcon("icons/second.jpg");
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(280,0,320,300);
        add(image);
        setBounds(400,200,600,300);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Admin){
            String user = username.getText();
            String pass = password.getText();
            try{
                Conn c = new Conn();
                String query = "select * from AdminId where username ='" +user +"'and pass = '"+pass+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    new AdminPage();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    };
    public static void main(String[] args){
        new Admin();
    }
}
