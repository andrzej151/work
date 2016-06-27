
<?php
	session_start();
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
				
				$_SESSION['fr_k']=$_POST['k'];
				$_SESSION['fr_r']=$_POST['r'];
				$k=$_POST['k'];
				$r=$_POST['r'];
				$p=$_POST['pkt'];
				$n=$_POST['nr'];
				$mr="r".$r;
				$q="UPDATE  mistrz SET  ".$mr." =".$p."   WHERE lp =".$n." AND kategoria = '".$k."'" ;
				if ($polaczenie->query($q))
				{
					echo ("wstawiono dla ".$n." pkt ".$p." kategoria ".$k."runda".$r."</br>");
				
				}
				else
				{
					echo ("NIE  wstawiono dla ".$n." pkt ".$p." kategoria ".$k." runda ".$r.$mr."</br>".$q."</br>");
				}
				
				
			}
		}
			catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności i prosimy o rejestrację w innym terminie!</span>';
			echo '<br />Informacja developerska: ';
		}
		
?>
<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Mistrzostwa</title>
</head>
<body>
	<form method="post">
	
		NR: <br /> <input type="text"  name="nr" /><br />
		
		
		
		kategoria: <br /> <input type="text" value="<?php
			if (isset($_SESSION['fr_k']))
			{
				echo $_SESSION['fr_k'];
				unset($_SESSION['fr_k']);
			}
		?>" name="k" /><br />
		
		
		
		runda: <br /> <input type="text" value="<?php
			if (isset($_SESSION['fr_r']))
			{
				echo $_SESSION['fr_r'];
				unset($_SESSION['fr_r']);
			}
			?>" name="r" /><br />


		punkty: <br /> <input type="text"  name="pkt" /><br />

		punkty: <br /> <input type="submit"  value="wyslij" /><br />
	</form>
</body>
</html>
