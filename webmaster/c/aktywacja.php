<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link href="css/styl.css" rel="stylesheet">
	<title>Empaiere</title>
</head>

<body>
<?php
	if(isset($_GET['activate']))
		{
			$key = $_GET['activate'];
			require_once "connect.php";
			mysqli_report(MYSQLI_REPORT_STRICT);
		
			$polaczenie = new mysqli($host, $db_user, $db_password, $db_name);
				if ($polaczenie->connect_errno!=0)
				{
					throw new Exception(mysqli_connect_errno());
				}
				else
				{

					$polaczenie->set_charset("utf8");	
					$rezultat = $polaczenie -> query('SELECT `kod` FROM `Euser` WHERE `kod` = "' . $key . '"');
					$ilu_userow = $rezultat->num_rows;
					if($ilu_userow>0)
					{
						$los=rand(1,1200);
						$keyn=md5($los);
						$polaczenie -> query('UPDATE `Euser` SET `status` = "akt", `kod` = "'.$keyn.'"  WHERE `kod`= "' . $key . '"');
						echo("Dziękujemy za potwierdzenie<br /><br />");
						
						
					}
					else
					{
						echo("Błedny klucz");
					}
				}
		}
		
?>
	
	

</body>
</html>