package oaDao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import oaBeans.user;


public class afterRegisterDAO {
static String DB_URL="jdbc:mysql://examdb.cqz6xsqboad9.us-east-2.rds.amazonaws.com/examschema";
static String DB_USER="TD";
static String DB_PWD="priya2000";

public String insertUserIntoDB(user newUser)
{
String regid="";
String fname=newUser.getFname();
String mname=newUser.getMname();
String lname=newUser.getLname();
String rnum=newUser.getRoll();
String code=newUser.getCode();
String phn=newUser.getPhnNum();
String pwd=newUser.getPass();
String mailid=newUser.getMail();


int count;
boolean s=false;
//String sqlQuery="INSERT INTO user (regId,userType,fname,mname,lname,rollnum,phonenum,pass,mailId) VALUES (" + S1+","A","Tiyasa","De",0,"7596972245","123","tusude2000@gmail.com")";

String sqlQuery="INSERT INTO user(userType,fname,mname,lname,rollnum,countrycode,phonenum,pass,mailId)VALUES(\"Student\",\""+fname+"\",\""+mname+"\",\""+lname+"\",\""+rnum+"\",\""+code+"\",\""+phn+"\",\""+pwd+"\",\""+mailid+"\");";

System.out.println("After insert query");

//String sqlQuery="insert into testTable(rollnum ,stuname) values (3,\"ratul\");";
try
{  
Class.forName("com.mysql.cj.jdbc.Driver"); 
//System.out.println("After class");
Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
//System.out.println("After connection");
PreparedStatement pstmt = con.prepareStatement(sqlQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//System.out.println("After pstmt");
//ResultSet rs=pstmt.executeQuery();
count = pstmt.executeUpdate();
//System.out.println("After executeupdate");
s = (count > 0);
if(s==true)
{
String sqlQuery2="Select regId from user where mailId=\""+mailid+"\";";
PreparedStatement pstmt2 = con.prepareStatement(sqlQuery2,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
ResultSet rs=pstmt2.executeQuery();
rs.next();
regid=(rs.getString("regId"));


}
con.close();
//System.out.println("After close");
}
catch(Exception e)
{
System.out.println(e); 
}
return regid;
}
}