package oaBeans;


@SuppressWarnings("serial")
public class QuestionBean implements java.io.Serializable //bean class for questions
{
private String subj;
private String quesid;
private String ques;
private String optn1;
private String optn2;
private String optn3;
private String optn4;
private String answer;


public QuestionBean() //constructor
{
}

//subject
public void setSubj(String subj)
{
this.subj=subj;
}
public String getSubj()
{
return subj;
}

//question_id
    public void setQuesId(String quesid)
{
this.quesid=quesid;
}
public String getQuesId()
{
return quesid;
}

//question
public void setQues(String ques)
{
this.ques=ques;
}
public String getQues()
{
return ques;
}

//option1
public void setOptn1(String optn1)
{
this.optn1=optn1;
}
public String getOptn1()
{
return optn1;
}

//option2
public void setOptn2(String optn2)
{
this.optn2=optn2;

}
public String getOptn2()
{
return optn2;
}

//option3
public void setOptn3(String optn3)
{
this.optn3=optn3;
}
public String getOptn3()
{
return optn3;
}

//option4
public void setOptn4(String optn4)
{
this.optn4=optn4;
}
public String getOptn4()
{
return optn4;
}

//answer
public void setAnswer(String answer)
{
this.answer=answer;
}
public String getAnswer()
{
return answer;
}

}