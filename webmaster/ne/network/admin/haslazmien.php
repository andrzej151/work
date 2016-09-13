<?php
	
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
				
				
				for($i=1;$i<21;$i++)
				{
					
						$haslo=md5("com", PASSWORD_DEFAULT);
						if ($polaczenie->query("UPDATE Nkom SET pass='$haslo'"))
						{
							echo("zmieniono</br>");
						}
						else
						{
							throw new Exception($polaczenie->error);
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