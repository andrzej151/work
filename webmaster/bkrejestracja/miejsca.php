<?php
session_start();
if(!isset($_SESSION['firma']))
{
	echo("bląd f");
}
else
{

	if(!isset($_GET['miejsce']))
	{
		echo("bląd m");
	}
	else
	{
		$miejsce=$_GET['miejsce'];
		$f=$_SESSION['firma'];
		
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
						
							$rezultat = $polaczenie->query("SELECT  id, dzien FROM `Mmiejsca` WHERE `idfirmy`=0 AND miejsce=$miejsce");
							if (!$rezultat) throw new Exception($polaczenie->error);
				
							$ile = $rezultat->num_rows;
							for ($i=0; $i <$ile ; $i++) { 
								$wiersz = $rezultat->fetch_assoc();
								echo '<a href="rezerwacja.php?firma='.$f."&miejsce=".$wiersz['id'].'"><button class="btn btn-primary">Dzien '.$wiersz['dzien']."</button></a></br>";
							}
							
					
						}
				}
				catch(Exception $e)
				{
					echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
					echo '<br />Informacja developerska: '.$e;
				}
	}
}