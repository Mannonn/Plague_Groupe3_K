<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<style>
.image {
	height: 100%;
	background-image: url("./images/espace.jpg");
}

.text-white

legend {
	color: white;
}

tr {
	color: white;
}

#error {
	color: red;
	font-size: 25px;
}

header {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 100%;
	height: 20%;
	background-color: #5B9BD5;
	margin: 0px;
	border-bottom: solid black 2px;
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
	width: 80px;
	justify-content: center;
}

#imgLogo {
	width: 150px;
	justify-content: center;
}

#corps {
	display: flex;
	justify-content: center;
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
}

footer
{
	display: flex;
	justify-content: center;
	align-items: center;
	width: 100%;
	height: 50%;
	background-color: #5B9BD5;
	margin: 0px;
	border-bottom: solid black 2px;
	border-top: solid black 2px;
	
}

#fin{
	display: flex;
	justify-content:flex-end;
}

</style>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>


meta charset="utf-8">
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

<header class="row no-gutters">
	<div class="col-12 col-md-2" id=menu>
		<a href="menu.jsp"><img id="imgMenu" src="./images/Menu.png"
			alt=""></a>
	</div>
	<div class="col-md-8 d-none d-md-flex" id=logo>
		<a href="fontjsp"><img id="imgLogo" src="./images/Logo.png" alt=""></a>
	</div>
	<div class="col-12 col-md-2 no-gutters" id=compteAccess>
		<c:if test="${isConnected==null}">
			<div id="connection">
				<a href="connection.jsp">Se connecter</a>
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
	<div class="row no-gutters" id="corps">
		<div class="col-12 col-md-2" id=vols>
			<a href="vols.jsp">Nos Vols</a>
		</div>
		<div class="col-12 col-md-2" id=sejours>
			<a href="sejours.jsp">Nos Sejours</a>
		</div>
		<div class="col-12 col-md-2" id=lastmin>
			<a href="lastmin.jsp">Last Minute</a>
		</div>
		<div class="col-12 col-md-2" id=offres>
			<a href="offres.jsp">Nos offres</a>
		</div>
		<div class="col-12 col-md-2" id=promos>
			<a href="promos.jsp">Promotions</a>
		</div>
	</div>

	<footer>
		<div class="row no-gutters id="fin">
			<div class="col-12 col-md-2" id=faq>
				<a href="faq.jsp">FAQ</a>
			</div>
			<div class="col-12 col-md-2" id=sejours>
				<a href="infos.jsp">Infos Legales</a>
			</div>
			<div class="col-12 col-md-2" id=lastmin>
				<a href="connaitre.jsp">Nous connaitre</a>
			</div>
			<div class="col-12 col-md-2" id=offres>
				<a href="contact.jsp">Contact</a>
			</div>
			<div class="col-12 col-md-2" id=promos>
				<a href="paiement.jsp">Moyens de paiements</a>
			</div>
			<div class="col-12 col-md-2" id=promos>
				<a href="missions.jsp">Nos missions</a>
			</div>
		</div>
		</div>
	</footer>


</header>


<body>

	<div class="image">
		<fieldset>
			<legend class="text-white"> ! </legend>
			<form action="home" method="post">
				<table>
					<tr>
						<td>Login * : <input name="login" required
							placeholder="Login" class="form-control"></td>
					</tr>

					<tr>
						<td>Mot de passe * : <input type="password" name="password"
							required placeholder="Mot de passe" class="form-control">
							<input type="submit" value="Se connecter">
							<div id="error">${error}</div>
						</td>
					</tr>

				</table>

			</form>
		</fieldset>


	</div>
</body>
</html>
