<?php
session_start();
if(!isset($_POST['firma']))
{
	header('Location: firma.php');
		exit();
}
$_SESSION['firma'] = $_POST['firma'];

?>

<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<title>Rejestracja - mapa</title>
	
	<!--
	<meta name="description" content="Zobacz wszystko, co powienieneś wiedzieć o monitorach komputerowych w technikum informatycznym." />
	<meta name="keywords" content="budowa, zasada działania, CRT, LCD, złącza, wady, zalety, parametry monitorów, oznaczenia, maski, rodzaje matryc: TN, PVA, MVA, IPS, wymiar przekątnej, rozdzielczość, wielkość plamki, wielkość piksela, jasność, kontrast, bad pixel, PDP, OLED, VGA, DSUB, HDMI, DVI, jaki monitor kupić, porównanie CRT vs LCD" />
	-->

	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
	<link rel="stylesheet" href="css/style.css" type="text/css" />
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="js/mapa.js"></script>
</head>

<body>
	<div class="conteiner">
			<div id="naglowek">
				<h1>Wybierz miejsce</h1>
			</div>
			<div class="col-lg-10">
				<div id="parter" class="col-lg-6">
					<h2>Parter</h2>
					<img src="img/m.png" width="600" heigth="400" alt="Wybierz"  >
				</div>
				<div id="parternotatka" class="col-lg-4">

				</div>

			</div>
			<div class="col-lg-10">
				<div id="antresola" class="col-lg-6">
					<h2>Antresola</h2>
					<img src="img/m.png" width="600" heigth="400" alt="Wybierz"  >
				</div>
				<div id="antresolanotatka" class="col-lg-4">

				</div>
			</div>
	</div>
	
</body>
</html>