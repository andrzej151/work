<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link rel="stylesheet" type="text/css" href="../gra/gra.css">
	<title>Gra networkingowa</title>
</head>
<body>

<?php
session_start();
	
	if (!isset($_SESSION['klucz']))
	{
		header('Location: ankieta.php');
		exit();
	}
	else
	{
	
		require_once "conect.php";
		mysqli_report(MYSQLI_REPORT_STRICT);
		
		
		try 
		{
			$polaczenie = new mysqli($host, $db_user, $db_password, $db_name);
			if ($polaczenie->connect_errno!=0)
			{
				throw new Exception(mysqli_connect_errno());
			}
			else
			{
				$key=$_SESSION['klucz'];
				$polaczenie->set_charset("utf8");
				
				$rezultat = $polaczenie->query("SELECT Nusers.id, Nlisty.list, Nusers.email FROM Nusers, Nlisty WHERE klucz = '$key' AND Nusers.idlistu = Nlisty.id");
				
				$ile = $rezultat->num_rows;
				
				$status="koniec";
				if($ile>0)
				{
						$wiersz = $rezultat->fetch_assoc();
					
						$id=$wiersz['id'];
						$email=$wiersz['email'];
						$list=$wiersz['list'];
						
						$los=rand(1,1200);
						$key=md5($los);
						
						$naglowki = "From: active@andr-t.cba.pl\n" .
									"Reply-To: active@andr-t.cba.pl\n" .
									"Content-type: text/html; charset=utf-8\n";

						mail($email, "Mail feedbackowy",$list,$naglowki);
						$polaczenie->query("UPDATE Nusers SET status='$status', klucz='$key' WHERE id='$id'");
						session_unset();
							echo("Wysłano maila");
							
					
				}
				else
				{
					echo("blad");
				}
				
				$polaczenie->close();
			}
			
		}
		catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
			echo '<br />Informacja developerska: ';
		}
	}
?>
</body>
</html>