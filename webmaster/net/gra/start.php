<?php

	session_start();
	
	if (!isset($_SESSION['zalogowany']))
	{
		header('Location: log.php');
		exit();
	}
	
?>
<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Gra networkingowa - Runda</title>
	<link rel="stylesheet" type="text/css" href="gra.css">
</head>

<body>
	
<?php

	echo "<p>Witaj ".$_SESSION['nazwakom'].'! [ <a href="logout.php">Wyloguj się!</a> ]</p>';
	
?>

	<form method="POST" action="nowarunda.php">
	 Runda </br> <input type="text" name="runda"></br>
	 Spotkanie </br> <input type="text" name="spotkanie"></br>
	 <input type="submit" value="wejdz"></br>
	</form>
	

</body>
</html>