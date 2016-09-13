<?php

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
						
							$rezultat = $polaczenie->query("SELECT miejsce, idfirmy  FROM `Mmiejsca` ORDER BY miejsce ASC");
							if (!$rezultat) throw new Exception($polaczenie->error);
							
							$ile = $rezultat->num_rows;
							$m=1;
							$w=1;
							echo('{"wolne":[');
							for ($i=0; $i <$ile ; $i++) { 
									$wiersz = $rezultat->fetch_assoc();
									if ($wiersz['miejsce']!=$m) {
										$m++;
										echo($w.",");
										$w=1;
									}
									if ($w!=0) {
										if($wiersz['idfirmy']==0)
										{
											$w=0;
										}
										}

								
									}
									echo $w."]}";
						
					
						}
					}
				catch(Exception $e)
				{
					echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
					echo '<br />Informacja developerska: '.$e;
				}

