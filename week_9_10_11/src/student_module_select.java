import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class student_module_select extends JFrame implements ActionListener {
    JMenuBar selectModuleMenu;
    JMenu SelectModule;
    JMenuItem java,web,network,ethics;
    JButton logout;
    JLabel displayLabel;
    
    public student_module_select(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c=getContentPane();
        setSize(600,400);
        c.setLayout(null);
        setResizable(false);
        
        displayLabel=new JLabel("Select module from Menu");
        displayLabel.setBounds(140,120,400,30);
        displayLabel.setFont(new Font("DIALOG",Font.BOLD,25));
        add(displayLabel);
        
        selectModuleMenu=new JMenuBar();
        SelectModule=new JMenu("Select Module");
        java=new JMenuItem("Java");
        web=new JMenuItem("Web");
        network=new JMenuItem("Network");
        ethics=new JMenuItem("Ethics");
        
        
        selectModuleMenu.add(SelectModule);
        SelectModule.add(java);
        SelectModule.add(web);
        SelectModule.add(network);
        SelectModule.add(ethics);
        
        add(selectModuleMenu);
        setJMenuBar(selectModuleMenu);
        java.addActionListener(this);
        web.addActionListener(this);
        network.addActionListener(this);
        ethics.addActionListener(this);
        
        logout=new JButton("Log out");
        logout.setBounds(240,200,80,30);
        logout.addActionListener(this);
        add(logout);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
         
        if(ae.getSource().equals(java)){
            try {
                new javaQuestionDisplay().setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(student_module_select.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       }
             
        
        
       if (ae.getSource().equals(web)){
            try {
                new webQuestionDisplay().setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(student_module_select.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
       
       if (ae.getSource().equals(network)){
            try {
                new networkQuestionDisplay().setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(student_module_select.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
       
        if (ae.getSource().equals(ethics)){
            try {
                new ethicsQuestionDisplay().setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(student_module_select.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
       
         if(ae.getSource()==logout){
              new FrontPage().setVisible(true);   
              this.dispose();
           } 
    }
    
    
    
}
