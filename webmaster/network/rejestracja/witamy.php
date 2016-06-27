<?php

	session_start();
	
	if (!isset($_SESSION['udanarejestracja']))
	{	
		if(isset($_GET['activate']))
		{
			$key = $_GET['activate'];
			require_once "../gra/conect.php";
			mysqli_report(MYSQLI_REPORT_STRICT);
		
			$polaczenie = new mysqli($host, $db_user, $db_password, $db_name);
				if ($polaczenie->connect_errno!=0)
				{
					throw new Exception(mysqli_connect_errno());
				}
				else
				{

					$polaczenie->set_charset("utf8");	
					$users = $polaczenie -> query('SELECT `klucz` FROM `Nusers` WHERE `klucz` = "' . $key . '"');
					if(empty($users))
					{
						header("Location: index.php?error=3");
						exit;
					}
					$los=rand(1,1200);
					$keyn=md5($los);
					$db -> Exec('UPDATE `Nusers` SET `status` = "aktywowano" `klucz` = "'.$keyn.'"  WHERE `klucz`= "' . $key . '"');
				
					header("Location: index.php?succes=1");
					exit;
				}
		}
		header('Location: rejestracja.php');
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
	<link rel="stylesheet" type="text/css" href="../gra/gra.css">
	<title>Network</title>
</head>

<body>
	
	Dziękujemy za rejestrację w serwisie! Wysłaliśmy do ciebie maila w celach weryfikacji.<br /><br />
	

</body>
</html>