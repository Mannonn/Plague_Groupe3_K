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
	position: relative;
	bottom: 0;
	width: 100%;
	height: 10%;
	background-color: #5B9BD5;
	border-top: solid black 2px;
	text-align: center;
}

article {
	position: relative;
	margin-left: 10%;
	margin-right: 10%;
	color: white;
	text-align: justify;
}

#article1 {
	margin-top: 8%;
}

#article2 {
	margin-top: 2%;
}

#slideshow {
	overflow: hidden;
	width: 1000px;
	height: 500px;
	position: relative;
	margin: auto;
}

#slideshow-container {
	width: 4000px;
	-webkit-animation: slide 18s ease infinite;
}

#mySlides {
	float: left;
	height: 500px;
	width: 1000px;
	background-size: cover;
}

#mySlides:nth-child(1) {
	background-image: url("./images/img1.jpg");
}

#mySlides:nth-child(2) {
	background-image: url("./images/img2.jpg");
}

#mySlides:nth-child(3) {
	background-image: url("./images/img3.jpg");
}

#mySlides:nth-child(4) {
	background-image: url("./images/img4.jpg");
}

#numbertext {
	color: white;
}

#text {
	position: absolute;
	bottom: 0;
	color: white;
}

@
-webkit-keyframes slide { 20% {
	margin-left: 0px;
}
30












%
{
margin-left












:












-1000px










;
}
50












%
{
margin-left












:












-1000px










;
}
60












%
{
margin-left












:












-2000px










;
}
70












%
{
margin-left












:












-2000px










;
}
80












%
{
margin-left












:












-3000px










;
}
90












%
{
margin-left












:












-3000px










;
}
}
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
				<a href="planetes.jsp">Nos Planètes</a>
			</div>
			<div class="col" id=sejours>
				<a href="activites.jsp">Nos Activités</a>
			</div>
			<div class="col" id=lastmin>
				<a href="vols.jsp">Nos vols</a>
			</div>
			<div class="col" id=offres>
				<a href="offres.jsp">Nos offres</a>
			</div>
		</div>
	</header>

	<article id="article1">
		<h1>
			Bienvenue sur le site de Voyageez, la première agence de voyages
			interplanetaires pour tous!<br> <br>
		</h1>
		<p>
			Notre mission: vous proposer des services de qualités pour que vos
			vacances dans les étoiles soient les plus belles possibles.<br>
			Pour toi, qui aime le frisson et l'aventure, ou encore toi, qui veut
			te dorer la pillule au soleil, et toi là bas, qui ne sais pas faire
			autrement que te prendre à la dernière minute pour tes vacances et
			pour tous les autres qu'on embrasse fort <3... <br> <br> Il
			ne vous reste qu'à commencer votre recherche, cliquez et ...
		</p>
		<h2 align="right">...Voyageez vers d'autres cieux!</h2>

		<br>
	</article>

	<div id="slideshow">
		<div id="slideshow-container">
			<div id="mySlides">
				<div id="numbertext">1 / 4</div>
				<div id="text">Magnifique vue du levé de soleil sur la planète
					Venus, le meilleur spot romantique de la galaxie.</div>
			</div>
			<div id="mySlides">
				<div id="numbertext">2 / 4</div>
				<div id="text">Les canyons de Mars, une aventure à couper le
					souffle en famille ou entre amis.</div>
			</div>
			<div id="mySlides">
				<div id="numbertext">3 / 4</div>
				<div id="text">Et pourquoi pas une croisière autour de Mercure
					pour oublier la grisaille de l'hivers.</div>
			</div>
			<div id="mySlides">
				<div id="numbertext">4 / 4</div>
				<div id="text">Sur Uranus, vous pouvez observer les plus
					belles aurores boréales de la Voie Lactée, alors ? Ca vous tente ?</div>
			</div>
		</div>
	</div>

	<article id="article2">
		<p>Pour commencer votre recherche rien de plus simple. Il vous
			suffit de préciser votre planète de départ puis votre planète
			d'arrivée. Sélectionner la date de départ souhaitée (attention, il se
			peut qu'à cause d'une forte demande vous ne trouviez pas de vol pour
			vos dates, nous vous recommandons de choisir une autre dates ou de
			tenter le tout pour le tout en attendant qu'une place se libère dans
			la journée). Si le coeur vous en dit vous pouvez aussi choisir une
			activité sur votre le lieu de destination parmis une large sélection
			d'offres. Enfin, il ne vous restera plus qu'à préciser le nombre de
			passagers qui vous accompagnent et à cliquer sur le bouton "VALIDER"
			afin d'acceder à vos résultats.</p>
	</article>

	<div id="recherche">
		<form action="post">
			<h2>Recherche</h2>

			<label>Planete de départ</label> <input type="text" name="depart">
			<label>Planete d'arrivee</label> <input type="text" name="arrivee"></br>
			<label>Date de départ</label> <input type="date" name="date"></br>
			<label>Choisir une activité en plus</label> <input type="radio"
				name="activite"> <label>Activité</label> <select
				name="activites" id="activite-select">
				<option value="">--Choisir une activité--</option>
			</select> </br> <input type="submit" id='submit' value='Valider ma sélection'>
		</form>
	</div>

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
</body>
</html>