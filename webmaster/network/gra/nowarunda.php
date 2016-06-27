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
		$_SESSION['los']=$_SESSION['los']+1;
		$los=$_SESSION['los'];
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
			$os="komb/kombinacja".$fc2.".txt";
			$fp = fopen($os, "r");
			fseek($fp,((($_SESSION['runda']-1)*($fc2)))*7);
			$i=0;
			unset($_SESSION['kto']);
			unset($_SESSION['kim']);
			while($i<($fc2/4))
			{
				$inf=fread($fp, 7);
				$_SESSION['kto'] = $_SESSION['kto'].$inf." </br>";
				
				$i++;
				
			}
			
			while($i<$fc2/2)
			{
				$inf=fread($fp, 7);
				$_SESSION['kim'] = $_SESSION['kim'].$inf." </br>";
				$i++;
			}
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
				$os="komb/kombinacja".$fc2.".txt";
				$fp = fopen($os, "r");
					fseek($fp,((($_SESSION['runda']-1)*($fc2/2)))*7);
				$i=0;
			
			unset($_SESSION['kto']);
			unset($_SESSION['kim']);
			while($i<($fc2/4))
			{
				$inf=fread($fp, 7);
				$_SESSION['kto'] = $_SESSION['kto'].$inf." </br>";
				
				$i++;
				
			}
			
			while($i<$fc2/2)
			{
				$inf=fread($fp, 7);
				$_SESSION['kim'] = $_SESSION['kim'].$inf." </br>";
				
				$i++;
			}
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