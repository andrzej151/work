
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
				$dane = $polaczenie->query("SELECT id,lp,r1,r2,r3 FROM mistrz ");
						$danew = $dane->fetch_assoc();
				
				$i=1;
				while($i<$dane->num_rows)
				{
					$dan = $polaczenie->query("SELECT id,lp,r1,r2,r3 FROM mistrz WHERE id='$i'");
						$danecw = $dan->fetch_assoc();

					$id=$danecw['id'];
					$r1=$danecw['r1'];
					$r2=$danecw['r2'];
					$r3=$danecw['r3'];
					$n=$danecw['lp'];
					$s=$r1+$r2+$r3;
					echo $id." ".$r1."</br>";
					$q="UPDATE  mistrz SET  suma =".$s."   WHERE id =".$id ;
					if ($polaczenie->query($q))
					{
						echo ("wstawiono dla ".$n." ".$r1." ".$r2." ".$r3." ".$s."</br>");
					
					}
					else
					{
						echo ("NIE  wstawiono dla ".$n." ".$r1." ".$r2." ".$r3." ".$s."</br>".$q."</br>");
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
