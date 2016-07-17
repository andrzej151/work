<?php

	session_start();
	
	if (!isset($_SESSION['udanarejestracja']))
	{
		header('Location: index.php');
		exit();
	}
	else
	{
		unset($_SESSION['udanarejestracja']);
	}
	
	//Usuwanie zmiennych pamiętających wartości wpisane do formularza
	if (isset($_SESSION['fr_nick'])) unset($_SESSION['fr_nick']);
	if (isset($_SESSION['fr_email'])) unset($_SESSION['fr_email']);
	if (isset($_SESSION['fr_haslo1'])) unset($_SESSION['fr_haslo1']);
	if (isset($_SESSION['fr_haslo2'])) unset($_SESSION['fr_haslo2']);
	if (isset($_SESSION['fr_regulamin'])) unset($_SESSION['fr_regulamin']);
	if (isset($_SESSION['fr_imie'])) unset($_SESSION['fr_imie']);
	if (isset($_SESSION['fr_nazwisko'])) unset($_SESSION['fr_nazwisko']);

	//Usuwanie błędów rejestracji
	if (isset($_SESSION['e_nick'])) unset($_SESSION['e_nick']);
	if (isset($_SESSION['e_email'])) unset($_SESSION['e_email']);
	if (isset($_SESSION['e_haslo'])) unset($_SESSION['e_haslo']);
	if (isset($_SESSION['e_regulamin'])) unset($_SESSION['e_regulamin']);
	if (isset($_SESSION['e_bot'])) unset($_SESSION['e_bot']);
	
?>

<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link href="css/styl.css" rel="stylesheet">
	<title>Empier</title>
</head>

<body>
	
	Dziękujemy za rejestrację w serwisie! Wysłano do Ciebie maila w celu weryfikacji!<br /><br />
	Prosimy o potwierdzenie<br /><br />
	
	<a href="index.php">Przejdź na stronę logowania</a>
	<br /><br />

</body>
</html>