<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
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
</html>-->








<%@page import="oaBeans.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">


<title>Student After Login Home Page</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleStudentAfterLogin.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css&quot; integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js&quot; integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js&quot; integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js&quot; integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">






</head>
<body>
<% user USER = (user)request.getAttribute("loginUsers"); %>
<!-- <div id="wrapper"> -->

<header><h1> Student Home page</h1></header>
<ul class="main">
<li class="reg">Registration no.:-<%= USER.getRegId() %> <% %></li>

<li><a href="#">Logout</a></li>
</ul>
  <div class="sidenav">
  <a href="#!" data-toggle="modal" data-target="#profile-modal">Profile</a>
  <a href="<%= request.getContextPath() %>/html/chooseSubj.html" id="take_test">Take Test</a>
  <a href="#" id="past_attempts">Past Attempts</a>
</div>
<!-- </div> -->
<div id="mainbody" class="text">Welcome <%= USER.getFname() %>!!</div>



<!-- profile modal -->

<!-- Modal -->
<div class="modal fade" id="profile-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header primary-background text-center">
        <h5 class="modal-title" id="exampleModalLabel" style="background-color:powderblue;"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <div class="container primary-background text-center">
        <h2 class="modal-title" id="exampleModalLabel" style="background-color: ForestGreen; color: white; font-family: Lucida Handwriting;"> YOUR PROFILE </h2>
       
        <!-- details -->
        <table class="table">
 
  <tbody>
    <tr>
      <th scope="row">First Name</th>
      <td><%= USER.getFname() %></td>
      
    </tr>
    <tr>
      <th scope="row">Middle Name</th>
      <td><%= USER.getMname() %></td>
      
    </tr>
    
    <tr>
      <th scope="row">Last Name</th>
      <td><%= USER.getLname() %></td>
      
    </tr>
    
    <tr>
      <th scope="row">Registration ID</th>
      <td><%= USER.getRegId() %></td>
    </tr>
    
    <tr>
      <th scope="row">Roll Number</th>
      <td><%= USER.getRoll() %></td>
    </tr>
    
    <tr>
      <th scope="row">Contact Number</th>
      <td><%= USER.getCode() %> <%=USER.getPhnNum() %></td>
    </tr>
    
    <tr>
      <th scope="row">Mail ID</th>
      <td><%= USER.getMail() %></td>
    </tr>
    
  </tbody>
</table>
        <!-- end details -->
        </div> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Edit</button>
      </div>
    </div>
  </div>
</div>

<!-- end of profile modal -->



</body>
</html>
