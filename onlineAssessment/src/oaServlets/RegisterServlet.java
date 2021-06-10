package oaServlets;




import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import oaBeans.user;
import oaServices.registerDBdata;


@WebServlet("/RegisterServletURL")
public class RegisterServlet extends HttpServlet
{
private static final long serialVersionUID = 1L;
    public RegisterServlet()
    {
        super();
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
user newUser=new user();
System.out.println("Welcome to registration");

newUser.setFname(request.getParameter("first_name"));
newUser.setMname(request.getParameter("middle_name"));
newUser.setLname(request.getParameter("last_name"));

newUser.setRoll(request.getParameter("roll_no"));
newUser.setPhnNum(request.getParameter("mobile"));
newUser.setCode(request.getParameter("area_code"));
newUser.setMail(request.getParameter("email"));

newUser.setPass(request.getParameter("password"));

String message="";
String message2="";

registerDBdata obj=new registerDBdata();
String reg_done=obj.regUser(newUser);   //USR001 

if(reg_done.compareTo("1")!=0 && reg_done.compareTo("2")!=0 && reg_done.compareTo("")!=0 )
{
//response.getWriter().print("<html><body>Your name is successfully registered.</body></html>");
message="Your have been successfully registered!!";

message2=reg_done;
}
else if(reg_done.compareTo("2")==0)
{
message="Sorry, Your name could not be registered!! Please try again.";
//response.getWriter().print("<html><body>Sorry, Your name could not be registered!! Please try again.</body></html>");
}
else if(reg_done.compareTo("1")==0)
{
//response.getWriter().print("<html><body>Sorry, You are already registered.</body></html>");
message="Sorry, this user is already registered!!";
}

String destination="/jsp/viewRegId.jsp";

RequestDispatcher RD = getServletContext().getRequestDispatcher(destination);



//String message="Your name is "+username;
request.setAttribute("message", message);
request.setAttribute("message2", message2);


//System.out.println(message);



RD.forward(request, response);
}


}
