<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Failed login</title>
</head>
<body>
<p>login failed</p>


<p><%= request.getAttribute("message") %></p>
</body>
</html>