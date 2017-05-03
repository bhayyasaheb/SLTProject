<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/register">

<fieldset>
<legend>Personal Details</legend>
<div align="center">

Enter Name:
<input type="text" name="userName"><br><br>
Enter Email id:
<input type="text" name="email" ><br> <br>
Enter Contact No:
<input type="text" name="phoneNo" ><br><br>
Enter a Password:
<input type="password" name="password" ><br><br>
<!-- Confirm Password:
<input type="password" name="password"><br><br>
 --><input type="submit" value="Submit">
</div>
</fieldset>


</form>
</body>
</html>