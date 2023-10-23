import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddNewStudent extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5;
    JComboBox jcgender,jcCourse,jcBranch;
    JTextField Rollno,name,father;
    JButton save;
    AddNewStudent(){
        setLayout(null);
        b1 = new JButton("Add New Student",null);
        b1.setBounds(0,75,250,35);
        b1.addActionListener(this);
        b1.setBackground(Color.blue);
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

        JLabel lb2 = new JLabel("Course");
        lb2.setBounds(350,15,120,30);
        lb2.setFont(new Font("italic",Font.BOLD,15));
        add(lb2);
        String course[] = {"Select","BTech","MTech","BBA","MBA"};
        jcCourse = new JComboBox(course);
        jcCourse.setBounds(450,20,250,25);
        jcCourse.setBackground(Color.white);
        add(jcCourse);

        JLabel lb3 = new JLabel("Branch");
        lb3.setBounds(350,85,120,30);
        lb3.setFont(new Font("italic",Font.BOLD,15));
        add(lb3);
        String Brach[] = {"Select","EEE","CS","IT","ECE","MECH"};
        jcBranch = new JComboBox(Brach);
        jcBranch.setBounds(450,90,250,25);
        jcBranch.setBackground(Color.white);
        add(jcBranch);

        JLabel lb4 = new JLabel("Roll No");
        lb4.setBounds(350,155,120,30);
        lb4.setFont(new Font("italic",Font.BOLD,15));
        add(lb4);
        Rollno = new JTextField();
        Rollno.setBounds(450,160,250,25);
        Rollno.setBackground(Color.white);
        add(Rollno);

        JLabel lb5 = new JLabel("Name");
        lb5.setBounds(350,225,120,30);
        lb5.setFont(new Font("italic",Font.BOLD,15));
        add(lb5);
        name = new JTextField();
        name.setBounds(450,230,250,25);
        name.setBackground(Color.white);
        add(name);

        JLabel lb1 = new JLabel("Gender");
        lb1.setBounds(350,295,120,30);
        lb1.setFont(new Font("italic",Font.BOLD,15));
        add(lb1);
        String gender[] = {"Select","Male","Female","Others"};
        jcgender = new JComboBox(gender);
        jcgender.setBounds(450,300,250,25);
        jcgender.setBackground(Color.white);
        add(jcgender);

        JLabel lb6 = new JLabel("Father Name");
        lb6.setBounds(350,365,120,30);
        lb6.setFont(new Font("italic",Font.BOLD,15));
        add(lb6);
        father = new JTextField();
        father.setBounds(450,370,250,25);
        father.setBackground(Color.white);
        add(father);

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
        if (ae.getSource() == save) {
            String Course = (String) jcCourse.getSelectedItem();
            String Branch = (String) jcBranch.getSelectedItem();
            String RollNo = Rollno.getText();
            String Name = name.getText();
            String Gender = (String) jcgender.getSelectedItem();
            String fatherName = father.getText();

            try{
                Conn conn = new Conn();
                String str = "insert into Student values('"+RollNo+"','"+Name+"','"+fatherName+"','"+Course+"','"+Branch+"','"+Gender+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Student Added Success fully");
                setVisible(false);
                new AddNewStudent();
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
        new AddNewStudent();
    }
}
