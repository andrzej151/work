<?php
	session_start();
	
	if (isset($_GET['ankieta']))
	{
		$_SESSION['klucz']=$_GET['ankieta'];
	}
?>
<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link rel="stylesheet" type="text/css" href="../gra/gra.css">
	<title>Gra networkingowa</title>
</head>
<body>
<form  method="POST" action="ankietap.php">

	Ankieta</br>
	<input type="text" name="ankieta"></br>
	<input type="submit" value="Odbierz list">
</form>

</body>
</html>