<?php

	session_start();
	
	
	
?>

<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Empire - załóż darmowe konto!</title>
 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/simple-sidebar.css" rel="stylesheet">
    <link href="css/styl.css" rel="stylesheet">
 	<!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
	<style>
		.error
		{
			color:red;
			margin-top: 10px;
			margin-bottom: 10px;
		}
	</style>
</head>

<body>
	<div class="container">
		<div class="col-lg-4">
		

			<form  method="POST" role="form" action="spr.php">
				
		
				<label for="nazwa">
				Nazwa Firmy: </label> <input type="text" class="form-control input-lg" value="<?php
					if (isset($_SESSION['fr_nazwa']))
					{
						echo $_SESSION['fr_nazwa'];
						unset($_SESSION['fr_nazwa']);
					}
				?>" name="nazwa" /><br />
		
				<?php
					if (isset($_SESSION['e_nazwa']))
					{
						echo '<div class="error">'.$_SESSION['e_nazwa'].'</div>';
						unset($_SESSION['e_nazwa']);
					}
				?>

				<label for="imie">
				Imię osoby do kontaktu: </label> <input type="text" class="form-control input-lg" value="<?php
					if (isset($_SESSION['fr_imie']))
					{
						echo $_SESSION['fr_imie'];
						unset($_SESSION['fr_imie']);
					}
				?>" name="imie" /><br />
		
				<?php
					if (isset($_SESSION['e_imie']))
					{
						echo '<div class="error">'.$_SESSION['e_imie'].'</div>';
						unset($_SESSION['e_imie']);
					}
				?>

				<label for="nazwisko">
				Nazwisko osoby do kontaktu: </label> <input type="text" class="form-control input-lg" value="<?php
					if (isset($_SESSION['fr_nazwisko']))
					{
						echo $_SESSION['fr_nazwisko'];
						unset($_SESSION['fr_nazwisko']);
					}
				?>" name="nazwisko" /><br />
		
				<?php
					if (isset($_SESSION['e_nazwisko']))
					{
						echo '<div class="error">'.$_SESSION['e_nazwisko'].'</div>';
						unset($_SESSION['e_nazwisko']);
					}
				?>

				<label for="email">
				E-mail osoby do kontaktu: </label> <input type="text" class="form-control input-lg" value="<?php
					if (isset($_SESSION['fr_email']))
					{
						echo $_SESSION['fr_email'];
						unset($_SESSION['fr_email']);
					}
				?>" name="email" /><br />
		
				<?php
					if (isset($_SESSION['e_email']))
					{
						echo '<div class="error">'.$_SESSION['e_email'].'</div>';
						unset($_SESSION['e_email']);
					}
				?>
		
				<label for="telefon">
				Nr telefonu osoby do kontaktu: </label> <input type="text" class="form-control input-lg" value="<?php
					if (isset($_SESSION['fr_telefon']))
					{
						echo $_SESSION['fr_telefon'];
						unset($_SESSION['fr_telefon']);
					}
				?>" name="telefon" /><br />
		
				<?php
					if (isset($_SESSION['e_telefon']))
					{
						echo '<div class="error">'.$_SESSION['e_telefon'].'</div>';
						unset($_SESSION['e_telefon']);
					}
				?>

				
			<button type="submit" class="btn btn-primary">Zarejestruj się!</button>
		
			</form>
		</div>

	</div> <!-- cointeiner -->


</body>
</html>