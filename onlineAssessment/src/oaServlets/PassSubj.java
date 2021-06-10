package oaServlets;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PassSubjURL")
public class PassSubj extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    public PassSubj() {
        super();
      
    }


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
String subj = request.getParameter("subject");
System.out.println("in passSubj"+subj);
String destination="/jsp/Instructions.jsp";
request.setAttribute("subj", subj);

    RequestDispatcher RD = getServletContext().getRequestDispatcher(destination);


RD.forward(request, response);
}


}