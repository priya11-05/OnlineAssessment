package oaServices;
import oaBeans.user;

import oaDao.afterLoginDAO;;
public class getDBdata
{
public String getName(String regId,String pwd, String userType)
{
String name="";
String ut="";
String a;
afterLoginDAO obj=new afterLoginDAO();
user userArr[]=obj.getNameFromDB();

for(int i=0;i<userArr.length;i++)
{
//if(Integer.parseInt(rollnum)==stuarr[i].getID())
//System.out.println(userArr[i].getRegId());
a=userArr[i].getUserType().substring(0,1);
if(a.compareTo("T")==0)
ut="Teacher";
else if(a.compareTo("A")==0)
ut="Admin";
else if(a.compareTo("S")==0)
ut="Student";
if((regId.compareTo(userArr[i].getRegId()))==0 && (pwd.compareTo(userArr[i].getPass()))==0 && (userType.compareTo(ut))==0)
{
name=userArr[i].getFname();
break;
}
}
return name;
}
}