import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
public class admin_login extends JFrame implements ActionListener{
    JLabel adminlabelemail,adminlabelpassword;
    JPasswordField admintxtpassword;
    JTextField admintxtemail;
    JButton adminlogin_but,back_btn;
    
    public admin_login(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,400);
        setTitle("Admin Login"); 
        setLayout(null);
        setResizable(false);
        
        adminlabelemail=new JLabel("Email");
        adminlabelemail.setBounds(70,50,50,30);
        adminlabelemail.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        admintxtemail=new JTextField();
        admintxtemail.setBounds(170,50,200,30);
        
        adminlabelpassword=new JLabel("Password");
        adminlabelpassword.setBounds(70,100,80,30);
        adminlabelpassword.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        admintxtpassword=new JPasswordField();
        admintxtpassword.setBounds(170,100,200,30);
        
        adminlogin_but=new JButton("Login");
        adminlogin_but.setBounds(170,180,80,30);
        adminlogin_but.addActionListener(this);
        
        back_btn=new JButton("Back");
        back_btn.setBounds(270,180,80,30);
        back_btn.addActionListener(this);
        
        add(adminlabelemail);
        add(admintxtemail);
        add(adminlabelpassword);
        add(admintxtpassword);
        add(adminlogin_but);
        add(back_btn);
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(ae.getSource().equals(adminlogin_but)){
          try{
           student_database db = new student_database();
           Statement st = db.conn.createStatement();
           String query="select AdminPassword from admin where AdminEmail ='"+admintxtemail.getText()+"'";
           ResultSet rs=st.executeQuery(query);
           String get_password="";
           while (rs.next()){
               get_password=rs.getString(1);
           }
           if(admintxtemail.getText().isEmpty() || admintxtpassword.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null,"Please Fill out all fields");
           }
           else if(get_password.equals(admintxtpassword.getText())){
               JOptionPane.showMessageDialog(null,"Logged in successfully");
//              String msg= txtEmail.getText();
                new administrator_dashboard().setVisible(true);
                this.dispose();
           }
        
           else{
               JOptionPane.showMessageDialog(null,"Incorrect Email/Password");
           }
        }
           catch(Exception ex){}
      }
        if(ae.getSource().equals(back_btn)){
            this.dispose();
             new FrontPage().setVisible(true);
         }
    }
    
    /* public void validateAccount(){
       try{
           student_database db=new student_database();
           String username=admintxtemail.getText();
           String password=admintxtpassword.getText();
            if(username.equals("admin")){
                if(password.equals("admin")){
                    new administrator_dashboard().setVisible(true);
                    this.dispose();
                } 
            }     
       }
         
       catch(Exception e){    
           
       }
    } */ 
}
