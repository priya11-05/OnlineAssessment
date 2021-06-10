package oaServices;


import oaBeans.user;
import oaDao.afterLoginDAO;
import oaDao.afterRegisterDAO;


public class registerDBdata {
public int FlagReg=0;
public String regUser(user newUser)
{
//int flagReg=0;
String p="";
afterLoginDAO obj1=new afterLoginDAO();
user userArr[]=obj1.getUserFromDB("rollnum",newUser.getRoll());
String regid="";

if(userArr[0].getRegId()!="null")
{ 
//p="this roll number is already registered";
p="1";
}
else
{
afterRegisterDAO obj=new afterRegisterDAO();
regid=obj.insertUserIntoDB(newUser);
if(regid.compareTo("")!=0)
{
p=regid;

}
else
//p="registration unsuccessful";
p="2";
}
return p;
}

}