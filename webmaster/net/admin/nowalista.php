
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
	
	require_once "conect.php";
	mysqli_report(MYSQLI_REPORT_STRICT);
		
		$spotkanie=3;
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
				
				$rezultat = $polaczenie->query("SELECT id,imie,nazwisko FROM Nusers WHERE idspotkania='$spotkanie'");
				
				$ile = $rezultat->num_rows;
				$i=0;
				$status="obecny";
				while($i<$ile)
				{
					$wiersz = $rezultat->fetch_assoc();
					$nid=$wiersz['id'];
					$nim=$wiersz['imie'];
					$nin=$wiersz['nazwisko'];
					if($polaczenie->query("INSERT INTO Nlista VALUES (NULL, '$nid','$nim','$nin','$status')"));
					{
						echo(($i+1)." ".$nim." ".$nin."</br>");
							$i++;
							
					}
						
					
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
</body>
</html>
