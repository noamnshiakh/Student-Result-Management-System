import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddResult extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5;
    JTextField RollNo,physics,Maths,EM,DBMS,OS;
    JButton save;
    AddResult(){
        setLayout(null);
        b1 = new JButton("Add New Student",null);
        b1.setBounds(0,75,250,35);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Add Result",null);
        b2.setBounds(0,150,250,35);
        b2.addActionListener(this);
        b2.setBackground(Color.blue);
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

        JLabel lb2 = new JLabel("Roll Number");
        lb2.setBounds(350,15,120,30);
        lb2.setFont(new Font("italic",Font.BOLD,15));
        add(lb2);
        RollNo = new JTextField();
        RollNo.setBounds(450,20,250,25);
        RollNo.setBackground(Color.white);
        add(RollNo);

        JLabel lb3 = new JLabel("Physics");
        lb3.setBounds(350,85,120,30);
        lb3.setFont(new Font("italic",Font.BOLD,15));
        add(lb3);
        physics = new JTextField();
        physics.setBounds(450,90,250,25);
        physics.setBackground(Color.white);
        add(physics);

        JLabel lb4 = new JLabel("Maths");
        lb4.setBounds(350,155,120,30);
        lb4.setFont(new Font("italic",Font.BOLD,15));
        add(lb4);
        Maths = new JTextField();
        Maths.setBounds(450,160,250,25);
        Maths.setBackground(Color.white);
        add(Maths);

        JLabel lb5 = new JLabel("EM");
        lb5.setBounds(350,225,120,30);
        lb5.setFont(new Font("italic",Font.BOLD,15));
        add(lb5);
        EM = new JTextField();
        EM.setBounds(450,230,250,25);
        EM.setBackground(Color.white);
        add(EM);

        JLabel lb1 = new JLabel("DBMS");
        lb1.setBounds(350,295,120,30);
        lb1.setFont(new Font("italic",Font.BOLD,15));
        add(lb1);
        DBMS = new JTextField();
        DBMS.setBounds(450,300,250,25);
        DBMS.setBackground(Color.white);
        add(DBMS);

        JLabel lb6 = new JLabel("OS");
        lb6.setBounds(350,365,120,30);
        lb6.setFont(new Font("italic",Font.BOLD,15));
        add(lb6);
        OS = new JTextField();
        OS.setBounds(450,370,250,25);
        OS.setBackground(Color.white);
        add(OS);

        save = new JButton("Save");
        save.setBounds(500,425,150,30);
        save.setForeground(Color.white);
        save.setBackground(Color.black);
        save.addActionListener(this);
        add(save);

        setBounds(250,125,800,500);
        setVisible(true);
        JPanel jp = new JPanel();
        jp.setBounds(0,0,250,500);
        jp.setBackground(Color.gray);
        add(jp);
        JPanel jp1 = new JPanel();
        jp1.setBounds(250,0,550,500);
        jp1.setBackground(Color.pink);
        add(jp1);
        JLabel l1 = new JLabel("Admin");
        l1.setBounds(30,10,100,35);
        l1.setFont(new Font("SERIF",Font.PLAIN,20));
        l1.setForeground(Color.white);
        jp.add(l1);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == save) {
            String rollNo = RollNo.getText();
            String Physics = physics.getText();
            String maths = Maths.getText();
            String em = EM.getText();
            String dbms = DBMS.getText();
            String os = OS.getText();

            try{
                Conn conn = new Conn();
                String str = "insert into Result values('"+rollNo+"','"+Physics+"','"+maths+"','"+em+"','"+dbms+"','"+os+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Result Added Success fully");
                setVisible(false);
                new AddResult();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == b2){
            new AddResult();
            setVisible(false);
        } else if (ae.getSource() == b1) {
            new AddNewStudent();
            setVisible(false);
        }
    };
    public static void main(String[] args){
        new AddResult();
    }
}
