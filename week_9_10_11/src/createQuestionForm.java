import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class createQuestionForm extends JFrame implements ActionListener
     {
    JLabel displaylabel,displaylabel2,labelopt1,labelopt2,labelopt3,labelopt4,comboLabel,correct_label;
    JTextField txtqstn,txtopt1,txtopt2,txtopt3,txtopt4,correcttxt;
  
    JButton btnAdd,btnclear,btnBack;
    
    public createQuestionForm (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,600);
        setTitle("Add Questions"); 
        setBackground(Color.yellow);
        setLayout(null);
        
        
        displaylabel=new JLabel("programming Questions");
        displaylabel.setBounds(110,10,300,50);
        displaylabel.setFont(new Font("serif",Font.BOLD,25));
        
        txtqstn=new JTextField();
        txtqstn.setBounds(40,70,400,60);
        
        displaylabel2=new JLabel("Options");
        displaylabel2.setBounds(120,135,50,20);
        
        labelopt1=new JLabel("1.");
        labelopt1.setBounds(50,165,20,20);
        txtopt1=new JTextField();
        txtopt1.setBounds(120,160,200,30);
        
        labelopt2=new JLabel("2.");
        labelopt2.setBounds(50,215,20,20);
        txtopt2=new JTextField();
        txtopt2.setBounds(120,210,200,30);
        
        labelopt3=new JLabel("3.");
        labelopt3.setBounds(50,265,20,20);
        txtopt3=new JTextField();
        txtopt3.setBounds(120,260,200,30);
        
        labelopt4=new JLabel("4.");
        labelopt4.setBounds(50,315,20,20);
        txtopt4=new JTextField();
        txtopt4.setBounds(120,310,200,30);
        
        correct_label=new JLabel("Correct Answer");
        correct_label.setBounds(20,365,100,20);
        correcttxt=new JTextField();
        correcttxt.setBounds(120,360,200,30);
        
       /* comboLabel=new JLabel("Correct Answer");
        comboLabel.setBounds(5,365,100,20);
        comboAns=new JComboBox();
        comboAns.addItem("");
        comboAns.addItem("");
        comboAns.addItem("");
        comboAns.addItem("");
        comboAns.setBounds(120,360,200,30);*/
       
        btnAdd=new JButton("Add");
        btnAdd.setBounds(150,420,80,30);
        btnAdd.addActionListener(this);
        
        btnclear=new JButton("Clear");
        btnclear.setBounds(250,420,80,30);
        btnclear.addActionListener(this);
        
        btnBack=new JButton("Back");
        btnBack.setBounds(350,420,80,30);
        btnBack.addActionListener(this);
        
        
        add(displaylabel);
        add(displaylabel2);
        add(txtqstn);
        add(labelopt1);
        add(txtopt1);
        add(labelopt2);
        add(txtopt2);
        add(labelopt3);
        add(txtopt3);
        add(labelopt4);
        add(txtopt4);
        add(correct_label);
        add(correcttxt);
      //  add(comboAns);
      //  add(comboLabel);
        add(btnAdd);
        add(btnclear);
        add(btnBack);
 }
    
              
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try{
             if(ae.getSource().equals(btnAdd)){
                student_database db=new student_database();     
                String question=txtqstn.getText().toString();
                String opt1=txtopt1.getText().toString();
                String opt2=txtopt2.getText().toString();
                String opt3=txtopt3.getText().toString();
                String opt4=txtopt4.getText().toString();
                String rightAns=correcttxt.getText().toString();
                
                 if(question.isEmpty() || opt1.isEmpty() || opt2.isEmpty() ||opt3.isEmpty() || opt4.isEmpty() || rightAns.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Fill out all the fields");
                }
                
               else{
                int result=db.java_question_save(question,opt1,opt2,opt3,opt4,rightAns);               
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
        
        if(ae.getSource().equals(btnclear)){
            txtqstn.setText(null);
            txtopt1.setText(null);
            txtopt2.setText(null);
            txtopt3.setText(null);
            txtopt4.setText(null);
            correcttxt.setText(null);
        }
        
        if(ae.getSource().equals(btnBack)){
            new administrator_dashboard().setVisible(true);
            this.dispose();
        }
    }
}