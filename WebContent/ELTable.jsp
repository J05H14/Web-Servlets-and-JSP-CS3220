<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL Table</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class = "container">
<h1 class = "page-header" >EL Table</h1>

<table class = "table">
<tr>
	<th>EL Expression</th>
	<th>Result</th>
</tr>
<tr>
	<td>${'${'}2+4/2}</td>
	<td>${2+4/2}</td>
</tr>
<tr>
	<td>${'${'}2+3/2}</td>
	<td>${2+3/2}</td>
</tr>
<tr>
	<td>${'${'}"2"+3/2}</td>
	<td>${"2"+3/2}</td>
</tr>
<tr>
	<td>${'${'}"2"+3 div 2}</td>
	<td>${'2'+ 3 div 2}</td>
</tr>
<tr>
	<td>${'${'}"a"+ 3 div 2}</td>
	<td>${"a".concat(3 div 2)}</td>
<%-- 	${"a" + 3 div 2} throws NumberFormatException: For input string: "a" --%>
</tr>
<tr>
	<td>${'${'}null == 'test'}</td>
	<td>${null == 'test'}</td>
</tr>
<tr>
	<td>${'${'}null eq null}</td>
	<td>${null eq null}</td>
</tr>
<tr>
	<td>${'${'}empty ""}</td>
	<td>${empty ""}</td>
</tr>
<tr>
	<td>${'${'}empty null}</td>
	<td>${empty null}</td>
</tr>
<tr>
	<td>${'${'}empty "null"}</td>
	<td>${empty "null"}</td>
</tr>
<tr>
	<td>${'${'}"abc" lt 'b'}</td>
	<td>${"abc" lt 'b'}</td>
</tr>
<tr>
	<td>${'${'}"cs320" > "cs203"}</td>
	<td>${"cs320" > "cs203"}</td>
</tr>
</table>
</div>
</body>
</html>