package oaDao;


import oaBeans.QuestionBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AllQuesDao {


static String DB_URL="jdbc:mysql://examdb.cqz6xsqboad9.us-east-2.rds.amazonaws.com/examschema";
static String DB_USER="TD";
static String DB_PWD="priya2000";

public QuestionBean[] getAllQuesFromDB(String subj)
{
QuestionBean[] quesArr=null;
int rowcount=0,i=0;
String sqlQuery="Select * from questions where subject_name=\""+subj+"\";";
try
{  
System.out.println("immediate after try");
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
PreparedStatement pstmt = con.prepareStatement(sqlQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
ResultSet rs=pstmt.executeQuery();
System.out.println("after executing query");
      if(rs!=null)
      {
           rs.last();
           rowcount=rs.getRow();
      }
      if(rowcount==0)
      {
      System.out.println("in size=0");
      quesArr=new QuestionBean[1];
      quesArr[0]=new QuestionBean();
      quesArr[0].setSubj("null");
      }
      else
      {
      System.out.println("Size="+rowcount);
      quesArr=new QuestionBean[rowcount];
      rs.beforeFirst();
      while(rs.next())  
      {
      quesArr[i]=new QuestionBean();
      quesArr[i].setSubj(rs.getString("subject_name"));
      quesArr[i].setQuesId(rs.getString("quesId"));
      quesArr[i].setQues(rs.getString("question"));
      quesArr[i].setOptn1(rs.getString("optn1"));
      quesArr[i].setOptn2(rs.getString("optn2"));
      quesArr[i].setOptn3(rs.getString("optn3"));
  quesArr[i].setOptn4(rs.getString("optn4"));
  quesArr[i].setAnswer(rs.getString("answer"));

  i++;

//System.out.println("in while block");
      }
      }
con.close();
}
catch(Exception e)
{
quesArr=new QuestionBean[1];
    quesArr[0]=new QuestionBean();
    quesArr[0].setSubj("null");
    System.out.println("in catch");
    System.out.println(e);
}
return quesArr;
}
}