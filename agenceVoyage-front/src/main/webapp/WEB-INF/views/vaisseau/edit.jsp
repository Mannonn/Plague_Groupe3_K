<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
<title>voyageez</title>
</head>
<body>
	<div class="container">
		<h1>edition vaisseau</h1>

		<form action="${action}" method="post">
			<div class="form-group">
				<label>id:</label> <input class="form-control" name="id"
					readonly="readonly" placeholder="generation automatique"
					value="${vaisseau.id}">
			</div>
			<div class="form-group">
				<label>capacite:</label> <input class="form-control" name="capacite"
					value="${vaisseau.capacite}">
			</div>
			<div class="form-group">
				<label>nom:</label> <input class="form-control" name="nom"
					value="${vaisseau.nom}">
			</div>
			<div class="form-group">
				<label>capitaine:</label> <input class="form-control"
					name="capitaine" value="${vaisseau.capitaine}">
			</div>

			<div>
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="${ctx}/vaisseau" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>