<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>


<html>
<style>
body{
    background: #67BE4B;
}
#container{
    width:400px;
    margin:0 auto;
    margin-top:10%;
}
/* Bordered form */
form {
    width:100%;
    padding: 30px;
    border: 1px solid #f1f1f1;
    background: #fff;
}
#container h1{
    width: 38%;
    margin: 0 auto;
    padding-bottom: 10px;
}

/* Full-width inputs */
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
    background-color: #53af57;
    color: white;
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
<!-- importer le fichier de style -->
<link rel="stylesheet" href="style.css" media="screen" type="text/css" />
</head>
<body>
	<div id="container">
		<!-- zone de connexion -->

		<form action="verification.php" method="POST">
			<h1>Connexion</h1>

			<label><b>Nom d'utilisateur</b></label> <input type="text"
				placeholder="Entrer le nom d'utilisateur" name="username" required>

			<label><b>Mot de passe</b></label> <input type="password"
				placeholder="Entrer le mot de passe" name="password" required>

			<input type="submit" id='submit' value='LOGIN'>
		</form>
	</div>
</body>