import java.sql.*;
import java.util.ArrayList;
public class student_database {
    public Connection conn;
    PreparedStatement pstmt;
    ResultSet rs=null;
    public student_database()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","");
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    
    public int signup(String name,String email,String address,String gender,String batch,String token)
    {
        int result=0;
        try {
            pstmt=conn.prepareStatement("insert into student (Name,Email,Address,Gender,Batch,Token) values(?,?,?,?,?,?)");
            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setString(3,address);
            pstmt.setString(4,gender);
            pstmt.setString(5,batch);
            pstmt.setString(6,token);
            result=pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
          return result;     
    }
    
    public int adminSignup(String name,String email,String password)
    {
        int result=0;
        try {
            pstmt=conn.prepareStatement("insert into admin (AdminName,AdminEmail,AdminPassword) values(?,?,?)");
            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setString(3,password);
           
            result=pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
          return result;     
    }
    
    
    public int java_question_save(String question,String option1,String option2,String option3,String option4,String CorrectAns){
        int result=0;
        try {
            pstmt=conn.prepareStatement("insert into javaquestion (question,option_1,option_2,option_3,option_4,correct_ans) values(?,?,?,?,?,?)");
            pstmt.setString(1,question);
            pstmt.setString(2,option1);
            pstmt.setString(3,option2);
            pstmt.setString(4,option3);
            pstmt.setString(5,option4);
            pstmt.setString(6,CorrectAns);
            result=pstmt.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
          return result;     
    }
    
     public int web_question_save(String Webquestion,String Weboption1,String Weboption2,String Weboption3,String Weboption4,String WebCorrectAns){
        int result=0;
        try {
            pstmt=conn.prepareStatement("insert into webquestion (webquestion,weboption_1,weboption_2,weboption_3,weboption_4,webcorrectans) values(?,?,?,?,?,?)");
            pstmt.setString(1,Webquestion);
            pstmt.setString(2,Weboption1);
            pstmt.setString(3,Weboption2);
            pstmt.setString(4,Weboption3);
            pstmt.setString(5,Weboption4);
            pstmt.setString(6,WebCorrectAns);
            result=pstmt.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
          return result;       
    }
     
     
     
    public int network_question_save(String netquestion,String netoption1,String netoption2,String netoption3,String netoption4,String netCorrectAns){
        int result=0;
        try {
            pstmt=conn.prepareStatement("insert into networkquestion (NetQuestion,NetOption1,NetOption2,NetOption3,NetOption4,NetCorrectAns) values(?,?,?,?,?,?)");
            pstmt.setString(1,netquestion);
            pstmt.setString(2,netoption1);
            pstmt.setString(3,netoption2);
            pstmt.setString(4,netoption3);
            pstmt.setString(5,netoption4);
            pstmt.setString(6,netCorrectAns);
            result=pstmt.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
          return result;       
    }
     
     public int ethics_question_save(String ethicsquestion,String ethicsoption1,String ethcisoption2,String ethcisoption3,String ethicsoption4,String ethicsCorrectAns){
        int result=0;
        try {
            pstmt=conn.prepareStatement("insert into ethicsquestion (ethicsQuestion,ethicsOption1,ethicsOption2,ethicsOption3,ethicsOption4,ethicsCorrectAns) values(?,?,?,?,?,?)");
            pstmt.setString(1,ethicsquestion);
            pstmt.setString(2,ethicsoption1);
            pstmt.setString(3,ethcisoption2);
            pstmt.setString(4,ethcisoption3);
            pstmt.setString(5,ethicsoption4);
            pstmt.setString(6,ethicsCorrectAns);
            result=pstmt.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
          return result;       
    }
    
     public ResultSet FetchData(String query){
         try{
         pstmt=conn.prepareStatement(query);
         rs=pstmt.executeQuery();
         }
         catch(Exception e)
         {
         }
         return rs;
    
    }
     
     public ArrayList<setsQuestion> javaQuestionDisplayFunction() throws SQLException{
        ArrayList<setsQuestion> java = new ArrayList<setsQuestion>();
        String query = "Select * from javaquestion";
        
        student_database dbc = new student_database();
	ResultSet rs = dbc.FetchData(query);
	setsQuestion qs;
	while (rs.next()) {
		qs = new setsQuestion(rs.getInt("question_id"),rs.getString("question"), rs.getString("Option_1"), rs.getString("Option_2"),rs.getString("Option_3"), rs.getString("Option_4"), rs.getString("correct_ans"));
                java.add(qs);
	}
	return java;  
     }
     
     
     public ArrayList<setsQuestion> webQuestiondisplayFunction() throws SQLException{
        ArrayList<setsQuestion> web = new ArrayList<setsQuestion>();
        String query = "Select * from webquestion";
        
        student_database dbc = new student_database();
	ResultSet rs = dbc.FetchData(query);
	setsQuestion qs;
	while (rs.next()) {
		qs = new setsQuestion(rs.getInt("web_questionId"),rs.getString("webquestion"), rs.getString("weboption_1"), rs.getString("weboption_2"),rs.getString("weboption_3"), rs.getString("weboption_4"), rs.getString("webcorrectans"));
                web.add(qs);
	}
	return web;  
     }
     
     
     public ArrayList<setsQuestion> networkQuestionDisplayFunc() throws SQLException{
        ArrayList<setsQuestion> network = new ArrayList<setsQuestion>();
        String query = "Select * from networkquestion";
        
        student_database dbc = new student_database();
	ResultSet rs = dbc.FetchData(query);
	setsQuestion qs;
	while (rs.next()) {
		qs = new setsQuestion(rs.getInt("NetworkQuestionId"),rs.getString("NetQuestion"), rs.getString("NetOption1"), rs.getString("NetOption2"),rs.getString("NetOption3"), rs.getString("NetOption4"), rs.getString("NetCorrectAns"));
                network.add(qs);
	}
	return network;  
     }
     
     
      public ArrayList<setsQuestion> ethicsQuestionDisplay() throws SQLException{
        ArrayList<setsQuestion> ethics = new ArrayList<setsQuestion>();
        String query = "Select * from ethicsquestion";
        
        student_database dbc = new student_database();
	ResultSet rs = dbc.FetchData(query);
	setsQuestion qs;
	while (rs.next()) {
		qs = new setsQuestion(rs.getInt("ethicsQuestionId"),rs.getString("ethicsQuestion"), rs.getString("ethicsOption1"), rs.getString("ethicsOption2"),rs.getString("ethicsOption3"), rs.getString("ethicsOption4"), rs.getString("ethicsCorrectAns"));
                ethics.add(qs);
	}
	return ethics;  
     }
     
}
