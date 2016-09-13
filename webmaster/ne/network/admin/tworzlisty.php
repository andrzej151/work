
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
		$status="list";
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
				$listaklucze = $polaczenie->query("SELECT id,iduser FROM Nlista");
				
				
				$ilosckluczow = $listaklucze->num_rows;
				$i=0;
				while($i<$ilosckluczow)
				{
						$tklucz = $listaklucze->fetch_assoc();
					
						$jagra=$tklucz['id'];//id na cele gry anonimowe
						$jauser=$tklucz['iduser'];//id uzytkownika z bazy 
						
						
						$datalisty =NULL;
						$datalisty = $polaczenie->query("SELECT * FROM Ngra, Nusers WHERE Ngra.idkto=Nusers.id AND Ngra.idkomu='$jagra' AND Nusers.idspotkania='$spotkanie'");
						//dane wszystkich urzytkownikow z danego jednego spotkania z odpowiednimi kluczami o danymi
						$datakluczow=$datalisty->num_rows;
						$j=0;
						
						//szablon listu feedbackowego	
						$email_feedback="email_list_feedback.html";
						$list=file_get_contents($email_feedback);
						
						//poszczegulne listy do poszczegulnych osub
						$dane = $polaczenie->query("SELECT imie, nazwisko FROM Nusers WHERE id='$jauser'");
						$danew = $dane->fetch_assoc();
						
						$imie = $danew['imie'];
						$nazwisko = $danew['nazwisko'];
						
						$kontakt=" ";
						
						$ocena = " ";
						$zalety = " ";
						$popraw = " ";
						$milo = " ";
						
						while($j<$datakluczow)
						{
							$data = $datalisty->fetch_assoc();
							
							if(($data['kmail']==1)||($data['ktelefon']==1)||($data['kinne']==1))
							{
								//wyrazil chec kontaktu
								$kontakt = $kontakt."<div> <h3>Jestem ".$data['imie']." ".$data['nazwisko']."<h3></br> <h4>rozmawialismy o: ";
								$kontakt = $kontakt.$data['pytanie']."oceniam ją na:".$data['ocena']."</h4></br><p>".$data['owiecej']."</br></p><p>Oto do mnie kontakt:</br></p>";
								if($data['kmail']==1)
								{
									$kontakt = $kontakt."<p>E-mail: ".$data['email']."</br></p>";
								}
								if($data['ktelefon']==1)
								{
									$kontakt = $kontakt."<p>Telefon: ".$data['telefon']."</br></p>";
								}
									if($data['kinne']==1)
								{
									$kontakt = $kontakt."<p>Fb: ".$data['inne']."</br></p>";
								}
								$kontakt = $kontakt."</p></br></div>";
							}
							else
							{
								//nie wyrazil checi 
								$ocena = $ocena."<div><h5>".$data['pytanie']."</br> znajomość oceniam: ".$data['ocena']."</h5></br><p>".$data['owiecej']."</br></p></div>";
							}
							
							$zalety = $zalety."<div><p>".$data['zalety']."</p></div></br>";
							$popraw = $popraw."<div><p>".$data['poprawic']."</p></div></br>";
							$milo = $milo."<div><p>".$data['mile']."</p></div></br>";

							//$scid=$data['id'];
							//$polaczenie->query("UPDATE Ngra SET  status='t' WHERE id='$scid'");
							$j++;
						}
						
						
						$list = str_replace("[Imie]", $imie, $list);
						$list = str_replace("[Nazwisko]", $nazwisko, $list);
						$list = str_replace("[kontakt]", $kontakt, $list);
						$list = str_replace("[ocena]", $ocena, $list);
						$list = str_replace("[zalety]", $zalety, $list);
						$list = str_replace("[popraw]", $popraw, $list);
						$list = str_replace("[milo]", $milo, $list);
						
						
						
						
						
						$df="listy/lsit".$jauser;
						$nzplik="lsit".$jauser;
						$fp = fopen($df, "w");
   						fputs($fp, $list);
						fclose($fp);

						$polaczenie->query("UPDATE Nusers SET idlistu='$nzplik', status='$status' WHERE id='$jauser' AND idspotkania='$spotkanie'");
						echo($i.". ".$imie." ".$nazwisko." ".$ili." ".$spotkanie."</br>");
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