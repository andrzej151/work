<?php

	if(isset($_POST['dni'])){
		if(isset($_POST['miejsc'])){
			if($_POST['dni']<1){
				require_once "connect.php";
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
				
						$rezultat = $polaczenie->query("TRUNCATE Mmiejsca");

						}
				}
				catch(Exception $e)
				{
					echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
					echo '<br />Informacja developerska: '.$e;
				}
			}
			else
			{
				if($_POST['miejsc']<1){
					require_once "connect.php";
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
					
							$rezultat = $polaczenie->query("TRUNCATE Mmiejsca");

							}
					}
					catch(Exception $e)
					{
						echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
						echo '<br />Informacja developerska: '.$e;
					}
				}
				else
				{
					require_once "connect.php";
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
						for ($i=1; $i <=$_POST['dni'] ; $i++) { 
							for ($j=1; $j <=$_POST['miejsc'] ; $j++) { 
														$rezultat = $polaczenie->query("INSERT INTO `Mmiejsca`(`id`, `dzien`, `miejsce`, `idfirmy`) VALUES (Null,$i,$j,0)");
													}						
						
								}
								echo("got");
						}
				}
				catch(Exception $e)
				{
					echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
					echo '<br />Informacja developerska: '.$e;
				}

				}
			}
		}
	}
	
?>

<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>miejsca</title>
	
	
	
</head>

<body>


	<form method="post">
		ilosc dni: <br /> <input type="text"  name="dni" /><br />
		ilosc miejsc: <br /> <input type="text"  name="miejsc" /><br />

		<input type="submit" value="Wyslij" />
	</form>

</body>
</html>