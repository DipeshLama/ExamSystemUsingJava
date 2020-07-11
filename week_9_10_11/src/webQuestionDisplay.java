import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
public class webQuestionDisplay extends JFrame implements ActionListener{
    JLabel Question[] = new JLabel[10];
    JRadioButton[] opt1 = new JRadioButton[10];
    JRadioButton[] opt2 = new JRadioButton[10];
    JRadioButton[] opt3 = new JRadioButton[10];
    JRadioButton[] opt4 = new JRadioButton[10];
    JPanel mainqstnpanel;
    ButtonGroup[] group= new ButtonGroup[10];
    String[] userchoseenAns = new String[10];
    int marks = 0;
     ArrayList<setsQuestion> qna = new ArrayList<setsQuestion>();
        student_database db = new student_database();   
        JButton btnNext;
        JButton btnPrevious;
        JButton btnFinish;
        int counter=-1;
        private JPanel[] QuestionPane;
        private JLabel[] Questions;
        private ButtonGroup[] BtnGrp;
        private JRadioButton[] option1;
        private JRadioButton[] option2;
        private JRadioButton[] option3;
        private JRadioButton[] option4;
        private JPanel btnPane;
        private final JPanel qstnpane;
    
        public webQuestionDisplay() throws SQLException{
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        setResizable(false);
        
        mainqstnpanel = new JPanel();
        mainqstnpanel.setBounds(0,0,700,700);
        mainqstnpanel.setLayout(null);
        add(mainqstnpanel);
        
        qstnpane = new JPanel();
        qstnpane.setBounds(0,0,700,400);
        qstnpane.setLayout(null);
        mainqstnpanel.add(qstnpane);
        
        btnNext= new JButton("Next");
        btnNext.setBounds(500,200,70,30);
        btnNext.setBackground(Color.black); 
        btnNext.setForeground(Color.white);
        btnNext.addActionListener(this);
        
        btnPane = new JPanel();
        btnPane.setBounds(0,350,600,250);
   
        btnPane.setLayout(null);
        btnPane.add(btnNext);
        
        mainqstnpanel.add(btnPane);
        
        btnPrevious= new JButton("Previous");
        btnPrevious.setBounds(200,200,100,30);
        btnPrevious.setBackground(Color.orange);
        btnPrevious.addActionListener(this);
        btnPane.add(btnPrevious);
      
        btnFinish= new JButton("Finish");
        btnFinish.setBounds(500,200,70,30);
        btnFinish.setVisible(false);
        btnFinish.addActionListener(this);
        btnPane.add(btnFinish);
        
        qna =db.webQuestiondisplayFunction();
        Collections.shuffle(qna);
        dynamicQuestionPanel(qna);
        }
        
        
      
        
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == btnNext) {
            counter=counter+1;
            if (option1[counter].isSelected() || option2[counter].isSelected() || option3[counter].isSelected()|| option4[counter].isSelected()) {
                // group[counter].getSelection().getActionCommand();
                userchoseenAns[counter] = BtnGrp[counter].getSelection().getActionCommand();
                 if (userchoseenAns[counter].equals(qna.get(counter).correctAnswer())) {
                     
                marks = marks + 1;
            }
                
            }
            else{
                userchoseenAns[counter] = null;
            }
           
            
            if (counter==8) {
                btnNext.setVisible(false);
                btnFinish.setVisible(true);
            }
            addPanel(counter);
        }
        
        
        if (e.getSource() == btnPrevious) {
            counter=counter-1;
            addPanel(counter);
            if (option1[counter].isSelected() || option2[counter].isSelected() || option3[counter].isSelected()|| option4[counter].isSelected()) {
                // group[counter].getSelection().getActionCommand();
                userchoseenAns[counter] = BtnGrp[counter].getSelection().getActionCommand();
                
            }
            else{
                userchoseenAns[counter] = null;
            }
            
            if (counter==7) {
                btnNext.setVisible(true);
                btnFinish.setVisible(false);
            }
        }
        
        
        if (e.getSource().equals(btnFinish)) {
        
            if (option1[counter].isSelected() || option2[counter].isSelected() || option3[counter].isSelected()|| option4[counter].isSelected()) {
                // group[counter].getSelection().getActionCommand();
                userchoseenAns[counter] = BtnGrp[counter].getSelection().getActionCommand();
                 if (userchoseenAns[counter].equals(qna.get(counter).correctAnswer())) {
                     
                marks = marks + 1;
            }
                
            }
            
            JOptionPane.showMessageDialog(null, "You scored " + marks);
            this.dispose();
            new student_module_select().setVisible(true);
        }
        
        
    }
    
    public void dynamicQuestionPanel(ArrayList<setsQuestion> questionList){
	QuestionPane = new JPanel[10];
	Questions = new JLabel[10];
	BtnGrp = new ButtonGroup[10];
	option1 = new JRadioButton[10];
	option2 = new JRadioButton[10];
	option3 = new JRadioButton[10];
	option4 = new JRadioButton[10];
	
	
	for (int i = 0; i < 10; i++) {
		QuestionPane[i] = new JPanel();
		QuestionPane[i].setBounds(0, 0, 700, 400);
		QuestionPane[i].setLayout(null);
                
		qstnpane.add(QuestionPane[0]);
		
		
		
		Questions[i] = new JLabel("<html>Q"+(i+1)+".   "+questionList.get(i).getQuestion()+"</html>");
		Questions[i].setFont(new Font("SansSerif", Font.PLAIN, 17));
		Questions[i].setBounds(20, 80, 700, 50);
		QuestionPane[i].add(Questions[i]);
		
		BtnGrp[i]= new ButtonGroup();
		
		option1[i] = new JRadioButton("<html>"+qna.get(i).getOption1()+"</html>");
		option1[i].setBounds(20, 167, 670, 35);
		option1[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option1[i].setActionCommand(qna.get(i).getOption1());
		BtnGrp[i].add(option1[i]);
		QuestionPane[i].add(option1[i]);
		
		option2[i] = new JRadioButton("<html>"+qna.get(i).getOption2()+"</html>");
		option2[i].setBounds(20, 206, 670, 35);
		option2[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option2[i].setActionCommand(questionList.get(i).getOption2());
		BtnGrp[i].add(option2[i]);
		QuestionPane[i].add(option2[i]);
		
		option3[i] = new JRadioButton("<html>"+qna.get(i).getOption3()+"</html>");
		option3[i].setBounds(20, 245, 670, 35);
		option3[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option3[i].setActionCommand(questionList.get(i).getOption3());
		BtnGrp[i].add(option3[i]);
		QuestionPane[i].add(option3[i]);
		
		option4[i] = new JRadioButton("<html>"+qna.get(i).getOption4()+"</html>");
		option4[i].setBounds(20, 284, 670, 35);
		option4[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option4[i].setActionCommand(qna.get(i).getOption4());
		BtnGrp[i].add(option4[i]);
		QuestionPane[i].add(option4[i]);
		
	}	

        }
        
     public void addPanel(int counter){
       qstnpane.removeAll();
       qstnpane.add(QuestionPane[counter+1]);
       qstnpane.repaint();
       qstnpane.revalidate();
}
    
    
}

