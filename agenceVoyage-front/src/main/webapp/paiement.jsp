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

.logoP {
	width: 130px;
	justify-content: center;
}

#comete{
	width: 100px;
	justify-content: center;
}

#grille{
display: flex;
justify-content: center;
align-items: center;
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
	bottom :0;
	width: 100%;
	height: 7%;
	background-color: #5B9BD5;
	border-top: solid black 2px;
	text-align: center;
}

article {
	position: relative;
	margin-left: 10%;
	margin-right: 10%;
	margin-top: 8%;
	color: white;
	text-align: justify;
}

.form-group {
        margin-bottom: 20px;
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
			<a href="banniere.jsp"><img id="imgMenu" src="./images/Menu.png"
				alt=""></a>
		</div>
		<div class="col-md-8 d-none d-md-flex" id=logo>
			<a href="banniere.fsp"><img id="imgLogo" src="./images/Logo.png"
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
	<article>
		<h2>MOYEN DE PAIEMENTS</h2><br>
		<!-- <ul> -->
		<!--<div class="container overflow-hidden"> -->
		<div class="row form-group" id=grille>
		
			<div class="col"><img class="LogoP" src="./images/Visalogo.svg.png"></div>
		
			<div class="col" ><img class="LogoP" src="./images/MasterCard.jpg"></div>
		
			<div class="col"><img class="LogoP" src="./images/Paypal.png"></div> 
			 
			<div class="col"><img id=comete src="./images/Comete.png"></div> 
			 
		
		</div>
		
		<div class="row" id=grille>
		
			<div class="col"><img class="LogoP" src="./images/ANCV.png"></div>
		
			<div class="col" ><img class="LogoP" src="./images/NeuraLink.png"></div>
			
			<div class="col"><img id=comete src="./images/Etoiles.png"></div>
		
			<div class="col"><img class="LogoP" src="./images/BitCoin.png"></div>
			
			
		
		</div>
		
		
		
	<!--</div> -->

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