<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>lotr</title>
</head>
<body>
	<div class="container">
		<h1>edition personnage</h1>

		<form:form action="${ctx}/personnage" method="post"
			modelAttribute="personnage">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input cssClass="form-control" path="id" readonly="true"
					placeholder="generation automatique" />
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input cssClass="form-control" path="nom" />
				<form:errors path="nom" cssClass="alert alert-danger" element="div"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="pv">pv:</form:label>
				<form:input cssClass="form-control" path="pv" />
				<form:errors path="pv" cssClass="alert alert-danger" element="div"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="vivant">vivant:</form:label>
				<form:input cssClass="form-control" path="vivant" />
				<form:errors path="vivant" cssClass="alert alert-danger"
					element="div"></form:errors>
			</div>
			<c:if test="${personnage.getClass().name=='model.Arme'}">
				<div class="form-group">
					<form:label path="hand">nombre main:</form:label>
					<form:input cssClass="form-control" path="hand" />
					<form:errors cssClass="alert alert-danger" path="hand"
						element="div"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="portee">portee:</form:label>
					<form:input cssClass="form-control" path="portee" />
					<form:errors path="portee" cssClass="alert alert-danger"
						element="div"></form:errors>
				</div>
			</c:if>
			<c:if test="${personnage.getClass().name=='model.Armure'}">
				<div class="form-group">
					<form:label path="materiaux">materiaux:</form:label>
					<form:input cssClass="form-control" path="materiaux" />
					<form:errors path="materiaux" cssClass="alert alert-danger"
						element="div"></form:errors>
				</div>
			</c:if>
			<c:if test="${personnage.getClass().name=='model.Monture'}">
				<form:label path="type">monture:</form:label>
				<form:select cssClass="form-control" path="type" items="${montures}"></form:select>
			</c:if>
			<c:if test="${personnage.getClass().name=='model.Race'}">
				<form:label path="type">race:</form:label>
				<form:select cssClass="form-control" path="type" items="${races}"></form:select>
			</c:if>



			<div>
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="${ctx}/personnage" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>