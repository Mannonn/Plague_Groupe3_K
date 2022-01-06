<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="fr" dir="ltr">

<style>
header {
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
	height: 35%;
	background-color: #5B9BD5;
	margin: 0px;
	width: 100%;
}

a:link {
	color: black;
	font-size: large;
}

#menu {
	display: flex;
	justify-content: center;
	align-items: center;
}

#logo {
	display: flex;
	justify-content: center;
	align-items: center;
}

#imgMenu {
	width: 55px;
	justify-content: center;
}

#imageP{
position: absolute;
margin-left: 70%;
margin-top: 3%;
}

#imgCo{
width: 90%;;
}

#image1{
width: 40%;}

#imgLogo {
	width: 130px;
	justify-content: center;
}

#corps {
	display: flex;
	justify-content: flex-end;
	align-items: center;
	width: 100%;
	height: 50%;
	background-color: #5B9BD5;
	margin: 0px;
	border-bottom: solid black 2px;
	border-top: solid black 2px;
}

body {
	background-image: url("./images/espace.jpg");
	height: 50%;
	width: 100%;
	margin: 0px;
}

footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 7%;
	background-color: #5B9BD5;
	border-top: solid black 2px;
	text-align: center;
}

article {
	color: white;
}

#container {
	position: absolute;
	width: 500%;
	margin-left: 35%;
	margin-top: 5%;
	color: white;
}

#container h2 {
	text-align: center;
}

#texte {
	position: absolute;
	text-align: center;
	margin-left: 6%;
	margin-top: 9%;
	
}

form {
	width: 100%;
	padding: 30px;
	border: 1px solid #003396;
	background: #003396;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
input[type=submit] {
	background-color: #00BFF;
	color: black;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

input[type=submit]:hover {
	background-color: white;
	color: #53af57;
	border: 1px solid #53af57;
}
</style>

<head>
<meta charset="utf-8">
<link
	href="https://fonts.googleapis.com/css2?family=Prompt:ital,wght@1,500&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="icon" href="">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</head>
<body>
	<header class="row no-gutters">
		<div class="col-11 col-md-2" id=menu>
			<a href="menu.jsp"><img id="imgMenu" src="./images/Menu.png"
				alt=""></a>
		</div>
		<div class="col-md-8 d-none d-md-flex" id=logo>
			<a href="fontjsp"><img id="imgLogo" src="./images/Logo.png"
				alt=""></a>
		</div>
		<div class="col-12 col-md-2 no-gutters" id=compteAccess>
			<c:if test="${isConnected==null}">
				<div id="connection">
					<a href="connexion.jsp">Se connecter</a>
				</div>
				<div id="inscription">
					<a href="inscription.jsp">Créer un compte</a>
				</div>
			</c:if>
			<c:if test="${isConnected=='y'}">
				<div id="deConnect">
					<a href="deconnection">Se déconnecter</a>
				</div>
			</c:if>
		</div>
		<div class="row" id="corps">
			<div class="col" id=vols>
				<a href="vols.jsp">Nos Vols</a>
			</div>
			<div class="col" id=sejours>
				<a href="sejours.jsp">Nos Sejours</a>
			</div>
			<div class="col" id=lastmin>
				<a href="lastmin.jsp">Last Minute</a>
			</div>
			<div class="col" id=offres>
				<a href="offres.jsp">Nos offres</a>
			</div>
			<div class="col" id=promos>
				<a href="promos.jsp">Promotions</a>
			</div>
		</div>
	</header>
	<article>
		<div id="texte">
			<h2>
				Faites confiance à nos</br> pilotes d'exceptions
			</h2>
			<h2>
				Leur metier,</br> notre fierte
			</h2>
			</br>
			<img id="image1" src="./images/Image1.png"
				alt="">
		</div>
		<div id="container">
			<form action="post">
				<h2>Connexion</h2>

				<label><b>Nom d'utilisateur</b></label> <input type="text"
					placeholder="Entrer le nom d'utilisateur" name="username" required></br>

				<label><b>Mot de passe</b></label> <input type="password"
					placeholder="Entrer le mot de passe" name="password" required></br>

				<input type="submit" id='submit' value='Se connecter'>
			</form>
		</div>
		<div id="imageP"><img id="imgCo" src="./images/pilote.png"
				alt=""></div>
	</article>
	<footer class="row no-gutters">
		<div class="col" id=faq>
			<a href="faq.jsp">Foire Aux Questions</a>
		</div>
		<div class="col" id=infos>
			<a href="infos.jsp">Infos Legales</a>
		</div>
		<div class="col" id=connaitre>
			<a href="connaitre.jsp">Nous connaitre</a>
		</div>
		<div class="col" id=contacts>
			<a href="contact.jsp">Contact</a>
		</div>
		<div class="col" id=paiements>
			<a href="paiement.jsp">Moyens de paiements</a>
		</div>
		<div class="col" id=missions>
			<a href="missions.jsp">Nos missions</a>
		</div>
	</footer>
</body>
</html>
