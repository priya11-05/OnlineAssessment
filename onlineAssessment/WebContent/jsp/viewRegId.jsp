<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is the result page of registration</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleViewRegId.css">

</head>
<body>

    <div class="showmsg">
  <p><%= request.getAttribute("message") %></p>
</div>

<% String m=String.valueOf(request.getAttribute("message2")); %>

<% if(m.compareTo("")!=0){ %>
<div class="box">
<a class="button" href="#popup1">View Registration ID</a>
</div>

<div id="popup1" class="overlay">
<div class="popup">
<h2>YOUR REGISTRATION ID IS</h2>
<a class="close" href="#">&times;</a>
<div class="content">
<h2><%= request.getAttribute("message2") %></h2>
</div>
</div>
</div>
<% } %>

</body>
</html>
