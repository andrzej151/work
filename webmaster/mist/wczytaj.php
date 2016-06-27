
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
				
				$polaczenie->set_charset("utf8");
				//$listaklucze = 
				
				
				$sp1=135;
				$sp2=239;
				$gim=134;
				$lo=66;
				$dr=18;
				$i=0;
				$tb[0]=$sp1;
				$tb[1]=$sp2;
				$tb[2]=$gim;
				$tb[3]=$lo;
				$tb[4]=$dr;
				$tb2[0]="sp1";
				$tb2[1]="sp2";
				$tb2[2]="gim";
				$tb2[3]="lo";
				$tb2[4]="dr";
				$l;

				while($i<5)
				{
						$j=0;
						$l=$tb2[$i];
						while($j<$tb[$i])
						{
							$j++;
							echo $j;
							echo "</br>";
							$polaczenie->query("INSERT INTO `mistrz`(`id`, `lp`, `kategoria`,`suma`) VALUES ( NULL,'$j','$l',0)");
							
						}
						$i++;

				}
				
			}
		}
			catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
			echo '<br />Informacja developerska: ';
		}
		
?>
