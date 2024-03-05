package employee;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class view extends JFrame implements ActionListener{
    JTable table;
    Choice emp;
    JButton searched,download,update,back;
    
    view(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel search= new JLabel("Search By Employee id");
        search.setBounds(20,20,150,20);
        search.setForeground(Color.BLACK);
        add(search);
        
        emp=new Choice();
        emp.setBounds(180,20,150,20);
        add(emp);
        
        try{
            emp_manage e=new emp_manage();
            ResultSet rs=e.s.executeQuery("select * from employee");
            while(rs.next()){
                emp.add(rs.getString("empid"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        table=new JTable();
        try{
            emp_manage e=new emp_manage();
            ResultSet rs=e.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(50,100,800,600);
        add(jsp);
        
        searched=new JButton("Search");
        searched.setBounds(20,70,80,20);
        searched.addActionListener(this);
        add(searched);
        
        download=new JButton("Download");
        download.setBounds(120,70,100,20);
        download.addActionListener(this);
        add(download);
        
        update=new JButton("Update");
        update.setBounds(240,70,80,20);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBounds(360,70,80,20);
        back.addActionListener(this);
        add(back);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("imgs/bg.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,900,700);
        add(img);
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==searched){
            String query="select * from employee where empid='"+emp.getSelectedItem()+"'";
            try{
                emp_manage em=new emp_manage();
                ResultSet rs=em.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==download){
            try{
                table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
       else if(ae.getSource()==update){
            setVisible(false);
            new Update(emp.getSelectedItem());
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Function();
        }
    }
    public static void main(String args[]){
        new view();
    }
}