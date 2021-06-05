package oaServices;

import oaBeans.user;
import oaDao.afterLoginDAO;
import oaDao.afterRegisterDAO;

public class registerDBdata {
public int FlagReg=0;
public String regUser(String fname,String mname,String lname,String rnum,String code, String phn,String mailid,String pwd)
{
//int flagReg=0;
String p="none";
afterLoginDAO obj1=new afterLoginDAO();
user userArr[]=obj1.getNameFromDB();
try
{
for(int i=0;i<userArr.length;i++)
{
if(Integer.parseInt(rnum)==userArr[i].getRoll())
{
FlagReg=1;
break;
}
}
if(FlagReg==0)
{
afterRegisterDAO obj=new afterRegisterDAO();
p=obj.insertUserIntoDB(fname,mname,lname,rnum,code,phn,mailid,pwd);
return p;
}
else
return p;
}
catch(Exception e)
{
return p;
}
}
}