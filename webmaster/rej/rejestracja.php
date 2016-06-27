<?php

	session_start();
	
	if (isset($_POST['email']))
	{
		//Udana walidacja? Załóżmy, że tak!
		$wszystko_OK=true;
		
		//Sprawdź poprawność imie
		$imie = $_POST['imie'];
		$nazwisko = $_POST['nazwisko'];
		
		//Sprawdzenie długości imienia
		if ((strlen($imie)<3) || (strlen($imie)>20))
		{
			$wszystko_OK=false;
			$_SESSION['e_imie']="Imie musi posiadać od 3 do 20 znaków!";
		}

		//sprawdzenie nazwiska
		if ((strlen($nazwisko)<3) || (strlen($nazwisko)>20))
		{
			$wszystko_OK=false;
			$_SESSION['e_nazwisko']="Nazwisko musi posiadać od 3 do 20 znaków!";
		}
		
		
		// Sprawdź poprawność adresu email
		$email = $_POST['email'];
		$emailB = filter_var($email, FILTER_SANITIZE_EMAIL);
		
		if ((filter_var($emailB, FILTER_VALIDATE_EMAIL)==false) || ($emailB!=$email))
		{
			$wszystko_OK=false;
			$_SESSION['e_email']="Podaj poprawny adres e-mail!";
		}
		
		require_once "conect.php";
		//mysqli_report(MYSQLI_REPORT_STRICT);
		
		try 
		{
			if (isset($_POST['ankieta'])) 
			{
				//wysyłka maila
				$ank = "ankieta.html";

				$message = file_get_contents($ank);
				$message = str_replace("[Imie]", $imie, $message);
				$message = str_replace("[Nazwisko]", $nazwisko, $message);


				if (mail($email, "Przypomnienie o ankiecie" , $message, $naglowki)==true) 
				{	
					if(!isset($_POST['newslater']))
					{
						echo "Wrzystko ok";
						exit();
					}
				}

			}

			if(isset($_POST['newslater']))
			{
				$polaczenie =new mysqli($host, $db_user, $db_password, $db_name);
				if ($polaczenie->connect_errno!=0) 
				{
						throw new Exception(mysqli_connect_errno());
					
				}
				else
				{
					//czy mail istnieje
					$rezultat = $polaczenie->query("SELECT id FROM Ruser WHERE email='$email'");
					if(!rezultat) throw new Exception($polaczenie->error);

					$ile_takich_maili = $rezultat->num_rows;	
					if($ile_takich_maili>0)
					{
						$wszystko_OK=false;
						$_SESSION['e_email']="Istnieje już w naszej bazie taki mail";
					}

					if ($wszystko_OK==true) {
					
						if ($polaczenie->query("INSERT INTO Ruser VALUES (NULL, '$imie', '$nazwisko', '$email')")) 
						{
							$news = "newslater.html";

							$message = file_get_contents($news);
							$message = str_replace("[Imie]", $imie, $message);
							$message = str_replace("[Nazwisko]", $nazwisko, $message);


							if (mail($email, "$potwierdzamy subskrypcje" , $message, $naglowki)==true) 
							{							
								echo "Wrzystko ok";
								exit();
							}
							else
							{
								throw new Exception("blad wysylki maila", 1);
								
							}
						}
						else
						{
							throw new Exception($polaczenie->error);	
						}
					}
					$polaczenie->close();
				}
			}

		} 
		catch (Exception $e) 
		{
			echo '<span style="color:red;">Błąd serwera!</span>';	
			echo "inf dev ".$e;		
		}
		
			
		
	}
	
	
?>

<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>network - zarejestruj sie na spotkanie!</title>
	<link rel="stylesheet" type="text/css" href="../gra/gra.css">
	
	<style>
		.error
		{
			color:red;
			margin-top: 10px;
			margin-bottom: 10px;
		}
	</style>
</head>

<body>
	
	<form method="post">
	
		Imię: <br /> <input type="text" name="imie"/><br />
		
		<?php
			if (isset($_SESSION['e_imie']))
			{
				echo '<div class="error">'.$_SESSION['e_imie'].'</div>';
				unset($_SESSION['e_imie']);
			}
		?>
		
		Nazwisko: <br /> <input type="text" name="nazwisko" /><br />

		<?php
			if(isset($_SESSION['e_nazwisko']))
			{
				echo '<div class="error">'.$_SESSION['e_nazwisko'].'</div>';
				unset($_SESSION['e_nazwisko']);
			}
		?>
		
		E-mail: <br /> <input type="text"  name="email" /><br />
		
		<?php
			if(isset($_SESSION['e_email']))
			{
				echo '<divclass="error">'.$_SESSION['e_email'].'</div>';
				unset($_SESSION['e_email']);
			}
		?>

</br>
		<label>
			<input type="checkbox" name="ankieta"/> Wyślij przypomnienie o Ankiecie Mój Idealny Pracodawca. 
		</label>
		</br>

		<label>
			<input type="checkbox" name="newslater"/> Dodaj do listy mailingowej i otrzymuj wiadomości o wydarzeniach
		</label>
		</br>

		<input type="submit" value="Wyślij" />
		
	</form>

</body>
</html>