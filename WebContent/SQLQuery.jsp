<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    
    
<%-- set data source --%>
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu72"
	user="cs3220stu72"
	password="EEK!o0m*"/>
<%-- if param.sql is null --%>

<c:if test="${ not empty param.sql }">
<sql:query var="items" sql="${ param.sql }"/>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL SQL Query</title>
</head>
<body>
<div class = "container">
<h1 class = "page-header text-center">SQL Query</h1>
<div class = "well">
<form action = "SQLQuery.jsp" method = "post">
	<c:out value="Valid Tables: Employees, Items, Projects, Project_Members, Salaries(Don't \"SELECT * \" with this)"></c:out>
	<div class="form-group">
	<textarea class="form-control" rows="5" name="sql"></textarea>
	</div>
	<div class="text-center">
	<input class="btn btn-primary" type="submit" name="submit" value="Execute Query">
	</div>
</form>
</div>
<c:if test="${ not empty param.sql }">
<table class="table table-striped table-hover table-border">
	
	<c:forEach items="${items.rows}" var="row" varStatus="loopStatus">
		<c:if test="${loopStatus.index == 0}">
			<tr>
	    	<c:forEach items="${row}" var="col">
	        	<th>${col.key}</th>
	    	</c:forEach>
	  		</tr>
  		</c:if>
  	</c:forEach>
	
	
	<c:forEach items="${items.rows}" var="row">
		
		<tr>
    	<c:forEach items="${row}" var="col">
      
        	<td>${col.value}</td>
      
    	</c:forEach>
  		</tr>
  	</c:forEach>
</table>
</c:if>
</div>

</body>
</html>