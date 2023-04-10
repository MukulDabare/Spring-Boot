<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<form action="update">
<pre>
Rollno:<input type="text" name="rollno" value=" ${stu.rollno}" readonly>
Name: <input type = "text" name = "name" value=" ${stu.name}">
Username: <input type="text" name="username" value=" ${stu.username}">
Password: <input type="text" name="password" value=" ${stu.password}">
<input type="submit" value="Update & Save">

</pre>
</form>
</body>
</html>