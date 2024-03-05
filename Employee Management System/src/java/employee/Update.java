package employee;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class Update extends JFrame implements ActionListener{
    JButton add,back;
    JTextField txteducation, txtfname ,txtaddress,txtphone,txtemail,txtsalary,txtdesignation;
    JLabel txtempid,txtaadhaar,txtname;
    String empid;
    
    Update(String empid){
        this.empid=empid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading= new JLabel("Update Employee Details");
        heading.setBounds(300,20,450,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel name=new JLabel("Name");
        name.setBounds(100,150,150,30);
        name.setFont(new Font("serif",Font.PLAIN,20));
        add(name);
        
        txtname=new JLabel();
        txtname.setBounds(220,150,150,30);
        txtname.setFont(new Font("serif",Font.PLAIN,15));
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
        
        JLabel txtdob=new JLabel();
        txtdob.setBounds(220,220,150,30);
        txtdob.setFont(new Font("serif",Font.PLAIN,15));
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
        
        txteducation=new JTextField();
        txteducation.setBackground(Color.WHITE);
        txteducation.setBounds(600,360,150,30);
        add(txteducation);
        
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
        
        txtaadhaar=new JLabel();
        txtaadhaar.setBounds(600,425,150,30);
        txtaadhaar.setFont(new Font("serif",Font.PLAIN,15));
        add(txtaadhaar);
        
        JLabel empId=new JLabel("Employee Id");
        empId.setBounds(100,485,150,30);
        empId.setFont(new Font("serif",Font.PLAIN,20));
        add(empId);
        
        txtempid=new JLabel();
        txtempid.setBounds(250,485,150,30);
        txtempid.setFont(new Font("serif",Font.PLAIN,15));
        add(txtempid);
        
        try{
           emp_manage e=new emp_manage();
           String query="select * from employee where empid='"+empid+"'";
           ResultSet rs=e.s.executeQuery(query);
           while(rs.next()){
               txtname.setText(rs.getString("name"));
               txtfname.setText(rs.getString("fname"));
               txtdob.setText(rs.getString("dob"));
               txtsalary.setText(rs.getString("salary"));
               txtaddress.setText(rs.getString("address"));
               txtphone.setText(rs.getString("phone"));
               txtemail.setText(rs.getString("email"));
               txteducation.setText(rs.getString("education"));
               txtdesignation.setText(rs.getString("designation"));
               txtaadhaar.setText(rs.getString("aadhaar"));
               txtempid.setText(rs.getString("empid"));
               
           }
        }catch(Exception e){
            e.printStackTrace();
        }
       
        add=new JButton("UPDATE DETAILS");
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
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String fname=txtfname.getText();
            String salary=txtsalary.getText();
            String address=txtaddress.getText();
            String phone=txtphone.getText();
            String email=txtemail.getText();
            String education=txteducation.getText();
            String designation=txtdesignation.getText();
            
            try{
                emp_manage em=new emp_manage();
                String query="update employee set fname='"+fname+"',salary= '"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empid='"+empid+"'";
                em.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Details Updated Successfully");
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
        new Update("");
    }
}