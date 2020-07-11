import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class FrontPage extends JFrame implements ActionListener{
    JMenuBar MainMenu;
    JMenu admin,student;
    JMenuItem adminLogin,adminSignup,studentLogin,studentSignup;
    JLabel welcomeDisplay,background;
    
    
    public FrontPage(){
     MainMenu=new JMenuBar();
     admin=new JMenu("Admin");
     student=new JMenu("Student");
     adminLogin=new JMenuItem("Login");
     adminSignup=new JMenuItem("Signup");
     studentLogin=new JMenuItem("Login");
     studentSignup=new JMenuItem("Signup");
     
     background=new JLabel();
     background.setBounds(0,0,600,400);
     background.setIcon(new ImageIcon("image/java_font_pic.jpg"));

     welcomeDisplay=new JLabel("Welcome to MCQ system");
     welcomeDisplay.setBounds(140,120,400,30);
     welcomeDisplay.setFont(new Font("DIALOG",Font.BOLD,25));
     
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container c=getContentPane();
    setSize(600,400);
    c.setLayout(null);
    setResizable(false);
    setTitle("Welcome to MCQ system");
    
    studentLogin.addActionListener(this);
    studentSignup.addActionListener(this);
    adminLogin.addActionListener(this);
    adminSignup.addActionListener(this);
    
    MainMenu.add(admin);MainMenu.add(student);admin.add(adminLogin);admin.add(adminSignup);student.add(studentLogin);
    student.add(studentSignup);add(MainMenu);setJMenuBar(MainMenu); add(background);
    add(welcomeDisplay);
    }
    
    public static void main(String[] args) {
         new FrontPage().setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if (ae.getSource().equals(studentLogin)){
             new student_login().setVisible(true);
             this.dispose();
        }
        
        if(ae.getSource().equals(studentSignup))
        {
            new student_signup().setVisible(true);
            this.dispose();
        }
        
         if(ae.getSource().equals(adminLogin))
        {
            new admin_login().setVisible(true);
            this.dispose();
        }
         
           if(ae.getSource().equals(adminSignup))
        {
            new admin_signup().setVisible(true);
            this.dispose();
        }
        
        
        
    
    }
    
}
