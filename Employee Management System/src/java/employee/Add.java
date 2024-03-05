package employee;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Add extends JFrame implements ActionListener{
    Random as=new Random();
    int number=as.nextInt(999);
    JButton add,back;
    JTextField txtname, txtfname ,txtaddress,txtphone,txtaadhaar,txtemail,txtsalary,txtdesignation;
    JDateChooser txtdob;
    JLabel txtempid;
    JComboBox txteducate;
    
    Add(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading= new JLabel("Add  Employee Details");
        heading.setBounds(300,20,450,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel name=new JLabel("Name");
        name.setBounds(100,150,150,30);
        name.setFont(new Font("serif",Font.PLAIN,20));
        add(name);
        
        txtname=new JTextField();
        txtname.setBounds(220,150,150,30);
        add(txtname);
        
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(450,150,150,30);
        fname.setFont(new Font("serif",Font.PLAIN,20));
        add(fname);
        
        txtfname=new JTextField();
        txtfname.setBounds(600,150,150,30);
        add(txtfname);
        
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(100,220,150,30);
        dob.setFont(new Font("serif",Font.PLAIN,20));
        add(dob);
        
        txtdob=new JDateChooser();
        txtdob.setBounds(220,220,150,30);
        add(txtdob);
        
        JLabel salary=new JLabel("Salary");
        salary.setBounds(450,220,150,30);
        salary.setFont(new Font("serif",Font.PLAIN,20));
        add(salary);
        
        txtsalary=new JTextField();
        txtsalary.setBounds(600,220,150,30);
        add(txtsalary);
        
        JLabel address=new JLabel("Address");
        address.setBounds(100,290,150,30);
        address.setFont(new Font("serif",Font.PLAIN,20));
        add(address);
        
        txtaddress=new JTextField();
        txtaddress.setBounds(220,290,150,30);
        add(txtaddress);
        
        JLabel phone=new JLabel("Phone No.");
        phone.setBounds(450,290,150,30);
        phone.setFont(new Font("serif",Font.PLAIN,20));
        add(phone);
        
        txtphone=new JTextField();
        txtphone.setBounds(600,290,150,30);
        add(txtphone);
        
        JLabel email=new JLabel("Email");
        email.setBounds(100,360,150,30);
        email.setFont(new Font("serif",Font.PLAIN,20));
        add(email);
        
        txtemail=new JTextField();
        txtemail.setBounds(220,360,150,30);
        add(txtemail);
        
        JLabel educate=new JLabel("Highest Education");
        educate.setBounds(450,360,150,30);
        educate.setFont(new Font("serif",Font.PLAIN,20));
        add(educate);
        
        String course[]={"BBA","BCA","BA","B.COM","BTech/B.E","B.Sc","MBA","MCA","MA","MTech/M.E","M.Sc"};
        txteducate=new JComboBox(course);
        txteducate.setBackground(Color.WHITE);
        txteducate.setBounds(600,360,150,30);
        add(txteducate);
        
        JLabel designation=new JLabel("Designation");
        designation.setBounds(100,425,150,30);
        designation.setFont(new Font("serif",Font.PLAIN,20));
        add(designation);
        
        txtdesignation=new JTextField();
        txtdesignation.setBounds(220,425,150,30);
        add(txtdesignation);
        
        JLabel aadhaar=new JLabel("Aadhaar No.");
        aadhaar.setBounds(450,425,150,30);
        aadhaar.setFont(new Font("serif",Font.PLAIN,20));
        add(aadhaar);
        
        txtaadhaar=new JTextField();
        txtaadhaar.setBounds(600,425,150,30);
        add(txtaadhaar);
        
        JLabel empid=new JLabel("Employee Id");
        empid.setBounds(100,485,150,30);
        empid.setFont(new Font("serif",Font.PLAIN,20));
        add(empid);
        
        txtempid=new JLabel("5427"+number);
        txtempid.setBounds(250,485,150,30);
        txtempid.setFont(new Font("serif",Font.PLAIN,20));
        add(txtempid);
       
        add=new JButton("ADD DETAILS");
        add.setBounds(250,580,150,40);
        add.setFont(new Font("serif",Font.BOLD,10));
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setSize(50,50);
        back.setBounds(430,580,150,40);
        back.setFont(new Font("serif",Font.BOLD,12));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("imgs/bg.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,900,700);
        add(img);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name=txtname.getText();
            String fname=txtfname.getText();
            String dob=((JTextField) txtdob.getDateEditor().getUiComponent()).getText();
            String salary=txtsalary.getText();
            String address=txtaddress.getText();
            String phone=txtphone.getText();
            String email=txtemail.getText();
            String education=(String)txteducate.getSelectedItem();
            String designation=txtdesignation.getText();
            String aadhaar=txtaadhaar.getText();
            String empid=txtempid.getText();
            
            try{
                emp_manage em=new emp_manage();
                String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhaar+"','"+empid+"')";
                em.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Details added Successfully");
                setVisible(false);
                new Function();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Function();
        }
    }
    public static void main(String args[]){
        new Add();
    }
}