package oaServlets;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import oaBeans.QuestionBean;
import oaServices.QuesDBdata;


@WebServlet("/ExamQuesServletURL")
public class ExamQuesServlet extends HttpServlet
{
private static final long serialVersionUID = 1L;
  
    public ExamQuesServlet() {
        super();
        
    }



protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
String sub = request.getParameter("subject");
System.out.println("in examquesservlet,"+sub);
String message="",destination="/jsp/QuestionPaper.jsp";
QuesDBdata obj=new QuesDBdata();
QuestionBean[] FinalQues=obj.getQuestions(sub);
if(FinalQues[0].getSubj()!="null")
{
int l=FinalQues.length;
System.out.println("Inservlet, length="+l);
message="QUESTIONS:";
    /*for(int i=0;i<l;i++)
    {
    System.out.println(FinalQues[i].getQues());
    System.out.println(FinalQues[i].getOptn1());
    System.out.println(FinalQues[i].getOptn2());
    System.out.println(FinalQues[i].getOptn3());
    System.out.println(FinalQues[i].getOptn4());
    System.out.println(FinalQues[i].getAnswer());
    System.out.println();
    System.out.println();
    }*/
}
else
{
message="This Subject is not available. Please select another subject.";
}
request.setAttribute("FinalQues", FinalQues);
request.setAttribute("message", message);
    RequestDispatcher RD = getServletContext().getRequestDispatcher(destination);


RD.forward(request, response);
    
}


}