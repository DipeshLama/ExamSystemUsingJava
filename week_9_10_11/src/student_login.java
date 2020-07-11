import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
import java.sql.*;
import javax.swing.*;
public class student_login extends JFrame implements ActionListener{
    JLabel labelemail,labelpassword, background,loginDisplayLabel;
    JPasswordField txtpassword;
    JTextField txtemail;
    JButton login_but,btnBack;
    
    public student_login(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,350);
        setTitle("Student Login"); 
        setLayout(null);
        setResizable(false);
        
        background=new JLabel();
        background.setBounds(50,30,150,150);
        background.setIcon(new ImageIcon("image/user.png"));
        add(background);
        
        loginDisplayLabel=new JLabel("Student Login");
        loginDisplayLabel.setBounds(50,160,150,30);
        loginDisplayLabel.setFont(new Font("SANS_SERIF",Font.BOLD,20));
        add(loginDisplayLabel);
          
        labelemail=new JLabel("Email");
        labelemail.setBounds(250,60,50,30);
        labelemail.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        txtemail=new JTextField();
        txtemail.setBounds(350,60,200,30);
        
        labelpassword=new JLabel("Password");
        labelpassword.setBounds(250,120,80,30);
        labelpassword.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        txtpassword=new JPasswordField();
        txtpassword.setBounds(350,120,200,30);
        
        login_but=new JButton("Login");
        login_but.setBounds(350,200,80,30);
        login_but.addActionListener(this);
        
        btnBack=new JButton("Back");
        btnBack.setBounds(450,200,80,30);
        btnBack.addActionListener(this);
        
        add(labelemail);
        add(txtemail);
        add(labelpassword);
        add(txtpassword);
        add(login_but);
        add(btnBack);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         
      if(ae.getSource().equals(login_but)){
        try{
           student_database db = new student_database();
           Statement st = db.conn.createStatement();
           String query="select Token from student where Email ='"+txtemail.getText()+"'";
           ResultSet rs=st.executeQuery(query);
           String get_password="";
           while (rs.next()){
               get_password=rs.getString(1);
           }
           if(txtemail.getText().isEmpty() || txtpassword.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null,"Please Fill out all fields");
           }
           else if(get_password.equals(txtpassword.getText())){
               JOptionPane.showMessageDialog(null,"Logged in successfully");
//              String msg= txtEmail.getText();
                new student_module_select().setVisible(true);
                this.dispose();
           }
        
           else{
               JOptionPane.showMessageDialog(null,"Incorrect Email/Password");
           }
        }
           catch(Exception ex){}
           
           
      }
    
        
      
        if(ae.getSource().equals(btnBack)){
             this.dispose();
             new FrontPage().setVisible(true);
             
         }
    }
    
}

