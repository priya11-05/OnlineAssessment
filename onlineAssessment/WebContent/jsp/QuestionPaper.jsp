<%@page import="oaBeans.QuestionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Question Paper</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleQuestionPaper.css">
</head>
<body>
<h1><%= request.getAttribute("message") %></h1>
<% String m=String.valueOf(request.getAttribute("message")); %>
<% if(m.compareTo("QUESTIONS:")==0){ %>
<% QuestionBean[] ques = (QuestionBean[])request.getAttribute("FinalQues"); %>
<%  int l=ques.length; %>



<form method="post" action="#">
<% for(int i=0;i<l;i++)
{ %>
<div class="question">
<h3><%= ques[i].getQues() %></h3>
</div>
<div class="options">
<input type="radio" name="<%= i %>" value="<%= ques[i].getOptn1() %>">
<label for="ques1"><%= ques[i].getOptn1() %></label><br>

<input type="radio" name="<%= i %>" value="<%= ques[i].getOptn2() %>">
<label for="ques1"><%= ques[i].getOptn2() %></label><br>

<input type="radio" name="<%= i %>" value="<%= ques[i].getOptn3() %>">
<label for="ques1"><%= ques[i].getOptn3() %></label><br>

<input type="radio" name="<%= i %>" value="<%= ques[i].getOptn4() %>">
<label for="ques1"><%= ques[i].getOptn4() %></label><br>
</div>
<% } %>
<button type="submit" class="button"><span>Submit Test</span></button>
</form>


<% } %>


</body>
</html>