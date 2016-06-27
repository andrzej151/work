<?php

	session_start();
	
	if (!isset($_SESSION['zalogowany']))
	{
		header('Location: index.php');
		exit();
	}
	
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
				$nazwa=$_POST['nazwa'];
				$kopis=$_POST['krotkiopis'];
				$idlider=$_SESSION['ID'];
				$opis=$_POST['pelnyopis'];
				$benefity=$_POST['benefity'];
				$czas=date('Y-m-d H:i:s');
				echo($czas);
				$status="Dotowanie";
				
					if ($polaczenie->query("INSERT INTO Eprojekty VALUES (NULL,'$nazwa','$kopis','$idlider','$opis','$benefity','$czas', '$status',0)"))
					{/*
						$email_active = "email_aktywacja.html";
						$messeage = file_get_contents($email_active);
						$messeage = str_replace("[Imie]", $imie, $messeage);
						$messeage = str_replace("[Nazwisko]", $nazwisko, $messeage);
						$messeage = str_replace("[key]", $kod, $messeage);
						$messeage = str_replace("[url]", "http://" . $_SERVER['HTTP_HOST'].'/emp/aktywacja.php', $messeage);

						$naglowki = "From: active@andr-t.cba.pl\n" .
									"Reply-To: active@andr-t.cba.pl\n" .
									"Content-type: text/html; charset=utf-8\n";

						if(mail($email, "Potwierdzenie maila",$messeage,$naglowki))
						{*/
					}
					else
					{
						throw new Exception($polaczenie->error);
					}
					
				}
				
				$polaczenie->close();
		}
			
		
		catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności!</span>';
			
		}
?>
<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Empaier </title>

	 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/simple-sidebar.css" rel="stylesheet">
    <link href="css/styl.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div class="container">
		<div class="col-lg-12">

			<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
				<a class="navbar-brand" href="panel.php">Empier</a>
				<a href="projekty.php"><button type="button" class="btn btn-primary navbar-btn ">PROJEKTY</button></a>
				<a href="projekty_stworz.php"><button type="button" class="btn btn-success navbar-btn active">STWORZ PROJEKT</button></a>
				<a href="transakcje.php"><button type="button" class="btn btn-primary navbar-btn">TRANSAKCJE</button></a>
				<a href="panel.php"><button type="button" class="btn btn-primary navbar-btn">MOJ PANEL</button></a>
				<a href="baza_wiedzy.php"><button type="button" class="btn btn-primary navbar-btn">BAZA WIEDZY</button></a>
				<a href="logout.php"><button type="button" class="btn btn-danger  navbar-btn">WYLOGUJ SIĘ</button></a>

			</nav>	
			Zapisalismy twoj projekt!
		</div>
<div> <!-- cointeiner -->
 <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>