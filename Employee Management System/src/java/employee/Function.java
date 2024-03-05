package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Function extends JFrame implements ActionListener{
    JButton add,view,update,delete,logout;
    
    Function(){
        setLayout(null);
        
        JLabel heading=new JLabel("Employee Management Functions");
        heading.setBounds(300,20,450,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        add=new JButton("ADD EMPLOYEE");
        add.setBounds(150,250,150,40);
        add.setFont(new Font("serif",Font.BOLD,10));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        view=new JButton("VIEW EMPLOYEE");
        view.setBounds(350,250,150,40);
        view.setFont(new Font("serif",Font.BOLD,10));
        view.setBackground(Color.WHITE);
        view.setForeground(Color.BLACK);
        view.addActionListener(this);
        add(view);
        
        update=new JButton("UPDATE EMPLOYEE");
        update.setBounds(150,320,150,40);
        update.setFont(new Font("serif",Font.BOLD,10));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        delete=new JButton("DELETE EMPLOYEE");
        delete.setBounds(350,320,150,40);
        delete.setFont(new Font("serif",Font.BOLD,10));
        delete.setBackground(Color.WHITE);
        delete.setForeground(Color.BLACK);
        delete.addActionListener(this);
        add(delete);
        
        logout=new JButton("Log Out");
        logout.setBounds(270,500,100,30);
        logout.setFont(new Font("serif",Font.BOLD,10));
        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("imgs/function.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(670,150,400,300);
        add(img);
        
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new Add();
        }
        else if(ae.getSource()==view){
            setVisible(false);
            new view();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new view();
        }
        else if(ae.getSource()==delete){
            setVisible(false);
            new Remove();
        }
        else{
            setVisible(false);
            new Front();
        }
    }
    public static void main(String args[]){
        new Function();
    }
}