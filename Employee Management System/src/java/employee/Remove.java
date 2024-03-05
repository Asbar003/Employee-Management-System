package employee;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Remove extends JFrame implements ActionListener{
    
    Choice eid;
    JButton delete,back;
    Remove(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading= new JLabel("Remove Employee Details");
        heading.setBounds(300,20,450,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel employeeid=new JLabel("Employee Id");
        employeeid.setBounds(50,50,150,50);
        employeeid.setFont(new Font("serif",Font.PLAIN,20));
        add(employeeid);
        
        eid=new Choice();
        eid.setBounds(200,67,150,20);
        add(eid);
        
        try{
            emp_manage em=new emp_manage();
            String query="select * from employee";
            ResultSet rs=em.s.executeQuery(query);
            while(rs.next()){
                eid.add(rs.getString("empid"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JLabel name=new JLabel("Name");
        name.setBounds(50,100,150,50);
        name.setFont(new Font("serif",Font.PLAIN,20));
        add(name);
        
        JLabel txtname=new JLabel();
        txtname.setBounds(200,100,150,50);
        txtname.setFont(new Font("serif",Font.PLAIN,20));
        add(txtname);
        
        JLabel phone=new JLabel("Phone");
        phone.setBounds(50,150,150,50);
        phone.setFont(new Font("serif",Font.PLAIN,20));
        add(phone);
        
        JLabel txtphone=new JLabel();
        txtphone.setBounds(200,150,150,50);
        txtphone.setFont(new Font("serif",Font.PLAIN,20));
        add(txtphone);
        
        JLabel email=new JLabel("Email");
        email.setBounds(50,200,150,50);
        email.setFont(new Font("serif",Font.PLAIN,20));
        add(email);
        
        JLabel txtemail=new JLabel();
        txtemail.setBounds(200,200,200,50);
        txtemail.setFont(new Font("serif",Font.PLAIN,20));
        add(txtemail);
        
        try{
            emp_manage em=new emp_manage();
            String query="select * from employee where empid='"+eid.getSelectedItem()+"'";
            ResultSet rs=em.s.executeQuery(query);
            while(rs.next()){
                txtname.setText(rs.getString("name"));
                txtphone.setText(rs.getString("phone"));
                txtemail.setText(rs.getString("email"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        eid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    emp_manage em=new emp_manage();
                    String query="select * from employee where empid='"+eid.getSelectedItem()+"'";
                    ResultSet rs=em.s.executeQuery(query);
                    while(rs.next()){
                        txtname.setText(rs.getString("name"));
                        txtphone.setText(rs.getString("phone"));
                        txtemail.setText(rs.getString("email"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        delete=new JButton("Delete");
        delete.setBounds(220,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("serif",Font.PLAIN,15));
        delete.addActionListener(this);
        add(delete);
        
        back=new JButton("Back");
        back.setBounds(350,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("serif",Font.PLAIN,15));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("imgs/bg.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,900,600);
        add(img);
        
        setSize(900,600);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                emp_manage e=new emp_manage();
                String query="delete from employee where empid='"+eid.getSelectedItem()+"'";
                e.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Details deleted Successfully");
                setVisible(false);
                new Function();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Function();
        }
    }
    public static void main(String args[]){
        new Remove();
    }
}