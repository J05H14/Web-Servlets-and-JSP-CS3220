<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CS3220 Final</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class = "container">
<div class = "well">
	<h5>Add a Link</h5>
	<form action="AddLink" method="post">
	Title<br>
	<input type="text" name="name"><br>
	Link<br>
	<input type="text" name="url"><br>
	<input class="btn btn-primary" type="submit">
	</form>
</div>

<table border="1">
  <tr><th>Name</th><th>URL</th><th>Score</th><th>Up Down</th></tr>
<c:forEach items="${links}" var="link">
  <tr>
  	<td>${link.id}</td>
    <td>${link.name}</td>
    <td><a href="${link.url} target="_blank">${link.url }</a></td>
    <td>${link.score}</td>
    <td><a href="Upvote?id=${link.getId()}">Up</a> <a href="Downvote?id=${link.getId()}">Down</a>
  </tr>
</c:forEach>
</table>
</div>
</body>
</html>