<?php

	session_start();
	
	if (!isset($_SESSION['zalogowany']))
	{
		header('Location: log.php');
		exit();
	}
	
	
	require_once "conect.php";

	$polaczenie = @new mysqli($host, $db_user, $db_password, $db_name);
	
	if ($polaczenie->connect_errno!=0)
	{
		echo "Error: ".$polaczenie->connect_errno;
	}
	else
	{
		//losowanie pytania
		$los=rand(1,12);
		$polaczenie->set_charset("utf8");
		$rezultat = $polaczenie->query("SELECT * FROM Npytania WHERE id='$los'");
		$wiersz = $rezultat->fetch_assoc();
		$_SESSION['mysl']=$wiersz['mysl'];
		$_SESSION['pytanie']=$wiersz['pytanie'];
		
		//przekazanie nr spotkania
		if(isset($_POST['spotkanie']))
		{
			$_SESSION['spotkanie']=$_POST['spotkanie'];
		}
		else
		{
			$_SESSION['spotkanie']=$_SESSION['spotkanie'];
		}
	
	
		if(isset($_POST['runda']))
		{		
			$_SESSION['stan']=1;
			$_SESSION['runda']=$_POST['runda'];
			$fc = fopen("config.txt", "r");
			$fc2=fread($fc, 2);
			if($_SESSION['runda']>=$fc2)
			{
				header('Location: log.php');
				exit();
			}
			$os='kombinacja'.$fc2.'.txt';
			$fp = fopen($os, "r");
			fseek($fp,(($_SESSION['idkom']-1)+(($_SESSION['runda']-1)*($fc2/2)))*7);
			$_SESSION['kto'] = fread($fp, 2);
			fread($fp,1);
			$_SESSION['kim'] = fread($fp, 2);
			unset($_POST['runda']);
		
			header('Location: gra.php');
			exit();
		}
		else
		{
			if(isset($_SESSION['runda'])) 
			{
				$_SESSION['stan']=1;
				$_SESSION['runda']=$_SESSION['runda']+1;
				$fc = fopen("config.txt", "r");
				$fc2=fread($fc, 2);
				if($_SESSION['runda']>=$fc2)
				{
					header('Location: log.php');
					exit();
				}
				$os='kombinacja'.$fc2.'.txt';
				$fp = fopen($os, "r");
				fseek($fp,(($_SESSION['idkom']-1)+(($_SESSION['runda']-1)*($fc2/2)))*7);
				$_SESSION['kto'] = fread($fp, 2);
				fread($fp,1);
				$_SESSION['kim'] = fread($fp, 2);

				header('Location: gra.php');
				exit();
			}
			else
			{
				header('Location: log.php');
				exit();
			}
		}
	
	}
?>
<html>

<body>


</body>
</html>