import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
public class student_signup extends JFrame implements ActionListener{
        JLabel labeldisplay,labelname,labelemail,labeladdress,labelgender,labelbatch,labelToken;
        JTextField txtname, txtemail,txtaddress,txtToken;
        JRadioButton rbtmale,rbtfemale,rbtothers;
        JComboBox cb;
	JButton buttonSignup,clrbutton,btnToken,btnBack;
    public student_signup(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setTitle("Signup Form");
        setLayout(null);
        setResizable(false);
        labelname=new JLabel("User name");
        labelname.setBounds(10,50,100,20);
        
        labeldisplay=new JLabel("Signup form");
        labeldisplay.setBounds(170,1,150,50);
        labeldisplay.setFont(new Font("serif",Font.BOLD,24));
        
        txtname=new JTextField();
        txtname.setBounds(100,50,100,20);
        
        labelemail=new JLabel("Email");
        labelemail.setBounds(10,90,50,20);
        txtemail=new JTextField();
        txtemail.setBounds(100,90,100,20);
        
        labeladdress=new JLabel("Address");
        labeladdress.setBounds(10,130,100,20);
        txtaddress=new JTextField();
        txtaddress.setBounds(100,130,100,20);
        
        labelgender=new JLabel("Gender");
        labelgender.setBounds(10,180,100,20);
        rbtmale=new JRadioButton("Male",true);
        rbtmale.setBounds(100,180,100,20);
        rbtfemale=new JRadioButton("Female");
        rbtfemale.setBounds(200,180,120,20);
        rbtothers=new JRadioButton("Others");
        rbtothers.setBounds(320,180,220,20);
        ButtonGroup bg=new ButtonGroup();
        
        labelbatch=new JLabel("Batch");
        labelbatch.setBounds(10,240,100,20);
        cb=new JComboBox();
        cb.addItem("24A");
        cb.addItem("24B");
        cb.addItem("25A");
        cb.addItem("25B");
        cb.addItem("25C");
        cb.setBounds(100,240,100,20);
        
        labelToken=new JLabel("Token");
        labelToken.setBounds(10,300,100,20);
        txtToken=new JTextField();
        txtToken.setBounds(100,300,100,20);
        
        buttonSignup=new JButton("Signup");
        buttonSignup.setBounds(100,350,80,30);
        buttonSignup.addActionListener(this);
        
        clrbutton=new JButton("Clear");
        clrbutton.setBounds(200,350,80,30);
        clrbutton.addActionListener(this);
        
        btnToken=new JButton("Create Token");
        btnToken.setBounds(240,300,150,20);
        btnToken.addActionListener(this);
        
        btnBack=new JButton("Back");
        btnBack.setBounds(300,350,80,30);
        btnBack.addActionListener(this);
        
        
        add(labeldisplay);
        add(labelname);
        add(labelemail);
        add(labeladdress);
        add(txtaddress);
        add(txtname);
        add(txtemail);    
        add(labelgender);
        bg.add(rbtmale);
        bg.add(rbtfemale);
        bg.add(rbtothers);
        add(rbtmale);
        add(rbtfemale);
        add(rbtothers);
        add(labelbatch);
        add(cb);
        add(labelToken);
        add(txtToken);
        add(buttonSignup);
        add(clrbutton);
        add(btnToken);
        add(btnBack);
        
    }
   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String batch=cb.getSelectedItem().toString();
                String student_gender="";
                if(rbtmale.isSelected()){
                    student_gender=rbtmale.getText().toString();
                }
                if(rbtfemale.isSelected()){
                    student_gender=rbtfemale.getText().toString();
                }
                if (rbtothers.isSelected()){
                    student_gender=rbtothers.getText().toString();
                }
       if(ae.getSource()==buttonSignup)
        {
            try {
                student_database db=new student_database();
                
                String student_name=txtname.getText().toString();
                String student_email=txtemail.getText().toString();
                String student_address=txtaddress.getText().toString();       
                String token=txtToken.getText().toString();
                
                if(student_name.isEmpty()|| student_email.isEmpty() || student_address.isEmpty() || token.isEmpty() )
                {
                    JOptionPane.showMessageDialog(null,"All fields should be filled");
                }
                else
                {
                int result=db.signup(student_name,student_email,student_address,student_gender,batch,token);       
                if (result>0)
                {
                    JOptionPane.showMessageDialog(null,"Saved");
                    new student_login().setVisible(true);
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
       
       if(ae.getSource()==btnToken){
           txtToken.setText(createToken());
           JOptionPane.showMessageDialog(null,"Note the token number");
      }
       
       
       if(ae.getSource()==clrbutton){
           txtname.setText(null);
           txtemail.setText(null);
           txtaddress.setText(null);  
           txtToken.setText(null);
       }
       
       if(ae.getSource().equals(btnBack)){
           this.dispose();
             new FrontPage().setVisible(true);
         }
    } 
    
   public String createToken(){
	int n = 10;
	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";  
	StringBuilder sb = new StringBuilder(n); 
	for (int i = 0; i < n; i++) { 
	int index = (int)(AlphaNumericString.length() * Math.random()); 
	sb.append(AlphaNumericString.charAt(index));
	}
	return sb.toString();
    }
}

