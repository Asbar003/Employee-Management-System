package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField txtuser;
    JPasswordField txtpassword;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel user=new JLabel("UserName");
        user.setBounds(90,120,100,30);
        user.setFont(new Font("serif",Font.PLAIN,20));
        add(user);
        
        txtuser=new JTextField();
        txtuser.setBounds(220,120,150,30);
        txtuser.setFont(new Font("serif",Font.PLAIN,20));
        add(txtuser);
        
        JLabel password=new JLabel("Password");
        password.setBounds(90,170,100,30);
        password.setFont(new Font("serif",Font.PLAIN,20));
        add(password);
        
        txtpassword=new JPasswordField();
        txtpassword.setBounds(220,170,150,30);
        txtpassword.setFont(new Font("serif",Font.PLAIN,20));
        add(txtpassword);
        
        JButton login=new JButton("LOGIN");
        login.setBounds(170,240,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("imgs/userimg.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1050,500);
        add(img);
        
        setSize(1050,500);
        setLocation(250,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String user=txtuser.getText();
            String password=txtpassword.getText();
  
            emp_manage c= new emp_manage();
            String query="select * from logindata where user= '"+user+"'AND password= '"+password+"'";
            //PreparedStatement preparedStatement = c.preparedStatement(query);
            
            ResultSet as = c.s.executeQuery(query);
            if(as.next()){
                setVisible(false);
                new Function();
                //next class
            }
            else{
                JOptionPane.showMessageDialog(null, "Please set the correct Username or Password");
                setVisible(false);
                new Login();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new Login();
    }
}