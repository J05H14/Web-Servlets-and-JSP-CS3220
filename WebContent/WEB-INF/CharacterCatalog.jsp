<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Simpsons Catalog</title>
</head>
<body>

<div class="container text-center">
<div class="row">
	<c:forEach items="${characters}" var = "character" varStatus="status">
		<div class="col-sm-4 text-center">
			<div class="well">
				<a href="CharacterProfile?id=${character.getId() }">
					${character.getName()}<br>
					<img style="height: 150px;" src="${character.getThumbnail()}" class="img-responsive img-thumbnail">
				</a>
			</div>
		</div>
	</c:forEach>
</div>
</div>
</body>
</html>