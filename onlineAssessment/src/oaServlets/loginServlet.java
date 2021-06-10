package oaServlets;


import oaServices.getDBdata; 
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import oaBeans.user;


@WebServlet("/loginServletURL")
public class loginServlet extends HttpServlet
{
private static final long serialVersionUID = 1L;
   
    public loginServlet()
    {
        super();
    }


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
System.out.println("in login servlet");

user loginUser=new user();
user loginUser1=new user();
//user obj -> regId,pass,usertype
loginUser.setRegId(request.getParameter("regID")); //USR011
loginUser.setUserType(request.getParameter("usertype"));
loginUser.setPass(request.getParameter("userpwd"));

String message="",destination="/jsp/loginFailure.jsp";

getDBdata obj1=new getDBdata();
loginUser1=obj1.getUser(loginUser);

//loginUser1-> regId, pwd,usertype,fname,maname,lname,email,phn,code

//String name=obj1.getName(regID,pwd,userType);
int respCode=obj1.respCode;

switch(respCode)
{
case 0:
message="Invalid Combination of Username / Password / user type.";
break;
case 1:
message="Login Successful!!";
request.setAttribute("loginUsers", loginUser1);
//System.out.println(loginUser.getRegId());
destination="/jsp/afterLogin.jsp";
break;
case 2:
message="This registration ID doesn't exist. Please register.";
break;
default:
message="Login failed.";
}

RequestDispatcher RD = getServletContext().getRequestDispatcher(destination);
 

request.setAttribute("message", message);



RD.forward(request, response);


}


}