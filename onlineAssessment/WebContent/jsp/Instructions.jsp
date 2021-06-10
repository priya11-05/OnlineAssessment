<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>instructions</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleInstructions.css">
</head>
<body>





<header>

<div class="home">
<a href="#" class="btn1">Home</a>
</div>

</header>
<% String m=String.valueOf(request.getAttribute("subj")); %>
<form method="post" action="<%= request.getContextPath() %>/ExamQuesServletURL">
<fieldset>
<legend>Instructions:</legend>
<div class="inst">
<h2>Please read the following instructions carefully:</h2><br>
<p>1. You have 30 mins to complete the test.</p>
<p>2. The test contains total of 20 MCQ for 20 marks.</p>
<p>3. There is only one correct answer to each question.</p>
<p>4. Click on the most appropriate option to mark it as your answer.</p>
<p>5. There is ¼ penalty for each wrong answer.</p>
<p>6. At the end of the test click the submit test button.</p>
<p>7. Do not click the submit test before completing the test. A test once submitted cannot be resumed.</p>
</div>

<input type="checkbox" id="check" name="check" required>
<label for="check">I have read the instructions carefully and understood every line.I am ready to begin the test.</label>

<input type="hidden" id="subject" name="subject" value="<%= m %>">
<div class="test">
<button type="submit" class="btn2">Start Test</button>
</div>
</fieldset>
</form>


</body>
</html>