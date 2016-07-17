<?php

	session_start();
	
	if ((isset($_SESSION['zalogowany'])) && ($_SESSION['zalogowany']==true))
	{
		
			header('Location: panel.php');
			exit();

	}


?>

<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="js/angular.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<title>Czat</title>

</head>

<body>
	<div class="col-lg-12  center">
		<h1>Czat</h1>
		<?php
		if(isset($_SESSION['blad']))	echo $_SESSION['blad'];
		?>

		<div class="col-lg-3">
				
			<form action="zaloguj.php" class="form-control" method="post">
				

				E-mail: <br /> <input class="form-control input-lg" type="text" name="email" /> 
				Hasło: <br /> <input class="form-control input-lg" type="password" name="haslo" /> 
				<input type="submit" class="btn btn-primary" value="Zaloguj się" />
				<button type="button" href="przypomnijhaslo.php" class="btn btn-danger ">Przypomnij Hasło</button>
			</form>

			
		</div>
		<div>
			<button type="button" href="rejestracja.php" class="btn btn-success">Rejestracja</button>
			
		</div>
	</div>
</body>
</html>