<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="cs3220" uri="http://cs3.calstatela.edu/cs3220stu72/examples" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Number to Words</title>
</head>
<body>
<p>Input a Number to be Wordified (Sounds Real Enough of a Word)</p>
<form action="NumberConverter.jsp" method="get">
	<input type="number" name="num">
	<input type="submit" value="Submit">
</form>
<p>Your Number is:<br>
${ cs3220:numToWords(param.num) }.
</p>

</body>
</html>