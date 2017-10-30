<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${character.getName()}'s Profile</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="css/simpsons.css">
<style>
body{ 
 	background-image:url(http://albertcervantes.com/cs3220/cdn/simpsons/clouds.png); 
} 
</style>
</head>
<body>
<c:if test="${character.getImages() ne 0 }">
	<div class="container text-center">
		<div class="row">
				<div class="col-sm-offset-3 col-sm-6">
					<div class="well text-center">
						<img style="width: 30%"src="http://albertcervantes.com/cs3220/cdn/simpsons/simpsons.png">
						<h1>${character.getName() }</h1>
						<h3>1 of ${character.getImages() } Images</h3>
						<p>
							<a class="btn btn-success" href="CharacterCatalog">Back to Catalog</a>
							<a class="btn btn-success" href="CharacterProfile?id=${character.getId()}">Load Another Image</a>
						</p>
						<p class="text-center" style="overflow: none">
							<a href="CharacterProfile?id=${character.getId() }"><img style="max-height: 200px;" src=${character.getRandomImage() }></a>
						</p>
					</div>
				</div>
		</div>
	</div>
</c:if>
<c:if test="${character.getImages() == 0 }">
	<div class="row">
				<div class="col-sm-offset-3 col-sm-6">
					<div class="well text-center">
						<img style="width: 30%"src="http://albertcervantes.com/cs3220/cdn/simpsons/simpsons.png">
						<h1>${character.getName() }</h1>
						<h3>No Images</h3>
						<p>
							<a class="btn btn-success" href="CharacterCatalog">Back to Catalog</a>
						</p>
						<p class="text-center" style="overflow: none">
							<img style="max-height: 200px;" src=${character.getRandomImage() }>
						</p>
					</div>
				</div>
		</div>
	</div>
</c:if>
</body>
</html>