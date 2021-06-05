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
}