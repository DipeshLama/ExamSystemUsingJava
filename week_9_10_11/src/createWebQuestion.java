import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class createWebQuestion extends JFrame implements ActionListener {
    JLabel Webdisplaylabel,Webdisplaylabel2,Weblabelopt1,Weblabelopt2,Weblabelopt3,Weblabelopt4,Webcorrect_label;
    JTextField Webtxtqstn,Webtxtopt1,Webtxtopt2,Webtxtopt3,Webtxtopt4,Webcorrecttxt;
    JButton btnAddWeb,btnclearWeb,btnBack;
    
     
    public createWebQuestion(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,600);
        setTitle("Add Questions"); 
        setLayout(null);
        setResizable(false);
        
        Webdisplaylabel=new JLabel("Add Web questions here");
        Webdisplaylabel.setBounds(110,10,250,50);
        Webdisplaylabel.setFont(new Font("serif",Font.PLAIN,25));
        
        Webtxtqstn=new JTextField();
        Webtxtqstn.setBounds(40,70,400,60);
        
        Webdisplaylabel2=new JLabel("Options");
        Webdisplaylabel2.setBounds(120,135,50,20);
        
        Weblabelopt1=new JLabel("1.");
        Weblabelopt1.setBounds(50,165,20,20);
        Webtxtopt1=new JTextField();
        Webtxtopt1.setBounds(120,160,200,30);
        
        Weblabelopt2=new JLabel("2.");
        Weblabelopt2.setBounds(50,215,20,20);
        Webtxtopt2=new JTextField();
        Webtxtopt2.setBounds(120,210,200,30);
        
        Weblabelopt3=new JLabel("3.");
        Weblabelopt3.setBounds(50,265,20,20);
        Webtxtopt3=new JTextField();
        Webtxtopt3.setBounds(120,260,200,30);
        
        Weblabelopt4=new JLabel("4.");
        Weblabelopt4.setBounds(50,315,20,20);
        Webtxtopt4=new JTextField();
        Webtxtopt4.setBounds(120,310,200,30);
        
        Webcorrect_label=new JLabel("Correct Answer");
        Webcorrect_label.setBounds(20,365,100,20);
        Webcorrecttxt=new JTextField();
        Webcorrecttxt.setBounds(120,360,200,30);
        
       /* comboLabel=new JLabel("Correct Answer");
        comboLabel.setBounds(5,365,100,20);
        comboAns=new JComboBox();
        comboAns.addItem("");
        comboAns.addItem("");
        comboAns.addItem("");
        comboAns.addItem("");
        comboAns.setBounds(120,360,200,30);*/
       
        btnAddWeb=new JButton("Add");
        btnAddWeb.setBounds(150,500,80,30);
        btnAddWeb.addActionListener(this);
        btnclearWeb=new JButton("Clear");
        btnclearWeb.setBounds(250,500,80,30);
        btnclearWeb.addActionListener(this);
        
        btnBack=new JButton("Back");
        btnBack.setBounds(350,500,80,30);
        btnBack.addActionListener(this);
        
        add(Webdisplaylabel);
        add(Webdisplaylabel2);
        add(Webtxtqstn);
        add(Weblabelopt1);
        add(Webtxtopt1);
        add(Weblabelopt2);
        add(Webtxtopt2);
        add(Weblabelopt3);
        add(Webtxtopt3);
        add(Weblabelopt4);
        add(Webtxtopt4);
        add(Webcorrect_label);
        add(Webcorrecttxt);
        add(btnAddWeb);
        add(btnclearWeb);
        add(btnBack);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
             if(ae.getSource().equals(btnAddWeb)){
                student_database db=new student_database();     
                String question=Webtxtqstn.getText().toString();
                String opt1=Webtxtopt1.getText().toString();
                String opt2=Webtxtopt2.getText().toString();
                String opt3=Webtxtopt3.getText().toString();
                String opt4=Webtxtopt4.getText().toString();
                String rightAns=Webcorrecttxt.getText().toString();
                if(question.isEmpty() || opt1.isEmpty() || opt2.isEmpty() ||opt3.isEmpty() || opt4.isEmpty() || rightAns.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Fill out all the fields");
                }
                
                else
                { 
                int result=db.web_question_save(question,opt1,opt2,opt3,opt4,rightAns);               
                if (result>0)
                {
                    JOptionPane.showMessageDialog(null,"Saved");                                
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Unable to saved");
                }
             }   
           }
         }
         catch(Exception e){
             
         }
        if(ae.getSource().equals(btnclearWeb)){
            Webtxtqstn.setText(null);
            Webtxtopt1.setText(null);
            Webtxtopt2.setText(null);
            Webtxtopt3.setText(null);
            Webtxtopt4.setText(null);
            Webcorrecttxt.setText(null);
        }
        
        if(ae.getSource().equals(btnBack)){
            new administrator_dashboard().setVisible(true);
            this.dispose();
        }
    }  
}
