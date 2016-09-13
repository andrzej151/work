<?php

	session_start();
	
	if ((isset($_SESSION['zalogowany'])) && ($_SESSION['zalogowany']==true))
	{
		header('Location: start.php');
		exit();
	}

?>
<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Gra networkingowa</title>
	<link rel="stylesheet" type="text/css" href="gra.css">
	<script src="gra.js" type="text/javascript"></script>
</head>
<body>
	<form method="POST" action="zaloguj.php">
	 Login </br> <input type="text" name="login"></br>
	 Haslo</br> <input type="password" name="haslo"></br>
	 <input type="submit" value="zaloguj"></br>
	</form>
</body>
</html>