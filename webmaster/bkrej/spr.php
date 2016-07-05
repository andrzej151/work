<?php
session_start();


	if (isset($_POST['email']))
	{
		//Udana walidacja? Załóżmy, że tak!
		$wszystko_OK=true;
		
		//Sprawdź poprawność nickname'a
		$nazwa = $_POST['nazwa'];
		$imie = $_POST['imie'];
		$nazwisko = $_POST['nazwisko'];
		$telefon =$_POST['telefon'];
		
		
		// Sprawdź poprawność adresu email
		$email = $_POST['email'];
		$emailB = filter_var($email, FILTER_SANITIZE_EMAIL);
		
		if ((filter_var($emailB, FILTER_VALIDATE_EMAIL)==false) || ($emailB!=$email))
		{
			$wszystko_OK=false;
			$_SESSION['e_email']="Podaj poprawny adres e-mail!";
		}
		
		/*
		//Czy zaakceptowano regulamin?
		if (!isset($_POST['regulamin']))
		{
			$wszystko_OK=false;
			$_SESSION['e_regulamin']="Potwierdź akceptację regulaminu!";
		}				
		*/
		
	
		//Zapamiętaj wprowadzone dane
		$_SESSION['fr_nazwa'] = $nazwa;
		$_SESSION['fr_email'] = $email;
		$_SESSION['fr_imie'] = $_POST['imie'];
		$_SESSION['fr_nazwisko'] = $_POST['nazwisko'];
		$_SESSION['fr_telefon'] = $_POST['telefon'];
		
		//if (isset($_POST['regulamin'])) $_SESSION['fr_regulamin'] = true;
		
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
				$polaczenie->set_charset("utf8");
				//Czy email już istnieje?
				$rezultat = $polaczenie->query("SELECT id FROM Bkrej WHERE email='$email'");
				
				if (!$rezultat) throw new Exception($polaczenie->error);
				
				$ile_takich_maili = $rezultat->num_rows;
				if($ile_takich_maili>0)
				{
					$wszystko_OK=false;
					$_SESSION['e_email']="Istnieje już konto przypisane do tego adresu e-mail!";
				}		

				
					//Hurra, wszystkie testy zaliczone, dodajemy gracza do bazy
					if ($wszystko_OK) {
					
						$liczba=rand(390);
						$kod=md5($liczba);
						if ($polaczenie->query("INSERT INTO `Bkrej`(`id`, `nazwa`, `imie`, `nazwisko`, `email`, `telefon`, `idmiejsce`,  `klucz`) VALUES (NULL,'$nazwa','$imie','$nazwisko','$email','$telefon',0,'$kod')"))
						{

							$polaczenie->close();
							header('Location: miejsca.php?k='.$kod);
							exit();
							
						}
						else
						{
							throw new Exception($polaczenie->error);
						}
					}
					else
					{
						$polaczenie->close();
						header('Location: rejestracja.php');
						exit();
					}
					
				}
				
				$polaczenie->close();
		}
			
		
		catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
			echo '<br />Informacja developerska: '.$e;
		}
		
	}

?>