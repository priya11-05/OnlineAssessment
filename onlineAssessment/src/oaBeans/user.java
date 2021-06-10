package oaBeans;


@SuppressWarnings("serial")
public class user implements java.io.Serializable
{
private String roll;
private String regid;
private String userType;
private String fname;
private String mname;
private String lname;
private String code;
private String phnNum;
private String pwd;
private String mailId;


public user()
{
}
//roll
public void setRoll(String roll)
{
this.roll=roll;
}
public String getRoll()
{
return roll;
}

//regid
    public void setRegId(String regid)
{
this.regid=regid;
}
public String getRegId()
{
return regid;
}

//usertype
public void setUserType(String userType)
{
this.userType=userType;
}
public String getUserType()
{
return userType;
}

//fname
public void setFname(String fname)
{
this.fname=fname;
}
public String getFname()
{
return fname;
}

//mname
public void setMname(String mname)
{
this.mname=mname;
}
public String getMname()
{
return mname;
}

//lname
public void setLname(String lname)
{
this.lname=lname;
}
public String getLname()
{
return lname;
}
//country code
public void setCode(String code)
{
this.code=code;
}
public String getCode()
{
return code;
}
//phonenum
public void setPhnNum(String phnNum)
{
this.phnNum=phnNum;
}
public String getPhnNum()
{
return phnNum;
}

//password
public void setPass(String pwd)
{
this.pwd=pwd;
}
public String getPass()
{
return pwd;
}

//mailid
public void setMail(String mailId)
{
this.mailId=mailId;
}
public String getMail()
{
return mailId;
}
}