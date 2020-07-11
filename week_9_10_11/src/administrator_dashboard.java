import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class administrator_dashboard extends JFrame implements ActionListener{
    JMenuBar adminMenu;
    JMenu CreateQstn;
    JMenuItem programmingMenuItem,webMenuItem,networkMenuItem,ethicsMenuItem;
    JButton logout;
  
    
    public administrator_dashboard(){
     adminMenu=new JMenuBar();
     CreateQstn=new JMenu("Create Questions");
     programmingMenuItem=new JMenuItem("Programming");
     webMenuItem=new JMenuItem("Modern Web");
     networkMenuItem=new JMenuItem("Network");
     ethicsMenuItem=new JMenuItem("Ethics");
             
     programmingMenuItem.addActionListener(this);
     webMenuItem.addActionListener(this);
     networkMenuItem.addActionListener(this);
     ethicsMenuItem.addActionListener(this);
     
     logout=new JButton("Log out");
     logout.setBounds(230,200,80,30);
     logout.addActionListener(this);
     add(logout);
 
     adminMenu.add(CreateQstn);
     
     CreateQstn.add(programmingMenuItem);
     CreateQstn.add(webMenuItem);
     CreateQstn.add(webMenuItem);
      CreateQstn.add(networkMenuItem);
        CreateQstn.add(ethicsMenuItem);
     add(adminMenu);setJMenuBar(adminMenu);
        
        
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setSize(550,400);
     setTitle("Admin DashBoard");
     setResizable(false);
     setLayout(null);
    
    
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
           if(ae.getSource()==programmingMenuItem){
              new createQuestionForm().setVisible(true);
              this.dispose();
           } 
        
          if(ae.getSource()==webMenuItem){
              new createWebQuestion().setVisible(true);   
              this.dispose();
           } 
          
           if(ae.getSource()==networkMenuItem){
              new createNetworkQuestion().setVisible(true);   
              this.dispose();
           } 
           
            if(ae.getSource()==ethicsMenuItem){
              new createEthicsQuestion().setVisible(true);   
              this.dispose();
           } 
           
           if(ae.getSource()==logout){
              new FrontPage().setVisible(true);   
              this.dispose();
           } 
        
        
    }
    
}
