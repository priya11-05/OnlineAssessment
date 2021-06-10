package oaServices;


import oaBeans.QuestionBean;
import oaDao.AllQuesDao;
import java.util.ArrayList;
import java.util.Collections;


public class QuesDBdata {
public QuestionBean[] getQuestions(String subj)
{
AllQuesDao obj=new AllQuesDao();
QuestionBean[] allQues=obj.getAllQuesFromDB(subj);

QuestionBean[] FinalQues=null;
FinalQues=new QuestionBean[20];

if(allQues[0].getSubj()!="null")
{
int l=allQues.length;
ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<l; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<20; i++) {
            System.out.println(list.get(i));
            FinalQues[i]=new QuestionBean();
            FinalQues[i].setSubj(allQues[list.get(i)].getSubj());
            FinalQues[i].setQuesId(allQues[list.get(i)].getQuesId());
            FinalQues[i].setQues(allQues[list.get(i)].getQues());
            FinalQues[i].setOptn1(allQues[list.get(i)].getOptn1());
            FinalQues[i].setOptn2(allQues[list.get(i)].getOptn2());
            FinalQues[i].setOptn3(allQues[list.get(i)].getOptn3());
            FinalQues[i].setOptn4(allQues[list.get(i)].getOptn4());
            FinalQues[i].setAnswer(allQues[list.get(i)].getAnswer());
        }
        return FinalQues;
       
}
return allQues;
}
}