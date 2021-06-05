package oaServlets;

import oaServices.getDBdata;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
String regID=request.getParameter("regID");
String pwd=request.getParameter("userpwd");
String userType=request.getParameter("usertype");
System.out.println("registration id:"+regID+" and password:"+pwd);
System.out.println("hello");

getDBdata obj1=new getDBdata();

String name=obj1.getName(regID,pwd,userType);

if(name=="")
response.getWriter().print("<html><body>Invalid Entry!! Please Try again</body></html>");
else
response.sendRedirect("html/chooseSubj.html");  
}

}