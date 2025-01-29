<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Info</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<div class="container">
<br><br>
<h2 class="display-4" style="color:#226da5">Search Result</h2>
<hr>

Balance : <%=session.getAttribute("accbal") %>
<br>
Transfer Status : <%=session.getAttribute("status") %>

<br><br>
<a href="index.jsp">Home</a>
</div>
</body>
</html>