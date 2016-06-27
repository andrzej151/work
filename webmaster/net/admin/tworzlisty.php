
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
		
		$spotkanie=3;
		$status="Slist";
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
				$listaklucz = $polaczenie->query("SELECT id,iduser FROM Nlista");
				
				
				$ilosckluczow = $listaklucz->num_rows;
				$i=0;
				while($i<$ilosckluczow)
				{
						$tklucz = $listaklucz->fetch_assoc();
					
						$jagra=$tklucz['id'];
						$jauser=$tklucz['iduser'];
						
						
						$datalisty =NULL;
						$datalisty = $polaczenie->query("SELECT * FROM Ngra, Nusers WHERE Ngra.idkto=Nusers.id AND Ngra.idkomu='$jagra' AND Nusers.idspotkania='$spotkanie'");
						
						$datakluczow=$datalisty->num_rows;
						$j=0;
						
						$email_feedback="email_list_feedback.html";
						$list=file_get_contents($email_feedback);
						
						
						$dane = $polaczenie->query("SELECT imie, nazwisko FROM Nusers WHERE id='$jauser'");
						$danew = $dane->fetch_assoc();
						
						$imie = $danew['imie'];
						$nazwisko = $danew['nazwisko'];
						$kontakt="</br>";
						
						$ocena = "</br>";
						$zalety = "</br>";
						$popraw = "</br>";
						$milo = "</br>";
						
						while($j<$datakluczow)
						{
							$data = $datalisty->fetch_assoc();
							
							if(($data['kmail']==1)||($data['ktelefon']==1)||($data['kinne']==1))
							{
								$kontakt = $kontakt." Jestem ".$data['imie']." ".$data['nazwisko']."\n</br> rozmawialismy o: ";
								$kontakt = $kontakt.$data['pytanie']."</br> oceniam ją na:".$data['ocena']."</br>".$data['owiecej']."</br>Oto do mnie kontakt:</br>";
								if($data['kmail']==1)
								{
									$kontakt = $kontakt."E-mail: ".$data['email']."</br>";
								}
								if($data['ktelefon']==1)
								{
									$kontakt = $kontakt."Telefon: ".$data['telefon']."</br>";
								}
									if($data['kinne']==1)
								{
									$kontakt = $kontakt."Fb: ".$data['inne']."</br>";
								}
								$kontakt = $kontakt."</br>";
							}
							else
							{
								$ocena = $ocena.$data['pytanie']."</br> znajomość oceniam: ".$data['ocena']."</br>".$data['owiecej']."</br>";
							}
							
							$zalety = $zalety.$data['zalety']."</br>";
							$popraw = $popraw.$data['poprawic']."</br>";
							$milo = $milo.$data['mile']."</br>";
							//echo ($milo);
							$j++;
						}
						
						
						$list = str_replace("[Imie]", $imie, $list);
						$list = str_replace("[Nazwisko]", $nazwisko, $list);
						$list = str_replace("[kontakt]", $kontakt, $list);
						$list = str_replace("[ocena]", $ocena, $list);
						$list = str_replace("[zalety]", $zalety, $list);
						$list = str_replace("[popraw]", $popraw, $list);
						$list = str_replace("[milo]", $milo, $list);
						
						$list=htmlentities($list,ENT_QUOTES,"utf-8");
						
						
						$ok=$polaczenie->query("INSERT INTO Nlisty VALUES(NULL,'$list','$jauser')"); 
						echo ($ok."</br>");
						$fin = $polaczenie->query("SELECT * FROM Nlisty WHERE IDuser='$jauser'");
						$fina = $fin->fetch_assoc();
						$ili=$fina['id'];
						$polaczenie->query("UPDATE Nusers SET idlistu='$ili', status='$status' WHERE id='$jauser' AND idspotkania='$spotkanie'");
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