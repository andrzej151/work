<?php
	$wszystko_OK=true;
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
				
				
				for($i=10;$i<21;$i++){
					if ($wszystko_OK==true)
					{
						//Hurra, wszystkie testy zaliczone, dodajemy gracza do bazy
						$nick="kom".$i;
						$haslo=md5("kom", PASSWORD_DEFAULT);
						if ($polaczenie->query("INSERT INTO Nkom VALUES (NULL, '$nick', '$haslo')"))
						{
							echo(ok);
						}
						else
						{
							throw new Exception($polaczenie->error);
						}
						
					}
				}
				$polaczenie->close();
			}
			
		}
		catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
			echo '<br />Informacja developerska: '.$e;
		}
?>