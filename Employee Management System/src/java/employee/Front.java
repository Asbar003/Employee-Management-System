package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Front extends JFrame implements ActionListener{
    Front(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading= new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(130,60,1200,60);
        heading.setFont(new Font("serif",Font.PLAIN,50));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("imgs/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1170,640);
        add(img);
        
        JButton button=new JButton("Click Here");
        button.setBounds(400,400,300,70);
        button.setFont(new Font("serif",Font.PLAIN,25));
        button.setBackground(Color.BLUE);
        button.setForeground(Color.YELLOW);
        button.addActionListener(this);
        add(button);
        
        setSize(1170,640);
        setLocation(50,50);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent act){
        setVisible(false);
        new Login();
    }
    public static void main(String args[]){
        new Front();
    }
}