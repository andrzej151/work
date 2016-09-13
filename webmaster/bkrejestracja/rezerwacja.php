<?php
session_start();

	if (!isset($_GET['firma'])) {
		header('Location: firma.php');
		exit();
	}
	if (!isset($_GET['miejsce'])) {
		header('Location: firma.php');
		exit();
	}
	$miejsce=$_GET['miejsce'];
	$firma=$_GET['firma'];

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
						
							$rezultat = $polaczenie->query("SELECT  `idfirmy` FROM `Mmiejsca` WHERE `id`=$miejsce");
							$wiersz = $rezultat->fetch_assoc();
							if($wiersz['idfirmy']==0)
							{
								$rezultat = $polaczenie->query("UPDATE `Mmiejsca` SET `idfirmy`=$firma WHERE `id`=$miejsce");
								$komunikat="<h1>Zarezezerwowano miejsce potwierdzenie wysłano mailem</h1>";
							}
							else
							{
								$komunikat="<h1>To miejsce jest zarezerwowane</h1> <a href='firma.php>Wyierz inne</a>";
							}
							
						}
				}
				catch(Exception $e)
				{
					echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
					echo '<br />Informacja developerska: '.$e;
				}

?>



	<?php echo($komunikat);?>

