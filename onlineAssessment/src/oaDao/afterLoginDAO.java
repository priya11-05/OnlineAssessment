/*package oaDao;
import oaBeans.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class afterLoginDAO
{
static String DB_URL="jdbc:mysql://examdb.cqz6xsqboad9.us-east-2.rds.amazonaws.com/examschema";
static String DB_USER="TD";
static String DB_PWD="priya2000";

public user[] getNameFromDB()
{
user[] userArr = null;
int i=0;
String sqlQuery="select * from user";

try
{  
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
PreparedStatement pstmt = con.prepareStatement(sqlQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
ResultSet rs=pstmt.executeQuery();
int rowCount = 0;
     while (rs.next())
     {
          rowCount++;
     }
   userArr=new user[rowCount];
rs.beforeFirst();
while(rs.next())  
{
userArr[i]=new user();
userArr[i].setRoll(rs.getInt("rollnum"));
userArr[i].setRegId(rs.getString("regId"));
userArr[i].setUserType(rs.getString("userType"));
userArr[i].setFname(rs.getString("fname"));
userArr[i].setMname(rs.getString("mname"));
userArr[i].setLname(rs.getString("lname"));
userArr[i].setCode(rs.getString("countrycode"));
userArr[i].setPhnNum(rs.getString("phonenum"));
userArr[i].setPass(rs.getString("pass"));
userArr[i].setMail(rs.getString("mailId"));
i++;
}
con.close();
}
catch(Exception e)
{
System.out.println(e);
}
return userArr;
}
}*/


package oaDao;
import oaBeans.user;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class afterLoginDAO 
{
static String DB_URL="jdbc:mysql://examdb.cqz6xsqboad9.us-east-2.rds.amazonaws.com/examschema";
static String DB_USER="TD";
static String DB_PWD="priya2000";

public user[] getUserFromDB(String prop,String val)
{
user[] userArr = null;
int i=0,size=0;
String sqlQuery="select * from user where "+prop+"=\""+val+"\";";
System.out.println("After setting query");
System.out.println(prop+"  "+val);
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
           size=rs.getRow();
      }
      if(size==0)
      {
      System.out.println("in size=0");
      userArr=new user[1];
      userArr[0]=new user();
      userArr[0].setRegId("null");
      }
      else
      {
      System.out.println("Size="+size);
      userArr=new user[size];
      rs.beforeFirst();
      while(rs.next())  
      {
userArr[i]=new user();
userArr[i].setRoll(rs.getString("rollnum"));
userArr[i].setRegId(rs.getString("regId"));
userArr[i].setUserType(rs.getString("userType"));
userArr[i].setFname(rs.getString("fname"));
userArr[i].setMname(rs.getString("mname"));
userArr[i].setLname(rs.getString("lname"));
userArr[i].setCode(rs.getString("countrycode"));
userArr[i].setPhnNum(rs.getString("phonenum"));
userArr[i].setPass(rs.getString("pass"));
userArr[i].setMail(rs.getString("mailId"));
i++;

System.out.println("in while block of afterlogindao");
      }
      }
con.close();
}
catch(Exception e)
{
userArr=new user[1];
    userArr[0]=new user();
    userArr[0].setRegId("null");
    System.out.println("in catch");
    System.out.println(e);
}
return userArr;
}
}