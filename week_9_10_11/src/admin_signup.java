import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
public class admin_signup extends JFrame implements ActionListener{
     JLabel labelName,labelEmail,labelPassword;
     JTextField txtname, txtemail,txtpassword;
     JButton adminSaveBtn,backBtn;
    public admin_signup(){
         setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setTitle("Admin Signup");
        setLayout(null);
        setResizable(false);
        
        labelName=new JLabel("User name");
        labelName.setBounds(10,50,100,20);
        add(labelName);
        
        txtname=new JTextField();
        txtname.setBounds(100,50,100,20);
        add(txtname);
        
        
        labelEmail=new JLabel("Email");
        labelEmail.setBounds(10,90,50,20);
        add(labelEmail);
        txtemail=new JTextField();
        txtemail.setBounds(100,90,100,20);
        add(txtemail);
        
        labelPassword=new JLabel("Password");
        labelPassword.setBounds(10,130,80,20);
        add(labelPassword);
        txtpassword=new JTextField();
        txtpassword.setBounds(100,130,100,20);
        add(txtpassword);
        
        adminSaveBtn=new JButton("Signup");
        adminSaveBtn.setBounds(100,190,80,30);
        adminSaveBtn.addActionListener(this);
        add(adminSaveBtn);
        
        backBtn=new JButton("Back");
        backBtn.setBounds(200,190,80,30);
        backBtn.addActionListener(this);
        add(backBtn);
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==adminSaveBtn)
        {
            try {
                student_database db=new student_database();
                
                String adminName=txtname.getText().toString();
                String adminEmail=txtemail.getText().toString();                      
                String password=txtpassword.getText().toString();
                
                if(adminName.isEmpty()|| adminEmail.isEmpty() || password.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"All fields should be filled");
                }
                else
                {
                int result=db.adminSignup(adminName,adminEmail,password);       
                if (result>0)
                {
                    JOptionPane.showMessageDialog(null,"Saved");
                    new admin_login().setVisible(true);
                    this.dispose();
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Unable to saved");
                }
              }
            }
            
            catch (Exception e) 
            {
                
            }
        }
        
        
          if(ae.getSource().equals(backBtn)){
             this.dispose();
             new FrontPage().setVisible(true);
         }
    }
    
}
