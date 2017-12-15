<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="cs3220" uri="http://cs3.calstatela.edu/cs3220stu72/examples" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<c:if test="${ not empty param.num }">
<p>Your Number is:<br>
${ cs3220:numToWords(param.num) }.
</p>
</c:if>
</body>
</html>