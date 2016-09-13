<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Gra networkingowa</title>
</head>
<body>
<?php
	
	require_once "conect.php";
	mysqli_report(MYSQLI_REPORT_STRICT);
		
		$spotkanie=7;
		try 
		{
			$polaczenie = new mysqli($host, $db_user, $db_password, $db_name);
			if ($polaczenie->connect_errno!=0)
			{
				throw new Exception(mysqli_connect_errno());
			}
			else
			{
				
				$polaczenie->set_charset("utf8");
				
				$rezultat = $polaczenie->query("SELECT id,imie,nazwisko,email,klucz FROM Nusers WHERE idspotkania='$spotkanie'");
				
				$ile = $rezultat->num_rows;
				$i=0;
				$status="wyslanoA";
				while($i<$ile)
				{
						$wiersz = $rezultat->fetch_assoc();
					
						$imie=$wiersz['imie'];
						$nazwisko=$wiersz['nazwisko'];
						$key=$wiersz['klucz'];
						$email=$wiersz['email'];
						$id=$wiersz['id'];
						
						$email_ankieta = "email_ankieta.html";
						$messeage = file_get_contents($email_ankieta);
						$messeage = str_replace("[Imie]", $imie, $messeage);
						$messeage = str_replace("[Nazwisko]", $nazwisko, $messeage);
						$messeage = str_replace("[key]", $key, $messeage);
						$messeage = str_replace("[url]", "http://" . $_SERVER['HTTP_HOST'].'/netw/rejestracja/ankieta.php', $messeage);

						$naglowki = "From: active@andr-t.cba.pl\n" .
									"Reply-To: active@andr-t.cba.pl\n" .
									"Content-type: text/html; charset=utf-8\n";

						if(mail($email, "Ankieta",$messeage,$naglowki)){
						$polaczenie->query("UPDATE Nusers SET status='$status' WHERE id='$id'");
							echo($i.". ".$imie." ".$nazwisko."</br>");
						}
						else
						{
							echo($i.". ".$imie." ".$nazwisko."BLAD BLAD BLAD BLAD</br>");
						}
					$i++;
				}
				
				$polaczenie->close();
			}
			
		}
		catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
			echo '<br />Informacja developerska: ';
		}
?>